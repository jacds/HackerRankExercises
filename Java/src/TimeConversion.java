/**
 * Created by Joao Silva on 26-09-2017.
 */

import java.util.Scanner;

/**
 *
 * Available at: https://www.hackerrank.com/challenges/time-conversion
 *
 * Given a time in -hour AM/PM format, convert it to military (-hour) time.

 Note: Midnight is  on a -hour clock, and  on a -hour clock. Noon is  on a -hour clock, and  on a -hour clock.

 Input Format

 A single string containing a time in -hour clock format (i.e.:  or ), where  and .

 Output Format

 Convert and print the given time in -hour format, where .

 Sample Input

 07:05:45PM
 Sample Output

 19:05:45
 */
public class TimeConversion {

    static String timeConversion(String s) {
        String result = s.substring(s.length()-2);
        int hour = Integer.parseInt(s.substring(0,2));
        hour = (result.equals("PM"))? hour + 12 : hour - 12;

        // Prevent wrong output dates (given actual valid input dates!)
        if(hour<0){
            hour += 12;
        }
        if(hour > 23){
            hour -= 12;
        }

        result = (hour > 10)? Integer.toString(hour) + s.substring(2,s.length()-2) : Integer.toString(0) + Integer.toString(hour) + s.substring(2,s.length()-2);

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }

}
