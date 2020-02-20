package ru.job4j.parser;

import java.sql.*;

public class DBSaver implements Saver {
    private final Config config;
    private Connection connection;

    public DBSaver(Config config) {
        this.config = config;
    }

    private void init() {
        try {
            this.connection = DriverManager.getConnection(config.get("url"), config.get("username"), config.get("password"));
            this.connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vacancy add(Vacancy vacancy) {
        this.init();
        try (PreparedStatement st = connection.prepareStatement("INSERT INTO vacancies (name, link, text) VALUES (?, ?, ?)")) {
            st.setString(1, vacancy.getName());
            st.setString(2, vacancy.getLink());
            st.setString(3, vacancy.getText());
            st.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkDuplicate(String nameVacancy) {
        this.init();
        boolean result = false;
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM vacancies WHERE name = ?;")) {
            st.setString(1, nameVacancy);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
