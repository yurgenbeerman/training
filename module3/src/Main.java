import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        https://docs.google.com/spreadsheets/d/1JM4M8JboXZWKJ57pB0dwIrgNcZDqiNixw5r9C0lkR6I/edit#gid=0
        Module 3:

        - Реализовать бинарное дерево поиска (без балансировки)
        - Реализовать рекурсивный обход дерева с лева на право (в порядке возрастания), для выше созданного бинарного дерева
         */
        System.out.println("1. Binary search tree");
        MyBinarySearchTree<Integer> tree =
                new MyBinarySearchTree<>(47);
        tree.insert(9);
        tree.insert(34);
        tree.insert(98);
        tree.insert(37);
        tree.insert(37);
        tree.insert(91);
        tree.insert(99);
        tree.insert(92);
        tree.insert(33);
        System.out.println(tree);

        /*
        - Реализовать интерфейс List на базе массива, придерживаясь спецификации интерфейса List
        - Реализовать Iterator для выше созданного List'а
         */
        System.out.println("TESTING: 2. Custom List implementation");
        MyList<Integer> myList = new MyList<>();
        System.out.println("isEmpty = " + myList.isEmpty());
        myList.add(1111);
        myList.add(1);
        System.out.println("1 isEmpty = " + myList.isEmpty());
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        final Integer SEVEN = 7;
        myList.add(SEVEN);
        myList.add(7);
        myList.add(7);
        myList.add(7);
        //myList.add(8,8); //ArrayIndexOutOfBoundsException
        //myList.add(5,8); //not implemented => UnsupportedOperationException
        System.out.println(myList);
        System.out.println("myList.size() = " + myList.size());
        //contains
        System.out.println("myList.contains(7) = " + myList.contains(7));
        System.out.println("myList.contains(15) = " + myList.contains(15));

        System.out.println("iterator:");
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("iterator.remove() 2 times:");
        iterator = myList.iterator();
        iterator.remove();
        iterator.remove();
        System.out.println("myList = " + myList);

        //myList.remove(5); //IndexOutOfBoundsException
        System.out.println("myList.remove(2) = "+myList.remove(2));
        System.out.println("myList = " + myList);
        System.out.println("myList.remove(new Integer(12)) = "+myList.remove(new Integer(12)));
        System.out.println("myList.remove(SEVEN) = "+myList.remove(SEVEN));
        System.out.println("myList.remove(SEVEN) => myList = " + myList);
        System.out.println("myList.remove(new Integer(7)) = "+myList.remove(new Integer(7)));
        System.out.println("myList.remove(new Integer(7)) => myList = " + myList);

        System.out.println("myList.indexOf(4) = " + myList.indexOf(4));
        System.out.println("myList.indexOf(7) = " + myList.indexOf(7));
        System.out.println("myList.indexOf(17) = " + myList.indexOf(17));

        System.out.println("myList.lastIndexOf(4) = " + myList.lastIndexOf(4));
        System.out.println("myList.lastIndexOf(SEVEN) = " + myList.lastIndexOf(SEVEN));
        System.out.println("myList.lastIndexOf(17) = " + myList.lastIndexOf(17));

        System.out.println("myList before adding two 7 = " + myList);
        myList.add(7);
        myList.add(7);
        System.out.println("myList = " + myList);
        //System.out.println("myList.subList(4,2) = " + myList.subList(4,2));//IndexOutOfBoundsException
        //System.out.println("myList.subList(0,7) = " + myList.subList(0,7));//IndexOutOfBoundsException
        System.out.println("myList.subList(4,6) = " + myList.subList(4,6));
        System.out.println("myList.subList(0,6) = " + myList.subList(0,6));
        System.out.println("myList.subList(1,3) = " + myList.subList(1,3));
        System.out.println("myList.subList(2,2) = " + myList.subList(2,2));

        //TODO Should I copy SubList subcalss from the ArrayList?
        //the following idiom removes a range of elements from a list:
        //myList.subList(4, 6).clear(); //Should I copy SubList subcalss from the ArrayList?
        //System.out.println("myList.subList(4, 6).clear() => myList = " + myList);

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        list.add(7);
        myList.retainAll(list);
        System.out.println("list = " + list);
        System.out.println("myList.retainAll(list) => myList = " + myList);

        System.out.println("adding 1,2,3 = ");
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println("myList = " + myList);

        myList.removeAll(list);
        System.out.println("list = " + list);
        System.out.println("myList.removeAll(list) => myList = " + myList);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        list2.add(4);

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("myList.containsAll(list1) = " + myList.containsAll(list1));
        System.out.println("myList.containsAll(list2) = " + myList.containsAll(list2));

        System.out.println("myList = " + myList);
        Object[] array = myList.toArray();
        System.out.println("array = myList.toArray() = "+ Arrays.toString(array));

        Integer[] integerArray = {};
        integerArray = myList.toArray(integerArray);
        System.out.println("integerArray = myList.toArray(integerArray) = "+ Arrays.toString(integerArray));

        myList.add(4);
        myList.add(5);
        System.out.println("myList = " + myList);

        myList.set(3,4);
        System.out.println("myList after myList.set(3,4) = " + myList);

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("arrayList = " + arrayList);

        arrayList.set(3,4);
        System.out.println("arrayList after arrayList.set(3,4) = " + arrayList);
    }
}
