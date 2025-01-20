package c_datastructure.map;

import c_datastructure.list._LinkedList;
import c_datastructure.set._HashSet_P3;

import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings("unchecked")
public class _HashMap<K, V> {

    private int size;
    private int arraySize = 17;
    private Object[] table;
    private _HashSet_P3<Entry<K,V>> entrySet = new _HashSet_P3();

    public _HashMap() {
        this.table = new Object[arraySize];
    }

    public _HashMap(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }

    private int hash(K key){
        // 0 ~ 21억 사이의 값이 반환이 된다.
        int hashCode = Math.abs(key.hashCode());

        // 정수 N을 arraySize로 나눈 나머지는 0 ~ arraySize-1
        return hashCode % arraySize;
    }

    private void resize() {
        arraySize *= 2;
        Object[] temp = new Object[arraySize];

        for(int i = 0; i < table.length; i++){
            if(table[i] == null) continue;
            _LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[i];
            int index = hash(row.get(0).getKey());
            temp[index] = row;
        }

        table = temp;
    }

    public V put(K key, V value) {
        if (size == arraySize - 1) {
            resize();
        }

        int index = hash(key);
        Entry<K, V> entry = new Entry<>(key, value);
        _LinkedList<Entry<K,V>> row = ( _LinkedList<Entry<K,V>>) table[index];

        if (row == null) {
            createNewRow(entry, index);
            size++;
            return null;
        }

        if (row.contains(entry)) {
            Entry<K,V> res = row.remove(row.indexOf(entry));
            row.add(entry);
            return res.getValue();
        }

        row.add(entry);
        size++;
        return null;
    }

    private void createNewRow(Entry<K, V> data, int index) {
        _LinkedList<Entry<K,V>> newRow = ( _LinkedList<Entry<K,V>>) table[index];
        newRow.add(data);
        table[index] = newRow;
    }

    public int size() {
        return size;
    }


}

