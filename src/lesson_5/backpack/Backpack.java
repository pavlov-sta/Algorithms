package lesson_5.backpack;


import java.util.ArrayList;
import java.util.List;

public class Backpack { //рюкзак

    private List<MyItem> setItems;

    private double maxW;

    private double setPrice;

    private double setWeight;

    public Backpack(double maxW) {
        this.maxW = maxW;
        this.setItems = null;
    }

    //создание всех наборов
    public void makeAllSets(List<MyItem> items) {
        if (items.size() > 0) {
            checkSet(items);
        }

        for (int i = 0; i < items.size(); i++) {
            List<MyItem> newSet = new ArrayList<>(items);
            newSet.remove(i);

            makeAllSets(newSet);
        }
    }

    //проверка, является ли данный набор лучшим решением задачи
    private void checkSet(List<MyItem> items) {
        if (setItems == null) {
            if (calcWeigth(items) <= maxW) {
                setItems = items;
                setPrice = calcPrice(items);
                setWeight = calcWeigth(items);
            }
        } else {
            if (calcWeigth(items) <= maxW && calcPrice(items) > setPrice) {
                setItems = items;
                setPrice = calcPrice(items);
                setWeight = calcWeigth(items);
            }
        }
    }

    //вычисляет общий вес набора
    private double calcWeigth(List<MyItem> items) {
        double sumW = 0;

        for (MyItem e : items) {
            sumW += e.weight;
        }

        return sumW;
    }

    //вычисляет общую стоимость набора предметов
    private double calcPrice(List<MyItem> items) {
        double sumPrice = 0;

        for (MyItem e : items) {
            sumPrice += e.price;
        }

        return sumPrice;
    }

    // получаем лучший набор
    public List<MyItem> getBestSet() {
        return setItems;
    }

    // получаем цену набора
    public double getSetPrice() {
        return setPrice;
    }

    // получаем вес набора
    public double getSetWeight() {
        return setWeight;
    }
}
