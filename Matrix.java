public class Matrix {

    private int[][] elements;

    public Matrix(int[][] elements) {

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                this.elements[i][j] = elements[i][j];
            }
        }

    }



}