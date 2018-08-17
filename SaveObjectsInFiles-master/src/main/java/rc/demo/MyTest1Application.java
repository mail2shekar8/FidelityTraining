package rc.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTest1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyTest1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		FileReaderWriter fwr = new FileReaderWriter("my.name.txt");
		List<Trade> trades = new ArrayList<Trade>();
		IntStream.range(0, 6).forEach(i -> {
			trades.add(generate(230.50, 320.00, 4));
		});
		fwr.write(trades);
	}

	public Trade generate(double low, double high, int count) {
		Random rand = new Random();
		List<Double> d = rand.doubles(count, low, high).sorted().collect(ArrayList::new, ArrayList::add,
				ArrayList::addAll);
		Trade trade = new Trade(new Date(), d.get(rand.nextInt(2)), d.get(d.size() - 1), d.get(0), d.get(rand.nextInt(2)), rand.nextInt(200000));
		return trade;
	}

}
