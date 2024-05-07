package Task10;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyHashMap<T> {
    private final Map<Long, Pair<HashMap<Long, T>, ReentrantReadWriteLock>> map;

    public MyHashMap() {
        this.map = new HashMap<>() {{
            put(0L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(1L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(2L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(3L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(4L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(5L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(6L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(7L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(8L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(9L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(10L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(11L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(12L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(13L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(14L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
            put(15L, new Pair<>(new HashMap<>(), new ReentrantReadWriteLock()));
        }};
    }

    public void put(long key, T value) {
        long pk = key % 16;
        Map<Long, T> curMap = map.get(pk).getValue0();
        ReentrantReadWriteLock lock = map.get(pk).getValue1();
        lock.writeLock().lock();
        try {
            if (!curMap.containsKey(key)) {
                curMap.put(key, value);
            } else {
                throw new IllegalArgumentException("This key already in the map");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T get(long key) {
        long pk = key % 16;
        Map<Long, T> curMap = map.get(pk).getValue0();
        ReentrantReadWriteLock lock = map.get(pk).getValue1();
        lock.readLock().lock();
        try {
            if (curMap.containsKey(key)) {
                return curMap.get(key);
            } else {
                throw new IllegalArgumentException("No such key");
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    public T remove(long key) {
        long pk = key % 16;
        Map<Long, T> curMap = map.get(pk).getValue0();
        ReentrantReadWriteLock lock = map.get(pk).getValue1();
        lock.writeLock().lock();
        try {
            if (curMap.containsKey(key)) {
                return curMap.remove(key);
            } else {
                throw new IllegalArgumentException("No such key");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean containsKey(long key) {
        long pk = key % 16;
        Map<Long, T> curMap = map.get(pk).getValue0();
        ReentrantReadWriteLock lock = map.get(pk).getValue1();
        lock.readLock().lock();
        try {
            return curMap.containsKey(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Map<Long, T> curMap;
        ReentrantReadWriteLock lock;
        for (long value: map.keySet()){
            lock = map.get(value).getValue1();
            lock.readLock().lock();
            curMap = map.get(value).getValue0();
            for (long value1: curMap.keySet()) {
                sb.append("key[").append(value1).append("] = ").append(curMap.get(value1)).append("; ");
            }
            sb.append("\n");
            lock.readLock().unlock();
        }
        return sb.toString();
    }
}
