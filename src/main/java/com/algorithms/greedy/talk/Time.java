package com.algorithms.greedy.talk;

/**
 * Created by Usuario on 19/02/2017.
 */
public class Time implements Comparable {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.minute = minute;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                '}';
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public int compareTo(Object o) {
        Time other  = (Time)o;

        if (this.hour > other.hour) {
            return 1;
        } else if (this.hour < other.hour) {
            return -1;
        } else {
            if (this.minute > other.minute) {
                return 1;
            } else if ( this.minute < other.minute) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
