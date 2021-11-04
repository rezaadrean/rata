/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recruitment.rata.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rezaadrean
 */
public class TestCase2 {
    public static void main(String[] args){      
        TestCase2 n = new TestCase2();                
        System.out.println("hasil = "+n.value(n.list()));
    }
    
    public int value(List<List<Integer>> list){
        int val1=0;
        int val2=0;
        
        for (int i = 0; i < list.size(); i++) {
            val1 += list.get(i).get(i);
        }
        
        for (int i = 0; i < list.size(); i++) {
            val2 += list.get(i).get(list.size() -(i+1));
        }
        
        return Math.abs(val1 - val2);
    }
    
    public List<List<Integer>> list(){
        List<List<Integer>> list = new ArrayList<>();
        int[] arr0 = {11,2,4};
        int[] arr1 = {4,5,6};
        int[] arr2 = {10,8,-12};
        list.add(Arrays.stream(arr0).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(arr1).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
        
        return list;
    }
}
