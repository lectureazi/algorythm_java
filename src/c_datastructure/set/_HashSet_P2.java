package c_datastructure.set;

import c_datastructure.Node;

import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("unchecked")
public class _HashSet_P2<E> implements Iterable<E>{

    private int arraySize = 17;
    private Object[] table;
    private int size = 0;

    public _HashSet_P2() {
        this.table = new Object[arraySize];
    }

    public _HashSet_P2(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }

    public boolean isEmpty(){
        return size <= 0;
    }

    public int size(){
        return size;
    }

    private int hash(E data){
        // 0 ~ 21억 사이의 값이 반환이 된다.
        int hashCode = Math.abs(data.hashCode());

        // 정수 N을 arraySize로 나눈 나머지는 0 ~ arraySize-1
        return hashCode % arraySize;
    }

    private void resize() {
        arraySize *= 2;
        Object[] temp = new Object[arraySize];

        for(int i = 0; i < table.length; i++){
            if(table[i] == null) continue;
            int index = hash((E)table[i]);
            temp[index] = table[i];
        }

        table = temp;
    }

    public boolean add(E data){

        Node<E> node = new Node<E>(data);

        if(size == arraySize - 1) {
            resize();
        }

        int index = hash(data);
        Node<E> head = (Node<E>) table[index];

        if(head == null){
            table[index] = node;
            size++;
            return true;
        }

        // head가 null이 아니라면 node 체인을 탐색
        // 만약 중복된 요소라면 요소를 추가하지 않고 false 반환

        // 같다 ==, equals()
        // == : stack 영역의 값으로 비교
        // equals : 객체에서 같음을 정의한 내용에 따라 비교
        // == (동일비교): 완전히 같음, 객체라면 동일한 객체 (주소가 같음)
        // equals (동등비교): 같다고 정의한 내용(equals())에 따라 같음

        // String ==, equals()
        // 객체는 new 연산자를 사용해 생성.
        // 극히 일부, 아주 많이 사용되는 클래스는 생성자가 아니라 literal로 생성할 수 있다.
        // String a = new String(10);
        Node<E> link = head;
        Node<E> prev = head;

        while(link != null){
            if(link.data().equals(data)){
                return false;
            }
            prev = link;
            link = link.next();
        }

        prev.next(node);
        size++;
        return true;
    }

    public boolean remove(E data){
        int index = hash(data);
        Node<E> head = (Node<E>) table[index];

        if(head == null){
            return false;
        }

        Node<E> link = head;
        Node<E> prev = head;

        if(head.data().equals(data)){
            table[index] = head.next();
            size--;
            return true;
        }

        while(link != null){
            if(link.data().equals(data)){
                prev.next(link.next());
                size--;
                return true;
            }

            prev = link;
            link = link.next();
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        for(int i = 0; i < table.length; i++){
            if(table[i] == null) continue;
            Node<E> link = (Node<E>) table[i];

            while(link != null){
                sb.append(link.data());
                sb.append(", ");
                link = link.next();
            }
        }

        sb.append("]");
        return sb.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int cnt;
            private int pointer = -1;
            private Node<E> prev = new Node<E>(null);

            @Override
            public boolean hasNext() {
               return cnt < size;
            }

            @Override
            public E next() {
                if(prev.next() != null){
                    prev = prev.next();
                    cnt++;
                    return prev.data();
                }

                // prev.next() == null => 해당 row에 저장된 마지막 node
                do {
                    pointer++;
                } while (table[pointer] == null);

                prev = (Node<E>) table[pointer];
                cnt++;
                return prev.data();
            }
        };
    }
}
