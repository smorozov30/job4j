package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<SimpleMap.Pair<K, V>> {
    private Object[] container;
    private int count = 0;

    public SimpleMap() {
        this.container = new Object[16];
    }

    /**
     * Метод добавляет пару ключ-значение в карту.
     * @param key - ключ.
     * @param value - значение.
     * @return - результат добавления.
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        if (this.count >= this.container.length) {
            this.expand();
        }
        int index = this.getIndex(this.hash(key));
        if (this.container[index] == null) {
            this.container[index] = new Pair<>(key, value);
            this.count++;
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает значение из карты по ключу.
     * @param key - ключ для поиска.
     * @return - значение.
     */
    public V get(K key) {
        Pair<K, V> pair = ((Pair) this.container[this.getIndex(this.hash(key))]);
        return pair != null ? pair.getValue() : null;
    }

    /**
     * Метод удаляет значение из карты по ключу.
     * @param key
     * @return
     */
    public boolean delete(K key) {
        boolean result = false;
        if (this.container[this.getIndex(this.hash(key))] != null) {
            this.container[this.getIndex(this.hash(key))] = null;
            this.count--;
            result = true;
        }
        return result;
    }

    /**
     * Метод рассчитывает хэш-код ключа.
     * @param key - ключ.
     * @return - хэш-код ключа.
     */
    private int hash(K key) {
        int result = 0;
        if (key != null) {
            int h = key.hashCode();
            result = h ^ (h >>> 16);
        }
        return result;
    }

    /**
     * Метод на основе хэш-кода ключа, определяет в какую ячейку container поместить
     * пару ключ-значение добавляемые в карту.
     * @param hash - хэш-код ключа.
     * @return - индекс в массиве для размещения пары.
     */
    private int getIndex(int hash) {
        return (hash & (this.container.length - 1));
    }

    /**
     * Метод расширяет container на котором построена карта.
     */
    private void expand() {
        Object[] temp = this.container.clone();
        this.container = new Object[this.container.length * 2];
        this.redistribute(temp);
    }

    /**
     * Метод перераспределяет пары в container на основе хэш-кода ключей и увеличенного размера container.
     * @param temp
     */
    private void redistribute(Object[] temp) {
        this.count = 0;
        for (Object obj : temp) {
            Pair<K, V> pair = (Pair) obj;
            K key = pair.getKey();
            V value = pair.getValue();
            this.insert(key, value);
        }
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new Iterator<>() {
            int cursor = 0;
            int expectedModCount = count;

            @Override
            public boolean hasNext() {
                if (this.expectedModCount != count) {
                    throw new ConcurrentModificationException("Коллекция была изменена.");
                }
                boolean result = false;
                while (this.cursor < container.length) {
                    if (container[this.cursor] != null) {
                        result = true;
                        break;
                    }
                    this.cursor++;
                }
                return result;
            }

            @Override
            public Pair<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (Pair<K, V>) container[cursor++];
            }
        };
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
}
