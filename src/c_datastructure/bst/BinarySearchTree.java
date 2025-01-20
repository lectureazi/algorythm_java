package c_datastructure.bst;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public int size() {
        return size;
    }

    public void insert(E element) {
        Node<E> newNode = new Node<>(element);

        if(root == null) {
            root = newNode;
            size++;
            return;
        }

        Node<E> link = root;
        while(true){
            if(element.compareTo(link.data) < 0) {
                if(link.getLeft() == null){
                    link.setLeft(newNode);
                    break;
                }
                link = link.getLeft();
            } else{
                if(link.getRight() == null){
                    link.setRight(newNode);
                    break;
                }

                link = link.getRight();
            }
        }

        size++;
    }

    public boolean find(E element) {
        Node<E> link = root;

        while(true){

            if(link == null) return false;

            if(element.compareTo(link.data) == 0) {
                return true;
            }

            if(element.compareTo(link.data) < 0) {
                link = link.getLeft();
            }

            if(element.compareTo(link.data) > 0) {
                link = link.getRight();
            }


        }
    }



}
