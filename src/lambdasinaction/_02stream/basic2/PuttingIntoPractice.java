package lambdasinaction._02stream.basic2;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
		transactions.stream()
					.filter(tx -> tx.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))//tx -> tx.getValue()
					.forEach(System.out::println);
        
        // Query 2: What are all the unique cities where the traders work?
		//map(), distinct(), 
		transactions.stream()
					.map(tx -> tx.getTrader().getCity())
					.distinct()
					.forEach(System.out::println);

        // Query 3: Find all traders from Cambridge and sort them by name.
        //map(),filter(), sorted()
		transactions.stream()					//stream<transactions>
					.map(tx -> tx.getTrader())	//stream<trader>
					.filter(tr -> tr.getCity().equals("Cambridge")) 
					.distinct()
					.sorted(Comparator.comparing(Trader::getName))
					.forEach(System.out::println);
					
					
        // Query 4: Return a string of all traders names sorted alphabetically.
        //map(), sorted(), reduce()
		String names = transactions.stream()
								.map(tx -> tx.getTrader().getName())//stream<string>
								.distinct()
								.sorted()//문자열을 comparing 필요 없음
								.reduce("", (s1, s2) -> s1 + s2);
					
		System.out.println(names);
        
        // Query 5: Are there any trader based in Milan?
        boolean milanBased = transactions.stream()
        								.anyMatch(tx -> tx.getTrader().getCity().equals("Milan"));
        
        System.out.println(milanBased);
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        System.out.println("Before ::"+transactions);
        transactions.stream()
        			.map(Transaction::getTrader)
        			.filter(tr -> tr.getCity().equals("Milan"))
        			.forEach(tr -> tr.setCity("Cambridge")); //원래는 안된다는 거였는데 값을 셋팅하는 것도 이제 됨.
        System.out.println("After ::"+transactions);
        
        // Query 7: What's the highest value in all the transactions?
        int highValue = transactions.stream() //stream<Transaction>
				        			.mapToInt(Transaction::getValue) //IntStream
				        			.max() //OptionalInt
				        			.getAsInt();

        System.out.println(highValue);

    }
}