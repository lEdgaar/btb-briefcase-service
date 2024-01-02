package com.btb.briefcaseservice.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date createdAt;

    private long transactionType;

    private long quantity;

    private Assets asset;

    private double priceUnit;

    private long user;

    private boolean isSandbox;

    private Briefcase briefcase;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}
