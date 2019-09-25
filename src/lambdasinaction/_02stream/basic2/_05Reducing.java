package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import lambdasinaction._02stream.basic1.Dish;


public class _05Reducing {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
    	
        //reduce - - reduce를 사용하여 sum을 구하는 방법
        int sum1 = numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(sum1);
        int sum2 = numbers.stream().reduce(0, (n1, n2) -> Integer.sum(n1, n2));
        System.out.println(sum2);
        
        //reduce를 사용하여 최소값 구하기
        Optional<Integer> opt = numbers.stream().reduce(Integer::min);
        //Į(n1,n2) -> Integer.min(n1,n2)
        opt.ifPresent(System.out::println);
        if(opt.isPresent()) {
        	int min1 = opt.get();
        	System.out.println(min1);
        }
        //reduce를 사용하여 최대값을 구하는 방법
        
        //칼로리의 합계를 구하는 여러가지 방법
        //1. reduce 함수 내부를 직접 구현
        int sumOfCalory = Dish.menu.stream()		//stream<Dish>
        					.map(Dish::getCalories)
        					.reduce(0, (prev, curr) -> prev + curr);
        		
        System.out.println(sumOfCalory);
        //2. reduce 함수 내부에서 Integer.sum() 호출
        sumOfCalory = Dish.menu.stream()
        				.map(dish -> dish.getCalories())
        				.reduce(0, Integer::sum);
        
        //3. reduce() 대신에 mapToInt()를 사용해서 Stream을 IntStream으로 변환
        sumOfCalory = Dish.menu.stream()
        				.mapToInt(Dish::getCalories)
        				.sum();
        
        System.out.println(sumOfCalory);
        
        
        
        System.out.println(IntStream.rangeClosed(1, 100).summaryStatistics());
        
        
        
    }
    
    
    
    
    
}
