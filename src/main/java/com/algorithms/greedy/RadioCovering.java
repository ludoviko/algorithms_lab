package com.algorithms.greedy;

import java.util.*;

/**
 * Created by Usuario on 28/08/2016.
 *
 */

// Source: Groking Algorithms, page 141.

public class RadioCovering {
    private Set<String> states;
    private Map<String, Set<String>> stationMap;
    private Set<String> stations;

    public RadioCovering() {
        states = new HashSet<String>();
        stationMap = new HashMap<String, Set<String>>();
        stations = new HashSet<String>();
    }

    public void addState(String state) {
        states.add(state);
    };

    public void addStation(String station, Set<String> states) {
        stationMap.put(station, states);
    };

    public Set<String> find() {

        String stationBest;
        Set<String> statesCovered;

        while ( ! states.isEmpty() ) {
            stationBest = "";
            statesCovered = new HashSet<String>();

            for (Map.Entry<String, Set<String>> entry : stationMap.entrySet() ) {
                Set<String> statesIntersetion = new HashSet<String>(entry.getValue());
                statesIntersetion.retainAll(states);

                if ( statesIntersetion.size() > statesCovered.size() ) {
                    statesCovered = statesIntersetion;
                    stationBest = entry.getKey();
                }

            }
            states.removeAll(statesCovered);
            stations.add(stationBest);
        }

        return stations;
    }

    public static void main(String[] strings) {
        RadioCovering radio = new RadioCovering();
        radio.addState("mt");
        radio.addState("wa");
        radio.addState("or");
        radio.addState("id");
        radio.addState("nv");
        radio.addState("ut");
        radio.addState("ca");
        radio.addState("az");

        Set<String> cities;
        cities   = new HashSet<String>();
        cities.addAll(Arrays.asList("id", "nv", "ut"));
        radio.addStation("kone", cities);

        cities   = new HashSet<String>();
        cities.addAll(Arrays.asList("wa", "id", "mt"));
        radio.addStation("ktwo", cities);

        cities   = new HashSet<String>();
        cities.addAll(Arrays.asList("or", "nv", "ca"));
        radio.addStation("kthree", cities);

        cities   = new HashSet<String>();
        cities.addAll(Arrays.asList("nv", "ut"));
        radio.addStation("kfour", cities);

        cities   = new HashSet<String>();
        cities.addAll(Arrays.asList("ca", "az"));
        radio.addStation("kfive", cities);

        cities = radio.find();

        System.out.println(cities);
    }
}
