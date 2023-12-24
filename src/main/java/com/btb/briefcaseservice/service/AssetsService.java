package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.dto.BuyAssetDTO;
import com.btb.briefcaseservice.dto.SellAssetDTO;
import com.btb.briefcaseservice.entity.Assets;

import java.util.List;

public interface AssetsService {

    List<Assets> getAsset();

    void getAssetByCategory(Long categoryId);

    void getAssetByName(String assetName);

    void followAsset(Long assetId);

    void unfollowAsset(Long assetId);

    void getFollowedAssetList(Long userId);

    void getAssetFeeling(Long assetId);

    void buyAsset(BuyAssetDTO buyAssetDTO);

    void sellAsset(SellAssetDTO sellAssetDTO);

    void buyAssetSandbox(BuyAssetDTO buyAssetDTO);

    void sellAssetSandbox(SellAssetDTO sellAssetDTO);

}
