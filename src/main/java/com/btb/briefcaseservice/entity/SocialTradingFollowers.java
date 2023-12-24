package com.btb.briefcaseservice.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocialTradingFollowers extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long followerId;

    private Briefcase briefcase;

    private Date timeAt;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
