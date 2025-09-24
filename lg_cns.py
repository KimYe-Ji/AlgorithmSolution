# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
from collections import deque
input = sys.stdin.readline

N, M, T, S, E = map(int, input().strip().split())
freepass = list(map(int, input().strip().split()))
graph = [[] for _ in range(N+1)] # 단방향 그래프
bi_graph = [[] for _ in range(N+1)] # 양방향 그래프

for i in range(M):
	s, e = map(int, input().strip().split())
	graph[s].append(e)
	bi_graph[s].append(e)
	bi_graph[e].append(s)

deq = deque()
deq.append(S)
visited = [0]*(N+1)
def dfs(node, count):
	if len(deq) == 0:
		return -1
		
	current = deq.popleft()
	if visited[current]:
		return -1
	visited[current] = 1
	if current == node:
		return count # 어케할지 결정!!! 넘기기 전에 +1할 지, 넘긴 후에 +1 할지

	minimum = 20001
	for v in graph[current]:
		deq.append(v)
		answer = dfs(node, count+1)
		if answer == -1:
			continue
		else:
			minimum = min(answer, minimum)
	if minimum == 20001:
		return -1
	return minimum


def dfs(node, count):
	if len(deq) == 0:
		return -1
		
	current = deq.popleft()
	if visited[current]:
		return -1
	visited[current] = 1
	if current == node:
		return count # 어케할지 결정!!! 넘기기 전에 +1할 지, 넘긴 후에 +1 할지

	minimum = 20001
	for v in bi_graph[current]:
		deq.append(v)
		answer = dfs(node, count+1)
		if answer == -1:
			continue
		else:
			minimum = min(answer, minimum)
	if minimum == 20001:
		return -1
	return minimum

# unavailable = False
# frepass 고르기!!!!!!!!!!!
freepass_cost = {}
for i in freepass:
	cost = dfs(i, 0)
	if cost == -1:
		# unavailable = True
		continue
	freepass_cost[i] = cost
minimum_freepass = 20001
min_frepass = []
for i in freepass_cost:
	value = freepass_cost.get(i)
	# print('value: ', value, type(value))
	if value == minimum_freepass:
		min_frepass = min_frepass.append(int(i))
	elif value < minimum_freepass:
		minimum_freepass = value
		min_frepass = [int(i)]

deq.clear()
print(freepass_cost)
print(min_frepass)
for i in range(N+1):
	visited[i] = 0
minimum_E = 20001
answer_freepass = 3001
for i in min_frepass:
	deq.append(i)
	cost = dfs(i, 0)
	if cost == -1:
		# unavailable = True
		continue
	if cost == minimum_E:
		answer_freepass = min(answer_freepass, i)
	elif cost < minimum_E:
		answer_freepass = i
		minimum_E = cost

if minimum_E == 20001:
	print(-1)
else:
	print(answer_freepass, minimum_E)