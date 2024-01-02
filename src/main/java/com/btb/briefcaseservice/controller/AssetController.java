package com.btb.briefcaseservice.controller;

import com.btb.briefcaseservice.dto.BuyAssetDTO;
import com.btb.briefcaseservice.dto.SellAssetDTO;
import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.exception.AssetsException;
import com.btb.briefcaseservice.exception.BriefcaseException;
import com.btb.briefcaseservice.exception.DBException;
import com.btb.briefcaseservice.service.AssetsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/asset")
public class AssetController {

    private AssetsService assetsService;

    @Autowired
    public AssetController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @GetMapping("/")
    public List<Assets> getAsset() {
        log.info("Asset: Get Asset");

        log.info("Event: Get Asset");
        return assetsService.getAsset();
    }

    @GetMapping("/{assetId}")
    public List<Assets> getAssetById(@PathVariable("assetId") Long assetId) {
        log.info("Asset: Get Asset by id {}", assetId);

        log.info("Event: Get Assetby id {}", assetId);
        return assetsService.getAsset();
    }

    @GetMapping("/category/{categoryId}")
    public List<Assets> getAssetByCategory(@PathVariable("categoryId") Long categoryId) {
        log.info("Asset: Get Asset by Category");

        log.info("Event: Get Asset by Category");
        return assetsService.getAssetByCategory(categoryId);
    }

    @GetMapping("/name/{assetName}")
    public List<Assets> getAssetByName(@PathVariable("assetName") String assetName) {
        log.info("Asset: Get Asset by Name");

        log.info("Event: Get Asset by Name");
        return assetsService.getAssetByName(assetName);
    }

    @PostMapping("/{assetId}/follow/{userId}")
    public void followAsset(@PathVariable("assetId") Long assetId, @PathVariable("userId") Long userId) throws DBException, AssetsException {
        log.info("Asset: Follow Asset");

        log.info("Event: Follow Asset");
        assetsService.followAsset(assetId, userId);
    }

    @PostMapping("/{assetId}/unfollow/{userId}")
    public void unfollowAsset(@PathVariable("assetId") Long assetId, @PathVariable("userId") Long userId) throws AssetsException {
        log.info("Asset: Unfollow Asset");

        log.info("Event: Unfollow Asset");
        assetsService.unfollowAsset(assetId, userId);
    }

    @GetMapping("/followed/{userId}")
    public List<Assets> getFollowedAssetList(@PathVariable("userId") Long userId) {
        log.info("Asset: Get Followed Asset List");

        log.info("Event: Get Followed Asset List");
        return assetsService.getFollowedAssetList(userId);
    }

    @PostMapping("/buy")
    public void buyAsset(@RequestBody BuyAssetDTO buyAssetDTO) throws DBException, AssetsException, BriefcaseException {
        log.info("Asset: Buy Asset");

        log.info("Event: Buy Asset");
        assetsService.buyAsset(buyAssetDTO);
    }

    @PostMapping("/sell")
    public void sellAsset(@RequestBody SellAssetDTO sellAssetDTO) throws DBException, AssetsException, BriefcaseException {
        log.info("Asset: Sell Asset");

        log.info("Event: Sell Asset");
        assetsService.sellAsset(sellAssetDTO);
    }

    @PostMapping("/buy/sandbox")
    public void buyAssetSandbox(@RequestBody BuyAssetDTO buyAssetDTO) throws DBException, AssetsException {
        log.info("Asset: Buy Asset Sandbox");

        log.info("Event: Buy Asset Sandbox");
        assetsService.buyAssetSandbox(buyAssetDTO);
    }

    @PostMapping("/sell/sandbox")
    public void sellAssetSandbox(@RequestBody SellAssetDTO sellAssetDTO) throws DBException, AssetsException {
        log.info("Asset: Sell Asset Sandbox");

        log.info("Event: Sell Asset Sandbox");
        assetsService.sellAssetSandbox(sellAssetDTO);
    }

}
