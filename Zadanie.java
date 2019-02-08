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
    StartingPoint starting_point;

    int w = input_data[0].length;
    int h = input_data.length;

    for (int i = 0; i < h; i++) {
      if (found == 0) {
        for (int j = 0; j < w; j++) {
          if (input_data[i][j] == 1) {
//            starting_point.SetPoints(i, j);
            starting_point = new StartingPoint(i, j);
            found = 1;
            break;
          }
        }
      } else {
        break;
      }
    }

    System.out.println("b");
  }

  static void recursion(StartingPoint starting_point){
    int x = starting_point.x;
    int y = starting_point.y;
  }
}

class StartingPoint{
  int x;
  int y;

  StartingPoint(int x, int y){
    this.x = x;
    this.y = y;
  }

  public void SetPoints(int x, int y){
    this.x = x;
    this.y = y;
  }

}
