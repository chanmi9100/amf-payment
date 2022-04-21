package com.mixx.withkids.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Coupon {

    @Id @GeneratedValue
	Long id;

    Long amount;

    Date createDate;

    @ManyToOne
    Payment payment;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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