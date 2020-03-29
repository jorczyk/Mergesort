package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReader {

    public static Long[] getLongArray(String filePath) {
        ArrayList<Long> input = new ArrayList<>();
        BufferedReader reader;
        ResourcesReader resourcesReader = new ResourcesReader();
        try {
            reader = resourcesReader.readFile(filePath);
            String line = reader.readLine();
            while (line != null) {
                input.add(Long.parseLong(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return input.toArray(new Long[input.size()]);
    }

    public static <T extends Comparable<? super T>>
    boolean isSorted(Iterable<T> iterable) {
        Iterator<T> iter = iterable.iterator();
        if (!iter.hasNext()) {
            return true;
        }
        T t = iter.next();
        while (iter.hasNext()) {
            T t2 = iter.next();
            if (t.compareTo(t2) > 0) {
                return false;
            }
            t = t2;
        }
        return true;
    }

    public static boolean isSorted2(List<Long> myList) {
        List tmp = new ArrayList(myList);
        Collections.sort(tmp);
        return tmp.equals(myList);
    }

    public static void printAlongSorted(List<Long> myList) {
        List tmp = new ArrayList(myList);
        Collections.sort(tmp);

        for(int i=0; i<myList.size(); i++) {
            System.out.print("Sorted: " + tmp.get(i) + " ,Mine: " + myList.get(i) + " ,Diff: " + (tmp.get(i).equals(myList.get(i))) + ";");
        }
    }
}
