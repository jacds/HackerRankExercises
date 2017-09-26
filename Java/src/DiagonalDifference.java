/**
 * Created by Joao Silva on 26-09-2017.
 */

/**
 *
 * Available at: https://www.hackerrank.com/challenges/diagonal-difference
 * 
 * Given a square matrix of size , calculate the absolute difference between the sums of its diagonals.

 Input Format

 The first line contains a single integer, . The next  lines denote the matrix's rows, with each line containing space-separated integers describing the columns.

 Constraints

 Output Format

 Print the absolute difference between the two sums of the matrix's diagonals as a single integer.

 Sample Input

 3
 11 2 4
 4 5 6
 10 8 -12
 Sample Output

 15
 Explanation

 The primary diagonal is:

 11
 5
 -12
 Sum across the primary diagonal: 11 + 5 - 12 = 4

 The secondary diagonal is:

 4
 5
 10
 Sum across the secondary diagonal: 4 + 5 + 10 = 19
 Difference: |4 - 19| = 15

 Note: |x| is absolute value function
 */

import java.util.*;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nRows = in.nextInt();
        int[] matrix = new int[nRows*nRows];

        for(int i = 0; i < nRows*nRows; i++){
            matrix[i] = in.nextInt();
        }

        System.out.println(Math.abs(diagonalSum(nRows,matrix, 0) - diagonalSum(nRows, matrix, 1)));
    }

    public static int diagonalSum(int n, int[] matrix, int indexExtra){
        int diagonalSum = 0;
        int incrementer = (indexExtra == 0)? n+1 : n-1;
        int checkingIndex;

        for(int i = 0; i < n; i++){
            checkingIndex = incrementer*(i + indexExtra);
            diagonalSum += matrix[checkingIndex];
        }

        return diagonalSum;
    }

}
