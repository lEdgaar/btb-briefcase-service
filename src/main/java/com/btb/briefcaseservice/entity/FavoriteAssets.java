package com.btb.briefcaseservice.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteAssets extends BaseModel<Long> {

    private Long id;

    private Long userId;

    private Assets assets;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
