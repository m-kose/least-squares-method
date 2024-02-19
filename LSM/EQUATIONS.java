package LSM;
import java.util.*;
import java.util.function.*;
public class EQUATIONS{
    static Map<BiFunction<Double, Double, Double>, Double> functions = new HashMap<>();
    

    //The system that you are going to solve:
    public static void firstFunction(){
        functions.put(((x, y) -> (x - y)), 4.0);
    }

    public static void secondFunction(){
        functions.put(((x, y) -> (3*x + 2*y)), 1.0);
    }

    public static void thirdFunction(){
        functions.put(((x, y) -> (-2*x + 4*y)), 3.0);
    }

    public static Map<BiFunction<Double, Double, Double>, Double> returnAllFunctions(){
        firstFunction();
        secondFunction();
        thirdFunction();
        return functions;
    }
}