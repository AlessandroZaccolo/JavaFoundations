package service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import data.Dish;
import data.MyDish;
import data.Order;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class SalesManager implements OnlineOrderOps{

    public SalesManager(){

    }


    public List<Order> readOrdersFromCSV(String fileName) throws IOException {

        List<Order> orders = new ArrayList<>();


        CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName)).withSkipLines(1).build();

        List<String[]> elements = csvReader.readAll();

        for (String[] items : elements){
            Order order = new Order();

            order.setCustomerName(items[0]);
            order.setDishName(items[1]);
            order.setEnumType(Order.Type.valueOf(items[2]));
            order.setGfd(Boolean.parseBoolean(items[3]));
            order.setVdg(Boolean.parseBoolean(items[4]));
            order.setHmd(Boolean.parseBoolean(items[5]));
            order.setHmd(Boolean.parseBoolean(items[6]));
            Object extra = items[7];
            order.setExtras(extra);

            orders.add(order);

        }

        return orders;

    }

    public List<MyDish> readDishesFromCSV(String filename)throws IOException{

        List<MyDish> dishList = new ArrayList<>();


        CSVReader csvReader = new CSVReaderBuilder(new FileReader(filename)).withSkipLines(1).build();

        List<String[]> elements = csvReader.readAll();

        for (String[] element : elements){
            MyDish dish = new MyDish();

            dish.setDishName(element[1]);
            dish.setEnumType(MyDish.Type.valueOf(element[2]));
            dish.setGfd(Boolean.parseBoolean(element[3]));
            dish.setVdg(Boolean.parseBoolean(element[4]));
            dish.setHmd(Boolean.parseBoolean(element[5]));
            dish.setHmd(Boolean.parseBoolean(element[6]));
            Object extra = element[7];
            dish.setExtras(extra);

            dishList.add(dish);

        }

        return dishList;
    }


    @Override
    public int getNumberOrders(List orderList) {

        return orderList.size();

    }

    @Override
    public Object getOrder(List orderList, int orderIndex) {

        return orderList.get(orderIndex);
    }

    @Override
    public String getAllOrdersToString(List orderList) {

        String result = "";
        for (Object order : orderList){
            result += "     " + order.toString() + "\n";
        }
        return result;
    }

    @Override
    public Dish getDish(List dishList, int dishIndex) {

        return (Dish) dishList.get(dishIndex);
    }

    @Override
    public String getAllDishToString(List dishList) {

        String result = "";
        for(Object dish : dishList){
            result += "     " + dish.toString() + "\n";
        }
        return result;
    }

    @Override
    public List getDishesByType(List dishList, String dishType) {

        List result = new ArrayList<>();

        for(int i = 0; i <= dishList.size()-1; i++){
            String check = dishList.get(i).toString();
            if(check.contains(dishType)){
                result.add(dishList.get(i));
            }

        }

        return result;
    }

    @Override
    public List getDishesByFeature(List dishList, String feature) {

        List result = new ArrayList<>();

        for(Object checkDish : dishList){
            Dish dish = (Dish) checkDish;
            if(dish.isGfd() && feature.equals("gfd")){
                result.add(dish);
            } else if (dish.isVdg() && feature.equals("vgd")){
                result.add(dish);
            } else if(dish.isHmd() && feature.equals("hmd")){
                result.add(dish);
            } else if (dish.isSfd() && feature.equals("sfd")){
                result.add(dish);
            }

        }

        return result;
    }

    @Override
    public String getStatsByDishType(List dishList, String dishType) {


        double numerator = 0;
        double denominator = dishList.size();

        for(int i = 0; i <= dishList.size()-1; i++){
            String check = dishList.get(i).toString();
            if(check.contains(dishType)){
                numerator++;
            }
        }

        double percentage = numerator / denominator * 100;




        return percentage + "% of dishes are "+ dishType ;
    }
}
