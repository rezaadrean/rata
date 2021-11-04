/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rezaadrean
 */
@Entity
@Table(name = "trx_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlBuktiBayar;
    
    @Temporal(TemporalType.TIMESTAMP)   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tanggalBayar;
    
    @ManyToOne
    @JoinColumn(name = "payment_method_id",referencedColumnName = "id",updatable = true,nullable = true)    
    private PaymentMethod paymentMethod;
    
    @ManyToOne
    @JoinColumn(name = "payment_status_id",referencedColumnName = "id",updatable = true,nullable = true)    
    private Status status;
    
    @ManyToOne
    @JoinColumn(name = "invoice_produksi_id",referencedColumnName = "id",updatable = true,nullable = true)    
    private InvoiceProduksi invoiceProduksi;

    public Payment() {
    }

    public InvoiceProduksi getInvoiceProduksi() {
        return invoiceProduksi;
    }

    public void setInvoiceProduksi(InvoiceProduksi invoiceProduksi) {
        this.invoiceProduksi = invoiceProduksi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlBuktiBayar() {
        return urlBuktiBayar;
    }

    public void setUrlBuktiBayar(String urlBuktiBayar) {
        this.urlBuktiBayar = urlBuktiBayar;
    }

    public Date getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(Date tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
}
