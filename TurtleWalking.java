import java.util.List;
import java.util.ArrayList;

public class TurtleWalking {

    public static void main (String []args){

        int matrix_size = 10;
        List<Entry> actions_list = new ArrayList<Entry>();

        actions_list.add(new Entry('N', 3));
        actions_list.add(new Entry('E', 2));
        actions_list.add(new Entry('S', 5));
        actions_list.add(new Entry('W', 4));
        actions_list.add(new Entry('N', 3));
        actions_list.add(new Entry('E', 3));
        actions_list.add(new Entry('S', 2));

//        actions_list.add(new Entry('N', 4));
//        actions_list.add(new Entry('E', 2));
//        actions_list.add(new Entry('S', 2));
//        actions_list.add(new Entry('W', 4));
//        actions_list.add(new Entry('W', 2));

        int signed_path = 5;
        int matrix [][] = new int[matrix_size][matrix_size];
        int x = matrix_size/2;
        int y = matrix_size/2;
        int steps = 0;

        System.out.println("We are starting from [xo][y0]: "+ "[" + x + "][" + "[" + y + "]" + '\n');

        for (Entry action : actions_list){
            char step_direction = action.step;
            int number_of_steps = action.number_of_steps;

            if (step_direction == 'E'){
                // Going right
                steps++;
                int y_temp = y;

                // Checking for right intersection
                for (int i = 1; i <= number_of_steps; i++){
                    y_temp = y_temp + 1;
                    if (matrix[x][y_temp] == signed_path){
                        System.out.println("Intersection at step: " + steps);
                    }

                }
                // Marking path
                for (int i = 1; i <= number_of_steps; i++){
                    y = y + 1;
                    System.out.println("Going right  [x][y]: " + "[" + x + "][" + "[" + y + "]");
                    matrix[x][y] = signed_path;
                }

            } else if (step_direction == 'W'){
                // Going left
                steps++;
                int y_temp = y;

                // Checking for left intersection
                for (int i = 1; i <= number_of_steps; i++){
                    y_temp = y_temp - 1;
                    if (matrix[x][y_temp] == signed_path){
                        System.out.println("Intersection at step: " + steps);
                    }
                }
                // Marking path
                for (int i = 1; i <= number_of_steps; i++){
                    y = y - 1;
                    System.out.println("Going left   [x][y]: " + "[" + x + "][" + "[" + y + "]");
                    matrix[x][y] = signed_path;
                }

            } else if (step_direction == 'S'){
                // Going down
                steps++;
                int x_temp = x;

                // Checking for down intersection
                for (int i = 1; i <= number_of_steps; i++){
                    x_temp = x_temp + 1;
                    if (matrix[x_temp][y] == signed_path){
                        System.out.println("Intersection at step: " + steps);
                    }

                }
                // Marking path
                for (int i = 1; i <= number_of_steps; i++){
                    x = x + 1;
                    System.out.println("Going down   [x][y]: " + "[" + x + "][" + "[" + y + "]");
                    matrix[x][y] = signed_path;
                }

            } else if (step_direction == 'N'){
                // Going up
                steps++;
                int x_temp = x;

                // Checking for down intersection
                for (int i = 1; i <= number_of_steps; i++){
                    x_temp = x_temp - 1;
                    if (matrix[x_temp][y] == signed_path){
                        System.out.println("Intersection at step: " + steps);
                    }

                }
                // Marking path
                for (int i = 1; i <= number_of_steps; i++){
                    x = x - 1;
                    System.out.println("Going up     [x][y]: " + "[" + x + "][" + "[" + y + "]");
                    matrix[x][y] = signed_path;
                }

            }
        }
        array_print(matrix);
        System.out.println("Number of steps: " + steps);
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

class Entry {
    char step;
    int number_of_steps;

    Entry(char step, int number_of_steps){
        this.step = step;
        this.number_of_steps = number_of_steps;
    }

}
