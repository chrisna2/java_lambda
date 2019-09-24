package lambdasinaction._02stream.basic2;

import static java.util.stream.Collectors.*;

import lambdasinaction._02stream.basic1.Dish;

import java.util.Arrays;
import java.util.List;

public class _03Mapping {

    public static void main(String...args){

        //1. map - Dish의 name 목록만
    	List<String> dishNames = Dish.menu.stream()
    								.map(Dish::getName)
    								.collect(toList());
    	
    	//System.out.println(dishNames);
    	dishNames.forEach(System.out::println);
    	
    	
        // map 
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)//길이로 변환한 값을 가져온다 : 가져오는 값 Integer
                                         .collect(toList());
        System.out.println(wordLengths);

        //2. map - 중복된 문자 제거한 word 리스트
        //안되는 케이스
        words.stream()
        	.map(word -> word.split(""))//split의 리턴타입, 여기까지 리턴 타입은 Stream<String[]>
        	.distinct()
        	.forEach(System.out::println);
        
        //따라서 위와 같은 경우를 피하기 위해 flatMap을 사용해야 한다.
        //3.flatMap  - 중복된 문자 제거가 word 리스트
        words.stream()
    	.map(word -> word.split(""))//split의 리턴타입, 여기까지 리턴 타입은 Stream<String[]>
    	.flatMap((String[] strs) -> Arrays.stream(strs))// arg -> 
    	.distinct()
    	.forEach(System.out::print);
        
        //한방에 써보면
        words.stream()
        	.flatMap(word -> Arrays.stream(word.split("")))
        	.distinct()
        	.forEach(System.out::print);

        
        
        // flatMap
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs =
                        numbers1.stream()
                                .flatMap((Integer i) -> numbers2.stream()
                                                       .map((Integer j) -> new int[]{i, j})
                                 )
                                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                                .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
