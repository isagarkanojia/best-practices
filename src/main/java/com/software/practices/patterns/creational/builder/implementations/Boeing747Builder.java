package com.software.practices.patterns.creational.builder.implementations;

import com.software.practices.patterns.creational.builder.Aircraft;
import com.software.practices.patterns.creational.builder.AircraftBuilder;
import com.software.practices.patterns.creational.builder.products.Boeing747;
import org.springframework.stereotype.Component;

@Component
public class Boeing747Builder extends AircraftBuilder {

    Boeing747 boeing747;

    @Override
    public void buildCockpit() {

    }

    @Override
    public void buildEngine() {

    }

    @Override
    public void buildBathrooms() {
        
    }

    @Override
    public void buildWings() {

    }

    public Aircraft getResult() {
        return boeing747;
    }
}