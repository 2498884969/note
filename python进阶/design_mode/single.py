import threading


class Single:

    lock = threading.Lock()

    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            with cls.lock:
                if not hasattr(cls, '_instance'):
                    setattr(cls, '_instance', super().__new__(cls))
        return getattr(cls, '_instance')


class MtClass(Single):
    pass


if __name__ == '__main__':
    o1 = MtClass()
    o2 = MtClass()
    print(id(o1))
    print(id(o2))


