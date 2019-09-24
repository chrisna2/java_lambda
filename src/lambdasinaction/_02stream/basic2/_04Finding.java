package lambdasinaction._02stream.basic2;
import java.util.Optional;

import lambdasinaction._02stream.basic1.Dish;

public class _04Finding {

    public static void main(String...args){
        if(isVegetarianFriendlyMenu()){
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());
        
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    //1. anyMatch
    private static boolean isVegetarianFriendlyMenu(){
    	//적어도 한 개라도 일치 하는 경우 통과
        return Dish.menu.stream()
        		.anyMatch(Dish::isVegetarian);
    }
    //2.allMatch
    private static boolean isHealthyMenu(){
    	//모두 조건에 일치하는 경우
        return Dish.menu.stream()
        		.allMatch(dish -> dish.getCalories() < 900);
    }

    //3. noneMatch
    private static boolean isHealthyMenu2(){
    	//어떤것도 통과 하지 못할 경우
        return Dish.menu.stream()
        		.noneMatch(dish -> dish.getCalories() > 900);
    }
    //4. findAny
    private static Optional<Dish> findVegetarianDish(){
    	//현재 스트림의 임의 요소 반환
        return Dish.menu.stream()
        		.filter(dish -> dish.getCalories() < 200)
        		.findAny();
    }
    
}
