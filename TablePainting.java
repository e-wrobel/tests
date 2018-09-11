public class TablePainting {
    /* Find all surroundings based on rectangle (described by KxK dim), for every surface containing number '2'.
     Assumption is that surface should be omitted from the scope, once '1' is found.
     Please return the biggest rectangle.
     */

    public static void main (String []args) {
        // Expected k = 4
//        int[][] table = new int[][]{
//                {0, 0, 0, 2},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {2, 0, 0, 0}
//        };

        // Expected k = 3
//        int [][] table = new int[][]{
//                {2, 2, 2, 2},
//                {2, 2, 2, 2},
//                {2, 2, 2, 2},
//        };

        // Expected k = 4
//        int [][] table = new int [][]{
//                {0, 0, 0, 0, 2},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0},
//                {2, 0, 0, 0, 0}
//
//        };

        // Expected k = 1
//                int [][] table = new int[][]{
//                {0, 0, 0, 0},
//                {1, 0, 0, 0},
//                {2, 0, 0, 0},
//        };

        // Expected k = 3
//        int [][] table = new int [][]{
//                {1, 0, 0, 2},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0}
//
//        };

        // Expected 2
        int [][] table = new int [][]{
                {0, 0, 0},
                {0, 0, 1},
                {0, 0, 0},
                {2, 0, 1}

        };
        int x = 0, y = 0;
        int two_number = 0, one_number = 0;

        // Finding 2 coordinates
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 2) {
                    System.out.println("2 coordinates [i][j]: " + "[" + i + "][" + j + "]");
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int k = 0;
        // Creating sub arrays and checking if contain 2 or zero
        // Searchg for different sub array sizes
        for (int sub_array_size = 1; sub_array_size <= table[0].length; sub_array_size++) {
            System.out.println("\nChanging sub array size to -> " + sub_array_size);
            // Row shift
            for (int row_shift = 0; row_shift <= table.length - sub_array_size; row_shift++) {

                // Column shift
                for (int column_shift = 0; column_shift <= table[0].length - sub_array_size; column_shift++) {
                    System.out.println("Row shift, column shift = " + row_shift + ", " + column_shift);

                    // Checking for 2 and 1 elements in sub arrays
                    for (int i = row_shift; i < row_shift + sub_array_size; i++) {
                        for (int j = column_shift; j < column_shift + sub_array_size; j++) {
                            System.out.println("i, j = " + i + ", " + j);

                            if (table[i][j] == 2){
                                two_number++;
                            }   else if (table[i][j] == 1){
                                one_number++;
                            }
                        }
                    }
                    if (two_number > 0 && one_number == 0){
                        if (k < sub_array_size){
                            k = sub_array_size;
                        }
                        System.out.println("Sub array size KxK = " + sub_array_size);
                    }
                    two_number = 0;
                    one_number = 0;
                }
            }
        }
        System.out.println("\nMax k = " + k);
    }

}