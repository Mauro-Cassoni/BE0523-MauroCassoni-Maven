package org.example.m1.week2.day4;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Shop {

    public static void main(String[] args) {
        Product prod1 = new Product(01L,"Libro1", "Books", 13.90);
        Product prod2 = new Product(02L,"Libro2", "Books", 101.00);
        Product prod3 = new Product(03L,"Libro3", "Books", 14.90);
        Product prod4 = new Product(04L,"Libro4", "Books", 110.00);
        Product prod5 = new Product(05L,"Pannolini", "Baby", 10.00);
        Product prod6 = new Product(05L,"Ciuccio", "Baby", 35.00);
        Product prod7 = new Product(05L,"Game1", "Boys", 70.00);
        Product prod8 = new Product(05L,"Game2", "Boys", 60.00);
        Product prod9 = new Product(05L,"Game3", "Boys", 80.00);


        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = ld1.plusDays(5);


        List<Product> productList = List.of(prod1,prod2,prod3,prod4,prod5,prod6,prod7,prod8,prod9);

        List<Product> book100 = productList.stream()
                .filter(book -> book.getCategory()
                .equals("Books")&& book.getPrice() > 100.00)
                .collect(Collectors.toList());
        System.out.println("i prodotti filtrati sono: " + book100);

        List<Product> baby = productList.stream()
                .filter(b -> b.getCategory()
                .equals("Baby"))
                .collect(Collectors.toList());

        Customer custom1 = new Customer(01L,"Emi",02);
        Customer custom2 = new Customer(02L,"Ema",01);
        Customer custom3 = new Customer(03L,"Dav",02);


        System.out.println(custom1.toString());

        Order order1 = new Order(05L,"open",ld1,ld2, baby,custom1);

        List<Product> boys = productList.stream()
                .filter(b -> {
                    if (b.getCategory().equals("Boys")){
                        b.setPrice( (b.getPrice()*0.9) );
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());

        System.out.println(boys);

        LocalDate gennaio = LocalDate.of(2021, Month.JANUARY,10);
        LocalDate febbraio = LocalDate.of(2021, Month.FEBRUARY,05);
        LocalDate marzo = LocalDate.of(2021, Month.MARCH,17);
        LocalDate aprile = LocalDate.of(2021, Month.APRIL,20);
        LocalDate maggio = LocalDate.of(2021, Month.MAY,03);


        Order order2 = new Order(01L,"open",gennaio,febbraio, baby, custom1);
        Order order3 = new Order(02L,"open",febbraio,marzo, boys, custom2);
        Order order4 = new Order(03L,"open",marzo,aprile, book100, custom3);
        Order order5 = new Order(04L,"open",aprile,maggio, boys, custom1);
        Order order6 = new Order(05L,"open",maggio,maggio, baby, custom2);

        List<Order> orderList = List.of(order1,order2,order3,order4,order5,order6);

        LocalDate filtroFeb = LocalDate.of(2021, Month.FEBRUARY,01);
        LocalDate filtroApr = LocalDate.of(2021, Month.APRIL,01);



        List<Order> orderFebApr = orderList.stream().filter(o -> o.getOrderDate().isAfter(filtroFeb) && o.getOrderDate().isBefore(filtroApr) && o.getCustomer().getTier().equals(02) ).collect(Collectors.toList());

        orderFebApr.stream().forEach(l -> System.out.println("prodotti ordinati" + l.getProducts()));

        //Day 4

        //Esercizio 1

        Map<Customer, List<Order>> esercizio1 = orderList.stream().collect(Collectors.groupingBy(Order::getCustomer));
        System.out.println("Ordini per cliente:");
        esercizio1.forEach((customer, orders) -> {
            System.out.println("Cliente: " + customer.getName());
            orders.forEach(o -> System.out.println(" " + o));});

        //Esercizio 2

        Map<Customer, Double> esercizio2 = orderList.stream().collect(Collectors.groupingBy(Order::getCustomer,Collectors.summingDouble(o ->o.getProducts().stream().mapToDouble(Product::getPrice).sum())));

        esercizio2.forEach((customer, aDouble) -> System.out.println("Cliente: " + customer.getName() + " ha speso in totale: " + aDouble + "€"));

        //Esercizio 3

        List<Product> moreExpensive = productList.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).limit(3).collect(Collectors.toList());
        System.out.println("I 3 prodotti più costosi sono:");
        moreExpensive.forEach(System.out::println);

        //Esercizio 4

        Map<Customer, Double> esercizio4 = orderList.stream().collect(Collectors.groupingBy(Order::getCustomer,Collectors.averagingDouble(o ->o.getProducts().stream().mapToDouble(Product::getPrice).sum())));

        esercizio4.forEach((customer, aDouble) -> System.out.println("La media degli importi è: " + aDouble + "€"));

        //Esercizio 5

        Map<String, Double> esercizio5 = productList.stream().collect(Collectors.groupingBy(Product::getCategory,Collectors.summingDouble(Product::getPrice)));

        esercizio5.forEach((categoria, importo) -> System.out.println("Categoria: " + categoria + ", somma: " + importo + "€"));


    }





}
