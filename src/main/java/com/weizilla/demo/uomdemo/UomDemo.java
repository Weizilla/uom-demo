package com.weizilla.demo.uomdemo;

import tec.uom.se.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import java.math.BigDecimal;

import static systems.uom.common.USCustomary.HOUR;
import static systems.uom.common.USCustomary.METER;
import static systems.uom.common.USCustomary.MILE;
import static tec.uom.se.unit.MetricPrefix.KILO;
import static tec.uom.se.unit.Units.METRE;

public class UomDemo {
    public static void main(String[] args) {
        Quantity<Length> km = Quantities.getQuantity(5, KILO(METRE));
        System.out.println(km);

        Quantity<Length> miles = km.to(MILE);
        System.out.println(miles);

        Quantity<Time> time = Quantities.getQuantity(2, HOUR);
        System.out.println(time);

        Quantity<Speed> speed = miles.divide(time).asType(Speed.class);
        System.out.println(speed);

        Quantity<Length> parsed = Quantities.getQuantity("10.0 mi").asType(Length.class);
        System.out.println(parsed);

        Quantity<Length> parsedM = parsed.to(METER);
        System.out.println(parsedM);

        Quantity<Length> created = Quantities.getQuantity(BigDecimal.valueOf(10.0), MILE);

        // Parsed Quantity are backed by BigDecimal as DecimalQuantity so in order for equals to work
        // the reference Quantity has to be created with a BigDecimal as well
        System.out.println("Same ? " + created.equals(parsed));
    }
}
