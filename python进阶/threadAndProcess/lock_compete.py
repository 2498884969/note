import threading

g_list = []


def append1():
    global g_list
    for i in range(100000):
        g_list.append(1)
    pass


def append2():
    global g_list
    for i in range(100000):
        g_list.append(2)


if __name__ == '__main__':

    threading.Thread(target=append1).start()
    threading.Thread(target=append2).start()

    print(len(g_list))
    pass
