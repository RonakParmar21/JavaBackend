package com.codingshuttle.ronak.module1Introduction.Homework.impl;

import com.codingshuttle.ronak.module1Introduction.Homework.Syrup;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StrawberrySyrupImpl implements Syrup {
    @Override
    public String getSyrupType() {
        return "Strawberry syrup...";
    }
}
