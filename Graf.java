public class Graf {

  public static void main (String[] args){

    /*
    Create following graph:

            1
             \
              \
               2
              / \
             /   \
            3     4

     */

    // Vertex
    Vertex v = new Vertex(1, new Vertex[]{
            new Vertex(2, new Vertex[]{
                    new Vertex(3, null),
                    new Vertex(4, null)
            })
    });

    walk(v);
    System.out.println("Stop");
  }

  static void walk(Vertex v){
    System.out.println("Vertex number: " + v.number);
    Vertex[] neighbours = v.neighbours;
    printNeighbours(neighbours);

    if (neighbours != null){
      for (Vertex n: neighbours) {
        walk(n);
      }
    }
  }

  static void printNeighbours(Vertex[] v){

  }

}

// Graph structure
class Vertex {
  int number;
  Vertex[] neighbours;

  Vertex(int number, Vertex[] neighbours){
    this.number = number;
    this.neighbours = neighbours;
  }
}
