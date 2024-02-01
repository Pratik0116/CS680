package edu.umb.cs680.hw11;

import java.util.List;

public class Cosine implements DistanceMetric {
    public double distance(List<Double> p1, List<Double> p2) {
        if (p1.size() != p2.size()) {
            throw new IllegalArgumentException("Dimensions of the input points do not match.");
        }

        double dotProduct = 0.0;
        double magnitudeP1 = 0.0;
        double magnitudeP2 = 0.0;

        for (int i = 0; i < p1.size(); i++) {
            dotProduct += p1.get(i) * p2.get(i);
            magnitudeP1 += Math.pow(p1.get(i), 2);
            magnitudeP2 += Math.pow(p2.get(i), 2);
        }

        if (magnitudeP1 == 0 || magnitudeP2 == 0) {
            throw new ArithmeticException("One or both vectors have zero magnitude.");
        }

        double cosineSimilarity = dotProduct / (Math.sqrt(magnitudeP1) * Math.sqrt(magnitudeP2));
        return 1 - cosineSimilarity;
    }
}