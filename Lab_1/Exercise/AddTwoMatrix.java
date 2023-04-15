import java.util.*;

public class AddTwoMatrix {
    static Scanner sc = new Scanner(System.in);

    static double[][] addMatrix(double[][] matrix1, double[][] matrix2){
        int row = matrix1.length;
        int col = matrix1[0].length;
        double[][] resMatrix = new double[row][col];
        for (int i = 0; i< row; i++)
            for (int j = 0; j < col; j++)
                resMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
        return resMatrix;
    }

    public static void main(String[] args) {
        System.out.println("Enter size of matrix row x col");
        int row = sc.nextInt();
        int col = sc.nextInt();

        double[][] matrix1 = new double[row][col];
        double[][] matrix2 = new double[row][col];

        System.out.println("Enter size of matrix 1");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matrix1[i][j] = sc.nextDouble();
        System.out.println("Enter size of matrix 1");
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matrix2[i][j] = sc.nextDouble();

        double[][] sumMatrix = addMatrix(matrix1, matrix2);
        System.out.println("Matrix1 + Matrix2: ");
        for (int i = 0; i < row; i++)
            System.out.println(Arrays.toString(sumMatrix[i]));       
    }
}