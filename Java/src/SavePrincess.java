/**
 * Created by Joao Silva on 17-10-2017.
 */


import java.util.Scanner;

/**
 * Available at: https://www.hackerrank.com/challenges/saveprincess
 */

public class SavePrincess {


    public static void displayPathtoPrincess(String[][] matrix){
        int[] marioPosition = new int[2];
        int[] princessPosition = new int[2];

        //  UP, RIGHT, DOWN, LEFT
        double[] movementDistance = new double[4];
        String[] movement = {"UP", "RIGHT", "DOWN", "LEFT"};
        int minimumValue;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j].equals("m")){
                    marioPosition[0] = i;
                    marioPosition[1] = j;
                    //System.out.println(marioPosition[0] + ", " + marioPosition[1]);
                }
                else if(matrix[i][j].equals("p")){
                    princessPosition[0] = i;
                    princessPosition[1] = j;
                    //System.out.println(princessPosition[0] + ", " + princessPosition[1]);
                }
            }
        }

        while(euclideanDistance(marioPosition, princessPosition) != 0){
            movementDistance[0] = marioPosition[0] - 1 > -1? euclideanDistance(new int[]{marioPosition[0] - 1, marioPosition[1]}, princessPosition) : -1;
            movementDistance[1] = marioPosition[1] + 1 < matrix.length? euclideanDistance(new int[]{marioPosition[0], marioPosition[1] + 1}, princessPosition) : -1;
            movementDistance[2] = marioPosition[0] + 1 < matrix.length? euclideanDistance(new int[]{marioPosition[0] + 1, marioPosition[1]}, princessPosition) : -1;
            movementDistance[3] = marioPosition[1] - 1 > -1? euclideanDistance(new int[]{marioPosition[0], marioPosition[1] - 1}, princessPosition) : -1;

            //System.out.println(movementDistance[0] + "|| " + movementDistance[1] + "|| " + movementDistance[2] + "|| " + movementDistance[3]);

            minimumValue = 0;
            for(int i = 1; i < movementDistance.length; i++){
                if((movementDistance[i] < movementDistance[minimumValue] || movementDistance[minimumValue] == -1) && movementDistance[i] != -1){
                    minimumValue = i;
                }
            }

            System.out.println(movement[minimumValue]);

            if(minimumValue%2 == 0){
                marioPosition[0] += (minimumValue - 1);
            }
            else{
                marioPosition[1] += -(minimumValue - 2);
            }

            //System.out.println(marioPosition[0] + ", " + marioPosition[1]);
        }
        //euclideanDistance(marioPosition, princessPosition);

    }

    public static double euclideanDistance(int[] objectOne, int[] objectTwo){
        double distance = Math.sqrt(Math.pow(objectOne[0] - objectTwo[0], 2) + Math.pow(objectOne[1] - objectTwo[1], 2));
        //System.out.println(distance);
        return distance;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int gridSize = in.nextInt();

        String[][] matrix = new String[gridSize][gridSize];

        //  Get the matrix grid
        for(int i = 0; i < gridSize; i++){
            String line = in.next();
            matrix[i] = line.split("(?!^)");
        }

        /*for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }*/

        displayPathtoPrincess(matrix);
    }

}
