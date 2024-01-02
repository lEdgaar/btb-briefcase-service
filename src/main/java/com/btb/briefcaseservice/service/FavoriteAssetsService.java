package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.exception.AssetsException;
import com.btb.briefcaseservice.exception.DBException;

import java.util.List;

public interface FavoriteAssetsService {

    void addFollowAsset(Assets assets, Long userId) throws AssetsException, DBException;

    void deleteFollowAsset(Assets assets, Long userId) throws AssetsException;

    List<Assets> getFollowedAssetList(Long userId);

}
