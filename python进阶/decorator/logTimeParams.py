import time


class LogTimeParams:

    def __init__(self, use_int=False):
        self.use_int = use_int
        pass

    def __call__(self, func):
        def _wrap(*args, **kwargs):
            beg = time.time()
            res = func(*args, **kwargs)
            if self.use_int:
                print('use time {}'.format(int(time.time() - beg)))
            else:
                print('use time {}'.format(time.time() - beg))
            return res

        return _wrap


@LogTimeParams(use_int=True)
def my_sleep():
    time.sleep(1)


if __name__ == '__main__':
    my_sleep()
    pass
