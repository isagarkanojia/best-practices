package com.software.practices.patterns.creational.builder;

import com.software.practices.patterns.creational.builder.implementations.F16Builder;
import org.springframework.stereotype.Component;

@Component
public class Client {


    public static void main(String...arg) {

        F16Builder f16Builder = new F16Builder();
        Director director = new Director(f16Builder);
        director.construct(false);

        Aircraft f16 = f16Builder.getResult();
    }
}