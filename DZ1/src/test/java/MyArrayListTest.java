import javax.naming.OperationNotSupportedException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    public static void main(String[] args) {

        System.out.println("Проверка метода add");
        MyArrayList strList=new MyArrayList();

        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");

        System.out.println("strList = " + strList);

        System.out.println("Проверка метода set, индекс вне пределов массива, должна быть ошибка");
        try{
            strList.set("err",8);
        }
        catch (Exception e){
            System.out.println("IndexOutOfBounds error. Ok.");
        }

        System.out.println("Проверка метода set");
        strList.set("insert_1",3);
        System.out.println("strList = " + strList);

        System.out.println("Проверка метода remove, индекс вне пределов массива, должна быть ошибка");
        try{
            strList.remove(12);
        }
        catch (Exception e){
            System.out.println("IndexOutOfBounds error. Ok.");
        }

        System.out.println("Проверка метода remove");
        strList.remove(3);
        System.out.println("strList = " + strList);

        strList.add("f");
        strList.add("g");
        strList.add("h");
        strList.add("i");
        strList.add("j");


        System.out.println("Проверка расширения массива после добавления следующего элемента");
        strList.add("k");
        System.out.println("strList = " + strList);

        // Новый массив
        strList=new MyArrayList();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");
        strList.add("f");
        strList.add("g");
        strList.add("h");
        strList.add("i");
        strList.add("j");
        System.out.println("strList = " + strList);

        System.out.println("Проверка расширения массива после вставки следующего элемента");
        strList.set("insert_2",8);
        System.out.println("strList = " + strList);

        // Новый массив
        strList=new MyArrayList();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");

        // Новый массив 2
        MyArrayList strList2=new MyArrayList();
        strList2.add("a2");
        strList2.add("b2");
        strList2.add("c2");
        strList2.add("d2");
        strList2.add("e2");
        strList2.add("f2");
        strList2.add("g2");
        strList2.add("h2");
        strList2.add("i2");
        strList2.add("j2");

        System.out.println("Проверка метода addAll + проверка расширения массива");
        strList.addAll(strList2);

        System.out.println("strList = " + strList);

        System.out.println("Проверка remove по значению");
        if (strList.remove("g2")) {
            System.out.println("strList = " + strList);
        }

        System.out.println("Проверка метода remove, значение отстутствует в массиве");
        if (! strList.remove("notExist")) {
            System.out.println("Value not found. Ok.");
        }

        System.out.println("Проверка remove по индексу");
        try {
            strList.remove(2);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("strList = " + strList);

        System.out.println("Проверка remove по индексу, значение отстутствует в массиве");
        try {
            strList.remove(50);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBounds error. Ok.");
        }

    }
}