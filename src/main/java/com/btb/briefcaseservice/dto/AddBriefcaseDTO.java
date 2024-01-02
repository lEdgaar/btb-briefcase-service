package com.btb.briefcaseservice.dto;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBriefcaseDTO {

    private String name;

    private Long userId;

    private Boolean enableSocialTrading;

}
