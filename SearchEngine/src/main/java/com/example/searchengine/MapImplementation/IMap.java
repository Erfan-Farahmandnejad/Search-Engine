package com.example.searchengine.MapImplementation;

import com.example.searchengine.MapImplementation.Entry;

public interface IMap<K, V> {
    int size();

    boolean isEmpty();

    V get(K key);

    V put(K key, V value);

    V remove(K key);

    Iterable<K> KeySet();

    Iterable<V> Values();

    Iterable<Entry<K, V>> entrySet();
}