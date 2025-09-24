# 트리의 부모 찾기 (실버2)
# 유형 : 트리

import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = [[0] for _ in range(N+1)] # 연결리스트

for i in range(1, N):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)


parent = [0]*(N+1) # 1차원 리스트
q = deque()
q.append(1)

# dfs
while q:
    # 부모에 연결된 자식들의 parent[i] 업데이트
    current = q.popleft()
    for c in graph[current]:
        if parent[c] == 0:
            parent[c] = current
            q.append(c)

print('\n'.join(map(str, parent[2:])))