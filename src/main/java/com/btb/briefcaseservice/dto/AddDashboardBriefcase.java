package com.btb.briefcaseservice.dto;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddDashboardBriefcase {

    private Long briefcaseId;

    private String filterColumn;

    private String order;

}
