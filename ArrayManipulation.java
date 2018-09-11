import java.util.ArrayList;

public class ArrayManipulation {
    public static void main(String []args){
        int [] passwd = {1, 2, 3};
        int len = passwd.length;
        ArrayList myList = new ArrayList();

        System.out.println();
        for (int i = 0; i < len; i++){
            myList.add(passwd[i]);
        }

        System.out.println(myList.toString());
    }

}
