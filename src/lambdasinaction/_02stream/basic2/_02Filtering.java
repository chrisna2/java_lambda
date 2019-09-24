package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

//이런 식으로 선언이 가능하다.
import static java.util.stream.Collectors.*;

import lambdasinaction._02stream.basic1.Dish;

public class _02Filtering {

    public static void main(String...args){

        // 1. Filtering with predicate ( isVegeterian() )
    	List<Dish> vegeList = Dish.menu.stream()
    								.filter(Dish::isVegetarian)//리턴 타입 : Stream<Dish>
    								//import static 된 경우 굳이 객체를 부를 필요가 사라진다.
    								.collect(toList());

    	System.out.println(vegeList);
    	
    	//[과제] 1 - 1 칼로리가 500이상인 Dish를 Set<Dish>로 형변환
    	Set<Dish> over500DishSet = Dish.menu.stream()
	    							.filter(dish -> dish.getCalories() > 500)
	    							.collect(toSet());
    	
    	System.out.println(over500DishSet);
    	
        // 2. Filtering unique elements
    	List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    	
    	

        //3. Truncating 3 stream ( d.getCalories() > 300 )
    	//List<Dish> dishesLimit3 = 
    	

        //4. Skipping elements
    	//List<Dish> dishesSkip2 =



    }
}
