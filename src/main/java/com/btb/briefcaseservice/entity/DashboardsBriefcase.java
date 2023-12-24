package com.btb.briefcaseservice.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DashboardsBriefcase extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private DashboardsType dashboardsType;

    private Briefcase briefcase;

    private String filterColumn;

    private String order;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
