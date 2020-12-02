package ru.job4j.cahce;

import net.jcip.annotations.ThreadSafe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class NonBlockingCache {
    private final Map<Integer, Base> map = new ConcurrentHashMap<>();

    public void add(Base model) {
        this.map.putIfAbsent(model.getId(), model);
    }

    public void update(Base model) {
        this.map.computeIfPresent(model.getId(), (key, currentModel) -> {
            int modelVersion = model.getVersion();
            int currentVersion = currentModel.getVersion();
            if (modelVersion != currentVersion) {
                throw new OptimisticException("Data update error!");
            }
            currentModel.setVersion(currentVersion + 1);
            return currentModel;
        });
    }

    public void delete(Base model) {
        this.map.remove(model.getId(), model);
    }
}