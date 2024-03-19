import sys
from typing import Dict, List


class Vertex:
    def __init__(self, vertexNum):
        self.vertexNum = vertexNum
        self.edgeNumList: List[int] = []
    def addEdge(self, edgeNum):
        self.edgeNumList.append(edgeNum)

def dfs(vertex : Vertex):
    global visit
    global vertexDict
    visit[vertex.vertexNum] = True
    print(str(vertex.vertexNum),  end=" ")

    vertex.edgeNumList.sort()
    for edgeNum in vertex.edgeNumList:
        if visit[edgeNum] == True:
            continue
        dfs(vertexDict.get(edgeNum))

def bfs(vertex : Vertex):
    global visit
    global vertexDict

    for vertexNum in queue:
        vertex = vertexDict.get(vertexNum)
        for edgeNum in vertex.edgeNumList:
            if visit[edgeNum] == True:
                continue
            visit[edgeNum] = True
            print(str(edgeNum),  end=" ")
            queue.append(edgeNum)

inputData = input().split()
N = int(inputData[0])
M = int(inputData[1])
V = int(inputData[2])
vertexDict: Dict[int, Vertex] = {}
for i in range(0, M):
    inputData = input().split()
    V1 = int(inputData[0])
    V2 = int(inputData[1])
    v1Vertex = vertexDict.get(V1)
    v2Vertex = vertexDict.get(V2)
    if V1 not in vertexDict:
        v1Vertex = Vertex(V1)
        vertexDict[V1] = v1Vertex
    if V2 not in vertexDict:
        v2Vertex = Vertex(V2)
        vertexDict[V2] = v2Vertex
    v1Vertex.addEdge(V2)
    v2Vertex.addEdge(V1)

vertex = vertexDict.get(V)
if vertex == None:
    print(V,  end=" ")
    print(V,  end=" ")
    sys.exit()
else:
    visit = [False for i in range(N+1)]
    dfs(vertex)
    visit = [False for i in range(N+1)]
    queue = [vertex.vertexNum]
    visit[vertex.vertexNum] = True
    print()
    print(str(vertex.vertexNum),  end=" ")
    bfs(vertex)