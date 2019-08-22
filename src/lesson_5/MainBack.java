package lesson_5;

import lesson_5.backpack.Backpack;
import lesson_5.backpack.MyItem;

import java.util.ArrayList;
import java.util.List;

public class MainBack {

    public static void main(String[] args) {

        List<MyItem> itemList = new ArrayList<>();
        itemList.add(new MyItem("Книга", 1, 500));
        itemList.add(new MyItem("Бинокль", 2, 5000));
        itemList.add(new MyItem("Аптечка", 4, 1500));
        itemList.add(new MyItem("Ноутбук", 2, 40000));
        itemList.add(new MyItem("Котелок", 1, 500));
        itemList.add(new MyItem("Пенал", 1.5, 500));


        Backpack backpack = new Backpack(2);
        backpack.makeAllSets(itemList);

        itemList = backpack.getBestSet();

        for (MyItem e : itemList) {
            System.out.println("Предмет = " + e.name + "; Вес = " + e.weight + "; Цена = " + e.price);
        }

        System.out.println("Вес = " + backpack.getSetWeight());
        System.out.println("Стоимость = " + backpack.getSetPrice());
    }
}
