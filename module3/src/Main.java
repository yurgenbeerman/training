import java.util.ArrayList;
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
        myList.add(1);
        System.out.println("1 isEmpty = " + myList.isEmpty());
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(7);
        myList.add(7);
        myList.add(7);
        //myList.add(8,8); //ArrayIndexOutOfBoundsException
        //myList.add(5,8); //not implemented => UnsupportedOperationException
        System.out.println(myList);
        System.out.println("myList.size() = " + myList.size());
        //contains
        System.out.println("myList.contains(5) = " + myList.contains(5));
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
        System.out.println("myList.remove(new Integer(12)) = "+myList.remove(new Integer(12)));
        //TODO correct myList implememntation
        System.out.println("myList.remove(new Integer(7)) = "+myList.remove(new Integer(7)));
        System.out.println("myList.remove(2) => myList = " + myList);

        System.out.println("myList.indexOf(4) = " + myList.indexOf(4));
        System.out.println("myList.indexOf(7) = " + myList.indexOf(7));
        System.out.println("myList.indexOf(17) = " + myList.indexOf(17));

        System.out.println("myList.lastIndexOf(4) = " + myList.lastIndexOf(4));
        System.out.println("myList.lastIndexOf(7) = " + myList.lastIndexOf(7));
        System.out.println("myList.lastIndexOf(17) = " + myList.lastIndexOf(17));

        System.out.println("myList = " + myList);
        //System.out.println("myList.subList(4,2) = " + myList.subList(4,2));//IndexOutOfBoundsException
        //System.out.println("myList.subList(0,7) = " + myList.subList(0,7));//IndexOutOfBoundsException
        System.out.println("myList.subList(4,6) = " + myList.subList(4,6));
        System.out.println("myList.subList(0,6) = " + myList.subList(0,6));
        System.out.println("myList.subList(1,3) = " + myList.subList(1,3));
        System.out.println("myList.subList(2,2) = " + myList.subList(2,2));

        //TODO correct myList implememntation
        //the following idiom removes a range of elements from a list:
        myList.subList(4, 6).clear();
        System.out.println("myList.subList(4, 6).clear() => myList = " + myList);
    }
}
