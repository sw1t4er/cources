import java.util.AbstractList;
import java.util.List;

public class MyArrayList<E> extends AbstractList<E> implements List<E> {

    private final int INIT_SIZE = 10;

    private Object[] array;
    private int pointer = 0;

    public MyArrayList() {
        this.array =  new Object[INIT_SIZE];
        this.pointer =0;
    }

    public MyArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        this.array = new Object[initialCapacity];
        pointer = array.length;
    }

    // Возвращает элемент списка по индексу.
    @Override
    public E get(int index) {
        if (index >= pointer || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+pointer);
        return (E) array[index];
    }

    @Override
    public int size() {
        return pointer;
    }

    // Добавляет новый элемент в список. При достижении размера внутреннего массива происходит его увеличение
    // в (oldCapacity * 3) / 2 + 1 раза.
    @Override
    public boolean add(E value){
        if(pointer == array.length-1)
            resize( ((array.length*3)/2)+1 ); // увеличивает в (oldCapacity * 3) / 2 + 1 раза, если достигли границ
        array[pointer++] = value;
        return true;
    }

    public void add(E value, int index) {
        if (index > pointer || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+pointer);
        if(pointer == array.length-1)
            resize( ((array.length*3)/2)+1 ); // увеличивает в (oldCapacity * 3) / 2 + 1 раза, если достигли границ
        System.arraycopy(array, index, array, index + 1,
                pointer - index);
        array[index] = value;
        pointer++;
    }

    // Добавляет новый массив в список. При достижении размера внутреннего массива происходит его увеличение
    // на размер добавленного массива.
    public boolean addAll(List<E> list) {
        Object[] a = list.toArray();
        int numNew = a.length;
        resize( ((array.length*3)/2) + numNew );  // увеличивает на (oldCapacity * 3) / 2 и размер добавленного массива
        System.arraycopy(a, 0, array, pointer, numNew);
        pointer += numNew;
        return numNew != 0;
    }

    public E set(E value, int index) {
        if (index >= pointer)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+pointer);
        E oldValue = array(index);
        array[index] = value;
        return oldValue;
    }

    // Возвращает элемент, который удалили.
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index >= pointer)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+pointer);
        E oldValue = array(index);
        int numMoved = pointer - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index, numMoved);
        array[--pointer] = null;
        return oldValue;
    }

    @Override
    public boolean remove(Object t) {
        for (int index = 0; index < pointer; index++)
            if (t.equals(array[index])) {
                int numMoved = pointer - index - 1;
                if (numMoved > 0)
                    System.arraycopy(array, index+1, array, index, numMoved);
                array[--pointer] = null;
                return true;
            }
        return false;
    }

    // Вспомогательный метод для масштабирования.
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    private E array(int index) {
        if (index >= pointer || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+pointer);
        return (E) array[index];
    }

    @Override
    public String toString() {
        String result="{[";
        for (int i = 0; i < pointer; i++) {
            result+="{"+i+": \""+array[i].toString()+"\"},";
        }
        result=result.substring(0,result.length()-1);
        result+="]}";
        return result;
    }

}