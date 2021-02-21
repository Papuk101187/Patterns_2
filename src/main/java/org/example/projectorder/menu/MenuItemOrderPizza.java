package org.example.projectorder.menu;

import java.io.IOException;

public interface MenuItemOrderPizza {

    public void doAction() throws IOException, InterruptedException;
    public String getName();
    public boolean closeAfter();

}
