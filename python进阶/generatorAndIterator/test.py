import dis


def f(a=[]):
    pass


if __name__ == '__main__':
    print(dis.dis(f))
