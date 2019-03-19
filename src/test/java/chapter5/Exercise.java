package chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Test
    public void year2011() {
        List<Integer> values = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .map(Transaction::getValue)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(values);
    }

    @Test
    public void cities() {
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);
    }

    @Test
    public void cambridge() {
        List<String> cambridges = transactions.stream()
                .map(t -> t.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(cambridges);
    }

    @Test
    public void allName() {
        List<String> names = transactions.stream()
                .map(t -> t.getTrader())
                .map(trader -> trader.getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Test
    public void inMilan() {
        boolean b = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(b);
    }

    @Test
    public void inCambridgeValues() {
        List<Integer> values = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
    }

    @Test
    public void minMax() {
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        Optional<Integer> min = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
    }


}
