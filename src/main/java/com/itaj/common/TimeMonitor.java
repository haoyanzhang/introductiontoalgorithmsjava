package com.itaj.common;

public class TimeMonitor {

    private String name;
    private long startTime = 0L;

    public TimeMonitor(String name) {
        this.name = name;
    }

    public TimeMonitor(Class<?> clazz) {
        this.name = clazz.getName();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        long endTime = System.currentTimeMillis();
        System.out.println(name + " time:" + (endTime - startTime) + "ms");
    }
}
