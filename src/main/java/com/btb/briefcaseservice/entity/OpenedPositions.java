package com.btb.briefcaseservice.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenedPositions extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Briefcase briefcase;

    private Assets assets;

    private Double stopLoss;

    private Double takeProfit;

    private Boolean isSandbox;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
