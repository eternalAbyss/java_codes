package stream;

import java.util.*;
import java.util.stream.Stream;

public class reduceDemo {
    public static void main(String[] args){
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("This ");
        stringList.add("is ");
        stringList.add("the ");
        stringList.add("string.");
    
        Stream<String> str = stringList.parallelStream();
    
        // Reduce operation is to reduce your stream to single value
        // Sum of the integers using reduce operation (terminal operation)
        // Without any external iteration

        String result = str.reduce("",(a,b)->a+b);
        System.out.println(result);
    }
}
