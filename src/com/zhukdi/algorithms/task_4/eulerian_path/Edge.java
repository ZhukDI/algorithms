package com.zhukdi.algorithms.task_4.eulerian_path;

public class Edge {
    public Vertex start;
    public Vertex end;
    public int weight;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    public Edge(Vertex start, Vertex end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (start == null || end == null) return false;
        if (start.equals(edge.start) && end.equals(edge.end)) return true;
        if (start.equals(edge.end) && end.equals(edge.start)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}
