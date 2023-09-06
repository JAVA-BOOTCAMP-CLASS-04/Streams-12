import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectSample {

	public static void main(String[] args) {

		List<Integer> lInt = Arrays.asList(1, 2, 3, 4, 5);
		
		System.out.println(lInt.stream().collect(Collectors.toList()));
		
		Map<String, Integer> map = Stream.of("A", "BB", "CCC").collect(Collectors.toMap(Function.identity(), String::length));
		
		map.entrySet().forEach(System.out::println);
		
		Map<Integer, Set<String>> map2 = Stream.of("A", "BB", "CCC", "DD", "E").collect(Collectors.groupingBy(String::length, Collectors.toSet()));
	
		map2.entrySet().forEach(System.out::println);
		
		System.out.println(lInt.stream().collect(Collectors.summingInt(Integer::valueOf)));
		
		lInt.stream().collect(Collectors.filtering(x -> x % 2 != 0, Collectors.toList())).forEach(System.out::println);

	}

}
