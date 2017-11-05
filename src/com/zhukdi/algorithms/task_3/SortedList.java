package com.zhukdi.algorithms.task_3;

public class SortedList {
    private Link first; // ������ �� ������ ������� ������

    public void SortedList() {
        first = null;
    }

    public void insert(Link link) { // ������� � ������� ������
        int key = link.getKey();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous==null) // � ������ ������
            first = link; // first --> ����� �������
        else // �� � ������
            previous.next = link; // prev --> ����� �������
        link.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public void displayList() {
//        System.out.print("List (first-->last): ");
        Link current = first; // �� ������ ������
        while (current != null) { // ����������� �� ����� ������
            current.displayLink(); // ����� ������
            current = current.next; // ������� � ���������� ��������
        }
        System.out.println("");
    }

    public Link find(int key) { // ����� �������� � �������� ������
        Link current = first; // ������� �� ������ ������
        // �� ����� ������
        while(current != null && current.getKey() <= key) { // ��� ���� ���� �� �������� current,
            if(current.getKey() == key) // ������� �������?
                return current; // ���������� ����������
            current = current.next; // ������� � ���������� ��������
        }
        return null; // ������� �� ������
    }
}
