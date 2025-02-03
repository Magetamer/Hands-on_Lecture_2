import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            //A new row starting at 1
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for (int j = 1; j < i; j++) { //Computation for the numbers within each row after 1
                row.set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt(); //Take user input for number of rows to calculate
        scanner.close();

        PascalsTriangle solution = new PascalsTriangle();
        List<List<Integer>> result = solution.generate(numRows);

        for (List<Integer> row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("""
                Expected Result for 5 rows:
                1\s
                1 1\s
                1 2 1\s
                1 3 3 1\s
                1 4 6 4 1\s""");
    }
}
