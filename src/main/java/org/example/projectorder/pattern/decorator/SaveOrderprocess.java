package org.example.projectorder.pattern.decorator;

import org.example.projectorder.details.Order;

public class SaveOrderprocess extends DecoratorOrderprocess {


    public SaveOrderprocess(Orderprocess orderprocess) {
        super(orderprocess);
    }

    @Override
    public String action(Order ordes) {
        return super.action(ordes);
    }

    public String save(){
        return ", из класса SaveOrders сохраняем";
    } //save


}
