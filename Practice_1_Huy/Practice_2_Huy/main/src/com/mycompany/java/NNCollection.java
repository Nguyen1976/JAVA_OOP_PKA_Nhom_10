package com.mycompany.java;

public class NNCollection {
    private NameNumber[] nnArray = new NameNumber[100];
    private int free;

    public NNCollection() {
        free = 0;
    }

    public void insert(NameNumber n) {
        int i = free;
        while (i > 0 && nnArray[i - 1].getLastName().compareTo(n.getLastName()) > 0) {
            nnArray[i] = nnArray[i - 1];
            i--;
        }
        nnArray[i] = n;
        free++;
    }

    public String findNumber(String lName) {
        for (int i = 0; i < free; i++) {
            if (nnArray[i] != null && nnArray[i].getLastName().equals(lName)) {
                return nnArray[i].getTelNumber();
            }
        }
        return "Name not found";
    }
}
