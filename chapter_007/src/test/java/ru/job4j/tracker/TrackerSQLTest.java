package ru.job4j.tracker;

import org.junit.After;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Метод проверяет соединение с базой данных.
     */
    @Test
    public void checkConnection() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            assertThat(tracker.checkConnection(), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет выборку всех элементов из базы.
     */
    @Test
    public void whenDBHasThreeItemThenLength3() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            if (tracker.checkConnection()) {
                Item first = new Item("test1");
                Item second = new Item("test2");
                Item third = new Item("test3");
                tracker.add(first);
                tracker.add(second);
                tracker.add(third);
                int result = tracker.findAll().size();
                int expected = 3;
                assertThat(result, is(expected));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет выборку всех элементов по имени заявки.
     */
    @Test
    public void whenTwoNamesInDBThanLength2() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            if (tracker.checkConnection()) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет добавление элемента в базу.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            if (tracker.checkConnection()) {
                Item item = new Item("test1");
                tracker.add(item);
                Item result = tracker.findById(item.getId());
                assertThat(result.getName(), is(item.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет замену старой заявки на новую.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            if (tracker.checkConnection()) {
                Item previous = new Item("test1");
                tracker.add(previous);
                Item next = new Item("test2");
                next.setId(previous.getId());
                tracker.replace(previous.getId(), next);
                assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет удаление заявки из таблицы.
     */
    @Test
    public void whenDeleteItemThenTrue() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            if (tracker.checkConnection()) {
                Item item = new Item("test1");
                tracker.add(item);
                String id = item.getId();
                boolean result = tracker.delete(id);
                assertThat(result, is(true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenSecondIdThanNameTest2() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            if (tracker.checkConnection()) {
                Item first = new Item("test1");
                Item second = new Item("test2");
                Item third = new Item("test3");
                tracker.add(first);
                Item item = tracker.add(second);
                tracker.add(third);
                String result = tracker.findById(item.getId()).getName();
                String expected = "test2";
                assertThat(result, is(expected));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
