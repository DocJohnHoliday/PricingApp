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

    public double glassSquareFootage(double width, double height, double price) {
        return Math.ceil((((width - 3) / 12) * ((height - 3) / 12)) * price);
    }

    public double metalLinearFoot(double width, double height, double price, int panels, int midRails) {
        if(panels == 1) {
            height = height * 2;
        }
        if (panels > 1) {
            int verticals = panels + 1;
            height = height * verticals;
        }
        if(midRails == 0) {
            width = width * 2;
        }
        if (midRails > 0) {
            int horizontals = midRails + 2;
            width = width * horizontals;
        }
        return (width + height) * price;
    }

    public double metalLinearFootUnited(double x, double y) {
        return (x + y) * 1.75;
    }

}
