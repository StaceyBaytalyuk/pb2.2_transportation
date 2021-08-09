package com.stacey.transportation.carrier;

import com.stacey.transportation.Route;

public class Train extends PassengerCarrier {
    private static final int wagons = 15;

    public Train(Route route, int id) {
        super(route, id);
    }

    public void carry(int a, int b) {
        System.out.println("chuchuh, train brings you from "+a+" to "+b+". I have "+ wagons +" wagons");
    }

    @Override
    public String toString() {
        return "Train №"+id;
    }

}
