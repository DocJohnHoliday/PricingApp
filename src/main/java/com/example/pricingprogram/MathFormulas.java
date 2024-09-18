package com.example.pricingprogram;

public class MathFormulas {
    public double fractionToDecimal(String x) {

        try {
            String[] split = x.trim().split("\\s+");
            String fraction = split[1];
            String[] splitFraction = fraction.split("/");
            double y = Double.parseDouble(splitFraction[0]);
            double z = Double.parseDouble(splitFraction[1]);
            String whole = split[0];
            double wholeNum = Double.parseDouble(whole);

            return wholeNum + (y / z);
        } catch (ArrayIndexOutOfBoundsException e) {
            return Double.parseDouble(x);
        }
    }

    public double glassSquareFootage(double x, double y) {
        return Math.ceil((((x - 3) / 12) * ((y - 3) / 12)) * 10);
    }

    public double metalLinearFoot(double x, double y) {
        return Math.ceil(((x * 2) + (y * 2)) / 0.50);
    }

    public double metalLinearFootUnited(double x, double y) {
        return (x + y) / 0.50;
    }

}
