package task;

import data.MyDish;
import data.Order;
import service.SalesManager;
import java.io.*;
import java.util.*;

public class Example {

    private static final String csvFile = "/Users/aless/JavaFoundations/src/main/resources/online_order.csv";


    public static void main(String[] args) throws IOException {

        SalesManager sm = new SalesManager();
        List<Order> orders = sm.readOrdersFromCSV(csvFile);
        List<MyDish> dishes = sm.readDishesFromCSV(csvFile);


        System.out.println("-------------Welcome to BtsMdsd-Restaurant-------------");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("# Number of orders: "+ sm.getNumberOrders(orders));
        System.out.println(" ");
        System.out.println("# Order: ");
        System.out.println("     " + sm.getOrder(orders, 1));
        System.out.println(" ");
        System.out.println("# All Orders: ");
        System.out.println(sm.getAllOrdersToString(orders));
        System.out.println("# Dish: ");
        System.out.println("     " + sm.getDish(dishes, 2));
        System.out.println(" ");
        System.out.println("# All Dishes: ");
        System.out.println(sm.getAllDishToString(dishes));
        System.out.println(" ");
        System.out.println("# Dish by \"Starter\" type: ");
        System.out.println("     " +sm.getDishesByType(dishes, "Starter"));
        System.out.println("# Dish by \"vgd\" feature: ");
        System.out.println("     " +sm.getDishesByFeature(dishes, "vgd"));
        System.out.println("# Dish by \"mc\" feature: ");
        System.out.format("      " +sm.getStatsByDishType(orders, "Main Course"));


    }


}
