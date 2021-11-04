/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.helper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.recruitment.rata.model.InvoiceProduksi;
import com.recruitment.rata.model.PaymentMethod;
import com.recruitment.rata.model.Status;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author rezaadrean
 */
@Data
public class PaymentHelper {
    private String urlBuktiBayar;
    private Date tanggalBayar;
    private Long paymentMethodId;
    private Long statusId;
    private Long invoiceProduksiId;
}
