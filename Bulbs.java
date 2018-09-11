public class Bulbs {
    public static void main (String []args){

        int []tab = {1, 2, 3};
        int count = 0;

        count = generateTab(tab);
        System.out.println("Count: " + count);
    }

    public static int generateTab(int[] tab) {
        int count = 0;

        for (int i=0; i<tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                for (int k = 0; k < tab.length; k++) {
                    if (i != j && i !=k && j != k) {
                        System.out.println("Pos[i,j,k]= " + i + ", " + j + ", " + k);
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
