public class Zadanie {

  static public void main (String[] args){


    /*
      Input data

      0011111111000
      0000000001000
      0000000001000
      0000000001000
      0000001111000
      0000001000000
      0000001000000

     */

    int[][] input_data = {
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
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
      // direction[2] = 1 -> go up
      // direction[3] = 1 -> go down
      // directions[4] = number, and it means how many paths we can choose
      // At the beginning we do not know about possible directions so everything = 0
      int[] directions = {0, 0, 0, 0, 0};

      // If given point is a crossroad then you can go in more than one direction
      // So we have multiple choices, it means that we can go in multiple paths
      directions = give_directions(starting_point, input_data);

      int number_of_paths = directions[4];

      if (number_of_paths > 1){
          // for every path execute recursivly walk method!
      }
      else if (number_of_paths == 1){
          // We are going into one direction
      }
      else {
          // We have finished
      }


  }

  static int[] give_directions(StartingPoint given_point, int[][] input_data){

      int[] directions = {0, 0, 0, 0, 0};

      // Number of possible paths, 1 means that we can go only into one direction
      int number_of_paths = 0;

      // Boundary conditions
      int x_max = input_data.length -1;
      int y_max = input_data[0].length -1;

      // Possition in matrix
      // x -> possition up|down
      // y -> possition left|righ
      int x = given_point.x;
      int y = given_point.y;

      // If we can go right
      if (y < y_max && input_data[x][y+1] == 1){
          directions[0] = 1;
          number_of_paths +=1;
      }

      // if we can go left
      if (y > 0 && input_data[x][y -1] == 1){
          directions[1] = 1;
          number_of_paths +=1;
      }

      // if we can go down
      if (x < x_max && input_data[x +1][y] == 1){
          directions[2] = 1;
          number_of_paths +=1;
      }

      // if we can go up
      if (x > 0 && input_data[x -1][y] == 1){
          directions[3] = 1;
          number_of_paths +=1;
      }

      directions[4] = number_of_paths;

      return directions;
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
