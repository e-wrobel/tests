public class Combinations {

    static public void main (String []args){
        int N = 5;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < i; j++){
                for (int k = 0; (k != i && k != j); k++){
                    System.out.println("i, j, k ->" + i +", "+j +", "+k);
                }
            }
        }
    }
}
