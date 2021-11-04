/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.helper;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author rezaadrean
 */
@Data
public class InvoiceProduksiHelper {
    private Long id;
    private Date tanggalPesan;    
    private String invoiceNumber;
    private String kodeBarang;
    private String namaBarang;
    private String penerima;
    private String alamatPenerima;
    private Double hargaBarang;
    private Double total;
    private Double qty;
}
