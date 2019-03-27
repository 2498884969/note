# 一个工厂方法的例子

class DogToy:
    def speak(self):
        print('wang wang')


class CatToy:
    def speak(self):
        print('miao miao')


def toy_factory(toy_type):
    if toy_type == 'dog':
        return DogToy()
    elif toy_type == 'cat':
        return CatToy()


