import java.lang.Object;

public class QueueExample {
    public static void main(String args[]){

        DtoQueue<String> dto1 = new DtoQueue<String>("StringObject1");
        DtoQueue<String> dto2 = new DtoQueue<String>("StringObject2");
        DtoQueue<String> dto3 = new DtoQueue<String>("StringObject3");
        DtoQueue<String> dto4 = new DtoQueue<String>("StringObject4");
        DtoQueue<String> dto5 = new DtoQueue<String>("StringObject5");

        Queue<DtoQueue> s = new Queue<>(3);
        s.isEmpty();

        // Scenario: adding 1, 2, 3
        s.push(dto1);
        s.push(dto2);
        s.push(dto3);

        // Removing 1
        s.pop();

        // Removing 2
        s.pop();

        // Removing 3 -> Queue is empty!
        s.pop();
        s.pop(); // It won't allow because no more elements left in queue!

        // Again adding 1, 2, 3
        s.push(dto1);
        s.push(dto2);
        s.push(dto3);

        // Removing 1
        s.pop();
    }
}

class Queue<T> {
    int size;
    int push_index;
    int pop_index;
    T tab[];

    Queue(int default_size){
        this.size = default_size;
        this.push_index = 0;
        this.pop_index = 0;
        this.tab = (T[]) new Object[this.size];
    }

    public void push(T e){

        if (this.push_index < this.size){
            this.tab[this.push_index++] = e;
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

            this.tab[this.push_index++] = e;
        }
    }

    public T pop(){
        if (this.pop_index < this.push_index) {
            T o = this.tab[this.pop_index];
            this.tab[this.pop_index++] = null;

            return o;
        }
        else {
            System.out.println("Queue is null.");
        }

        return null;

    }

    public boolean isEmpty(){
        if (this.push_index == 0) {

            return true;
        }
        else {
            return false;
        }
    }

}

class DtoQueue<T>{
    T o;

    DtoQueue(T o){
        this.o = o;
    }

    public T getObject(){
        return this.o;
    }
}