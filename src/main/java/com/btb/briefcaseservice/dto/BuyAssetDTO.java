package com.btb.briefcaseservice.dto;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyAssetDTO {

    private Long userId;

    private Long assetId;

    private Long quantity;

    private Double takeProfit;

    private Double stopLoss;

    private Long briefcaseId;

}
