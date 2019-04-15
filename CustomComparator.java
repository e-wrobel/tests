import java.util.*;

public class CustomComparator {

  public static void main(String []string){

  Person marcin = new Person("marcin", "W", 1);
  Person wojtek = new Person("wojtek", "W", 2);
  Person jezyk = new Person("jezyk", "X", 10);

  LinkedList<Person> list = new LinkedList<Person>();

  // Append Persons to the List
  list.add(jezyk);
  list.add(marcin);
  list.add(wojtek);

   for (Person p: list
         ) {
      System.out.println(p.name +"=" +p.id);
   }

   Collections.sort(list);

    System.out.println("\nSorted:\n");

    for (Person p: list
            ) {
      System.out.println(p.name +"=" +p.id);
    }


  }
}

// Comparable interface needs to be implemented in any custom class if we want to use Arrays or Collections sorting methods.

class Person implements Comparable<Person> {

  String name;
  String surname;
  int    id;

  public Person(String name, String surname, int id){
    this.name = name;
    this.surname = surname;
    this.id = id;
  }

  @Override
  public int compareTo(Person person) {
    return (this.id - person.id);
  }
}
