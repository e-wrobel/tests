public class TwoDimWalking {

    public static void main(String []args){

        // Idea is to walk right, down, left up through 2 dim matrix
        // Walking path is signed by the 8 number

        int [][] array = new int [][] {
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1}
        };

        int path = 8;
        int x0 = 0, y0 = 1;

        int x, y, steps = 0;
        x = x0;
        y = y0;

        // Walking right till '1' is found (increasing y)

        System.out.println("\nCurrent position [x][y] = ["+x+"]"+"["+y+"]\n");
        array_print(array);

        for (int i = y; i < array[0].length - 1; i++){
            if (array[x][y + 1] == 0){
                y = y + 1;
                array[x][y] = path;
                steps ++;
                System.out.println("Going right, current position: [x][y] = ["+x+"]"+"["+y+"]");
            } else {
                break;
            }
        }

        System.out.println("\nCurrent position [x][y] = ["+x+"]"+"["+y+"]\n");
        array_print(array);

        // Walking down till '1' is found (increasing x)

        for (int i = x; x < array.length - 1; i ++){
            if (array[x + 1][y] == 0){
                x = x + 1;
                array[x][y] = path;
                steps++;
                System.out.println("Going down, current position: [x][y] = ["+x+"]"+"["+y+"]");
            } else {
                break;
            }
        }

        System.out.println("\nCurrent position [x][y] = ["+x+"]"+"["+y+"]\n");
        array_print(array);

        // Walking left till '1' is found (decreasing y)

        System.out.println("\nCurrent position [x][y] = ["+x+"]"+"["+y+"]\n");
        array_print(array);

        for (int i = y; i > 0; i--){
            if (array[x][y - 1] == 0){
                y = y - 1;
                array[x][y] = path;
                steps++;
                System.out.println("Going left, current position: [x][y] = ["+x+"]"+"["+y+"]");
            } else {
                break;
            }
        }

        System.out.println("\nCurrent position [x][y] = ["+x+"]"+"["+y+"]\n");
        array_print(array);

        // Walking up till '1' is found (decreasing x)

        for (int i = x; x > 0; i --){
            if (array[x - 1][y] == 0){
                x = x - 1;
                array[x][y] = path;
                steps++;
                System.out.println("Going up, current position: [x][y] = ["+x+"]"+"["+y+"]");
            } else {
                break;
            }
        }

        System.out.println("\nCurrent position [x][y] = ["+x+"]"+"["+y+"]\n");
        array_print(array);

        System.out.println("\nNumber of steps performed: " + steps);
    }

    static void array_print(int [][]array){

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
