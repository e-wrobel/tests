public class Bulbs {
    public static void main (String []args){

        int []input = {1, 2, 3, 4};

        int []tab = new int[3];
        for (int k = 0; k < input.length; k++){
            System.out.println("Removing k element: " + k);
            for (int i = 0; i < input.length; i++){
                int index = 0;
                if (i != k) {
                    tab[index] = input[i];
                    index++;
                }
            }
//            Arrays a = generateTab(tab);
//            System.out.println("First: " + a.first[0] +" " + a.first[1] +" " + a.first[2]);
//            System.out.println("Second: " + a.second[0] +" " + a.second[1] +" " + a.second[2]);
//            System.out.println("Third: " + a.third[0] +" " + a.third[1] + " " + a.third[2]);
        }
//        int []tab = {1, 2, 3};

    }

    public static Arrays generateTab(int[] tab) {
        int count = 0;
        int found = 0;
        int []first = new int[3];
        int []second = new int[3];
        int []third = new int[3];
        for (int i=0; i<tab.length && found == 0; i++) {
            for (int j = 0; j < tab.length && found == 0; j++) {
                for (int k = 0; k < tab.length; k++) {
                    if (i != j && i !=k && j != k) {
                        if (count == 0){
                            first[0] = tab[i];
                            first[1] = tab[j];
                            first[2] = tab[k];
                        } else if (count == 1){
                            second[0] = tab[i];
                            second[1] = tab[j];
                            second[2] = tab[k];
                        } else if (count == 2){
                            third[0] = tab[i];
                            third[1] = tab[j];
                            third[2] = tab[k];
                        } else if (count == 3){
                            found = 1;
                            break;
                        }
                        count++;
                    }
                }
            }
        }

        Arrays A = new Arrays(first, second, third);

        return A;
    }

}
class Arrays {
    int[] first;
    int[] second;
    int[] third;

    Arrays(int[] first, int[] second, int[] third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

}
