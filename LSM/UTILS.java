package LSM;
import java.util.*;
public class UTILS {
    public static List<List<Double>> Transpose(List<List<Double>> A){
        int rows = A.size();
        int cols = A.get(0).size();
        List<List<Double>> Result = new ArrayList<>();

        for(int i = 0; i < cols; i++){
            List<Double> row = new ArrayList<>();
            for(int j = 0; j < rows ; j++){
                row.add(A.get(j).get(i));
            }
            Result.add(row);
        }
        return Result;
    }

    public static List<List<Double>> dotProduct2D2D(List<List<Double>> matrix1, List<List<Double>> matrix2) {
        int rows1 = matrix1.size();
        int cols1 = matrix1.get(0).size();
        int rows2 = matrix2.size();
        int cols2 = matrix2.get(0).size();
        List<List<Double>> result = new ArrayList<>();

        for (int i = 0; i < rows1; i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < cols2; j++) {
                double sum = 0.0;
                for (int k = 0; k < cols1; k++) {
                    sum += matrix1.get(i).get(k) * matrix2.get(k).get(j);
                }
                row.add(sum);
            }
            result.add(row);
        }

        return result;
    }

    public static List<Double> dotProduct2D1D(List<List<Double>> matrix, List<Double> array) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            double sum = 0.0;
            for (int j = 0; j < cols; j++) {
                sum += matrix.get(i).get(j) * array.get(j);
            }
            result.add(sum);
        }
        return result;
    }

    public static List<Double> GaussianElimination(List<List<Double>> equation, List<Double> values) {
        int n = values.size();
        for (int pivot = 0; pivot < n - 1; pivot++) {
            for (int row = pivot + 1; row < n; row++) {
                double factor = equation.get(row).get(pivot) / equation.get(pivot).get(pivot);
                for (int col = pivot; col < n; col++) {
                    double eq = equation.get(row).get(col) - factor * equation.get(pivot).get(col);
                    equation.get(row).set(col, eq);
                }
                values.set(row, values.get(row) - factor * values.get(pivot));
            }
        }

        // Back substitution
        List<Double> x = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            x.add(0.0);
        }

        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += equation.get(i).get(j) * x.get(j);
            }
            x.set(i, (values.get(i) - sum) / equation.get(i).get(i));
        }
        return x;
    }

    public static List<Double> matrixSubs(List<Double> max1, List<Double> max2){
        List<Double> Results = new ArrayList<>();
        for(int i = 0; i < max2.size(); i++){
            Results.add(max1.get(i) - max2.get(i));
        }
        return Results;
    }
}
