package lambdasinaction._02stream.collect;

import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.*;
import static lambdasinaction._02stream.collect.Dish.menu;

import static java.util.Comparator.*;

public class _02Summarizing {

    public static void main(String ... args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }


    private static long howManyDishes() {
        return menu.stream().collect(counting());
    }

    //1. Comparator를 사용한 collect(), reducing()
    private static Dish findMostCaloricDishUsingComparator() {
        return menu.stream()
        			.collect(maxBy(comparing(Dish::getCalories)))
        			.get();//Stream<>;
    }

    //collect() - reducing 사용
    private static Dish findMostCaloricDish() {
        return menu.stream()
        			.collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2))
        			.get();
    }

    //2.  summingInt() 사용
    private static int calculateTotalCalories() {
    	//합계구하기
        return menu.stream().collect(summingInt(dish -> dish.getCalories()));
    }

    //3. averagingInt() 사용
    private static Double calculateAverageCalories() {
    	//평균구하기
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    //4. summarizingInt() 사용
    private static IntSummaryStatistics calculateMenuStatistics() {
    	//IntSummaryStatistics{count=9, sum=4300, min=120, average=477.777778, max=800}
    	//각각의 수치들 계산의 요약본
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    //5. joining() 사용
    private static String getShortMenu() {
    	//구분자를 입력해서 출력
        return menu.stream()
        		.map(Dish::getName)
        		.collect(joining("/"));
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
