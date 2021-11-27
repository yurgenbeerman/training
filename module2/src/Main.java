
import java.util.*;

public class Main {

    /**
     * implementations for questions at https://habr.com/ru/post/422259/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Module2\n");

        //1. Объединить два отсортированных массива. "нужно считать что оба отсортированы, и решить за n"
        int[] array1 = {5,9,11,11,56,132,212};
        int[] array2 = {1,5,8,24,98,99,123};
        System.out.println(Arrays.toString(Helpers.joinTwoSortedArrays(array1,array2))+"\n");

        //2. Реверс строки с помощью стека
        System.out.println(Helpers.revertStringUsingStack("abcdefg")+"\n");

        //3. Реверс первых N элементов очереди
        int max = 12;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < max; i++)
            queue.add(i);
        System.out.println("result: "+Helpers.revertFirstNQueueElements(queue,5));

        //4. NO NEED TO IMPLEMENT in Java: Определение цикла в связанном списке
        //detectLoopInLinkedList();

        //5. NO NEED TO IMPLEMENT in Java: Посчитать количество ребер (дуг) в графе
        //countGrapthEdges();

        //6. NO NEED TO IMPLEMENT in Java: Найти предков N узла в двоичном дереве
        //findParensOfBinaryTreeElement();

        //7. NO NEED TO IMPLEMENT in Java: Вывести все слова Trie ( префиксное деревое )

        //8. Найти симметричные пары в массиве
        String[] array = {"a","b","c","d","b","a","b","d"};
        // має знайти наступні пари: ab-ba, db-bd
        System.out.println(Helpers.findSymmetricPairsInArray(array));
    }
}
