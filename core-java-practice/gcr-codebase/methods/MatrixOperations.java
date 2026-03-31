import java.util.Random;

public class MatrixOperations {

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int cols, int maxValue) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(maxValue + 1); // random number 0 to maxValue
            }
        }
        return matrix;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] diff = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                diff[i][j] = a[i][j] - b[i][j];
            }
        }
        return diff;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int common = a[0].length; // number of columns in a = number of rows in b
        int[][] product = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < common; k++) {
                    sum += a[i][k] * b[k][j];
                }
                product[i][j] = sum;
            }
        }
        return product;
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int rows = 3; // number of rows in a matrix
        int cols = 3; // number of columns in a matrix
        int maxValue = 10; // max random value

        // Generate two random matrices
        int[][] matrixA = createRandomMatrix(rows, cols, maxValue);
        int[][] matrixB = createRandomMatrix(rows, cols, maxValue);

        System.out.println("Matrix A:");
        displayMatrix(matrixA);

        System.out.println("Matrix B:");
        displayMatrix(matrixB);

        // Addition in matrix
        System.out.println("A + B:");
        int[][] sum = addMatrices(matrixA, matrixB);
        displayMatrix(sum);

        // Subtraction in matrix
        System.out.println("A - B:");
        int[][] diff = subtractMatrices(matrixA, matrixB);
        displayMatrix(diff);

        // Multiplication in matrix
        System.out.println("A * B:");
        int[][] product = multiplyMatrices(matrixA, matrixB);
        displayMatrix(product);
    }
}
