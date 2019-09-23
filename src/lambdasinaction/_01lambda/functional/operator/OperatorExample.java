package lambdasinaction._01lambda.functional.operator;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
	private static int[] scores = { 92, 95, 87, 15, 99, 52, 24, 87, 17};

	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result; }

	public static void main(String[] args) {
		// 최대값 얻기
		int max = maxOrMin((a1, a2) -> {
										 if(a1 >= a2) return a1;
										 else return a2;
								       });
		
		System.out.println(max);
		
		// 최소값 얻기
		int min = maxOrMin((a, b) -> a <= b ? a:b);
		System.out.println(min);			
	}
}
