#include <iostream>
using namespace std;

template <class T>
class CustomStack{
  public:

  int size;
  int index;
  T *tab;

  CustomStack(int default_size){
      size = default_size;
      index = 0;
      tab = new T[size];
  }

  void push (T e){

      if (index < size){
          tab[index++] = e;
      }
      else{
          cout << "tab overloaded, resizing!" << endl;

          // Create twice bigger array and copy everything from the old one
          T *temp = new T[2*size];
          for (int i = 0; i < size; i++){
              temp[i] = tab[i];
          }
          delete []tab;
          tab = temp;
          size *= 2;

          tab[index++] = e;
      }
  }

   T pop(){
      T o = tab[--index];

      return o;
  } 

  bool isEmpty(){
      if (index == 0){
          cout << "Array is empty." << endl;
          return true;
      }
      else {
          cout << "Array is not empty." << endl;
          return false;
      }
  } 

  void printStack(){
      for (int i = 0; i < index; i++){
          cout << "Index: " << i << ", item: " << tab[i] << endl;
      }
  }
};

int main(){

    CustomStack<string> s = CustomStack<string>(2);
    s.isEmpty();

    string dto1 = "StringObject1";
    string dto2 = "StringObject2";
    string dto3 = "StringObject3";
    string dto4 = "StringObject4";
    string dto5 = "StringObject5";

    // Scenario, should stay: 1, 2, 3, 5, 1, 2, 3
    s.push(dto1);
    s.push(dto2);
    s.push(dto3);
    s.push(dto4);
    s.pop();
    s.push(dto5);
    s.push(dto1);
    s.push(dto2);
    s.push(dto3);
    s.push(dto4);
    s.pop();

    s.isEmpty();
    s.printStack();

    return 0; 
}
