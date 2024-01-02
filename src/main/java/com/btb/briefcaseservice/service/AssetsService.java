package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.dto.BuyAssetDTO;
import com.btb.briefcaseservice.dto.SellAssetDTO;
import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.exception.AssetsException;
import com.btb.briefcaseservice.exception.BriefcaseException;
import com.btb.briefcaseservice.exception.DBException;

import java.util.List;

public interface AssetsService {

    List<Assets> getAsset();

    List<Assets> getAssetByCategory(Long categoryId);

    List<Assets> getAssetByName(String assetName);

    Assets getAssetById(Long assetId) throws AssetsException;

    void followAsset(Long assetId, Long userId) throws DBException, AssetsException;

    void unfollowAsset(Long assetId, Long userId) throws AssetsException;

    List<Assets> getFollowedAssetList(Long userId);

    void buyAsset(BuyAssetDTO buyAssetDTO) throws AssetsException, DBException, BriefcaseException;

    void sellAsset(SellAssetDTO sellAssetDTO) throws AssetsException, DBException, BriefcaseException;

    void buyAssetSandbox(BuyAssetDTO buyAssetDTO) throws AssetsException, DBException;

    void sellAssetSandbox(SellAssetDTO sellAssetDTO) throws AssetsException, DBException;

}
