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
@Table(name = "trx_status_produksi")
public class StatusProduksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tanggalMasuk;
    
    @Temporal(TemporalType.TIMESTAMP)   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tanggalProduksi;
    
    @Temporal(TemporalType.TIMESTAMP)   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tanggalSelesai;
    
    private String notes;
    
    @ManyToOne
    @JoinColumn(name = "status_produk_id",referencedColumnName = "id",updatable = true,nullable = true)    
    private StatusProduk statusProduk;
    
    @ManyToOne
    @JoinColumn(name = "invoice_produksi_id",referencedColumnName = "id",updatable = true,nullable = true)    
    private InvoiceProduksi invoiceProduksi;

    public StatusProduksi() {
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

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public Date getTanggalProduksi() {
        return tanggalProduksi;
    }

    public void setTanggalProduksi(Date tanggalProduksi) {
        this.tanggalProduksi = tanggalProduksi;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public StatusProduk getStatusProduk() {
        return statusProduk;
    }

    public void setStatusProduk(StatusProduk statusProduk) {
        this.statusProduk = statusProduk;
    }
    
    
}
