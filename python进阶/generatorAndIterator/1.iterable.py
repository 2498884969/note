# 什么是迭代协议？
# 迭代器是什么？ 迭代器是访问集合内元素的一种方式，一般用来遍历数据，属于设计模式的一种
# 迭代器和下标访问的方式不一样，迭代器是不能返回的（访问方向单一），迭代器提供了一种惰性访问数据的方式

from collections.abc import Iterable, Iterator

if __name__ == '__main__':
    a = [1, 2]
    print(isinstance(a, Iterable))
    print(isinstance(a, Iterator))
    a_iterator = iter(a)
    print(isinstance(a_iterator, Iterator))
    pass

