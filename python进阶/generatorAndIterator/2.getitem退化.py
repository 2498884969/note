from collections.abc import Iterator,Iterable

# 这里__getitem__方法进行了退化，使得Company可以进行迭代


class Company(object):
    def __init__(self, employee_list):
        self.employee = employee_list

    def __getitem__(self, item):
        return self.employee[item]


if __name__ == '__main__':
    company = Company(['tom', 'bob', 'jane'])
    print(isinstance(company, Iterable))
    for a in company:
        print(a)

    com_iterator = iter(company)
    print(next(com_iterator))



