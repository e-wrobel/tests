import java.util.ArrayList;
import java.util.List;

public class SubArray {
    static public void main (String []args){

        // def Shape -> structure described by alligned zeros
        List<Integer> rightZeros = new ArrayList<Integer>();
        List<Coordinates> coordinatesList = new ArrayList<Coordinates>();

        int are_there_zeros = 0;
//        Coordinates c;
        // To-Do: The idea is to discover Shape within given matrix

        /* there are two types of shapes
        def Matrix type -> horizontal (matrix_type = 1):
        00000  or 00000
            0     0
            0     0

         def Matrix type -> vertical (matrix_type = 2:
         0      or     0
         0             0
         0             0
         00000     00000

         def Matrix type -> single (matrix_tyoe = 0):

         single element
        */

        // Given matrix
        int [][] array = new int [][] {
                {0, 0, 0, 1, 3},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
        };

        // 1. We are starting from matrix below
//        array_print(array);

        // 2. Let us find the top element of the shape -> [x0, y0] coordinates
        int x, y, x0 = 0, y0 = 0, first_zero_found = 0, matrix_type = 0;
        int number_of_shapes = 0;

        do {
            x0 = 0;
            y0 = 0;
            first_zero_found = 0;
            matrix_type = 0;
            coordinatesList.clear();
            rightZeros.clear();

            find_zeros(rightZeros, coordinatesList, array, x0, y0, first_zero_found, matrix_type);
            array_print(array);

            for (Coordinates c : coordinatesList) {
                System.out.println("[x][y] -> " + "[" + c.x + "][" + c.y + "]");
                array[c.x][c.y] = 5;
            }

        } while (coordinatesList.size() > 0);

    }

    public static void find_zeros(List<Integer> rightZeros, List<Coordinates> coordinatesList, int[][] array, int x0, int y0, int first_zero_found, int matrix_type) {
        int x;
        int y;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){

                // if 0 is found then remembers its coordinates in [x0, y0] and quit from loop
                if (array[i][j] == 0){
                    x0 = i;
                    y0 = j;
                    first_zero_found = 1;
                    coordinatesList.add(new Coordinates(x0, y0));
                    break;
                }
            }
            if (first_zero_found == 1){
                break;
            }
        }

        // 3. Now lets find all zeros on the right from the starting point (Matrix type horizontal):
        x = x0;
        y = y0;

        for (int i = x; i < array[0].length - 1; i++){
            if (array[x][y + 1] == 0){
                y = y + 1;
                rightZeros.add(y);
                matrix_type = 1;
                coordinatesList.add(new Coordinates(x, y));
            }
        }

        if (rightZeros.size() == 0){
            matrix_type = 2;
        }

        // 4. Horizontal type matrix, find bottom elements
        if (matrix_type == 1){

            // First bottom element is here
            x = x + 1;
            for (int j = y0; j <= y; j++){
                if (array[x][j] == 0){
                    y = j;
                    break;
                }
            }

            for (int i = x; i < array.length; i++){
                if (array[i][y] == 0 && array[i - 1][y] == 0){
                    coordinatesList.add(new Coordinates(i, y));
                }
            }

        // 5. Vertical type matrix
        } else if (matrix_type == 2){
            int x_max = 0;
            x = x + 1;

            for (int i = x; i < array.length; i++){
                if (array[i][y] == 0 && array[i -1][y] == 0){
                    x_max = i;
                    coordinatesList.add(new Coordinates(x_max, y));
                }
            }

            // There are two possibilities for the last bottom element, you can go left or right
            // Going right
            for (int j = y; j <= array[0].length - 1; j++){
                if (array[x_max][j] == 0 && array[x_max][j - 1] == 0){
                    coordinatesList.add(new Coordinates(x_max, j));
                }
            }

            // Going left
            for (int j = y - 1; j >= 0; j--){
                if (array[x_max][j] == 0 && array[x_max][j+1] == 0){
                    coordinatesList.add(new Coordinates(x_max, j));
                }
            }

        } else{
            System.out.println("Single zero");
        }
    }

    static void array_print(int [][]array){
        System.out.println();

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Coordinates {
    int x;
    int y;

    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
}