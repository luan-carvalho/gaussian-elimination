package util;
import matrix.AugmentedMatrix;

public class GaussJordanElimination {

    public static AugmentedMatrix elimination(AugmentedMatrix m) {

        if (m.length() == 1) {
            return m;
        }
        
        if (!(m.findPivot() == 1)) {
            m.switchLines(1, m.findPivot());
        } else if (m.get(1, 1) != 1) {
            m.lineMultiplication(1, (1 / m.get(1,1)));
        }


        
        return m;
    
    }
    
}
