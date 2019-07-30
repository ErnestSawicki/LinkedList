package pl.beder;

import java.util.Arrays;

public class StaticTable implements Table {

    private final long[]table;
    private int counter = 0;

    public StaticTable(){
        table = new long[1000000];
    }


    @Override
    public long size() {
        return counter;
    }

    @Override
    public long get(int index) {
        return table[index];
    }

    @Override
    public int firstIndexWith(long value) {
        for (int i = 0; i < counter; i++){
            if (table[i] == value)
                return i;
        }
        return -1;
    }

    @Override
    public int firstIndexWithGivenOrHigherValue(long value) {
        for (int i = 0; i < counter; i++){
            if (table[i] >= value)
                return i;
        }
        return -1;
    }

    @Override
    public void insertAt(int index, long value) {
        counter++;
        int tempCounter = counter;
            while (tempCounter >= index) {
                table[tempCounter + 1] = table[tempCounter];
                tempCounter--;
            }
        table[index] = value;

    }

    @Override
    public void insertSorted(long value) {
        int index = firstIndexWithGivenOrHigherValue(value);
        if (index == -1){
            insert(value);
        } else {
            insertAt(index,value);
        }
    }

    @Override
    //TODO - This should return copy of the filled part of the array
    public long[] getHolderView() {
        return Arrays.copyOfRange(table, 0, counter);
    }

    @Override
    public void insert(long value) {
        table[counter] = value;
        counter++;
    }

    @Override
    public String toString(){
        String tableString = "[";
        for (int i = 0; i < counter; i++)
            tableString += table[i] + ", ";
        tableString += "]";
        return tableString;
    }
}
