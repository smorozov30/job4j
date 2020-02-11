package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class TrackerSQL implements ITracker, AutoCloseable {
    private Connection connection;
    private String config;
    private static final Random RANDOM = new Random();

    public TrackerSQL(String config) {
        this.config = config;
    }

    /**
     * Метод создает подключение к базе данных по config.
     * @return результат подключения.
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream(this.config)) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                                                            config.getProperty("url"),
                                                            config.getProperty("username"),
                                                            config.getProperty("password")
                                                         );
            this.tableCheck();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    /**
     * Метод создает таблицу items если она не существует в базе.
     * @throws SQLException
     */
    private void tableCheck() throws SQLException {
        PreparedStatement st = connection.prepareStatement("CREATE TABLE IF NOT EXISTS items "
                                                                + "("
                                                                + "id SERIAL PRIMARY KEY, "
                                                                + "item_id VARCHAR(30),"
                                                                + "name VARCHAR(50)"
                                                                + ");"
                                                            );
        st.executeUpdate();
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Для идентификации каждой заявки создает уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextLong());
    }

    /**
     * Метод добавляет элемент в базу.
     * @param item - заявка для добавления.
     * @return - добавленную заявку.
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement st = connection.prepareStatement("INSERT INTO items (item_id, name) VALUES (?, ?)")) {
            String id = this.generateId();
            item.setId(id);
            st.setString(1, id);
            st.setString(2, item.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Метод осуществляет замену элементов в БД по id заявки.
     * @param id - id заявки котрую нужно заменить в базе.
     * @return - результат замены.
     */
    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement("UPDATE items SET name = ? WHERE item_id = ?")) {
            st.setString(1, item.getName());
            st.setString(2, id);
            st.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод осуществляет удаление заявки из БД по id.
     * @param id - id заявки котрую нужно удалить из базе.
     * @return - результат удаления.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement("DELETE FROM items WHERE item_id = ?")) {
            st.setString(1, id);
            st.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод осуществляет выборку всех элементов из БД.
     * @return - коллекцию всех заявок в БД.
     */
    @Override
    public List<Item> findAll() {
        List<Item> all = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT item_id, name FROM items;")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Item temp = new Item(name);
                temp.setId(id);
                all.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    /**
     * Поиск заявок по имени: метод осуществляет выборку элементов из БД по имени заявки.
     * @param name - id заявки котрую нужно найти в базе.
     * @return - коллекцию найденных заявок.
     */
    @Override
    public List<Item> findByName(String name) {
        List<Item> all = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT item_id FROM items WHERE name = ?;")) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                Item item = new Item(name);
                item.setId(id);
                all.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    /**
     * Поиск заявки по id: метод осуществляет выборку элементов из БД по id заявки.
     * @param id - id заявки котрую нужно найти в базе.
     * @return - заявку или null.
     */
    @Override
    public Item findById(String id) {
        Item temp = null;
        try (PreparedStatement st = connection.prepareStatement("SELECT name FROM items WHERE item_id = ?;")) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                temp = new Item(name);
                temp.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * Метод закрывает соединение с базой данных, после завершения работы с классом TrackerSQL.
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        this.connection.close();
    }
}
