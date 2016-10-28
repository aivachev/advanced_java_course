package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String... args) {
        if (args.length < 6)
        {
            System.err.println("Неправильная строка аргументов");
            return;
        }
        int[] results = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            results[i] = Integer.parseInt(args[i]);
        }

        int cntA = results[0] * results[1];
        int cntB = results[2] * results[3];
        if(validate(cntA, cntB, results)) {
            int[] mtrx1 = new int[cntA];
            int[] mtrx2 = new int[cntB];

            for (int i = 0; i < results[0] * results[1]; i++) {
                mtrx1[i] = results[4 + i];
            }
            for (int i = 0; i < results[2] * results[3]; i++) {
                mtrx2[i] = results[4 + cntA + i];
            }

            Matrix A = new Matrix(results[0], results[1], mtrx1);
            Matrix B = new Matrix(results[2], results[3], mtrx2);

            int[][] AB = new int[results[0]][results[3]];
            AB = Matrix.multiplication(A,B);
            Matrix.printMatrix(AB, results[0], results[3]);
        }
    }

    static boolean validate(int cA, int cB, int[] arguments){
        if (arguments.length != 4 + cA + cB || arguments[0] < 1 || arguments[1] < 1 || arguments[2] < 1 || arguments[3] < 1) {
            System.err.println("Неправильные аргументы на входе");
            return false;
        } else if (arguments[1] != arguments[2]){
            System.err.println("Матрицы не согласованы, то есть число столбцов в первом сомножителе не равно числу строк во втором");
            return false;
        }
        else return true;
    }
}

class Matrix {
    private int N;
    private int M;
    public int[][] R;

    public Matrix(int n, int m, int[] nmbr) {
        N = n;
        M = m;
        int k = 0;
        R = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                R[i][j] = nmbr[k];
                k++;
            }
    }

    static public int[][] multiplication(Matrix A, Matrix B) {
        int[][] res = new int[A.N][B.M];
        for (int i = 0; i < A.N; i++) {
            for (int j = 0; j < B.M; j++) {
                for (int k = 0; k < A.M; k++) {
                    res[i][j] += A.R[i][k] * B.R[k][j];
                }
            }
        }
        return res;
    }

    static public void printMatrix(int[][] AB, int N, int M)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(AB[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
