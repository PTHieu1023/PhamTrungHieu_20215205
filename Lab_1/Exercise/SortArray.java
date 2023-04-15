import java.util.*;

public class SortArray {
    static Scanner sc = new Scanner(System.in);

    static String sortArray(double[] array, char mode){
        int arrLength = array.length;
        if (mode == 'a'){
            for (int i=0; i<arrLength-1; i++){
                for(int j = i+1; j < arrLength; j++){
                    if (array[i] > array[j]){
                        double temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        if (mode == 'd'){
            for (int i=0; i<arrLength-1; i++){
                for(int j = i+1; j < arrLength; j++){
                    if (array[i] < array[j]){
                        double temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        System.out.println("Enter length of array");
        int arrLength = sc.nextInt();

        System.out.println("Enter elements of array");
        double[] arr = new double[];
        for (int i = 0; i< arrLength; i++)
            arr[i] = sc.nextDouble();
        
        System.out.println("Enter:\n\"a\" for ascending\n\"d\" for decreasing\nChoose your mode: ");
        char mode = sc.next().charAt(0);

        System.out.println("Array after sorted: " + sortArray(arr, mode));
        
    }
}
