public class DzielZwyciezaj {

    public static void main(String []args){

        int []tab = {0, 5, 7, 9, 12, 13, 15, 18, 21};
        int number = 9;
        int index = 0;

        int left = 0;
        int right = tab.length;
        int middle = 0;

        while (left < right){
            middle = (left +right)/2;
            if (tab[middle] < number){
                left = middle +1;
            } else {
                right = middle;
            }
        }

        if (left < tab.length) {
            if (tab[left] == number) {
                index = left;
                System.out.println(left);
            }
        } else {
            System.out.println("Not found.");
        }

    }
}
