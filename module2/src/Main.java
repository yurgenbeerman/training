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
        revertFirstNQueueElements(10,19);

        //4. Определение цикла в связанном списке
        detectLoopInLinkedList();

        //5. Посчитать количество ребер (дуг) в графе
        countGrapthEdges();

        //6. Найти предков N узла в двоичном дереве
        findParensOfBinaryTreeElement();

        //7. NO NEED TO IMPLEMENT in Java: Вывести все слова Trie ( префиксное деревое )

        //8. Найти симметричные пары в массиве
        findSymmetricPairsInArray();
    }

    //6. Найти предков N узла в двоичном дереве
    private static void findParensOfBinaryTreeElement() {
        //TreeMap keys are organized as red-black binary tree
        TreeMap<Integer,Integer> tree = new TreeMap<>(); //HashMap will work too.
        tree.put(1,3);
        tree.put(2,3);
        tree.put(4,6);
        tree.put(5,6);
        tree.put(3,7);
        tree.put(6,7);
        tree.put(7,null);
        System.out.println("\nfindParensOfBinaryTreeElement\n"+findParens(tree,1));
    }
    private static List<Integer> findParens(Map<Integer,Integer> tree, Integer element) {
        if (element == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        element = tree.get(element);
        while (element != null) {
            result.add(element);
            element = tree.get(element);
        };
        return result;
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

    private static void joinTwoSortedArrays() {
        System.out.println("joinTwoSortedArrays");
        int[] array1 = {5,9,11,11,56,132,212};
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
                    posOfMin2++;
                }
            }
        }
        System.out.println(Arrays.toString(resultArray));
    }
}
