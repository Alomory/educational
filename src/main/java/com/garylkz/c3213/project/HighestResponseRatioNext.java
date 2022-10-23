package com.garylkz.c3213.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HighestResponseRatioNext {
    List<Process> waitingQueue, readyQueue = new ArrayList<>(), finishedQueue = new ArrayList<>();
    Process currentProcess = null;
    int t = -1; // current time

    public HighestResponseRatioNext(Process... processes) {
        this.waitingQueue = new ArrayList<>(Arrays.asList(processes));
        next();
    }

    public String next() {
        t++;
        // check waiting queue for processes that can be added to ready queue
        Iterator<Process> iterator = waitingQueue.iterator();
        while (iterator.hasNext()) {
            Process p = iterator.next();
            if (p.getW() == t) { // assume negative wait time is impossible
                readyQueue.add(p);
                iterator.remove();
            }
        }
        // process current process
        if (currentProcess != null) {
            int dt = currentProcess.getW() - t;
            if (dt < 0) dt = 0;
            int sum = dt + currentProcess.getS() + finishedQueue.stream().map(Process::getS).reduce(0, Integer::sum);
            if (t == sum) {
                finishedQueue.add(currentProcess);
                currentProcess = null;
            }
        }
        // check if current process is done
        if (currentProcess == null && readyQueue.size() > 0) {
            double r = 0;
            int i = 0;
            for (Process p : readyQueue) {
                double w = t - p.getW();
                double s = (w + p.getS()) / p.getS();
                if (s > r) {
                    r = s;
                    i = readyQueue.indexOf(p);
                }
            }
            currentProcess = readyQueue.remove(i);
        }
        return toString();
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "t = " + t + '\n' +
                "Current Process: " + currentProcess + '\n' +
                "Waiting Queue: " + waitingQueue + '\n' +
                "Ready Queue: " + readyQueue + '\n' +
                "Finished Queue: " + finishedQueue;
    }
}
