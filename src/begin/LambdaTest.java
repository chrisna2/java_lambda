package begin;
public class LambdaTest {

	public static void main(String[] args) {
		
		//#1 익명 클래스 형태로 구현 (Annoymous Inner 클래스)
		//빌드시 해당 익명 클래스 생성
		Thread t1 =  new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("익명클래스로  Runnable 클래스 구현");
			}
		});
		t1.start();
		
		//#2 lambda 방식
		Thread t2 = new Thread(() -> System.out.println("람다식으로 Runnalbe 클래스 구현"));
		t2.start();
		
	}

}
