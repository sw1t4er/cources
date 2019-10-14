import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

//    Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.
//    Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
//    Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.
//    Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
//    Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
//    Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

//    Sample Input 1:
//    Мама мыла-мыла-мыла раму!
//    Sample Output 1:
//    мыла
//    мама
//    раму
//
//    Sample Input 2:
//    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
//    Sample Output 2:
//    consectetur
//    faucibus
//    ipsum
//    lorem
//    adipiscing
//    amet
//    dolor
//    eget
//    elit
//    mi

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input text:");

        String text=scanner.nextLine()
                .replace('-',' ')
                .replace('.',' ')
                .replace('!',' ')
                .replace('?',' ')
                .replace(',',' ')
                .toLowerCase();
        String[] wordList=text.split(" ");

        System.out.println(Arrays.stream(wordList)
                .collect(Collectors.groupingBy(p -> p))
                .entrySet().stream()
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue().size()*-1))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(p -> p.getKey())
                .limit(10).collect(Collectors.toList()));
    }
}

/* альтернативное решение
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[^\\p{L}\\p{Digit}]+");
        Map<String, Integer> map = new HashMap<>();
        scanner.forEachRemaining(i -> map.merge(i.toLowerCase(), 1,Integer::sum));
        map.entrySet().stream()
                .sorted(mapComparator())
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
    private static Comparator<Map.Entry<String, Integer>> mapComparator() {
        return Comparator.<Map.Entry<String, Integer>>comparingInt(x->x.getValue())
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
 */