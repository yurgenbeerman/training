import java.util.*;

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
        revertStringUsingStack("abcdefg");

        //3. Реверс первых N элементов очереди
        revertFirstNQueueElements(0);

        //4. Определение цикла в связанном списке
        detectLoopInLinkedList();

        //5. Посчитать количество ребер (дуг) в графе
        countGrapthEdges();

        //6. Найти предков N узла в двоичном дереве

        //7. NO NEED TO IMPLEMENT in Java: Вывести все слова Trie ( префиксное деревое )

        //8. Найти симметричные пары в массиве
        findSymmetricPairsInArray();
    }

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

    //5. Посчитать количество ребер (дуг) в графе
    //used custom structure since there's no Graph in Java. But there are libs for that.
    private static void countGrapthEdges() {
        System.out.println("\ncountGrapthEdges");

        //used https://www.baeldung.com/java-graphs
        AdjacencyGraph adjacencyGraph = new AdjacencyGraph();
        adjacencyGraph.addVertex("Bob");
        adjacencyGraph.addVertex("Alice");
        adjacencyGraph.addVertex("Mark");
        adjacencyGraph.addVertex("Rusty");
        adjacencyGraph.addVertex("Maria");

        adjacencyGraph.addDirectAndReverseEdges("Bob", "Alice");
        adjacencyGraph.addDirectAndReverseEdges("Bob", "Rusty");
        adjacencyGraph.addDirectAndReverseEdges("Alice", "Mark");
        adjacencyGraph.addDirectAndReverseEdges("Rusty", "Mark");
        adjacencyGraph.addDirectAndReverseEdges("Alice", "Maria");
        adjacencyGraph.addDirectAndReverseEdges("Rusty", "Maria");
        //6x2 edges added

        /*assert("[Bob, Rusty, Maria, Alice, Mark]".equals(adjacencyGraph.depthFirstTraversal("Bob").toString()));
        System.out.println("we expect             [Bob, Rusty, Maria, Alice, Mark]");
        System.out.println("depthFirstTraversal = "+adjacencyGraph.depthFirstTraversal("Bob").toString());

        assert("[Bob, Alice, Rusty, Mark, Maria]".equals(adjacencyGraph.breadthFirstTraversal("Bob").toString()));
        System.out.println("we expect               [Bob, Alice, Rusty, Mark, Maria]");
        System.out.println("breadthFirstTraversal = "+adjacencyGraph.breadthFirstTraversal("Bob").toString());*/

        System.out.println("There are "+adjacencyGraph.edgesCount()+" grapth edges");
    }
    //4. Определение цикла в связанном списке
    private static void detectLoopInLinkedList() {
        System.out.println("\ndetectLoopInLinkedList:");
        //I have not found native Java LinkedList methods which allow to detect cycle in the LinkedList
        //let's use Map to create cyclic and none-cyclic "linked lists" without data (data is not required for this exersize)
        Map<Integer,Integer> linkedList1 = new HashMap<>();
        Map<Integer,Integer> linkedList2 = new HashMap<>();
        for (int i=1; i<8; i++) {
            linkedList1.put(i,i+1);
            linkedList2.put(i,i+1);
        }
        System.out.println("finishing linkedList1");
        linkedList1.put(8,null);
        System.out.println("finishing linkedList2");
        linkedList2.put(8,null);

        System.out.println("looping linkedList2");
        //linkedList2.put(7,1);
        linkedList2.put(4,2);

        System.out.println("isCircularLinkedList(linkedList1) = "+ isCircularLinkedList(1, linkedList1));
        System.out.println("isCircularLinkedList(linkedList2) = "+ isCircularLinkedList(1, linkedList2));
    }
    private static boolean isCircularLinkedList(Integer head, Map<Integer, Integer> linkedList) {
        System.out.println("linkedList = "+linkedList);
        int size = linkedList.size();
        Set<Integer> set = new HashSet<>();
        Integer link = linkedList.get(head);
        int i =0;
        do {
            Integer nextElement = linkedList.get(link);
            if(nextElement==null) {
                System.out.println("NO loop found. Elements count = "+i);
                return false;
            }
            if(!set.add(nextElement)) {
                System.out.println("LOOP FOUND. Elements count = "+i);
                return true;
            }
            link = linkedList.get(nextElement);
            i++;
        } while (i<size);
        System.out.println("links count = "+i);
        return false;
    }
    //3. Реверс первых N элементов очереди
    private static void revertFirstNQueueElements(int n) {
        System.out.println("revertFirstNQueueElements("+n+")");
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 9; i++)
            queue.add(i);
        System.out.println("queue = "+queue);

        int queueSize=queue.size();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n && i<queueSize; i++) {
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

        System.out.println(result);
    }

    //2. Реверс строки с помощью стека
    private static void revertStringUsingStack(String string) {
        System.out.println("revertStringUsingStack("+string+")");
        Stack<String> stack = new Stack();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<string.length();i++) {
            stack.push(string.substring(i,i+1));
        }
        for(int i = 0; i<string.length();i++) {
            result.append(stack.pop());
        }
        System.out.println(result);
    }

    private static void joinTwoSortedArrays() {
        System.out.println("joinTwoSortedArrays");
        int[] array1 = {9,56,132,212};
        int[] array2 = {1,5,8,24,98,99,123};

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
                    posOfMin1++;
                }
            }
        }
        System.out.println(Arrays.toString(resultArray));
    }
}
