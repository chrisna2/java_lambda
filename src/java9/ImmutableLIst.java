package java9;

import java.util.ArrayList;
import java.util.List;

public class ImmutableLIst {

	public static void main(String[] args) {
		final List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		
		//고정 객체의 값 -> final과는 다름
		List<String> imutableList = java.util.Collections.unmodifiableList(list);
		
		//imutableList.add("ccc");
		
		List<String> imList = List.of("aa","ccc");
		//에러 발생 읽기 전용
		imList.add("ccc");
		imList.set(0, "ab");
	}
}
