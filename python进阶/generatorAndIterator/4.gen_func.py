# 函数中只要存在yield关键字就为生成器函数
def gen_fib(index):
    n, a, b = 0, 0, 1
    while n < index:
        yield b
        a, b = b, a + b
        n += 1

# 惰性求值，为延迟求值提供了可能


if __name__ == '__main__':
    for data in gen_fib(10):
        print(data)
