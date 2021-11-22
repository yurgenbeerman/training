import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yurii.pyvovarenko on 11/22/2021.
 */
public class Helpers {
    public static int[] joinTwoSortedArrays(int[] array1, int[] array2) {
        System.out.println("joinTwoSortedArrays");

        final int length1 = array1.length;
        int posOfMin1 = 0;
        int lastMin1;

        final int length2 = array2.length;
        int posOfMin2 = 0;
        int lastMin2;

        int[] resultArray = new int[length1+length2];

        for(int i=0; i<length1+length2;i++) {
            if(posOfMin1>=length1 && posOfMin2<length2) {
                resultArray[i] = array2[posOfMin2];
                posOfMin2++;
            } else if(posOfMin2>=length2 && posOfMin1<length1) {
                resultArray[i] = array1[posOfMin1];
                posOfMin1++;
            } else if(posOfMin1<length1 && posOfMin2<length2) {
                lastMin1 = array1[posOfMin1];
                lastMin2 = array2[posOfMin2];
                if(lastMin1 > lastMin2) {
                    resultArray[i] = array2[posOfMin2];
                    posOfMin2++;
                } else if(lastMin1 < lastMin2) {
                    resultArray[i] = array1[posOfMin1];
                    posOfMin1++;
                } else {
                    resultArray[i] = array1[posOfMin1];
                    i++;
                    resultArray[i] = array2[posOfMin2];
                    posOfMin1++;
                    posOfMin2++;
                }
            }
        }
        return(resultArray);
    }

    //8. Найти симметричные пары в массиве
    public static Set<String> findSymmetricPairsInArray(String[] array) {
        System.out.println("\nfindSymmetricPairsInArray("+Arrays.toString(array)+")");
        Map<String,String> pairs = new HashMap<>();
        for (int i=0; i<array.length-1; i++) {
            String current = array[i]+array[i+1];
            for (int j=i+1; j<array.length-1; j++) {
                String candidate = array[j+1]+array[j];
                if(current.equals(candidate) && !pairs.containsValue(candidate)) {
                    String found = array[j]+array[j+1];
                    pairs.put(current,found);
                }
            }
        }
        return pairs.keySet();
    }
}
