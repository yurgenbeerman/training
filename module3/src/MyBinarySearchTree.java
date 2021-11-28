/**
 * Created by yurii.pyvovarenko on 11/28/2021.
 * MyBinarySearchTree without balancing
 */
public class MyBinarySearchTree<T extends Comparable<T>> {
    private static final String SPACE = " ";
    private Node<T> root;

    public MyBinarySearchTree(T value) {
        root = new Node<T>(value);
    }

    void insert(T value)  {
        root = insertRecursively(root, value);
    }

    Node insertRecursively(Node<T> root, T value) {
        //tree is empty
        if (root == null) {
            root = new Node(value);
            return root;
        }
        //traverse the tree
        if (value.compareTo(root.getValue()) < 0) { //insert in the left subtree
            root.setLeft(insertRecursively(root.getLeft(), value));
            System.out.println("insert left. value = " + value + ", root.getValue() = " + root.getValue());
        } else if (value.compareTo(root.getValue()) > 0) {    //insert in the right subtree
            root.setRight(insertRecursively(root.getRight(), value));
            System.out.println("insert right. value = " + value + ", root.getValue() = " + root.getValue());
        }
        // We do not insert existing value. Return pointer
        return root;
    }

    public String toString() {
        return toStringBuilderRecursively(root, new StringBuilder("")).toString();
    }

    private StringBuilder toStringBuilderRecursively(Node<T> root, StringBuilder valueStringBuilder) {
        if(root == null) {
            return valueStringBuilder;
        }
        Node<T> left = root.getLeft();
        Node<T> right = root.getRight();
        if(left==null && right==null) {
            //System.out.println("LEAF: "+root.getValue());
            return valueStringBuilder.append(SPACE).append(root.getValue());
        } else if (right == null && left != null) {
            //System.out.println("Only left branch to get. Current value = "+root.getValue());
            return toStringBuilderRecursively(left, valueStringBuilder).append(SPACE).append(root.getValue());
        } else if (left == null && right != null) {
            //System.out.println("Only right branch to get. Current value = " + root.getValue());
            return toStringBuilderRecursively(right, valueStringBuilder.append(SPACE).append(root.getValue()));
        }
        return toStringBuilderRecursively(right,
                toStringBuilderRecursively(left, valueStringBuilder)
                        .append(SPACE).append(root.getValue()));
    }

    class Node<T> implements Comparable<T> {
        private T value;
        Node left, right;

        public Node(T data) { //new node is added as a leaf
            value = data;
            left = null;
            right = null;
        }

        public T getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String toString() {
            return value.toString();
        }

        @Override
        public int compareTo(T o) {
            return this.compareTo(o);
        }
    }
}