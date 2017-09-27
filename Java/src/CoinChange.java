/**
 * Created by Joao Silva on 26-09-2017.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Available at: https://www.hackerrank.com/challenges/coin-change
 */
public class CoinChange {

    static long getWays(long n, long[] c){
        /** Create matrix (types of coins + 1) * (change + 1) (in order to also include 0 type of coins and 0 change)
         *  Each line is a type of coin
         *  Each column is a different change value
         *  Each cell contains the number of ways to give the change, given the available coin types
         * */
        long[][] numberOfWaysMatrix = new long[c.length+1][(int) n+1];

        for(int i = 1; i <= c.length; i++){
            for(int j = 1; j <= n; j++){
                /**
                 * There is just one way to give a 0 change with any type of coins
                 */
                numberOfWaysMatrix[i][0] = 1;

                /**
                 * If the current type of coin has a lower or equal value than the current change,
                 * current number of ways = previous number of ways with 1 less type of coin + previous number of ways with the same type of coins distancing the current coin value
                 */
                if(c[i-1] <= j){
                    numberOfWaysMatrix[i][j] = numberOfWaysMatrix[i-1][j] + numberOfWaysMatrix[i][(int) (j - c[i-1])];
                }
                /**
                 * Otherwise we will pick the number of ways for the same change with one less type of coins
                 */
                else{
                    numberOfWaysMatrix[i][j] = numberOfWaysMatrix[i-1][j];
                }
            }
        }

        //printMatrix(numberOfWaysMatrix, c.length+1,(int) n+1);

        return numberOfWaysMatrix[c.length][(int) n];
    }

    static void printMatrix(long[][] sumMatrix, int height, int width){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);

        System.out.println(ways);
    }
}
