import time


def get_execution_time_simple(func):

    def executor(*args, **kwargs):
        t1 = time.time()
        func(*args, **kwargs)
        t2 = time.time()

    return executor
