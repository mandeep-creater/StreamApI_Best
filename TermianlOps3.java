import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TermianlOps3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        //1. collect
        List<Integer> collect = list.stream().skip(1).collect(Collectors.toList());

        //2. forEach
        list.stream().forEach(x-> System.out.println(x));

        //3.reduce  : Combine elements to produce single result
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());

        //4. count

        //5.allMatch , anyMatch , noneMatch
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        boolean b1 = list.stream().allMatch(x -> x % 2 == 0);
        boolean b2 = list.stream().noneMatch(x -> x % 2 == 0);

        System.out.println(b+" "+b1+" "+b2);

        //6.findfirst , findAny
        Optional<Integer> first = list.stream().findFirst();
        Optional<Integer> any = list.stream().findAny();
        System.out.println(first+" "+any );

        //7.toArray()
        Object[] array = Stream.of(1,2,3).toArray();

        //8. min/max
        Stream.of(2,4,68).max(Comparator.naturalOrder());

        //9. forEachOrdered
        List<Integer> lll = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Using for Each Parallel Stream");
        lll.parallelStream().forEach(System.out::println);
        System.out.println("Using for EachOrder with Parallel Stream");
        lll.parallelStream().forEachOrdered(System.out::println);



        //Question

        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");

        //find length greater then three
        List<String> collect1 = names.stream().filter(x -> x.length() > 3).toList();
        collect1.forEach(System.out::println);

        //squaring and sorting numbers
        List<Integer> list1 = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(list1.stream().map(x->x*x).sorted().collect(Collectors.toList()));

        //summing values
        System.out.println("Sum -> "+list1.stream().reduce(Integer::sum).get());

        //counting Ocuurences of a character
        String sentence = "Hello World";
       long d= sentence.chars().filter(x->x=='l').count();
        System.out.println(d);

        //Statesfull or stateless
        //stateless means hume hr operation ka nhi pta hoga
        //Statesfull means hume sbb elements ka pta hoga jese sort krenge  tbb or distinct




    }

}
