import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class PasswordReductor {
    public static void main (String []args){

        // Remove all reptetable pairs from password
        String password = "160060005005";
        char []passwordArrray = password.toCharArray();

        List<Character> passwordList = new ArrayList<Character>();

        for (int i = 0; i < passwordArrray.length; i++){

            passwordList.add(passwordArrray[i]);
        }

        int len = 0, new_len = 1;

        while (len != new_len){
            len = passwordList.size();
            passwordList = reductor(passwordList);
            new_len = passwordList.size();
        }

        System.out.println(passwordList);
    }

   static List<Character> reductor(List passwordList){

       for (int i = 0; i < passwordList.size() - 1; i++){
           if (passwordList.get(i) == passwordList.get(i + 1)  ){
               passwordList.remove(i);
               passwordList.remove(i);
           }
       }

       return passwordList;
    }
}
