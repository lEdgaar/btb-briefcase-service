package com.btb.briefcaseservice.dto;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBriefcaseDTO {

    private String name;

    private Boolean enableSocialTrading;

}
