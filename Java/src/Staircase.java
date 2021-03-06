import java.util.Scanner;

/**
 * Created by Joao Silva on 26-09-2017.
 */

/**
 *
 * Available at: https://www.hackerrank.com/challenges/staircase
 *
 * Consider a staircase of size :

    #
   ##
  ###
 ####
 Observe that its base and height are both equal to , and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.

 Write a program that prints a staircase of size .

 Input Format

 A single integer, , denoting the size of the staircase.

 Output Format

 Print a staircase of size  using # symbols and spaces.

 Note: The last line must have  spaces in it.

 Sample Input

 6
 Sample Output

      #
     ##
    ###
   ####
  #####
 ######
 Explanation

 The staircase is right-aligned, composed of # symbols and spaces, and has a height and width of .
 */

public class Staircase {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int current = size - 1;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(j < current){
                    System.out.print(" ");
                }
                else{
                    System.out.print("#");
                }
            }
            System.out.println();
            current--;
        }
    }
}
