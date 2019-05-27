public class ListExample {

  public static void main(String []args){

    DtoList<String> dto1 = new DtoList<String>("StringObject1");
    DtoList<String> dto2 = new DtoList<String>("StringObject2");
    DtoList<String> dto3 = new DtoList<String>("StringObject3");
    DtoList<String> dto4 = new DtoList<String>("StringObject4");

    List<DtoList> l = new List<>(4);
    l.insert(dto1);
    l.insert(dto2);
    l.insert(dto3);
    l.insert(dto4);
    l.remove(1);
    l.insert(dto1);
    l.insert(dto2);
    l.remove(4);
    l.insert(dto2);
  }


}

class List<T> {
  int size;
  int index;
  T tab[];

  List(int default_size){
    this.size = default_size;
    this.index = 0;
    this.tab = (T[])new Object[this.size];
  }

  // Add elelement to the end of list
  public void insert(T e){
    if (this.index < this.size){
      this.tab[this.index++] = e;
    }
    else {
      System.out.println("tab overloaded, resizing!");

      // Create twice bigger array and copy everything from the new one
      T temp[] = (T[])new Object[2 * this.size];
      for (int i = 0; i < this.size; i++){
        temp[i] = this.tab[i];
      }

      this.tab = temp;
      this.size *= 2;

      this.tab[this.index++] = e;
    }
  }

  // Remove element from list for given index
  public void remove(int n){
    if (n < (this.index -1)){
      this.tab[n] = null;

      for (int i=n; i < this.size -1; i++){
        //make swap
        this.tab[i] = this.tab[i +1];
      }

      tab[this.index -1] = null;
      this.index--;
    }
    else {
      this.tab[n] = null;
      this.index--;
    }

  }

  // Return element from given index
  public DtoStack find(int n){
    return  null;
  }

  // Make list NULL
  public void makeNull(){

  }

  // Display all elements in List
  public void display(){

  }

}

class DtoList<T>{
  T o;

  DtoList(T o){
    this.o = o;
  }

  public T getObject(){
    return this.o;
  }
}
