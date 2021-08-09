package com.stacey.transportation.carrier;

import com.stacey.transportation.Route;

public class Plane extends PassengerCarrier {

    private static final int wings = 2;

    public Plane(Route route, int id) {
        super(route, id);
    }

    public void carry(int a, int b) {
        System.out.println("vzhuh, plane flies you from "+a+" to "+b+". I have "+wings+" wings");
    }

    @Override
    public String toString() {
        return "Plane №"+id;
    }
}
