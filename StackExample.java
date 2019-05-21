public class StackExample{
    public static void main(String args[]){
            DTO<String> dto1 = new DTO<String>("StringObject1");
            DTO<String> dto2 = new DTO<String>("StringObject2");
            DTO<String> dto3 = new DTO<String>("StringObject3");
            DTO<String> dto4 = new DTO<String>("StringObject4");
            DTO<String> dto5 = new DTO<String>("StringObject5");

            Stack s = new Stack(dto1, 3);

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

    }
}

class Stack {
    int size;
    int index;
    DTO tab[];

    Stack(DTO dto, int default_size){
        this.size = default_size;
        this.index = 0;

        this.tab = new DTO[this.size];
    }

    public void push(DTO e){

        if (this.index < this.size){
            this.tab[this.index++] = e;
        }
        else {
            System.out.println("tab overloaded, resizing!");

            // Create twice bigger array and copy everything from the new one
            DTO temp[] = new DTO[ 2 * this.size ];
            for (int i = 0; i < this.size; i++){
                temp[i] = this.tab[i];
            }

            this.tab = temp;
            this.size *= 2;

            this.tab[this.index++] = e;
        }
    }

    public DTO pop(){
        DTO o = this.tab[--this.index];
        this.tab[this.index] = null;

        return o;
    }

    public boolean isEmpty(){

        return true;
    }

}

class DTO<T>{
    T o;

    DTO(T o){
        this.o = o;
    }

    public T getObject(){
        return this.o;
    }
}