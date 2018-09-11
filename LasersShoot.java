public class LasersShoot {

    static public void main (String [] args){

        // Given array
        int [][] input_array = new int [][] {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {1, 0, 0, 1}
        };

        int [][] array = new int [input_array.length][input_array[0].length];

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                array[i][j] = input_array[i][j];
            }
        }

        int number_of_zero_rows = 0;
        int max_number_of_zero_rows = 0;
        int sum = 0;

        System.out.println("Starting calculations.\n");

        for (int x = 0; x <array[0].length; x++) {
            System.out.println("\nOriginal matrix");
            array_print(array);
            for (int y = 0; y < x; y++) {
                // Calculations for two independent columns x, y
                number_of_zero_rows = 0;
                sum = 0;

                System.out.println("\nCalculations for columns x and y: " + x + ", " +y);
                // First for x
                for (int j = 0; j < array.length; j++) {
                    if (array[j][x] == 0) {
                        array[j][x] = 1;
                    } else {
                        array[j][x] = 0;
                    }
                }

                // Second for y
                for (int j = 0; j < array.length; j++) {
                    if (array[j][y] == 0) {
                        array[j][y] = 1;
                    } else {
                        array[j][y] = 0;
                    }
                }

                // Matrix after substitutions
                System.out.println("Matrix after substitutions");
                array_print(array);

                // Finding zero rows
                for (int i = 0; i < array.length; i++){
                    for (int j = 0; j < array[0].length; j++){
                        sum = sum + array[i][j];
                    }
                    // If there are all zeros in row
                    if (sum == 0) {
                        number_of_zero_rows++;
                    }
                    sum = 0;

                }
                // Checking the max number of zeros in row

                System.out.println("Number of zero rows: " + number_of_zero_rows);

                if (max_number_of_zero_rows < number_of_zero_rows){
                    max_number_of_zero_rows = number_of_zero_rows;
                }

                // Reseting array
                for (int i = 0; i < array.length; i++){
                    for (int j = 0; j < array[0].length; j++){
                        array[i][j] = input_array[i][j];
                    }
                }
            }
        }

        System.out.println("\nMax number of zero rows: " + max_number_of_zero_rows);

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
