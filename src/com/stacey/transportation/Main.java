package com.stacey.transportation;

import com.stacey.transportation.carrier.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        List<PassengerCarrier> allCarriers = initializeCarriers();
        System.out.println("All carriers:");
        for (PassengerCarrier allCarrier : allCarriers) {
            System.out.println(allCarrier);
        }

        int a = 0; int b = 5;
        List<PassengerCarrier> reachable = findReachable(allCarriers, a, b);
        System.out.println("\nYou can get from A to B by:");
        for (PassengerCarrier passengerCarrier : reachable) {
            System.out.println(passengerCarrier);
        }

        int best = findShortestWay(reachable, a, b);
        System.out.println("\nIt's better to go by "+reachable.get(best));
        reachable.get(best).carry(a, b);
    }

    private int findShortestWay(List<PassengerCarrier> reachable, int a, int b) {
        int best = 0;
        int minDistance = reachable.get(0).getDistanceBetween(a, b);
        System.out.println("\nDistance:");

        for (int i = 0; i < reachable.size(); i++) {
            PassengerCarrier curr = reachable.get(i);
            int curDist = curr.getDistanceBetween(a, b);
            System.out.println(i+": "+curDist+" km");
            if ( curDist < minDistance ) {
                minDistance = curDist;
                best = i;
            }
        }
        return best;
    }
    private List<PassengerCarrier> findReachable(List<PassengerCarrier> allCarriers, int a, int b) {
        List<PassengerCarrier> result = new ArrayList<>();
        allCarriers.stream().filter(c -> c.isReachable(a, b)).forEach(result::add);
        return result;
    }

    private List<PassengerCarrier> initializeCarriers() {
        List<List<Integer>> distance = new ArrayList<>();
        distance.add( new ArrayList<>(Arrays.asList(0, 5, 0, 2, 0, 6)) );
        distance.add( new ArrayList<>(Arrays.asList(5, 0, 4, 0, 0, 2)) );
        distance.add( new ArrayList<>(Arrays.asList(0, 4, 0, 0, 0, 1)) );
        distance.add( new ArrayList<>(Arrays.asList(2, 0, 0, 0, 6, 0)) );
        distance.add( new ArrayList<>(Arrays.asList(0, 0, 0, 6, 0, 3)) );
        distance.add( new ArrayList<>(Arrays.asList(6, 2, 1, 0, 3, 0)) );

        List<Integer> sequenceTrain1 = new ArrayList<>(Arrays.asList(0, 1, 2, 5));
        List<Integer> sequencePlane1 = new ArrayList<>(Arrays.asList(0, 5));
        List<Integer> sequenceCar1 = new ArrayList<>(Arrays.asList(0, 1, 5));

        List<Integer> sequenceTrain2 = new ArrayList<>(Arrays.asList(1, 2, 5, 4));
        List<Integer> sequencePlane2 = new ArrayList<>(Arrays.asList(0, 1));
        List<Integer> sequenceCar2 = new ArrayList<>(Arrays.asList(3, 4));

        List<PassengerCarrier> allCarriers = new ArrayList<>();
        allCarriers.add(new Train(new Route(distance, sequenceTrain1), 1));
        allCarriers.add(new Plane(new Route(distance, sequencePlane1), 2));
        allCarriers.add(new Car(new Route(distance, sequenceCar1), 3));
        allCarriers.add(new Train(new Route(distance, sequenceTrain2), 4));
        allCarriers.add(new Plane(new Route(distance, sequencePlane2), 5));
        allCarriers.add(new Car(new Route(distance, sequenceCar2), 6));
        return allCarriers;
    }

}
