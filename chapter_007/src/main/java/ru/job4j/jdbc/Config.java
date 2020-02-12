package ru.job4j.jdbc;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    /**
     * Метод инициализирует файл свойств с параметрами из app.properties.
     */
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Метод возвращает параметры файла свойств по ключу.
     * @param key
     * @return
     */
    public String get(String key) {
        return this.values.getProperty(key);
    }
}
