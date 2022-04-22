package com.mixx.withkids.domain;

import com.mixx.withkids.AbstractEvent;

public class PaymentComplete extends AbstractEvent {
    Long paymentId; 
    Long reservationId;
    Status status;
    public Long getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
    public Long getReservationId() {
        return reservationId;
    }
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    
}
