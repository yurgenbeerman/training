import java.util.Arrays;
import java.util.Stack;

public class Main {

    /**
     * implementations for questions at https://habr.com/ru/post/422259/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Module2");

        //1. Объединить два отсортированных массива. "нужно считать что оба отсортированы, и решить за n"
        joinTwoSortedArrays();

        //2. Реверс строки с помощью стека

        //3. Реверс первых N элементов очереди

        //4. Определение цикла в связанном списке

        //5. Посчитать количество ребер (дуг) в графе

        //6. Найти предков N узла в двоичном дереве

        //7. Вывести все слова Trie ( префиксное деревое )

        //8. Найти симметричные пары в массиве
    }

    private static void joinTwoSortedArrays() {
        System.out.println("joinTwoSortedArrays");
        int[] array1 = {}; //{1,5,8,24,98,99,123};
        final int length1 = array1.length;
        int posOfMin1 = 0;
        int lastMin1;

        int[] array2 = {}; //{9,56,132,212};
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
                    posOfMin1++;
                }
            }
        }
        System.out.println(Arrays.toString(resultArray));
    }

    private static void revertStringUsingStack(String string) {
        //Stack
    }
}