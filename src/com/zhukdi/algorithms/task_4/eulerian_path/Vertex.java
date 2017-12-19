package com.zhukdi.algorithms.task_4.eulerian_path;

public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                ", wasVisited=" + wasVisited +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (label != vertex.label) return false;
        return wasVisited == vertex.wasVisited;
    }

    @Override
    public int hashCode() {
        int result = (int) label;
        result = 31 * result + (wasVisited ? 1 : 0);
        return result;
    }
}
