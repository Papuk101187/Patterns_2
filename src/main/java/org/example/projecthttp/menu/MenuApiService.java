package org.example.projecthttp.menu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuApiService {


    List<MenuItemApiService> listMenu;

    public MenuApiService(List<MenuItemApiService> lists) {
        listMenu = lists;
    }


    public boolean starting() throws IOException, InterruptedException {

        getText(); // выводим текст для пользователя

        while (true) {

            int index = 1;
            for (MenuItemApiService menuActio : listMenu) {
                System.out.println(index + ". " + menuActio.getName());
                index++;
            } // перебор менюшки

            System.out.println("------------------------------");
            Scanner scanner = new Scanner(System.in); // вычитываем ответ от пользователя
            int indexs = scanner.nextInt();
            boolean t = listMenu.get(indexs - 1).closeAfter(); // проверяем выход
            listMenu.get(indexs - 1).doAction();
            if (t) {
                break;
            } // выход из программы
        }
        return false;
    }
    private void getText() {
        System.out.println("Выберите действие :");
    }
}


