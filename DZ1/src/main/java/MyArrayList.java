import java.util.AbstractList;
import java.util.List;

public class MyArrayList<E> extends AbstractList<E> implements List<E> {

    private Object[] array;
    private int size;

    public MyArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        this.array = new Object[initialCapacity];
        size = array.length;
    }

    public MyArrayList() {
        this(10);
    }

    // Возвращает элемент списка по индексу.
    @Override
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        return (E) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    // Добавляет новый элемент в список. При достижении размера внутреннего массива происходит его увеличение
    // в (oldCapacity * 3) / 2 + 1 раза.
    @Override
    public boolean add(E value){
        if(size == array.length-1)
            resize( ((array.length*3)/2)+1 ); // увеличивает в (oldCapacity * 3) / 2 + 1 раза, если достигли границ
        array[size++] = value;
        return true;
    }

    public void add(E value, int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        if(size == array.length-1)
            resize( ((array.length*3)/2)+1 ); // увеличивает в (oldCapacity * 3) / 2 + 1 раза, если достигли границ
        System.arraycopy(array, index, array, index + 1,
                size - index);
        array[index] = value;
        size++;
    }

    // Добавляет новый массив в список. При достижении размера внутреннего массива происходит его увеличение
    // на размер добавленного массива.
    public boolean addAll(List<E> list) {
        Object[] a = list.toArray();
        int numNew = a.length;
        resize( ((array.length*3)/2) + numNew );  // увеличивает на (oldCapacity * 3) / 2 и размер добавленного массива
        System.arraycopy(a, 0, array, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    public E set(E value, int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        E oldValue = array(index);
        array[index] = value;
        return oldValue;
    }

    // Возвращает элемент, который удалили.
    @Override
    public E remove(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        E oldValue = array(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index, numMoved);
        array[--size] = null;
        return oldValue;
    }

    @Override
    public boolean remove(Object t) {
        for (int index = 0; index < size; index++)
            if (t.equals(array[index])) {
                int numMoved = size - index - 1;
                if (numMoved > 0)
                    System.arraycopy(array, index+1, array, index, numMoved);
                array[--size] = null;
                return true;
            }
        return false;
    }

    // Вспомогательный метод для масштабирования.
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private E array(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        return (E) array[index];
    }

}