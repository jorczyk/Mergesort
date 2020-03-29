package algorithm;

import java.util.ArrayList;

public class SortedArray {

    ArrayList<Long> sortedList;
    Long inversionsNumber;

    public SortedArray() {
    }

    public SortedArray(ArrayList<Long> sortedList, Long inversionsNumber) {
        this.sortedList = sortedList;
        this.inversionsNumber = inversionsNumber;
    }

    public ArrayList<Long> getSortedList() {
        return sortedList;
    }

    public void setSortedList(ArrayList<Long> sortedList) {
        this.sortedList = sortedList;
    }

    public Long getInversionsNumber() {
        return inversionsNumber;
    }

    public void setInversionsNumber(Long inversionsNumber) {
        this.inversionsNumber = inversionsNumber;
    }
}
