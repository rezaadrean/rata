/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.repository;

import com.recruitment.rata.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rezaadrean
 */
public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
}
