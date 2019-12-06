package ru.job4j.generics;

import java.util.Iterator;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    protected SimpleArray<T> container;

    public AbstractStore(int size) {
        this.container = new SimpleArray<>(size);
    }

    @Override
    public void add(T element) {
        this.container.add(element);
    }

    @Override
    public boolean replace(String id, T element) {
        return this.container.set(this.findIndex(id), element);
    }

    @Override
    public boolean delete(String id) {
        return this.container.remove(this.findIndex(id));
    }

    @Override
    public T findById(String id) {
        int index = this.findIndex(id);
        return (index >= 0) ? this.container.get(index) : null;
    }

    protected int findIndex(String id) {
        Iterator<T> it = container.iterator();
        boolean result = false;
        int index = -1;
        while (it.hasNext()) {
            index++;
            if (it.next().getId().equals(id)) {
                result = true;
                break;
            }
        }
        return result ? index : -1;
    }
}
