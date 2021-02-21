package org.example.projecthttp.menu;

import java.io.IOException;

public interface MenuItemApiService {

    public void doAction() throws IOException, InterruptedException;
    public String getName();
    public boolean closeAfter();


}
