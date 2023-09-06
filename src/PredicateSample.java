import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateSample {
	
	private static void simpleTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list.stream()
        							.filter(x -> x > 5)
        							.collect(Collectors.toList());

        System.out.println(collect); 
        
        Predicate<Integer> noGreaterThan5 =  x -> x > 5;
        
        collect = list.stream()
                	  .filter(noGreaterThan5)
                	  .collect(Collectors.toList());

        System.out.println(collect);        
		
	}

	private static void andTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list.stream()
                					.filter(x -> x > 5 && x < 8)
                					.collect(Collectors.toList());

        System.out.println(collect); 
        
        Predicate<Integer> noGreaterThan5 = x -> x > 5;
        Predicate<Integer> noLessThan8 = x -> x < 8;

        collect = list.stream()
                	  .filter(noGreaterThan5.and(noLessThan8))
                	  .collect(Collectors.toList());
		
        System.out.println(collect); 
	}
	
	private static void orTest() {
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collect = list.stream()
        						   .filter(lengthIs3.or(startWithA))
        						   .collect(Collectors.toList());

        System.out.println(collect);
	}

	private static void negateTest() {
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collect = list.stream()
                				   .filter(startWithA.negate())
                				   .collect(Collectors.toList());

        System.out.println(collect);
	}
	
	public static void main(String[] args) {
		
		System.out.println("---------------------------------------------------------");
		simpleTest();
		System.out.println("---------------------------------------------------------");
		andTest();
		System.out.println("---------------------------------------------------------");
		orTest();
		System.out.println("---------------------------------------------------------");
		negateTest();
		System.out.println("---------------------------------------------------------");

	}

}
