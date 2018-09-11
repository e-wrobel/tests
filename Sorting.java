import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Sorting {

    public static void main(String args[]){

        int [] password = {1, 2, 3, 8, 0, 9, 9, 0, 8, 4};
        ArrayList passwd = new ArrayList();

        for (int i = 0; i < password.length; i++){
            passwd.add(password[i]);
        }

        System.out.println("Original passwd: " + passwd.toString());

        ArrayList newpass;
        while ((newpass = reduce(passwd)) != null){
            passwd = newpass;
        }

        System.out.println("Password: " + passwd.toString());
    }

    static ArrayList reduce (ArrayList input){
        int is_reduced = 0;

        for (int i = 0; i < input.size() - 1; i++){
            if (input.get(i) == input.get(i + 1)){
                input.remove(i);
                input.remove(i);
                is_reduced = 1;
            }
        }

        if (is_reduced == 1){
            return input;
        } else {
            return null;
        }
    }
}
