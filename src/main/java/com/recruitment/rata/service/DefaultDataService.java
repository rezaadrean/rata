/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.service;

import com.recruitment.rata.model.PaymentMethod;
import com.recruitment.rata.model.Status;
import com.recruitment.rata.model.StatusProduk;
import com.recruitment.rata.repository.PaymentMethodRepository;
import com.recruitment.rata.repository.StatusProdukRepository;
import com.recruitment.rata.repository.StatusRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rezaadrean
 */
@Service
public class DefaultDataService {
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private StatusProdukRepository statusProdukRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    
    public void dataMaster(){
        List<Status> stats = statusRepository.findAll();
        if(stats.size() <= 0){
        statusRepository.save(new Status("Pending"));
        statusRepository.save(new Status("Lunas"));
        statusRepository.save(new Status("Batal"));
        }
        
        List<StatusProduk> stats1 = statusProdukRepository.findAll();
        if(stats1.size()<= 0){
        statusProdukRepository.save(new StatusProduk("desain"));
        statusProdukRepository.save(new StatusProduk("konfirmasi"));
        statusProdukRepository.save(new StatusProduk("cetak"));
        statusProdukRepository.save(new StatusProduk("kirim"));
        statusProdukRepository.save(new StatusProduk("sampai"));
        }
        
        List<PaymentMethod> pays = paymentMethodRepository.findAll();
        if(pays.size() <= 0){
        paymentMethodRepository.save(new PaymentMethod("Transfer"));
        paymentMethodRepository.save(new PaymentMethod("CC"));
        paymentMethodRepository.save(new PaymentMethod("Shopee"));
        paymentMethodRepository.save(new PaymentMethod("Tokopedia"));
        }
        
    }
}
