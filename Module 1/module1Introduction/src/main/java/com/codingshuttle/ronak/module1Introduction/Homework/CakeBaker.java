package com.codingshuttle.ronak.module1Introduction.Homework;

import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    private Frosting frosting;
    private Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void backCake() {
        System.out.println("Cake...");
        System.out.println("Frosting : " + frosting.getFronstingType());
        System.out.println("Syrup : " + syrup.getSyrupType());
    }
}
