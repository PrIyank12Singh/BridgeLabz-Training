import java.util.Random;

public class MatrixAdvancedOperations {

    // Method to create a random matrix
    public static double[][] createRandomMatrix(int rows, int cols, int maxValue) {
        double[][] matrix = new double[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(maxValue + 1); // random 0 to maxValue
            }
        }
        return matrix;
    }

    // Method to display a matrix
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.2f ", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Method to find transpose of a matrix
    public static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transpose = new double[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }

    //Method for Determinant of 2x2 matrix
    public static double determinant2x2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    //Method for Determinant of 3x3 matrix
    public static double determinant3x3(double[][] matrix) {
        double det = matrix[0][0]*(matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1])
                    - matrix[0][1]*(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0])
                    + matrix[0][2]*(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0]);
        return det;
    }

    //Method for Inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] matrix) {
        double det = determinant2x2(matrix);
        if (det == 0) {
            System.out.println("2x2 Matrix is singular; cannot find inverse.");
            return null;
        }
        double[][] inv = {
            { matrix[1][1]/det, -matrix[0][1]/det },
            { -matrix[1][0]/det, matrix[0][0]/det }
        };
        return inv;
    }

    //Method for Inverse of 3x3 matrix
    public static double[][] inverse3x3(double[][] matrix) {
        double det = determinant3x3(matrix);
        if (det == 0) {
            System.out.println("3x3 Matrix is singular; cannot find inverse.");
            return null;
        }
        double[][] inv = new double[3][3];
        inv[0][0] = (matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1])/det;
        inv[0][1] = (matrix[0][2]*matrix[2][1]-matrix[0][1]*matrix[2][2])/det;
        inv[0][2] = (matrix[0][1]*matrix[1][2]-matrix[0][2]*matrix[1][1])/det;
        inv[1][0] = (matrix[1][2]*matrix[2][0]-matrix[1][0]*matrix[2][2])/det;
        inv[1][1] = (matrix[0][0]*matrix[2][2]-matrix[0][2]*matrix[2][0])/det;
        inv[1][2] = (matrix[0][2]*matrix[1][0]-matrix[0][0]*matrix[1][2])/det;
        inv[2][0] = (matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0])/det;
        inv[2][1] = (matrix[0][1]*matrix[2][0]-matrix[0][0]*matrix[2][1])/det;
        inv[2][2] = (matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0])/det;
        return inv;
    }

    public static void main(String[] args) {
        int size2x2 = 2;
        int size3x3 = 3;
        int maxValue = 10;

        // 2x2 matrix advanced operations
        double[][] matrix2x2 = createRandomMatrix(size2x2, size2x2, maxValue);
        System.out.println("2x2 Matrix:");
        displayMatrix(matrix2x2);
        System.out.println("Transpose:");
        displayMatrix(transposeMatrix(matrix2x2));
        System.out.println("Determinant: " + determinant2x2(matrix2x2));
        System.out.println("Inverse:");
        displayMatrix(inverse2x2(matrix2x2));

        // 3x3 matrix advanced operations
        double[][] matrix3x3 = createRandomMatrix(size3x3, size3x3, maxValue);
        System.out.println("3x3 Matrix:");
        displayMatrix(matrix3x3);
        System.out.println("Transpose:");
        displayMatrix(transposeMatrix(matrix3x3));
        System.out.println("Determinant: " + determinant3x3(matrix3x3));
        System.out.println("Inverse:");
        displayMatrix(inverse3x3(matrix3x3));
    }
}
