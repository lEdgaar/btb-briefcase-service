package com.btb.briefcaseservice.dto;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellAssetDTO {

    private Long userId;

    private Long assetId;

    private Long quantity;

    private Long briefcaseId;

}
