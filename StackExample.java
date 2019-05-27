public class StackExample{
    public static void main(String args[]){
            DtoStack<String> dto1 = new DtoStack<String>("StringObject1");
            DtoStack<String> dto2 = new DtoStack<String>("StringObject2");
            DtoStack<String> dto3 = new DtoStack<String>("StringObject3");
            DtoStack<String> dto4 = new DtoStack<String>("StringObject4");
            DtoStack<String> dto5 = new DtoStack<String>("StringObject5");

            Stack<DtoStack> s = new Stack<>(3);
            s.isEmpty();

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

    }
}

class Stack<T> {
    int size;
    int index;
    T tab[];

    Stack(int default_size){
        this.size = default_size;
        this.index = 0;

        this.tab = (T[])new Object[this.size];
    }

    public void push(T e){

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

    public T pop(){
        T o = this.tab[--this.index];
        this.tab[this.index] = null;

        return o;
    }

    public boolean isEmpty(){
        if (this.index == 0) {

            return true;
        }
        else {
            return false;
        }
    }

}

class DtoStack<T>{
    T o;

    DtoStack(T o){
        this.o = o;
    }

    public T getObject(){
        return this.o;
    }
}