package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.dto.BuyAssetDTO;
import com.btb.briefcaseservice.dto.SellAssetDTO;
import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.entity.Transaction;
import com.btb.briefcaseservice.exception.AssetsErrorCodes;
import com.btb.briefcaseservice.exception.AssetsException;
import com.btb.briefcaseservice.exception.BriefcaseException;
import com.btb.briefcaseservice.exception.DBException;
import com.btb.briefcaseservice.md.TransactionTypeMD;
import com.btb.briefcaseservice.persistence.mapper.AssetsGroupsMapper;
import com.btb.briefcaseservice.persistence.mapper.AssetsMapper;
import com.btb.briefcaseservice.persistence.mapper.TransactionMapper;
import com.btb.briefcaseservice.service.AssetsService;
import com.btb.briefcaseservice.service.BriefcaseService;
import com.btb.briefcaseservice.service.FavoriteAssetsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class AssetsServiceImpl implements AssetsService {

    @Autowired
    private AssetsMapper assetsMapper;

    @Autowired
    private FavoriteAssetsService favoriteAssetsService;

    @Autowired
    private AssetsGroupsMapper assetsGroupsMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private BriefcaseService briefcaseService;

    @Override
    public List<Assets> getAsset() {
        return assetsMapper.findAll();
    }

    @Override
    public List<Assets> getAssetByCategory(Long categoryId) {
        log.info("Get asset by category: categoryId: {}", categoryId);

        Assets assets = new Assets();
        assets.setAssetsGroups(assetsGroupsMapper.findById(categoryId));

        log.info("Got asset by category: categoryId: {}", categoryId);
        return assetsMapper.findByFilter(assets);
    }

    @Override
    public List<Assets> getAssetByName(String assetName) {
        log.info("Get asset by name: assetName: {}", assetName);

        Assets assets = new Assets();
        assets.setName(assetName);

        log.info("Got asset by name: assetName: {}", assetName);
        return assetsMapper.findByFilter(assets);
    }

    @Override
    public Assets getAssetById(Long assetId) throws AssetsException {
        log.info("Get asset by id: assetId: {}", assetId);

        Assets assets = findAssetById(assetId);

        log.info("Got asset by id: assetId: {}", assetId);
        return assets;
    }

    @Override
    public void followAsset(Long assetId, Long userId) throws DBException, AssetsException {
        log.info("Follow asset: assetId: {}", assetId);

        favoriteAssetsService.addFollowAsset(findAssetById(assetId), userId);
        log.info("Followed asset: assetId: {}", assetId);
    }

    @Override
    public void unfollowAsset(Long assetId, Long userId) throws AssetsException {
        log.info("Unfollow asset: assetId: {}", assetId);

        favoriteAssetsService.deleteFollowAsset(findAssetById(assetId), userId);
        log.info("Unfollowed asset: assetId: {}", assetId);
    }

    @Override
    public List<Assets> getFollowedAssetList(Long userId) {
        log.info("Get followed asset list: userId: {}", userId);

        List<Assets> assetsList = favoriteAssetsService.getFollowedAssetList(userId);
        log.info("Got followed asset list: userId: {}", userId);

        return assetsList;
    }

    @Override
    public void buyAsset(BuyAssetDTO buyAssetDTO) throws AssetsException, DBException, BriefcaseException {
        log.info("Buying asset: {}", buyAssetDTO.getAssetId());

        Transaction transaction = new Transaction();
        transaction.setUser(buyAssetDTO.getUserId());
        transaction.setAsset(findAssetById(buyAssetDTO.getAssetId()));
        transaction.setQuantity(buyAssetDTO.getQuantity());
        transaction.setCreatedAt(new Date());
        transaction.setTransactionType(TransactionTypeMD.BUY.getCode());
        transaction.setSandbox(false);
        transaction.setBriefcase(briefcaseService.getBriefcaseById(buyAssetDTO.getBriefcaseId()));

        if (transactionMapper.save(transaction) != 1) {
            throw new DBException("Error adding transaction");
        }

        log.info("Asset bought: {}", buyAssetDTO.getAssetId());
    }

    @Override
    public void sellAsset(SellAssetDTO sellAssetDTO) throws AssetsException, DBException, BriefcaseException {
        log.info("Selling asset: {}", sellAssetDTO.getAssetId());

        Transaction transaction = new Transaction();
        transaction.setUser(sellAssetDTO.getUserId());
        transaction.setAsset(findAssetById(sellAssetDTO.getAssetId()));
        transaction.setQuantity(sellAssetDTO.getQuantity());
        transaction.setCreatedAt(new Date());
        transaction.setTransactionType(TransactionTypeMD.SELL.getCode());
        transaction.setSandbox(false);
        transaction.setBriefcase(briefcaseService.getBriefcaseById(sellAssetDTO.getBriefcaseId()));

        if (transactionMapper.save(transaction) != 1) {
            throw new DBException("Error adding transaction");
        }

        log.info("Asset sold: {}", sellAssetDTO.getAssetId());
    }

    @Override
    public void buyAssetSandbox(BuyAssetDTO buyAssetDTO) throws AssetsException, DBException {
        log.info("Buying sandbox asset: {}", buyAssetDTO.getAssetId());

        Transaction transaction = new Transaction();
        transaction.setUser(buyAssetDTO.getUserId());
        transaction.setAsset(findAssetById(buyAssetDTO.getAssetId()));
        transaction.setQuantity(buyAssetDTO.getQuantity());
        transaction.setCreatedAt(new Date());
        transaction.setTransactionType(TransactionTypeMD.BUY.getCode());
        transaction.setSandbox(true);

        if (transactionMapper.save(transaction) != 1) {
            throw new DBException("Error adding transaction");
        }

        log.info("Sandbox asset bought: {}", buyAssetDTO.getAssetId());
    }

    @Override
    public void sellAssetSandbox(SellAssetDTO sellAssetDTO) throws AssetsException, DBException {
        log.info("Selling sandbox asset: {}", sellAssetDTO.getAssetId());

        Transaction transaction = new Transaction();
        transaction.setUser(sellAssetDTO.getUserId());
        transaction.setAsset(findAssetById(sellAssetDTO.getAssetId()));
        transaction.setQuantity(sellAssetDTO.getQuantity());
        transaction.setCreatedAt(new Date());
        transaction.setTransactionType(TransactionTypeMD.BUY.getCode());
        transaction.setSandbox(true);

        if (transactionMapper.save(transaction) != 1) {
            throw new DBException("Error adding transaction");
        }

        log.info("Sandbox asset sold: {}", sellAssetDTO.getAssetId());
    }

    private Assets findAssetById(Long assetId) throws AssetsException {
        log.info("Getting asset: {}", assetId);
        if (assetId == null) {
            throw new AssetsException(AssetsErrorCodes.ASSET_ID_NOT_NULL, AssetsErrorCodes.ASSET_ID_NOT_NULL.getKey());
        }

        Assets assets = assetsMapper.findById(assetId);

        if (assets == null) {
            throw new AssetsException(AssetsErrorCodes.ASSET_NOT_FOUND, AssetsErrorCodes.ASSET_NOT_FOUND.getKey());
        }

        log.info("Asset found: {}", assetId);

        return assets;
    }
}
