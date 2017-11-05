package com.zhukdi.algorithms.task_3;

public class HashTable {
    private SortedList[] hashArray; // ������ �������
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize]; // �������� �������
        for (int j=0; j<arraySize; j++) { // ���������� �������
            hashArray[j] = new SortedList(); // ��������
        }
    }

    public void displayTable() {
        for (int j=0; j<arraySize; j++) { // ��� ������ ������
            System.out.print(j + ": "); // ����� ������ ������
            hashArray[j].displayList(); // ����� ������
        }
    }

    public int hashFunc(int key) { // ���-�������
        return key % 117;
    }

    public void insert(Link link) { // ������� ��������
        int key = link.getKey();
        int hashVal = hashFunc(key); // ����������� �����
        hashArray[hashVal].insert(link); // ������� � ������� hashVal
    }

    public void delete(int key) { // �������� ��������
        int hashVal = hashFunc(key); // ����������� �����
        hashArray[hashVal].delete(key); // ��������
    }

    public Link find(int key) { // ����� ��������
        int hashVal = hashFunc(key); // ����������� �����
        Link link = hashArray[hashVal].find(key); // �����
        return link; // ����� ���������� ��������� �������
    }
}
