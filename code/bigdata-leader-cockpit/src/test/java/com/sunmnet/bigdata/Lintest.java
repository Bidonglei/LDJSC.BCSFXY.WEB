package com.sunmnet.bigdata;

import com.sunmnet.bigdata.web.util.CommonUtils;

import java.math.BigDecimal;

public class Lintest {

    public static void main(String[] args) {
//        BigDecimal value = CommonUtils.getBigDecimal("123,125.00");
//        System.out.println(value);
//        int genderManNum = 3414;
//        int genderWomanNum = 1930;
//        System.out.println(new BigDecimal(genderManNum).divide(new BigDecimal(genderWomanNum),2,BigDecimal.ROUND_HALF_UP)+":1");
        String aa = "";
        System.out.println(aa.split(","));
        for (String a:aa.split(",")) {
            System.out.println(a);
        }
        Object aaa = "";
        if(aaa.equals("")){
            System.out.println(aaa.equals(""));
        }
    }
}
