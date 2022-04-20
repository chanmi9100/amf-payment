package com.mixx.withkids.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Payment {

    @Id @GeneratedValue
	Long id;

    Long amount;
    
    String reservationId;

    Status status;
    
    PayType payType;

    Date PayDate;

    public Date getPayDate() {
        return PayDate;
    }

    public void setPayDate(Date payDate) {
        PayDate = payDate;
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

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

}
