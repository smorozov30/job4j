package ru.job4j.parser;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    /**
     * Метод инициализирует файл свойств с параметрами из app.properties.
     */
    public void init(String config) {
        try (InputStream in = ru.job4j.jdbc.Config.class.getClassLoader().getResourceAsStream(config)) {
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
