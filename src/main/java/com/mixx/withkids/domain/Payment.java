package com.mixx.withkids.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Payment {

    @Id @GeneratedValue
	Long id;

    Long amount;
    
    Status status;
    
    PayType payType;

    Date createDate;

    Date updateDate;

    // @OneToMany
    // List<Coupon> Coupons;


    // public List<Coupon> getCoupons() {
    //     return Coupons;
    // }

    // public void setCoupons(List<Coupon> coupons) {
    //     Coupons = coupons;
    // }

    public Payment() {}

    public Payment(Long id) {
        setId(id);
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
