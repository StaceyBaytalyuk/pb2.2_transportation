package com.stacey.transportation;

import java.util.List;

public class Route {
    private List<List<Integer>> distance; // distance between each city
    private List<Integer> sequence; // route

    public Route(List<List<Integer>> distance, List<Integer> sequence) {
        this.distance = distance;
        this.sequence = sequence;
    }

    public boolean isReachable(int a, int b) {
        return sequence.contains(a) && sequence.contains(b);
    }

    public int distanceBetween(int a, int b) {
        int indexA=0; int indexB=0;
        for (int i = 0; i < sequence.size(); i++) {
            if ( sequence.get(i) == a ) {
                indexA = i;
            }
            if ( sequence.get(i) == b ) {
                indexB = i;
            }
        }

        if ( indexA > indexB ) {
            int temp = indexA; indexA = indexB; indexB = temp;
        }

        int result=0;
        for (int i = indexA; i < indexB; i++) {
            result += distance.get(i).get(sequence.get(i+1));
        }
        return result;
    }
}
