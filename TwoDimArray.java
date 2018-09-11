import java.math.*;

public class TwoDimArray {
    public static void main(String []args){

        int H = 3;
        int W = 5;

//        int [][]array = new int[H][W];
        int [][] array = new int [][] {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };
//        for (int i = 0; i < H; i++){
//            for (int j = 0; j < W; j++){
//                array[i][j] =  (int )(Math.random()*9 + 1);
//            }
//        }

        array_print(array);

        System.out.println(array[1][2]);

        int [] arr = {1, 0, 0, 0, 1, 0};


        int p0 = 1;
        int pos = p0;
        int steps;

        for (int k = 0; k < 2; k++) {
            if (k == 0) {
                System.out.println("Ide w prawo");
                steps = 0;

                for (int i = pos; i < arr.length - 1; i++) {
                    if (arr[i + 1] == 0) {
                        System.out.println(("\nJestem na pozycji i = " + i));
                        System.out.println("Ide na pozycje i + 1 = " + (i + 1));
                        pos = i + 1;
                        steps++;
                    } else {
                        break;
                    }

                }
                System.out.println("Moja pozycja to = " + pos);
                System.out.println("Zrobilem " + steps + " krokow.");

            } else if (k == 1) {
                System.out.println("\nIde w lewo");
                steps = 0;

                for (int i = pos; i >= 1; i--) {
                    if (arr[i - 1] == 0) {
                        System.out.println(("\nJestem na pozycji i = " + i));
                        System.out.println("Ide na pozycje i - 1 = " + (i - 1));
                        pos = i - 1;
                        steps++;

                    } else {
                        break;
                    }

                }
                System.out.println("Moja pozycja to = " + pos);
                System.out.println("Zrobilem " + steps + " krokow.");

            }

        }
    }

    static void array_print(int [][]array){

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
