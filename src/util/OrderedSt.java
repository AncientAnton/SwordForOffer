package util;

import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2018/8/2.
 * Description:
 */
public interface OrderedSt<Key extends Comparable<Key>, Value> {
    int size();

    Value get(Key key);

    void put(Key key, Value value);

    Key min();

    Key max();

    List<Key> keys(Key l, Key h);
}
