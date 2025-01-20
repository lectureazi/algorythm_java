package c_datastructure.queue;

import c_datastructure.Node;

import java.util.Iterator;
import java.util.Queue;

public class _Queue<E>  {

    private Node<E> top;
    private Node<E> cachNode;
    private int size;

    public int size() {
        return size;
    }

    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e);
        if (top == null) {
            top = newNode;
            cachNode = newNode;
        }

        cachNode.next(newNode);
        cachNode = newNode;
        size++;
    }

    public E dequeue() {
        if (top == null) return null;
        E res = top.data();
        top = top.next();
        size--;
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node<E> link = top;
        if(link == null) return "[]";

        sb.append("[");
        while(link != null) {
            sb.append(link.data());
            sb.append(", ");
            link = link.next();
        }

        sb.append("]");
        return sb.toString();
    }
}
