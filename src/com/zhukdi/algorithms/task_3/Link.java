package com.zhukdi.algorithms.task_3;

public class Link {
    private int iData; // ������
    public Link next; // ��������� ������� ������

    public Link(int it) {
        iData= it;
    }

    public void displayLink() {
        System.out.print( "->" + iData);
    }

    public int getKey() {
        return iData;
    }
}
