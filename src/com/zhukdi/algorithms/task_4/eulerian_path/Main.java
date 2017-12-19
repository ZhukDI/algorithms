package com.zhukdi.algorithms.task_4.eulerian_path;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);

        graph.addEdge(A, B, 1);
        graph.addEdge(B, C, 2);
        graph.addEdge(C, D, 4);
        graph.addEdge(D, E, 6);
        graph.addEdge(A, E, 5);
        graph.addEdge(A, D, 3);
        graph.addEdge(B, E, 4);
        graph.addEdge(B, D, 8);

        graph.displayAdjMat();

        if (graph.checkForEulerPath()) {
            graph.findEulerPath(A);
        } else {
            System.out.println("There is no Eulerian cycle.");
        }

    }
}
