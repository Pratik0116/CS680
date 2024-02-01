package edu.umb.cs680.hw11;

import java.util.List;

public class Manhattan implements DistanceMetric {

    public double distance(List<Double> p1, List<Double> p2) {
        if (p1.size() != p2.size()) {
            throw new IllegalArgumentException("Dimensions of the input points do not match.");
        }

        double manhattanDistance = 0.0;
        for (int i = 0; i < p1.size(); i++) {
            manhattanDistance += Math.abs(p1.get(i) - p2.get(i));
        }
        return manhattanDistance;
    }
}