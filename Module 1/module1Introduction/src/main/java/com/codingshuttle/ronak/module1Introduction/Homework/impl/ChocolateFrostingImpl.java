package com.codingshuttle.ronak.module1Introduction.Homework.impl;

import com.codingshuttle.ronak.module1Introduction.Homework.Frosting;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class ChocolateFrostingImpl implements Frosting {

    @Override
    public String getFronstingType() {
        return "Chocolate frosting...";
    }
}
