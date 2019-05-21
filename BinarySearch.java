
    if (array[middle] == number){public class BinarySearch {

      static public void main(String []args){

        // Unsorted array
        int []tab = {15,19,20,2,3,5,6,88};

        // Sorted array
        int []sorted_tab = insertion_sort(tab);

        // We are looking for position in array describing number below
        int search_number = 5;

        // Looking for number in sorted array
        int pos = binary_search(sorted_tab, search_number);
        System.out.println(pos);
      }

      static int[] insertion_sort(int []array){
        int n = array.length;

        for (int i=1; i<n; i++){

          // Get value for i-element
          int array_value = array[i];

          // Set previous index
          int j = i-1;

          while (j>=0 && array[j] > array_value){
            array[j+1] = array[j];
            j = j-1;
          }
          array[j+1] = array_value;
        }

        return array;
      }

      static int binary_search(int []array, int number){
        int result = 999;

        int length = array.length;
        int left = 0;
        int right = length-1;
        int middle = (left+right)/2;

        while (left < right){
          middle = (left + right)/2;

          if (array[middle] < number){
            left = middle + 1;
          }
          else {
            right = middle;
          }
        }

        result = middle;
    }

    return result;

  }
}
