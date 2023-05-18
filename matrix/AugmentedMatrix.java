package matrix;
import java.util.function.Consumer;
import java.util.function.Function;

public class AugmentedMatrix {

    private double[][] elements;
    private int switchLinesMultiplier = 1;

    public AugmentedMatrix(double[][] elements) {

        for (int i = 1; i < elements.length; i++) {

            if (elements[i].length != elements[i - 1].length)
                throw new RuntimeException("There must be the same number of columns in each row of the augmented matrix");

        }

        if (elements.length != elements[0].length -1) {
            throw new RuntimeException("This is not a valid augmented matrix, because the number of rows is not equal to the number of columns - 1");
        }

        this.elements = elements;

    }

    public int length() {
        return this.elements.length;
    }

    public double get(int i, int j) {
        return this.elements[i - 1][j - 1];
    }

    public void setLine(int row, double[] elements) {

        for (int i = 0; i < this.elements[row - 1].length; i++) {
            this.elements[row - 1][i] = elements[i];
        }

    }

    public double[] getLine(int row) {
        return this.elements[row - 1];
    }

    public double[] lineOperation(int line1, double k1, int line2, double k2) {

        double[] result = new double[elements[line1 - 1].length];

        for (int i = 0; i < result.length; i++) {

            result[i] = elements[line1 - 1][i] * k1 + elements[line2 - 1][i] * k2;

        }


        return result;

    }

    public int findPivot() {

        for (int i = 0; i < elements.length; i++) {
            if (elements[i][0] == 1) {
                return i + 1;
            }
        }

        return 1;

    }

    public int getSwitchLinesMultiplier() {
        return switchLinesMultiplier;
    }

    public void switchLines(int line1, int line2) {

        if ((line1 - 1 < 0 || line1 - 1 > elements.length) || (line2 - 1 < 0 || line2 - 1 > elements.length))
            throw new RuntimeException("Insert a valid row for line1 ([1, n], n = number of lines)");
        else if (line2 - 1 < 0 || line2 - 1 > elements.length) {
            throw new RuntimeException("Insert a valid row for line2 ([1, n], n = number of lines)");
        } else if (line1 == line2) {
            throw new RuntimeException("The lines must be different");
        }

        for (int i = 0; i < elements[line1 - 1].length; i++) {

            double temp = elements[line1 - 1][i];
            elements[line1 - 1][i] = elements[line2 - 1][i];
            elements[line2 - 1][i] = temp;

        }

        this.switchLinesMultiplier *= -1;
    }

    public void lineMultiplication(int row, double k) {
        mapLine(row, x -> x*k);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < elements.length; i++) {

            sb.append("[");

            for (int j = 0; j < elements[i].length; j++) {

                sb.append(elements[i][j]
                        + (j == elements[i].length - 1 ? "]" : "\t"));
            }

            sb.append(i == elements.length - 1 ? "" : "\n");

        }

        return sb.toString();

    }

    public void forEachInLine(int row, Consumer<Double> c) {

            for (double element : elements[row - 1]) {
                c.accept(element);
            }
    }

    public void mapLine(int row, Function<Double, Double> f) {
        for (int i = 0; i < elements[row - 1].length; i++) {
            elements[row - 1][i] = f.apply(elements[row - 1][i]);
        }
    }

    }
