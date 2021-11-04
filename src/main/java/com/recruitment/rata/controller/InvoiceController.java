/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.controller;

import com.recruitment.rata.helper.PaymentInvoiceHelper;
import com.recruitment.rata.helper.StatusProduksiHelper;
import com.recruitment.rata.model.InvoiceProduksi;
import com.recruitment.rata.model.StatusProduksi;
import com.recruitment.rata.service.InvoiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rezaadrean
 */
@RestController
@RequestMapping(path = "transaction")
public class InvoiceController {
    
    @Autowired
    InvoiceService invoiceService;
    
    @RequestMapping(value = "addInvoice", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    public @ResponseBody
    String addInvoice(@RequestBody PaymentInvoiceHelper helper) {
        return invoiceService.addInvoiceProduksi(helper);
    }
    
    @RequestMapping(value = "paymentLunas", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    public @ResponseBody
    String paymentLunas(@RequestBody StatusProduksiHelper helper) {
        return invoiceService.paymentLunas(helper);
    }
    
    @RequestMapping(value = "updateProduksi", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
    public @ResponseBody
    String updateProduksi(@RequestBody StatusProduksiHelper helper) {
        return invoiceService.updateProduksi(helper);
    }
    
    @RequestMapping(value = "deleteProduksi", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody
    String deleteProduksi(@RequestParam(value = "id",required = true) Long id) {
        return invoiceService.deleteProduksi(id);
    }
    
    @RequestMapping(value = "getInvoiceProduksi", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<InvoiceProduksi> getInvoiceProduksi() {
        return invoiceService.getInvoiceProduksi();
    }
    
    @RequestMapping(value = "getStatusProduksi", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<StatusProduksi> getStatusProduksi() {
        return invoiceService.getProduksi();
    }
}
