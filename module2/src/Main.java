
import java.util.*;

public class Main {

    /**
     * implementations for questions at https://habr.com/ru/post/422259/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Module2");

        //1. Объединить два отсортированных массива. "нужно считать что оба отсортированы, и решить за n"
        int[] array1 = {5,9,11,11,56,132,212};
        int[] array2 = {1,5,8,24,98,99,123};
        System.out.println(Arrays.toString(Helpers.joinTwoSortedArrays(array1,array2)));

        //2. Реверс строки с помощью стека
        revertStringUsingStack("abcdefg");

        //3. Реверс первых N элементов очереди
        revertFirstNQueueElements(10,19);

        //4. NO NEED TO IMPLEMENT in Java: Определение цикла в связанном списке
        //detectLoopInLinkedList();

        //5. NO NEED TO IMPLEMENT in Java: Посчитать количество ребер (дуг) в графе
        //countGrapthEdges();

        //6. NO NEED TO IMPLEMENT in Java: Найти предков N узла в двоичном дереве
        //findParensOfBinaryTreeElement();

        //7. NO NEED TO IMPLEMENT in Java: Вывести все слова Trie ( префиксное деревое )

        //8. Найти симметричные пары в массиве
        findSymmetricPairsInArray();
    }

    //8. Найти симметричные пары в массиве
    private static void findSymmetricPairsInArray() {
        System.out.println("\nfindSymmetricPairsInArray");
        String[] array = {"a","b","c","d","b","a","b","d"};
        // має знайти наступні пари: ab-ba, db-bd

        Map<String,String> pairs = new HashMap<>();
        for (int i=0; i<array.length-1; i++) {
            String current = array[i]+array[i+1];
            for (int j=i+1; j<array.length-1; j++) {
                String candidate = array[j+1]+array[j];
                if(current.equals(candidate) && !pairs.containsValue(candidate)) {
                    String found = array[j]+array[j+1];
                    pairs.put(current,found);
                    System.out.println(current+"-"+found);
                }
            }
        }
    }

    //3. Реверс первых N элементов очереди
    private static void revertFirstNQueueElements(int n, int max) {
        System.out.println("revertFirstNQueueElements("+n+", "+max+")");
        Deque<Integer> queue = new ArrayDeque<>();//LinkedList<>();
        for (int i = 0; i < max; i++)
            queue.add(i);
        System.out.println("queue = " + queue);
        if (n == 0) {
            System.out.println("result: " + queue);
            return;
        }
        if (n > max) {
            n = max;
        }
        int queueSize=queue.size();
        for (int i=0; i<n-1 && i<queueSize-1; i++) {
            for(int j=0; j<n-1 && i<queueSize-1; j++) {
                queue.addLast(queue.removeFirst());
            }
            Integer holder = queue.removeFirst();
            for(int j=0; j<n-1-i && j<queueSize-1; j++) {
                queue.addFirst(queue.removeLast());
            }
            queue.addFirst(holder);
            for(int j=0; j<i && j<queueSize-1; j++) {
                queue.addFirst(queue.removeLast());
            }
            //System.out.println("loop: "+i+", queue = "+queue);
        }
        System.out.println("result: "+queue);
        /*for (int i=0; i<n && i<queueSize; i++) {
            stack.push(queue.remove());
        }

        int stackSize=stack.size();
        Queue<Integer> result = new LinkedList<>();
        for (int i=0; i<stackSize; i++) {
            result.add(stack.pop());
        }

        for (int j=stackSize; j<queueSize; j++) {
            result.add(queue.remove());
        }

        System.out.println(result);*/
    }

    //2. Реверс строки с помощью стека
    private static void revertStringUsingStack(String string) {
        System.out.println("revertStringUsingStack("+string+")");
        Stack<String> stack = new Stack<>();  //was new Stack()  -- must use Dequeue
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<string.length();i++) {
            stack.push(string.substring(i,i+1));
        }
        for(int i = 0; i<string.length();i++) {
            result.append(stack.pop());
        }
        System.out.println(result);
    }
}
