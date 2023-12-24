package com.btb.briefcaseservice.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DashboardsType extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String internalCode;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
