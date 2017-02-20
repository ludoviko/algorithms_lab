package com.algorithms.greedy.talk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Schedule the most talks using a greedy algorithms.
 */
public class TalksSchedule {
    private List<Talk> data;

    public TalksSchedule(List<Talk> data) {
        this.data = data;
    }

    public List<Talk> findBestSchedule() {
        List<Talk> schedule = new ArrayList<Talk>();

        Collections.sort(data);
        Talk before = this.data.get(0);
        schedule.add(before);

        for (int i = 1; i < this.data.size(); i++) {
            if (before.getEnd().compareTo(this.data.get(i).getStart()) <= 0) {
                schedule.add(data.get(i));
                before = data.get(i);
            } else {
            }
        }
        return schedule;
    }

    public static void main(String[] args) {
        List<Talk> data = new ArrayList<Talk>();

        data.add(new Talk(new Time(9, 0), new Time(9, 45)));
        data.add(new Talk(new Time(9, 30), new Time(10, 0)));
        data.add(new Talk(new Time(9, 50), new Time(10, 15)));
        data.add(new Talk(new Time(10, 0), new Time(10, 30)));
        data.add(new Talk(new Time(10, 10), new Time(10, 25)));
        data.add(new Talk(new Time(10, 30), new Time(10, 55)));
        data.add(new Talk(new Time(10, 15), new Time(10, 45)));
        data.add(new Talk(new Time(10, 30), new Time(11, 0)));
        data.add(new Talk(new Time(10, 45), new Time(11, 30)));
        data.add(new Talk(new Time(10, 55), new Time(11, 25)));
        data.add(new Talk(new Time(11, 0), new Time(11, 15)));

        TalksSchedule talksSchedule = new TalksSchedule(data);

        List<Talk> schedule =  talksSchedule.findBestSchedule();

        for (Talk t : schedule) {
            System.out.println(t);
        }

        System.out.println(schedule.size());
    }
}
