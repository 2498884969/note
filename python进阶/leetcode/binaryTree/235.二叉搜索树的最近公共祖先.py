# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.__help(root, p, q)
        pass

    def __help(self, node: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if p.val < node.val < q.val:
            return node.val

        if p.val == node.val:
            return node

        if q.val == node.val:
            return node

        if q.val < node.val and p.val < node.val:
            return self.__help(node.left, p, q)

        if q.val > node.val and p.val > node.val:
            return self.__help(node.right, p, q)
