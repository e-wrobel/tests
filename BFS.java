class QPoint {
  Point p;
  int dist;
  QPoint(Point p, int dist) {
    this.p = p;
    this.dist = dist;
  }
}

public class BFS {
  public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 9, 1, 0, 1},
                {1, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
        };
        Point start = new Point(0,0);
        BFS bfs = new BFS(arr, start, 9);
        int shortestPath = bfs.findShortestPath();
        System.out.println(shortestPath);
    }
    
  int[][] array;
  boolean[][] visited;
  int rows, columns;
  Point start, end;
//  Queue<QPoint> q;
  MarcinsQueue<QPoint> q;


  BFS(int[][] array, Point start, int marker) {
    this.array = array;
    this.rows = array.length;
    this.columns = array[0].length;
    this.visited = new boolean[rows][columns];

    this.start = start;
    this.end = this.findTarget(marker);

//    this.q = new SynchronousQueue<>();
//    this.q = new LinkedList<>();
    this.q = new MarcinsQueue<QPoint>(2);
    this.q.add(new QPoint(this.start, 0));
    this.visited[start.y][start.x] = true;
  }

  int findShortestPath() {
    while (!q.isEmpty()) {
      QPoint qp = q.remove();
      if (qp.p.x == end.x && qp.p.y == end.y) {
        return qp.dist;
      }
      findEligibleNeighbors(qp);
    }
    return -1;
  }

  Point findTarget(int marker) {
    for (int y = 0; y < rows; y++) {
      for (int x = 0; x < columns; x++) {
        if (array[y][x] == marker) {
          return new Point(x, y);
        }
      }
    }
    return null;
  }

  void findEligibleNeighbors(QPoint qp) {
    int dist = qp.dist + 1;
    Point c;
    c = new Point(qp.p.x, qp.p.y-1);
    if (c.y >= 0 && array[c.y][c.x] >= 1 && !visited[c.y][c.x]) {
      q.add(new QPoint(c, dist));
      visited[c.y][c.x] = true;
    }
    c = new Point(qp.p.x, qp.p.y+1);
    if (c.y < rows && array[c.y][c.x] >= 1 && !visited[c.y][c.x]) {
      q.add(new QPoint(c, dist));
      visited[c.y][c.x] = true;
    }
    c = new Point(qp.p.x-1, qp.p.y);
    if (c.x >= 0 && array[c.y][c.x] >= 1 && !visited[c.y][c.x]) {
      q.add(new QPoint(c, dist));
      visited[c.y][c.x] = true;
    }
    c = new Point(qp.p.x+1, qp.p.y);
    if (c.x < columns && array[c.y][c.x] >= 1 && !visited[c.y][c.x]) {
      q.add(new QPoint(c, dist));
      visited[c.y][c.x] = true;
    }
  }
}
