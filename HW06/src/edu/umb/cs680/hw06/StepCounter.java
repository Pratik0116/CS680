package edu.umb.cs680.hw06;

import java.util.ArrayList;
import java.util.List;

public class StepCounter {
    private List<StepCountObserver> observers = new ArrayList<>();
    private int stepCount;

    public void addObserver(StepCountObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StepCountObserver observer) {
        observers.remove(observer);
    }

    public void updateStepCount(int steps) {
        this.stepCount = steps;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StepCountObserver observer : observers) {
            observer.onStepCountChanged(stepCount);
        }
    }

}
