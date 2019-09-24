package lambdasinaction._02stream.basic1;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() <= 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        List<String> lowCaloricLimit3DishesName = new ArrayList<>();
        lowCaloricLimit3DishesName = lowCaloricDishesName.subList(0,3);

        return lowCaloricLimit3DishesName;
    }

    //Java 8
    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        //1. stream() : Stream<Dish> : 무언가 흐르는 데이터를 처리한다는 느낌
    	return dishes.stream()
    				//필터링
        		     .filter(dish -> dish.getCalories() <= 400)
        		    //소팅 메서드 레퍼런스
        		     .sorted(Comparator.comparing(Dish::getCalories))
    				//map()
    				 .map(Dish::getName)
    				//리턴 타입 설정 : List<String> : collect(toList()) : List<String>
    				 .collect(Collectors.toList())
    				//개 중에 3개만 거른다.
    				 .subList(0, 3);
    	
    	
    }				
    
    //그룹핑 : RDB인 경우 이렇게 할 필요가 없다. 하지만  NoSql의 등장으로 이야기가 달라짐
    //400칼로리 이하인 메뉴를 다이어트로, 아닐 경우 일반으로 그룹핑해라.
    public static Map<String, List<Dish>>  getGroupingMenu(List<Dish> dishes){
    	return null;
 
    }
    
 
    //가장 칼로리가 높은 메뉴를 찾아라
    public static Dish getMaxCaloryDish (List<Dish> dishes) {
    	return null;
    	
    	
    }
}
