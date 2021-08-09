package com.stacey.transportation.carrier;

import com.stacey.transportation.Route;

public abstract class PassengerCarrier implements PassengerCarrierStrategy {
    protected Route route;
    protected int id;

    public PassengerCarrier(Route route, int id) {
        this.route = route;
        this.id = id;
    }

    public boolean isReachable(int a, int b) {
        return route.isReachable(a, b);
    }

    public int getDistanceBetween(int a, int b) {
        return route.distanceBetween(a, b);
    }

    public abstract void carry(int a, int b);
}
