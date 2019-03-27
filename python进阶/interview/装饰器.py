def decorator_a(func):
    print('a_in=', func)

    print('Get in decorator_a')

    def inner_a(*args, **kwargs):
        print('Get in inner_a')
        return func(*args, **kwargs)

    print('a_out=', inner_a)
    return inner_a


def decorator_b(func):
    print('b_in=', func)
    print('Get in decorator_b')

    def inner_b(*args, **kwargs):
        print('Get in inner_b')
        return func(*args, **kwargs)

    print('b_out=', inner_b)
    return inner_b


@decorator_b
@decorator_a
def f(x):
    print('Get in f')
    return x * 2


if __name__ == '__main__':
    f(1)
