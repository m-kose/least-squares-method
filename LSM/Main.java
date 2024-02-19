package LSM;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Double> Results = new ArrayList<>();
        List<Double> LSM_err_vector = new ArrayList<>();
        LEAST_SQUARES_METHOD LSM = new LEAST_SQUARES_METHOD();
        Results = LSM.finalResults();
        System.out.println("\n"+"THE x_1 AND x_2 VARIABLES IN THE SYSTEM: "+"\n");
        for(int i = 0; i < Results.size(); i++){
            System.out.println(Results.get(i));
        }

        LSM_err_vector = LSM.leastSquaresErrorVector();
        System.out.println("\n"+"THE ERROR VECTOR: "+"\n");
        for(int i = 0; i < LSM_err_vector.size(); i++){
            System.out.println(LSM_err_vector.get(i));
        }

        System.out.println("\n"+"ERROR: "+"\n");
        Double LSM_ERROR = LSM.leastSquaresError();
        System.out.print(LSM_ERROR);
    }
}