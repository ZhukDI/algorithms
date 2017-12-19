package com.zhukdi.algorithms.task_4.eulerian_path;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    private int adjMatrix[][];
    private ArrayList<Edge> edgeList;
    private ArrayList<Vertex> vertexList;

    public Graph(int vertexNumber) {
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();

        adjMatrix = new int[vertexNumber][vertexNumber];
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                }
            }
        }
    }

    public void addVertex(Vertex vertex) {
        vertexList.add(vertex);
    }

    public void addEdge(Vertex start, Vertex end, int weight) {
        int vertexFrom = 0, vertexTo = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).label == start.label) {
                vertexFrom = i;
            }
            if (vertexList.get(i).label == end.label) {
                vertexTo = i;
            }
        }
        adjMatrix[vertexFrom][vertexTo] = weight;
        adjMatrix[vertexTo][vertexFrom] = weight;
        edgeList.add(new Edge(start, end, weight));
    }

    public void displayAdjMat() {
        System.out.print("\t");
        for (int i = 0; i < vertexList.size(); i++) {
            displayVertex(i);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = 0; i < vertexList.size(); i++) {
            displayVertex(i);
            System.out.print("\t");
            for (int j = 0; j < vertexList.size(); j++) {
                System.out.print(adjMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void displayVertex(int v) {
        System.out.print(vertexList.get(v).label);
    }

    public void displayVertexList() {
        for (Vertex vertex : vertexList) {
            System.out.println(vertex);
        }
    }

    public void displayEdgeList() {
        for (Edge edge : edgeList) {
            System.out.println(edge);
        }
    }

    private int getDeg(int v) {
        int deg = 0;
        for (int i = v; i<v+1; i++) {
            for (int j = 0; j<vertexList.size(); j++) {
                if(adjMatrix[i][j]!=0) {
                    deg++;
                }
            }
        }
        return deg;
    }

    public boolean checkForEulerPath() {
        int oddVertex = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (getDeg(i) % 2 == 1) {
                oddVertex++;
            }
        }
        if (oddVertex > 2 /*|| nVerts != dfs().size()*/) {
            return false;
        }
        return true;
    }

    public void findEulerPath(Vertex v) {
        Stack<Vertex> stack = new Stack<>();
        ArrayList<Edge> list = (ArrayList<Edge>) edgeList.clone();
        for (Vertex u : vertexList) {
            if (getDeg(vertexList.indexOf(u)) % 2 == 1) {
                v = u;
                break;
            }
        }
        stack.push(v);
        while (!stack.isEmpty()) {
            Vertex w = stack.peek();
            for (Vertex u : vertexList) {
                Edge edge = new Edge(w, u);
                if (list.contains(edge)) {
                    stack.push(u);
                    list.remove(edge);
                    break;
                }
            }
            if (w == stack.peek()) {
                stack.pop();
                System.out.println(w);
            }
        }
    }
}
