import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> solution = new ArrayList<>();

        //If matrix is empty, return res as is to avoid errors
        if (matrix.length == 0) {
            return solution;
        }

        // Define boundaries
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        //Traversing the matrix
        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            //Move from left to right
            for (int j = colBegin; j <= colEnd; j++) {
                solution.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            //Move from top to bottom
            for (int j = rowBegin; j <= rowEnd; j++) {
                solution.add(matrix[j][colEnd]);
            }
            colEnd--;

            //Check if there are any rows left
            if (rowBegin <= rowEnd) {
                //Move from right to left
                for (int j = colEnd; j >= colBegin; j--) {
                    solution.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            //Check if there are any columns left
            if (colBegin <= colEnd) {
                //Move from bottom to top
                for (int j = rowEnd; j >= rowBegin; j--) {
                    solution.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return solution;
    }

    public static void main(String[] args) {
        SpiralMatrix matrixSolution = new SpiralMatrix();
        int[][] matrix = { //Testcase
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(matrixSolution.spiralOrder(matrix));
    }
}
