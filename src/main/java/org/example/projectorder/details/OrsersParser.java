package org.example.projectorder.details;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrsersParser {


    public Order deserializationСontact(String order) {
        Order order1 = null;
        Pattern pattern = Pattern.compile("(Название пиццы).(\\S+).\\[(желаемое количество)().([0-9]).:(доставка на адрес)(.+)(.)");
        Matcher matcher = pattern.matcher(order);

        while (matcher.find()) {
            String name = matcher.group(2);
            int count = Integer.parseInt(matcher.group(5));
            String adress = matcher.group(7);
            order1 = new Order(name, count, adress);
        }

        return order1;
    }


    public String deserializationСontact(Order order) {
        String name = order.name;
        int count = order.count;
        String address = order.address;

        return "Название пиццы "+name + " [ желаемое количество " + count + " : доставка на адрес " + address + "]";

    }




}
