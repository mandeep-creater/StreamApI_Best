import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream4 {
    public static void main(String[] args) {
        //A type of stream which enable parallel processing of elements
        //Means it allows multiple threads to process part of the stream simultaneously
        //this can significantly improve performance for large data sets
        //workload is  distributed across multiple threads

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50000).toList();
        List<Long> FactList = list.stream().map(ParallelStream4::fact).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken with sequential Stream :-> "+(endTime-startTime)+" ms ");


         startTime = System.currentTimeMillis();
        FactList = list.parallelStream().map(ParallelStream4::fact).collect(Collectors.toList());
       // FactList = list.parallelStream().map(ParallelStream4::fact).sequential().collect(Collectors.toList());

        endTime = System.currentTimeMillis();
        System.out.println("Time Taken with Paralle Stream :-> "+(endTime-startTime)+" ms ");

        // Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent
        //they may add overhead for simple task  or small datasets
    }
    private  static  long fact(int n){
        long result =1;
        for(int i=0;i<=n;i++){
            result *= i;
        }
        return  result;
    }
}
