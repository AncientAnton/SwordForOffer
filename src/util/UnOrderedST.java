package util;

/**
 * Author: AncientAnton
 * Date: 2018/8/2.
 * Description:
 * 无序符号表 Symbol Table
 */
public interface UnOrderedST<Key, Value> {
    int size();

    Value get(Key key);

    void put(Key key, Value value);

    void delete(Key key);
}
