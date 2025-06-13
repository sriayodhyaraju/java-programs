import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the matrix
        System.out.print("Enter the size of the matrix (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        int value = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (value <= n * n) {
            // Traverse from left to right
            for (int i = left; i <= right && value <= n * n; i++) {
                matrix[top][i] = value++;
            }
            top++;

            // Traverse downwards
            for (int i = top; i <= bottom && value <= n * n; i++) {
                matrix[i][right] = value++;
            }
            right--;

            // Traverse from right to left
            for (int i = right; i >= left && value <= n * n; i--) {
                matrix[bottom][i] = value++;
            }
            bottom--;

            // Traverse upwards
            for (int i = bottom; i >= top && value <= n * n; i--) {
                matrix[i][left] = value++;
            }
            left++;
        }

        // Output the matrix
        System.out.println("Spiral Matrix:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }
}
