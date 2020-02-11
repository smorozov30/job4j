package ru.job4j.tracker;

import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    /**
     * Переменная хранит данные для подключения к БД для проведения тестов.
     */
    private static String config =  "app.properties";

    /**
     * Метод выполняется до и после каждого теста, чтобы очистить таблицу перед выполнением каждого метода.
     */
    @After
    public void afterTest() {
        try (TrackerSQL tracker = new TrackerSQL(config)) {
            tracker.init();
            List<Item> all = tracker.findAll();
            for (Item item : all) {
                tracker.delete(item.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет соединение с базой данных.
     */
    @Test
    public void checkConnection() {
        try (TrackerSQL tracker = new TrackerSQL(config)) {
            assertThat(tracker.init(), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет выборку всех элементов из базы.
     */
    @Test
    public void whenDBHasThreeItemThenLength3() {
        try (TrackerSQL tracker = new TrackerSQL(config)) {
            tracker.init();
            Item first = new Item("test1");
            Item second = new Item("test2");
            Item third = new Item("test3");
            tracker.add(first);
            tracker.add(second);
            tracker.add(third);
            int result = tracker.findAll().size();
            int expected = 3;
            assertThat(result, is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет выборку всех элементов по имени заявки.
     */
    @Test
    public void whenTwoNamesInDBThanLength2() {
        try (TrackerSQL tracker = new TrackerSQL(config)) {
            tracker.init();
            Item first = new Item("test1");
            Item second = new Item("test2");
            Item third = new Item("test3");
            Item fourth = new Item("test2");
            tracker.add(first);
            tracker.add(second);
            tracker.add(third);
            tracker.add(fourth);
            int result = tracker.findByName("test2").size();
            int expected = 2;
            assertThat(result, is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет добавление элемента в базу.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (TrackerSQL tracker = new TrackerSQL(config)) {
            tracker.init();
            Item item = new Item("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет замену старой заявки на новую.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        try (TrackerSQL tracker = new TrackerSQL(config)) {
            tracker.init();
            Item previous = new Item("test1");
            tracker.add(previous);
            Item next = new Item("test2");
            next.setId(previous.getId());
            tracker.replace(previous.getId(), next);
            assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет удаление заявки из таблицы.
     */
    @Test
    public void whenDeleteItemThenTrue() {
        try (TrackerSQL tracker = new TrackerSQL(config)) {
            tracker.init();
            Item item = new Item("test1");
            tracker.add(item);
            String id = item.getId();
            boolean result = tracker.delete(id);
            assertThat(result, is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void whenSecondIdThanNameTest2() {
        try (TrackerSQL tracker = new TrackerSQL(config)) {
            tracker.init();
            Item first = new Item("test1");
            Item second = new Item("test2");
            Item third = new Item("test3");
            tracker.add(first);
            Item item = tracker.add(second);
            tracker.add(third);
            String result = tracker.findById(item.getId()).getName();
            String expected = "test2";
            assertThat(result, is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
