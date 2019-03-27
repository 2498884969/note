class Color:

    @property
    def RED(self):
        return True

    @property
    def BLACK(self):
        return False


color = Color()


class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.left = None
        self.right = None
        self.color = color.RED


class RBTree:
    def __init__(self):
        self.root = None
        self.size = 0

    def is_red(self, node: 'Node'):
        if not node:
            return color.BLACK
        return node.color
