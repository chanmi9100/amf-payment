package com.mixx.withkids.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Coupon {

    @Id @GeneratedValue
	Long id;

    Long couponAmount;

    Date createDate;

    public Long getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Long couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
}