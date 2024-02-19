package LSM;
import java.util.*;
import java.util.function.*;
public class LEAST_SQUARES_METHOD {
    static Map<BiFunction<Double, Double, Double>, Double> functions = new HashMap<>();
    static List<Double> Values = new ArrayList<>();
    List<List<Double>> A = new ArrayList<>();
    public LEAST_SQUARES_METHOD(){
        getFunctions();
        getValues();
        calculateA();
    }
    public static void getFunctions(){
        functions = EQUATIONS.returnAllFunctions();
    }

    public static void getValues(){
        for(Double i : functions.values()){
            Values.add(i);
        }
    }

    public void calculateA(){
        for(BiFunction<Double, Double, Double> Function : functions.keySet()){
            double X1 = Function.apply(1.0, 0.0);
            double X2 = Function.apply(0.0, 1.0);
            A.add(Arrays.asList(X1, X2));
        }
    }

    public List<List<Double>> ATdotA(){ // >(A^T * A)< * x = A^T * b
        List<List<Double>> AT = UTILS.Transpose(A);
        List<List<Double>> Results = new ArrayList<>();
        Results = UTILS.dotProduct2D2D(AT, A);
        return Results;
    }

    public List<List<Double>> ATdotAdotx(){ // >([A^T * A] * x)< = A^T * b
        List<List<Double>> ATdotA = new ArrayList<>();
        // Our gaussian elimination function will handle the array just fine without 
        //the need for dot OP with the [1,1] matrix which represents the x1 and x2 values
        //So we will not need these operations below
        //But you can check below and get an idea what we were trying to achieve
        /*
        List<Double> x = new ArrayList<>();
        List<Double> Results = new ArrayList<>();
        ATdotA = ATdotA();
        x.add(1.0);
        x.add(1.0);
        Results = UTILS.dotProduct2D1D(ATdotA, x);
        return Results;
        */
        ATdotA = ATdotA();
        return ATdotA;
    }

    public List<Double> ATdotb(){ // A^T * A * x = >(A^T * b)<
        List<List<Double>> AT = UTILS.Transpose(A);
        List<Double> Results = new ArrayList<>();
        Results = UTILS.dotProduct2D1D(AT, Values);
        return Results;
    }

    public List<Double> finalResults(){ // >(A^T * A * x = A^T * b)<
        List<List<Double>> ATdotAdotx = ATdotAdotx();
        List<Double> ATdotb = ATdotb();
        List<Double> Results = new ArrayList<>();
        Results = UTILS.GaussianElimination(ATdotAdotx, ATdotb);
        return Results;
    }

    public List<Double> leastSquaresErrorVector(){ // b - A * [finalResults]
        List<Double> calculatedX = finalResults();
        List<Double> newAx = new ArrayList<>();
        List<Double> Results = new ArrayList<>();
        newAx = UTILS.dotProduct2D1D(A, calculatedX);
        Results = UTILS.matrixSubs(Values, newAx); // Values is equivalent to b in the formula
        return Results;
    }

    public Double leastSquaresError(){ // || b - A * [finalResults] ||
        List<Double> LeastSquaresErrorVector = leastSquaresErrorVector();
        double sum = 0.0;
        for(int i = 0; i < LeastSquaresErrorVector.size(); i++){
            sum += Math.pow(LeastSquaresErrorVector.get(i), 2);
        }
        return Math.sqrt(sum);
    }
}