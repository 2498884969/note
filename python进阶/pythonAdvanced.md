## 1.Python 中的闭包

在函数内部定义的函数和外部定义的函数是一样的，只是他们无法被外部访问 ：

```python
def g():
    print 'g()...'

def f():
    print 'f()...'
    return g
```

将 **g** 的定义移入函数 **f** 内部，防止其他代码调用 **g**： 

```python
def f():
    print 'f()...'
    def g():
        print 'g()...'
    return g
```

下面的函数**calc_sum**：

```python
def calc_sum(lst):
    def lazy_sum():
        return sum(lst)
    return lazy_sum
```

**注意:** 发现没法把 **lazy_sum** 移到 **calc_sum** 的外部，因为它引用了 **calc_sum** 的参数 **lst** 

像这种**内层函数引用了外层函数的变量**（参数也算变量），然后返回内层函数的情况，称为**闭包（Closure）** 

**闭包的特点**是返回的函数还引用了外层函数的局部变量，所以，要正确使用闭包，就要**确保引用的局部变量在函数返回后不能变**。举例如下： 

```python
def count():
    fs = []
    for i in range(1, 4):
        def f():
            return i**2
        fs.append(f)
    return fs


f1, f2, f3 = count()

print(f1(), f2(), f3())
```

原因就是当count()函数返回了3个函数时，这3个函数所引用的变量 i 的值已经变成了3。由于f1、f2、f3并没有被调用，所以，此时他们并未计算 i*i 。

因此，返回函数不要引用任何循环变量，或者后续会发生变化的变量。 

改写函数让其返回1，4，9

```python
def count():
    fs = []
    for i in range(1, 4):
        def f(j):
            def g():
                return j**2
            return g
        fs.append(f(i))
    return fs


f1, f2, f3 = count()

print(f1(), f2(), f3())
```

## collections

### 1.namedtuple

#### 1.性能

- 1.可进行拆包操作
- 2._asdict()返回一个orderDict对象

```python
from collections import namedtuple

User = namedtuple("User", ["name", "age", "height", "edu"])
user_tuple = ("bobby", "29", 175)
user = User(*user_tuple, "master")
print(user.name)
```



```python
info_dict = user._asdict()
print(info_dict)
pass
```

#### 2.练习

```python
from collections import namedtuple

Clothes = namedtuple("Clothes", ["size", "color"])
Shoes = namedtuple("Shoes", ["size", "color"])
Person = namedtuple("Person", ["name", "age", "clothes", "shoes", "children"])

clothes = Clothes("L", "green")
shoes = Shoes(42, "white")
# person = Person("Black", 48, clothes, shoes)
# >.必须要参数对应不能多不能少
person_dict = {"name": "Black", "clothes": clothes, "shoes": shoes,
               "age": 48, "children": {"bob": 22}}
person = Person(**person_dict)
print(person)
pass
```



### 2.defaultdict

```python
user_dict = {}
users = ["bobby1", "bobby2", "bobby2", "bobby2", "bobby2", "bobby2"]
for user in users:
    user_dict[user] += 1
```

报错：

```python
    user_dict[user] += 1
KeyError: 'bobby1'
```

正确写法（也就是说当dict中不存在key的时候，dict[key不能作为右值]）

```python
from collections import defaultdict

user_dict = {}
users = ["bobby1", "bobby2", "bobby2", "bobby2", "bobby2", "bobby2"]
for user in users:
    if user not in user_dict:
        user_dict[user] = 1
    else:
        user_dict[user] += 1


print(user_dict)
```

- 使用user_dict.setdefault(user,0)

```python
user_dict = {}
users = ["bobby1", "bobby2", "bobby2", "bobby2", "bobby2", "bobby2"]
for user in users:
    user_dict.setdefault(user,0)
    user_dict[user] += 1


print(user_dict)
```



```python
default_dict = defaultdict(int)
print(default_dict['bobby1'])		# 输出为0
```

设置默认返回

```python
def gen_default():
    return {
        "name": '',
        "nums": 0
    }


default_dict = defaultdict(gen_default)     # 参数为句柄
print(default_dict["group1"])
```

### 3.deque

- shallow copy：浅拷贝只拷贝不可变元素
- deque 是线程安全的，而List不是线程安全的

## 4.Counter

```python
from collections import Counter

users = ["Bob1", "Bob1", "Bob1", "Bob1", "Bob1", "Bob1", "Bob12"]

user_count = Counter(users)
user_count2 = Counter('asdfwefsndfjankwqedssdafas')
print(user_count2)
print(user_count2.most_common(2))
```

## 5. orderedDict

- Python3中dict默认有序，顺序与添加顺序一致

```python
from collections import ChainMap

from collections import ChainMap

user_dict1 = {"a": "Bob1", "b": "Bob2"}
user_dict2 = {"c": "Bob3", "d": "Bob4"}

new_dict = ChainMap(user_dict1,user_dict2)

for key,value in new_dict.items():
    print(key,value)
```



```python
from collections import ChainMap

user_dict1 = {"a": "Bob1", "b": "Bob2"}
user_dict2 = {"b": "Bob3", "d": "Bob4"}

new_dict = ChainMap(user_dict1,user_dict2)

for key,value in new_dict.items():
    print(key,value) 
```



```python
from collections import ChainMap

from collections import ChainMap

user_dict1 = {"a": "Bob1", "b": "Bob2"}
user_dict2 = {"b": "Bob3", "d": "Bob4"}

new_dict = ChainMap(user_dict1,user_dict2)

print(new_dict.maps)        # 输出组成new_map的字典

# def __init__(self, *maps):
```



### 知识点

- exec函数了解一波
- \_\_missing\_\_魔法函数







