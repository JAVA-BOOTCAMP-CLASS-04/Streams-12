import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreateDemo {

	public static void main(String[] args) {

		List<Integer> lInt = Arrays.asList(1, 2, 3, 4, 5);
		
		System.out.println(lInt.stream().collect(Collectors.toList()));
		
		System.out.println(Stream.of(1, 2, 3).collect(Collectors.toList()));
		
		List<Integer> afsdf = Stream.of(1, 2, 3).collect(Collectors.toCollection(LinkedList::new));
		
		List lll = Stream.concat(Stream.of(1, 2, 3), Stream.of("A", "B", "C")).collect(Collectors.toList());
		
		System.out.println(Stream.concat(Stream.of(1, 2, 3), Stream.of("A", "B", "C")).collect(Collectors.toList()));
		
		System.out.println(Stream.generate(new Random()::nextInt).limit(20).collect(Collectors.toList()));

		System.out.println(Stream.generate(() -> new Random().nextDouble()).limit(20).collect(Collectors.toList()));
		
		System.out.println(Stream.iterate(0, n -> n + 1)
					        	  .limit(10)
					        	  .collect(Collectors.toList()));

		System.out.println(Stream.iterate(0, n -> n + 1)
					        	  .limit(10)
					        	  .filter(x -> x % 2 == 0)
					        	  .collect(Collectors.toList())); // Estamos utilizando siempre un Collector para pasar el stream a una
																  // lista, pero Stream implementa toList en Java 16

		System.out.println(Stream.iterate(0, n -> n + 1)
	        	  				 .limit(10)
	        	  				 .toList());
		
		System.out.println(Stream.iterate(new Long[] { 1L, 1L }, p -> new Long[] { p[1], p[0] + p[1] })
	      	  					 .limit(20)
	      	  					 .peek(x -> System.out.println(Arrays.asList(x)))
	      	  					 .flatMap(Stream::of)
	      	  					 .distinct()
	      	  					 .toList());

		System.out.println(Stream.iterate(new Long[] { 1L, 1L }, p -> new Long[] { p[1], p[0] + p[1] })
					 .limit(20)
					 .peek(x -> System.out.println(Arrays.asList(x)))
					 .map(x -> x[0])
					 .toList());
		
		Stream.Builder<String> builder = Stream.builder();
		
		System.out.println(builder.add("Hola")
								  .add("QUE")
								  .add("taL")
								  .build()
								  .map(String::toLowerCase)
								  .toList());
		
		
		/**
		 * SORT
		 */
		System.out.println(Stream.generate(() -> new Random().nextInt(100))
								 .limit(20)
								 .sorted()
								 .toList());

		System.out.println(Stream.generate(() -> new Random().nextInt(100))
								 .limit(20)
								 .sorted((a, b) -> Integer.valueOf(a).compareTo(Integer.valueOf(b)))
								 .toList());

		System.out.println(Stream.generate(() -> new Random().nextInt(100))
								 .limit(20)
								 .sorted(Comparator.reverseOrder())
								 .toList());
		
		
		/**
		 * SKIP
		 */
		System.out.println(Stream.iterate(1, n -> n + 1)
 				 .limit(20)
 				 .skip(10) // De los 20 elementos descartara los primeros 10
 				 .toList());
		
	}

}
