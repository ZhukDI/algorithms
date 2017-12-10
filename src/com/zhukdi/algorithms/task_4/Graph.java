package com.zhukdi.algorithms.task_4;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts; // текущее количество вершин
    private StackX theStack;


    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS]; // Матрица смежности
        nVerts = 0;
        for(int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        theStack = new StackX();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void displayAdjMat() {
        System.out.print("\t");
        for (int i = 0; i < nVerts; i++) {
            displayVertex(i);
            System.out.print("\t");
        }
        System.out.println();
        for (int i = 0; i < nVerts; i++) {
            displayVertex(i);
            System.out.print("\t");
            for (int j = 0; j < nVerts; j++) {
                System.out.print(adjMat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private int getDeg(int v) {
        int deg = 0;
        for (int i = v; i<v+1; i++) {
            for (int j = 0; j<nVerts; j++) {
                if(adjMat[i][j]!=0) {
                    deg++;
                }
            }
        }
        return deg;
    }

    public boolean checkForEulerPath() {
        int oddVertex = 0;
        for (int i = 0; i < nVerts; i++) {
            if (getDeg(i) % 2 == 1) {
                oddVertex++;
            }
        }
        if (oddVertex > 2 || nVerts != dfs().size()) {
            return false;
        }
        return true;
    }

//    public void findEulerPath()

    public List<Integer> dfs() { // Обход в глубину
        vertexList[0].wasVisited = true;
        List<Integer> visitedVertexList = new ArrayList<>();
        visitedVertexList.add(0);
//        displayVertex(0);
        theStack.push(0);


        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if(v == -1) { // Если такой вершины нет,
                theStack.pop(); // элемент извлекается из стека
            }
            else { // Если вершина найдена
                vertexList[v].wasVisited = true; // Пометка
//                displayVertex(v); // Вывод
                visitedVertexList.add(v);
                theStack.push(v); // Занесение в стек
            }
        }
        // Стек пуст, работа закончена
        for(int j=0; j<nVerts; j++) { // Сброс флагов
            vertexList[j].wasVisited = false;
        }
        return visitedVertexList;
    }

    // Метод возвращает непосещенную вершину, смежную по отношению к v
    public int getAdjUnvisitedVertex(int v) {
        for(int j=0; j<nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) {
                return j; // Возвращает первую найденную вершину
            }
        }
        return -1; // Таких вершин нет
    }
}
