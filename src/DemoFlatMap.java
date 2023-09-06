import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoFlatMap {

	public static void main(String[] args) {
		
		Integer[][] arrayVvalues = {{1, 2, 3}, {10, 20, 30}, {100, 200, 300}};
		
		List<Integer[]> lArrayValues = Arrays.asList(arrayVvalues);

		System.out.println(lArrayValues);
		
		List<List<Integer>> lValues = lArrayValues.stream().map(x -> Arrays.asList(x)).collect(Collectors.toList());
		
		System.out.println(lValues);
		
		List<Integer> lValuesFlat = lArrayValues.stream().flatMap(Stream::of).collect(Collectors.toList());

		System.out.println(lValuesFlat);
		
		List<Object> lValuesMulti = Stream.of(1, 2, 3)
										  .mapMulti((s, buffer) -> {
											  					buffer.accept(s);
											  					buffer.accept(s * 2);
																buffer.accept(s * 3);
										  					  })
										  .collect(Collectors.toList());
		
		System.out.println(lValuesMulti);

		List<Object> lValuesMulti2 = Stream.of(1, 2, 3)
				  						   .mapMulti((s, c) -> {
				  							   					 c.accept(Arrays.asList(s, s * 2, s * 3));
				  						   						})
				  						   .collect(Collectors.toList());

		System.out.println(lValuesMulti2);

	}

}
