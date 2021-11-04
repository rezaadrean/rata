/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.service;

import com.recruitment.rata.helper.InvoiceProduksiHelper;
import com.recruitment.rata.helper.PaymentHelper;
import com.recruitment.rata.helper.PaymentInvoiceHelper;
import com.recruitment.rata.helper.StatusProduksiHelper;
import com.recruitment.rata.model.InvoiceProduksi;
import com.recruitment.rata.model.Payment;
import com.recruitment.rata.model.StatusProduksi;
import com.recruitment.rata.repository.InvoiceProduksiRepository;
import com.recruitment.rata.repository.PaymentMethodRepository;
import com.recruitment.rata.repository.PaymentRepository;
import com.recruitment.rata.repository.StatusProdukRepository;
import com.recruitment.rata.repository.StatusProduksiRepository;
import com.recruitment.rata.repository.StatusRepository;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rezaadrean
 */
@Service
public class InvoiceService {
    @Autowired
    private InvoiceProduksiRepository invoiceProduksiRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private StatusProdukRepository statusProdukRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Autowired
    private StatusProduksiRepository statusProduksiRepository;
    
    private static final String characters = "1234567890";
    
    public String addInvoiceProduksi(PaymentInvoiceHelper helper){
        String s = null;
        try{
            InvoiceProduksi ip = new InvoiceProduksi();
            
            InvoiceProduksiHelper iph = helper.getInvoiceProduksiHelper();
            ip.setAlamatPenerima(iph.getAlamatPenerima());
            ip.setNamaBarang(iph.getNamaBarang());
            ip.setPenerima(iph.getPenerima());
            ip.setInvoiceNumber("INV-"+this.generateRandom(5));
            ip.setKodeBarang("GTX-"+this.generateRandom(4));
            ip.setTanggalPesan(Date.from(Instant.now()));
            ip.setHargaBarang(iph.getHargaBarang());
            ip.setQty(iph.getQty());
            ip.setTotal(iph.getHargaBarang() * iph.getQty());
            invoiceProduksiRepository.save(ip);
            
            Payment p = new Payment();
            
            PaymentHelper ph = helper.getPaymentHelper();
            p.setInvoiceProduksi(ip);
            p.setPaymentMethod(paymentMethodRepository.findById(ph.getPaymentMethodId()).get());
            p.setStatus(statusRepository.findById(1l).get());
            p.setUrlBuktiBayar(ph.getUrlBuktiBayar());
            p.setTanggalBayar(ph.getTanggalBayar());
            paymentRepository.save(p);
            
            s="success save invoice";
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
    
    public String paymentLunas(StatusProduksiHelper helper){
        String s = null;
        try{            
            Payment p = paymentRepository.findById(helper.getPaymentId()).get();                                    
            p.setStatus(statusRepository.findById(2l).get());            
            paymentRepository.save(p);
            
            StatusProduksi sp = new StatusProduksi();
            sp.setInvoiceProduksi(p.getInvoiceProduksi());
            sp.setStatusProduk(statusProdukRepository.findById(helper.getStatusProdukId()).get());
            sp.setNotes(helper.getNotes());
            sp.setTanggalMasuk(Date.from(Instant.now()));
            sp.setTanggalProduksi(Date.from(Instant.now()));
            sp.setTanggalSelesai(helper.getTanggalSelesai());
            statusProduksiRepository.save(sp);
            
            s="success save produksi";
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
    
    public String updateProduksi(StatusProduksiHelper helper){
        String s = null;
        try{                        
            StatusProduksi sp = statusProduksiRepository.findById(helper.getId()).get();            
            sp.setStatusProduk(statusProdukRepository.findById(helper.getStatusProdukId()).get());
            sp.setNotes(helper.getNotes());
            sp.setTanggalSelesai(helper.getTanggalSelesai());
            statusProduksiRepository.save(sp);
            
            s="success update produksi";
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
    
    public String deleteProduksi(Long id){
        String s = null;
        try{                        
            StatusProduksi sp = statusProduksiRepository.findById(id).get();                        
            statusProduksiRepository.delete(sp);
            
            s="success delete produksi";
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
    
    public String generateRandom(int length) {
        Random random = new SecureRandom();
        if (length <= 0) {
            throw new IllegalArgumentException("String length must be a positive integer");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
    
    public List<InvoiceProduksi> getInvoiceProduksi(){
        return invoiceProduksiRepository.findAll();
    }
    
    public List<StatusProduksi> getProduksi(){
        return statusProduksiRepository.findAll();
    }
}
