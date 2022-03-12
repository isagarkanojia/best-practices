package com.software.practices.patterns.creational.builder.implementations;

import com.software.practices.patterns.creational.builder.Aircraft;
import com.software.practices.patterns.creational.builder.AircraftBuilder;
import com.software.practices.patterns.creational.builder.products.F16;
import org.springframework.stereotype.Component;

@Component
public class F16Builder extends AircraftBuilder {

    F16 f16;

    @Override
    public void buildEngine() {
        // get F-16 an engine
        // f16.engine = new F16Engine();
    }

    @Override
    public void buildWings() {
        // get F-16 wings
        // f16.wings = new F16Wings();
    }

    @Override
    public void buildCockpit() {
        f16 = new F16();
        // get F-16 a cockpit
        // f16.cockpit = new F16Cockpit();
    }

    public Aircraft getResult() {
        return f16;
    }
}