package com.algorithms.greedy.talk;

/**
 * Created by Usuario on 19/02/2017.
 */
public class Talk implements Comparable {
    private Time start;
    private Time end;

    public Talk(Time start, Time end) {
        this.end = end;
        this.start = start;
    }

    public int compareTo(Object o) {
        Talk other = (Talk) o;
        Time oTimeEnd = other.getEnd();

        return this.getEnd().compareTo(oTimeEnd);
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
