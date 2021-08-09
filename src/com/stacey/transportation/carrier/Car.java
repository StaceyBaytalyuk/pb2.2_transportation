package com.stacey.transportation.carrier;

import com.stacey.transportation.Route;

public class Car extends PassengerCarrier {
    private static final int wheels = 4;

    public Car(Route route, int id) {
        super(route, id);
    }

    public void carry(int a, int b) {
        System.out.println("drrr, car carries you from "+a+" to "+b+". I have "+wheels+" wheels");
    }

    @Override
    public String toString() {
        return "Car №"+id;
    }
}
