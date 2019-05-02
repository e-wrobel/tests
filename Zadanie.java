public class Zadanie {



  static int[][] visitedArr = new int[7][13];



  static public void main (String[] args){


    /*
      Allowed path is marked by 2 number.
     */
    int[][] input_data = {
            {0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0},
            {0, 0, 2, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0}
    };


    // Starting point / coordinates
    int found = 0;
    StartingPoint starting_point = null;

    int w = input_data[0].length;
    int h = input_data.length;

    for (int i = 0; i < h; i++) {
      if (found == 0) {
        for (int j = 0; j < w; j++) {
          if (input_data[i][j] == 1) {
            starting_point = new StartingPoint(i, j);
            found = 1;
            break;
          }
        }
      } else {
        break;
      }
    }

    walk(starting_point, input_data);
    System.out.println("b");
  }

  static void walk(StartingPoint starting_point, int[][] input_data){
    int x = starting_point.x;
    int y = starting_point.y;

    // Possible directions to walk through -> 0 means not possible to walk in the particular direction.
    // direction[0] = 1 -> go right
    // direction[1] = 1 -> go left
    // direction[2] = 1 -> go down
    // direction[3] = 1 -> go up
    // directions[4] = number, and it means how many paths we can choose
    // At the beginning we do not know about possible directions so everything = 0

    boolean right = false, left = false, down = false, up = false;

    // Number of possible paths, 1 means that we can go only into one direction
    int number_of_paths = 0;

    // Boundary conditions
    int x_max = input_data.length -1;
    int y_max = input_data[0].length -1;

    // Possition in matrix
    // x -> possition up|down
    // y -> possition left|right

    // If we can go right
    if (y < y_max && input_data[x][y+1] == 2){
      number_of_paths +=1;
      right = true;
    }

    // if we can go left
    if (y > 0 && input_data[x][y -1] == 2){
      number_of_paths +=1;
      left = true;
    }

    // if we can go down
    if (x < x_max && input_data[x +1][y] == 2){
      number_of_paths +=1;
      down = true;
    }

    // if we can go up
    if (x > 0 && input_data[x -1][y] == 2){
      number_of_paths +=1;
      up = true;
    }

    // If given point is a crossroad then you can go in more than one direction
    // So we have multiple choices, it means that we can go in multiple paths

    if (number_of_paths > 0){
      System.out.println("We can go in multiple paths: " + number_of_paths);
      if (right){
        StartingPoint right_starting_point = new StartingPoint(x, y + 1);
        walk(right_starting_point, input_data);
        System.out.println("We can go right");
      }

      if (left){
        StartingPoint left_starting_point = new StartingPoint(x, y - 1);
        walk(left_starting_point, input_data);
        System.out.println("We can go left");
      }

      if (down){
        StartingPoint down_starting_point = new StartingPoint(x + 1, y);
        walk(down_starting_point, input_data);
        System.out.println("We can go down");
      }

      if (up){
        StartingPoint up_starting_point = new StartingPoint(x - 1, y);
        walk(up_starting_point, input_data);
        System.out.println("We can go up");
      }


    }
//    else if (number_of_paths == 1){
//      System.out.println("Going into one direction");
//    }
    else if (number_of_paths == 0){
      System.out.println("Not going anywhere. END.");
      return;
    }


  }

}

class StartingPoint{
  int x;
  int y;

  StartingPoint(int x, int y){
    this.x = x;
    this.y = y;
  }

//  public void SetPoints(int x, int y){
//    this.x = x;
//    this.y = y;
//  }

}
