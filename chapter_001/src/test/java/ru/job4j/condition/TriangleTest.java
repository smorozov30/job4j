package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест на класс Triangle.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class TriangleTest {

    /**
     * Тестируем возможность создания класса.
     */
    @Test
    public void whenCreateClassThenReturnNotNull() {
        Triangle triangle = new Triangle();
        assertNotNull(triangle);
    }

    /**
     * Тестируем существование треугольника со сторонами 2, 2, 2.
     */
    @Test
    public void whenExist() {
        boolean result = Triangle.exist(2.0, 2.0, 2.0);
        assertThat(result, is(true));
    }

    /**
     * Тестируем невозможность существования треугольника со сторонами 2, 1, 1.
     */
    @Test
    public void whenDoesNotExist() {
        boolean result = Triangle.exist(2.0, 1.0, 1.0);
        assertThat(result, is(false));
    }
}
