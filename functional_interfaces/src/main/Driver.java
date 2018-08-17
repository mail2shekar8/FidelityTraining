package main;

import java.util.List;
import domain.LimitOrder;
import domain.MarketOrder;
import domain.Order;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static domain.Currency.*;
import static domain.Side.BUY;
import static domain.Side.SELL;
public class Driver {

    public static void main(String[] args) {
        List<Order> orders = createOrders();
        List<Order> matches = printMatchedOrders(orders, o -> o.getSide() == BUY);
        matches.forEach(System.out::println);
        System.out.println("\n");
        
        orders.stream().filter(o -> o.getSide() == BUY).forEach(System.out::println);   
        orders.stream().filter(o -> o.getSide() == BUY).sorted(comparing(Order::getAmount)).map(Order::getAmount).forEach(System.out::println);
        
        double totalsum = orders.stream().mapToDouble(Order::getAmount).sum();
        System.out.printf("%nTotal amount is %.2f %n", totalsum);
                        
        double numberOfOrders = orders.stream().count();
        System.out.printf("%nTotal numberOfOrders is %.0f %n", numberOfOrders);
        
//        doubleSummaryStatistics
                
        Stream.of(1,2,3,4,5).limit(2).forEach(System.out::println);
        
        System.out.println("\nBuy side orders");
        printMatchedOrders(orders, o -> o.getSide() == BUY);

        System.out.println("\nSell side orders");
        printMatchedOrders(orders, o -> o.getSide() == SELL);
        
        System.out.printf("%nAverage order amount is %f%n", averageOrder.apply(orders));
        
        // Bonus for functional interfaces exercise

        System.out.println("\nOrders sorted by amount ascending");
        Collections.sort(orders, comparing(Order::getAmount));
        orders.forEach(System.out::println);

        System.out.println("\nOrders sorted by amount decending");
        Collections.sort(orders, comparing(Order::getAmount).reversed());
        orders.forEach(System.out::println);

    }


    //private static List<Order> printMatchedOrders(List<Order> orders, Predicate<Order> predicate){
    //     orders.forEach(o-> {
    //    if (predicate.test(o)) {
    //        System.out.println(o);
    //    }
    //});
    //}
    
    
    
    private static List<Order> printMatchedOrders(List<Order> orders, Predicate<Order> predicate)
    {
        	List<Order> result = new ArrayList<Order>();
      orders.forEach(o-> {
          if (predicate.test(o)) {
              result.add(o); 
          }
      });
      return result;
      }
    
    
    private static Function<List<Order>, Double> averageOrder = x -> {
        double total = 0.0;
        for(Order order: x) {
            total+= order.getAmount();
        }
        return total/x.size();
    };


	private static List<Order> createOrders(){
        List<Order> orders = new ArrayList<>();

        Order order = new LimitOrder(EUR, 1000000.0, BUY , 1.45);
        orders.add(order);
        order = new MarketOrder(EUR, 2100000.0, SELL);
        orders.add(order);
        order = new MarketOrder(EUR, 2000000.0, BUY);
        orders.add(order);
        order = new MarketOrder(EUR, 3000000.0, BUY);
        orders.add(order);

        order = new MarketOrder(USD, 1200000.0, SELL);
        orders.add(order);
        order = new MarketOrder(USD, 3400000.0, BUY);
        orders.add(order);

        order = new MarketOrder(JPY, 2300000.0, SELL);
        orders.add(order);
        order = new MarketOrder(JPY, 9800000.0, BUY);
        orders.add(order);

        order = new MarketOrder(GBP, 6500000.0, SELL);
        orders.add(order);
        order = new MarketOrder(GBP, 4500000.0, BUY);
        orders.add(order);

        return orders;
    }
}
