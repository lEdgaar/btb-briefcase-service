package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.entity.FavoriteAssets;
import com.btb.briefcaseservice.exception.AssetsException;
import com.btb.briefcaseservice.exception.DBException;
import com.btb.briefcaseservice.persistence.mapper.FavoriteAssetsMapper;
import com.btb.briefcaseservice.service.AssetsService;
import com.btb.briefcaseservice.service.FavoriteAssetsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class FavoriteAssetsServiceImpl implements FavoriteAssetsService {

    @Autowired
    private FavoriteAssetsMapper favoriteAssetsMapper;


    @Override
    public void addFollowAsset(Assets assets, Long userId) throws AssetsException, DBException {
        log.info("Follow asset: assetId: {}", assets.getId());

        FavoriteAssets favoriteAssets = new FavoriteAssets();

        favoriteAssets.setAssets(assets);
        favoriteAssets.setUserId(userId);

        if (favoriteAssetsMapper.save(favoriteAssets) != 1) {
            throw new DBException("Error adding favorite asset");
        }

        log.info("Asset followed: assetId: {}", assets.getId());
    }

    @Override
    public void deleteFollowAsset(Assets assets, Long userId) throws AssetsException {
        log.info("Unfollow asset: assetId: {}", assets.getId());

        FavoriteAssets favoriteAssets = new FavoriteAssets();
        favoriteAssets.setAssets(assets);
        favoriteAssets.setUserId(userId);

        List<FavoriteAssets> listFavoriteAssets = favoriteAssetsMapper.findByFilter(favoriteAssets);

        for (FavoriteAssets data : listFavoriteAssets) {
            favoriteAssetsMapper.delete(data.getId());
        }
        log.info("Asset unfollowed: assetId: {}", assets.getId());
    }

    @Override
    public List<Assets> getFollowedAssetList(Long userId) {
        log.info("Get followed asset list: userId: {}", userId);

        FavoriteAssets favoriteAssets = new FavoriteAssets();
        favoriteAssets.setUserId(userId);

        List<FavoriteAssets> listFavoriteAssets = favoriteAssetsMapper.findByFilter(favoriteAssets);
        List<Assets> listAssets = null;

        for (FavoriteAssets data : listFavoriteAssets) {
            listAssets.add(data.getAssets());
        }

        log.info("Got followed asset list: userId: {}", userId);
        return listAssets;
    }

}
