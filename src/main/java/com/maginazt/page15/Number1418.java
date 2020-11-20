package com.maginazt.page15;

import java.util.*;

/**
 * @author: zhaotao
 * @date: 2020/11/20 14:05
 */
public class Number1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer> countMap = new HashMap<>();
        TreeSet<String> foodItemNames = new TreeSet<>();
        TreeSet<Integer> tableNumbers = new TreeSet<>();
        for (List<String> orderItems : orders) {
            tableNumbers.add(Integer.parseInt(orderItems.get(1)));
            foodItemNames.add(orderItems.get(2));
            String key = orderItems.get(1) + "-" + orderItems.get(2);
            countMap.merge(key, 1, Integer::sum);
        }
        List<List<String>> result = new ArrayList<>(tableNumbers.size() + 1);
        List<String> title = new ArrayList<>(foodItemNames.size() + 1);
        title.add("Table");
        for (String foodItemName : foodItemNames) {
            title.add(foodItemName);
        }
        result.add(title);
        for (Integer tableNumber : tableNumbers) {
            List<String> nums = new ArrayList<>(foodItemNames.size() + 1);
            nums.add(tableNumber.toString());
            for (String foodItemName : foodItemNames) {
                nums.add(countMap.getOrDefault(tableNumber + "-" + foodItemName, 0).toString());
            }
            result.add(nums);
        }
        return result;
    }

    public static void main(String[] args) {
        Number1418 number1418 = new Number1418();
        System.out.println(number1418.displayTable(Arrays.asList(Arrays.asList("David", "3", "Ceviche"), Arrays.asList("Corina", "10", "Beef Burrito"), Arrays.asList("David", "3", "Fried Chicken"), Arrays.asList("Carla", "5", "Water"), Arrays.asList("Carla", "5", "Ceviche"), Arrays.asList("Rous", "3", "Ceviche"))));
        System.out.println(number1418.displayTable(Arrays.asList(Arrays.asList("James", "12", "Fried Chicken"), Arrays.asList("Ratesh", "12", "Fried Chicken"), Arrays.asList("Amadeus", "12", "Fried Chicken"), Arrays.asList("Adam", "1", "Canadian Waffles"), Arrays.asList("Brianna", "1", "Canadian Waffles"))));
        System.out.println(number1418.displayTable(Arrays.asList(Arrays.asList("Laura", "2", "Bean Burrito"), Arrays.asList("Jhon", "2", "Beef Burrito"), Arrays.asList("Melissa", "2", "Soda"))));
    }
}
