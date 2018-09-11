public class AirplaneWar {

    public static void main(String[] args) {
        // Path will be marked by 5

        int[][] table = new int[][]{
                {0, 1, 1, 2},
                {1, 0, 2, 0},
                {0, 2, 0, 0},
                {0, 1, 0, 1},
                {2, 2, 2, 2},
                {1, 0, 1, 1}
        };

        int columns = table[0].length;
        int rows = table.length;
        int y = 0;
        int score = 0;

        array_print(table);

        // Boundary conditions: starting from [x][y]
        for (int column = 0; column < columns; column++) {
            if (table[0][column] == 0) {
                y = column;
                break;
            }
        }

        table[0][y] = 5;

        // Going down
        for (int row = 1; row < rows; row++) {
//            System.out.println("Going to row number: " + row);
            if (y == 0) {
                // Moves: y, y + 1
                if (table[row][y] == 2) {
                    score = score + 2;
                } else if (table[row][y + 1] == 2) {
                    y = y + 1;
                    score = score + 2;
                } else if (table[row][y] == 0) {
                    continue;
                } else if (table[row][y + 1] == 0) {
                    y = y + 1;
                } else {
                    score = score - 1;
                }
//                System.out.println("Column: " + y);
                table[row][y] = 5;

            } else if (y == columns - 1) {
                // Moves: y, y - 1
                if (table[row][y] == 2) {
                    score = score + 2;
                } else if (table[row][y - 1] == 2) {
                    y = y - 1;
                    score = score + 2;
                } else if (table[row][y] == 0) {
                    continue;
                } else if (table[row][y - 1] == 0) {
                    y = y - 1;
                } else {
                    score = score - 1;
                }
                System.out.println("Column: " + y);
                table[row][y] = 5;

            } else {
                // Moves: y -1, y, y + 1
                if (table[row][y] == 2) {
                    score = score + 2;
                } else if (table[row][y - 1] == 2) {
                    y = y - 1;
                    score = score + 2;
                } else if (table[row][y + 1] == 2) {
                    y = y + 1;
                    score = score + 2;
                } else if (table[row][y - 1] == 0) {
                    y = y - 1;
                } else if (table[row][y + 1] == 0) {
                    y = y + 1;
                }
//                System.out.println("Column: " + y);
                table[row][y] = 5;
            }
        }
        System.out.println("\nScore: " + score);
        array_print(table);
    }

    static void array_print(int[][] array) {
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
