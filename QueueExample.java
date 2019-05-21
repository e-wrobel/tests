public class QueueExample {
    public static void main(String args[]){

        DTO2<String> dto1 = new DTO2<String>("StringObject1");
        DTO2<String> dto2 = new DTO2<String>("StringObject2");
        DTO2<String> dto3 = new DTO2<String>("StringObject3");
        DTO2<String> dto4 = new DTO2<String>("StringObject4");
        DTO2<String> dto5 = new DTO2<String>("StringObject5");

        Queue s = new Queue(dto1, 3);
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

class Queue {
    int size;
    int push_index;
    int pop_index;
    DTO2 tab[];

    Queue(DTO2 dto, int default_size){
        this.size = default_size;
        this.push_index = 0;
        this.pop_index = 0;
        this.tab = new DTO2[this.size];
    }

    public void push(DTO2 e){

        if (this.push_index < this.size){
            this.tab[this.push_index++] = e;
        }
        else {
            System.out.println("tab overloaded, resizing!");

            // Create twice bigger array and copy everything from the new one
            DTO2 temp[] = new DTO2[ 2 * this.size ];
            for (int i = 0; i < this.size; i++){
                temp[i] = this.tab[i];
            }

            this.tab = temp;
            this.size *= 2;

            this.tab[this.push_index++] = e;
        }
    }

    public DTO2 pop(){
        if (this.pop_index < this.push_index) {
            DTO2 o = this.tab[this.pop_index];
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

class DTO2<T>{
    T o;

    DTO2(T o){
        this.o = o;
    }

    public T getObject(){
        return this.o;
    }
}