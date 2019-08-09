public class Permutations {

    static public void main(String[] args){
        String s = "abc";
        getPermutations(s, "");
    }

    static void  getPermutations(String caption, String permutation){

        if (caption.length() == 0) {
            System.out.println(permutation + " ");
            return;
        }
        for (int i = 0; i < caption.length(); i++){

            // Char at i index
            char at_i = caption.charAt(i);

            // Rest of char (without i-th element)
            String rest_char = caption.substring(0, i) + caption.substring(i + 1);

            // Recursive call for new string
            getPermutations(rest_char, at_i + permutation);
        }
    }
}

