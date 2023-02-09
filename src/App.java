import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i ++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static boolean isSorted(int[] array) {
        for(int i = 0; i < array.length - 1; i ++) {
            if (array[i] > array[i+1])
            return false;
        }
        return true;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (int i = 0; i < array.length; i ++) {
                fileWriter.write(array[i] + "\n");
            }
        } catch (IOException e) {
            System.out.println("IOException happened.");
        }
    }

    public static int[] readFileToArray(String filename) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                arrayList.add(Integer.parseInt(s));
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("IOException happened.");
        }
        int [] newArray = new int[arrayList.size()];
        for (int i = 0; i < newArray.length; i ++) {
        }
        return newArray;

        }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the array length:");
        int arrayLength = scanner.nextInt();
        int[] array = createRandomArray(arrayLength);
        writeArrayToFile(array, "temp.txt");
        System.out.println("Is sorted?" + isSorted(array));
        bubbleSort(array);
        System.out.println("Is sorted?" + isSorted(array));
        writeArrayToFile(array, "temp1.txt");
        readFileToArray("temp1.txt"); 
        System.out.println(Arrays.toString(array));
        
    }
}
