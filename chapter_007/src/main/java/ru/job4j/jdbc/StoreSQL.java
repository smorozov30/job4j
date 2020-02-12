package ru.job4j.jdbc;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connection;

    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * Метод создает подключение к базе данных, если база отсутствует, то создает ее и создает подключение.
     */
    private void init() {
        try {
            this.connection = DriverManager.getConnection(config.get("url"));
            this.connection.setAutoCommit(false);
            this.tableCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод создает таблицу в базе если она не существовала ранее.
     * @throws SQLException
     */
    private void tableCheck() throws SQLException {
        PreparedStatement st = connection.prepareStatement("CREATE TABLE IF NOT EXISTS entry "
                + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "field INT"
                + ");"
        );
        st.executeUpdate();
    }

    /**
     * Метод генерирует в базе n записей.
     * @param n - количество записей, которые требуется сгенерировать в базу.
     */
    public void generate(int n) {
        this.cleaning();
        try (PreparedStatement st = connection.prepareStatement("INSERT INTO entry (field) VALUES (?);")) {
            for (int count = 1; count <= n; count++) {
                st.setInt(1, count);
                st.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод очищает таблицу от данных.
     */
    private void cleaning() {
        try (PreparedStatement st = connection.prepareStatement("DELETE FROM entry")) {
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод осуществляет выборку всех элементов из базы в коллекцию.
     * @return
     */
    public List<Entry> load() {
        List<Entry> temp = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT field FROM entry;");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                temp.add(new Entry(rs.getInt(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            this.connection.close();
        }
    }

    public static void main(String[] args) {
        Config config = new Config();
        config.init();
        StoreSQL store = new StoreSQL(config);
        store.init();

        store.generate(Integer.parseInt("1000000"));

        List<Entry> all = store.load();
        File target = new File("./chapter_007/test.xml");
        new StoreXML(target).save(all);

        File source = new File("./chapter_007/test.xml");
        target = new File("./chapter_007/test.xslt");
        File scheme = new File("./chapter_007/scheme.xsl");
        new ConvertXSQT().convert(source, target, scheme);

        source = target;
        new Parser().getSum(source);
    }
}
