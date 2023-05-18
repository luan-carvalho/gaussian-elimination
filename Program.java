import matrix.AugmentedMatrix;
import util.GaussJordanElimination;

public class Program {
    public static void main(String[] args) {

        double[][] e = {{5,2,3,4}, {2,6,7,8}, {9,15,8}};

        AugmentedMatrix m = new AugmentedMatrix(e);
        System.out.println(GaussJordanElimination.elimination(m));

    }

}
