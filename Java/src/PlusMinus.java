/**
 * Created by Joao Silva on 26-09-2017.
 */

import java.util.Scanner;

/**
 *
 * Available at: https://www.hackerrank.com/challenges/plus-minus
 *
Given an array of integers, calculate which fraction of its elements are positive, which fraction of its elements are negative, and which fraction of its elements are zeroes, respectively. Print the decimal value of each fraction on a new line.

Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.

Input Format

The first line contains an integer, , denoting the size of the array.
The second line contains  space-separated integers describing an array of numbers .

Output Format

You must print the following  lines:

A decimal representing of the fraction of positive numbers in the array compared to its size.
A decimal representing of the fraction of negative numbers in the array compared to its size.
A decimal representing of the fraction of zeroes in the array compared to its size.
Sample Input

6
-4 3 -9 0 4 1
Sample Output

0.500000
0.333333
0.166667
Explanation

There are  positive numbers,  negative numbers, and  zero in the array.
The respective fractions of positive numbers, negative numbers and zeroes are 3/6, 2/6 and 1/6, respectively.

*/

public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int value;

        int positiveValues = 0;
        int negativeValues = 0;

        //  We just need to verify the values greater or lower than zero
        //  And since there's no need to postprocess the values, there's no need to create a matrix
        //  Instead, let's store just the current matrix value
        for(int i = 0; i < n; i++){
            value = in.nextInt();
            if(value > 0){
                positiveValues++;
            }
            else if(value < 0 ){
                negativeValues++;
            }
        }

        System.out.println(String.format("%.6f", (double) positiveValues/n));
        System.out.println(String.format("%.6f", (double) negativeValues/n));
        //  The zeroes are basically the number of elements in the matrix minus the positive and negative values
        System.out.println(String.format("%.6f", (double) (n - positiveValues - negativeValues)/n));
    }
}
