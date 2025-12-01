import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

            //  MSDLF '->Intermediate operation

public class IntermediateOperation3 {
    public static void main(String[] args) {
        //Intermediate operations transform a stream into  another stream
        //They are lazy , meaning they don't execute untial a terminal operation is invoked

        //1. filter
        List<String> names = Arrays.asList("Ram ","R00m", "Shyam", "Ghanshyam", "Rohan", "Mohan");
        long m = names.stream().filter(x -> x.startsWith("M")).count();
        System.out.println(m);

        //2.map
        List<String> collect = names.stream().map(String::toUpperCase).toList();

        //3.Sorted
        Stream<String> sorted = names.stream().sorted();
        Stream<String> CustomSortedUsingComparator = names.stream().sorted((a, b) -> a.length() - b.length());

        //4. distinct
        long a = names.stream().filter(x -> x.startsWith("A")).distinct().count();

        //5. Limit
        Stream<String> m1 = names.stream().filter(x -> x.startsWith("R")).limit(2);
        m1.forEach( System.out::println);

        //6.skip
        System.out.println(Stream.iterate(1,x->x+1).skip(10).limit(100).count());

        //7.peek
        //Perform an action on each element as it is consumed.
        Stream.iterate(1,x->x+1).skip(10).limit(100).peek(System.out::println).count();

        //8. FlatMap
        //Handle streams of collections , lists or arrays where each element is itself a collection
        //Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        //Transform and flatten elements at the same time
        List<List<String>> fruits = Arrays.asList(Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );

        System.out.println(fruits.get(1).get(1));
        System.out.println(fruits.stream().flatMap(x->x.stream()).map(x->x.toUpperCase()).collect(Collectors.toList()));

;
    }
}
