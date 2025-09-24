# 트리 순회 실버1
# 트리

import sys

sys.setrecursionlimit(10**8) # 재귀함수 리미트하여 메모리 초과 방지

input = sys.stdin.readline

# 전위 : 루트-왼쪽-오른쪽
# 중위 : 왼쪽-루트-오른쪽
# 후위 : 왼쪽-오른쪽-루트
N = int(input().strip())
tree = {}

for i in range(N):
    parent, left, right = input().strip().split()
    tree[parent] = [left, right]

def preorder(node):
    if node == '.':
        return
    print(node, end='')
    preorder(tree[node][0])
    preorder(tree[node][1])

def inorder(node):
    if node == '.':
        return
    inorder(tree[node][0])
    print(node, end='')
    inorder(tree[node][1])


def postorder(node):
    if node == '.':
        return
    postorder(tree[node][0])
    postorder(tree[node][1])
    print(node, end='')


preorder('A')
print()
inorder('A')
print()
postorder('A')
