package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.dto.BuyAssetDTO;
import com.btb.briefcaseservice.dto.SellAssetDTO;
import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.service.AssetsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class AssetsServiceImpl implements AssetsService {
    @Override
    public List<Assets> getAsset() {
        return null;
    }

    @Override
    public void getAssetByCategory(Long categoryId) {

    }

    @Override
    public void getAssetByName(String assetName) {

    }

    @Override
    public void followAsset(Long assetId) {

    }

    @Override
    public void unfollowAsset(Long assetId) {

    }

    @Override
    public void getFollowedAssetList(Long userId) {

    }

    @Override
    public void getAssetFeeling(Long assetId) {

    }

    @Override
    public void buyAsset(BuyAssetDTO buyAssetDTO) {

    }

    @Override
    public void sellAsset(SellAssetDTO sellAssetDTO) {

    }

    @Override
    public void buyAssetSandbox(BuyAssetDTO buyAssetDTO) {

    }

    @Override
    public void sellAssetSandbox(SellAssetDTO sellAssetDTO) {

    }
}
