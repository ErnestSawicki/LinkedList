package pl.beder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        //My mess

        SimpleLinkedList linkedList  = new SimpleLinkedList();
        linkedList.insertSorted(5);
        linkedList.insertSorted(8);
        linkedList.insertSorted(12);
        linkedList.insertSorted(345);
        linkedList.insertSorted(1);
        linkedList.insertSorted(-65);


        long[] holderView = linkedList.getHolderView();

        for (long h : holderView)
            System.out.print(h + ", ");



    }
}
