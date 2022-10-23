package com.garylkz.c3213.project;

public class Process {
    private int w, s; // w = wait time, s = burst time

    public Process(int w, int s) {
        this.w = w;
        this.s = s;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Process{" +
                "w=" + w +
                ", s=" + s +
                '}';
    }
}
