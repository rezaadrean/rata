/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.helper;

import com.recruitment.rata.service.DefaultDataService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author rezaadrean
 */
@Component
public class DataDefaultInsert implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    DefaultDataService dataService;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ctx = event.getApplicationContext();
        (new Thread() {
            public void run(){
                try{
                    dataService.dataMaster();
                }catch(Throwable e){
                    Logger.getLogger(DataDefaultInsert.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }).start();
    }
    
}
