package com.codebrig.arthur.observe.observations

import com.google.common.collect.Maps

import java.util.concurrent.atomic.AtomicInteger

/**
 * Attributes observed during source code parsing
 *
 * @version 0.3.2
 * @since 0.1
 * @author <a href="mailto:brandon.fergerson@codebrig.com">Brandon Fergerson</a>
 */
class ObservedAttributes {

    final Map<String, AtomicInteger> observations = Maps.newConcurrentMap()

    void observe(Map<String, String> attributes) {
        attributes.keySet().stream().each {
            observations.putIfAbsent(it, new AtomicInteger())
            observations.get(it).incrementAndGet()
        }
    }

    void removeObservation(String attribute) {
        observations.remove(attribute)
    }

    List<String> getAttributes() {
        return observations.keySet().toList()
    }

    List<String> getRankedAttributes() {
        return entriesSortedByValues(observations).keySet().toList()
    }

    private static Map<String, AtomicInteger> entriesSortedByValues(Map<String, AtomicInteger> map) {
        List<Map.Entry<String, AtomicInteger>> list = new LinkedList<Map.Entry<String, AtomicInteger>>(map.entrySet())
        Collections.sort(list, new Comparator<Map.Entry<String, AtomicInteger>>() {
            @Override
            int compare(Map.Entry<String, AtomicInteger> o1, Map.Entry<String, AtomicInteger> o2) {
                return o2.getValue().get() <=> o1.getValue().get()
            }
        })

        Map<String, AtomicInteger> result = new LinkedHashMap<String, AtomicInteger>()
        for (Map.Entry<String, AtomicInteger> entry : list) {
            result.put(entry.getKey(), entry.getValue())
        }
        return result
    }
}
