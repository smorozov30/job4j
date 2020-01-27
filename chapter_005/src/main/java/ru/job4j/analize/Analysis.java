package ru.job4j.analize;

import java.util.Iterator;
import java.util.List;

public class Analysis {

    /**
     * Метод определяет рязницу между начальным состоянием коллекции и текущим.
     * В циклах проходим по коллекциям и определяем сколько элементов изменилось(changed++) и осталось
     * неизменными(noChanged++) в текущей коллекции по сравнению с начальной коллекцией.
     *      Вычисляем разницу:
     * remained = noChange + changes - количество объектов присутствующих в обоих коллекциях.
     * deleted = previous.size() - remained - количество объектов которые есть в старой коллекции,
     *                                        но отсутствуют в новой(объекты были удалены).
     * added = current.size() - remained - - количество объектов которые есть в новой коллекции,
     *      *                                но отсутствуют в старой(объекты были добавлены).
     * @param previous - начальная коллекция объектов User.
     * @param current - текущая коллекция объектов User.
     * @return - объект класса Info, содержащий количество изменений в коллекции.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info changes = new Info();
        int noChange = 0;
        for (User prevUser : previous) {
            Iterator<User> iterator = current.iterator();
            while (iterator.hasNext()) {
                User currUser = iterator.next();
                if (prevUser.id == currUser.id) {
                    if (prevUser.name.equals(currUser.name)) {
                        noChange++;
                    } else {
                        changes.changed++;
                    }
                    break;
                }
            }
        }
        int remained = noChange + changes.changed;
        changes.deleted = previous.size() - remained;
        changes.added = current.size() - remained;
        return changes;
    }

    public static class User {
        int id;
        String name;
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
