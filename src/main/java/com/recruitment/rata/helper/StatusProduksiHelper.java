/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.helper;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author rezaadrean
 */
@Data
public class StatusProduksiHelper {
    private Long id;
    private Long paymentId;
    private Date tanggalSelesai;
    private String notes;
    private Long statusProdukId;
    
}
