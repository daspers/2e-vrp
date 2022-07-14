package nl.tue.vrp.model;

import nl.tue.vrp.config.TimeWindowConfig;

public class TimeWindow {
    protected final int startTime;
    protected final int endTime;

    public TimeWindow(int start, int end) {
        if (start > end) {
            this.endTime = start;
            this.startTime = end;
        } else {
            this.startTime = start;
            this.endTime = end;
        }
    }

    public TimeWindow(TimeWindowConfig config) {
        if (config.getStart() > config.getEnd()) {
            this.endTime = config.getStart();
            this.startTime = config.getEnd();
        } else {
            this.startTime = config.getStart();
            this.endTime = config.getEnd();
        }
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean withinRange(int time) {
        return startTime <= time && time <= endTime;
    }

    public int compareTo(int time) {
        if (time < startTime) {
            return -1;
        }
        if (time > endTime) {
            return 1;
        }
        return 0;
    }

    public boolean isIntersect(TimeWindow window) {
        return !(window.endTime < startTime || window.startTime > endTime);
    }
}
