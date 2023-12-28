package com.btb.briefcaseservice.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Briefcase extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Long userId;

    private Date createdAt;

    private Boolean isActive;

    private Boolean enableSocialTrading;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
