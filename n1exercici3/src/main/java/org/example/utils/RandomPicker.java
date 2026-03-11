package org.example.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RandomPicker {
    public static <K, V> List<Map.Entry<K, V>> pickRandomEntries(Map<K, V> map, int n) {
        List<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        Collections.shuffle(entries);
        return entries.subList(0, Math.min(n, entries.size()));
    }
}
