import java.util.ArrayList;

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
        System.out.println("IN PROGRESS 2. Custom List implementation");
        ArrayList<Integer> a = new ArrayList<>();
    }
}
