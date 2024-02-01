package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class ElementKindComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement e1, FSElement e2) {
        if (e1.isDirectory() && !e2.isDirectory()) {
            return -1;
        } else if (!e1.isDirectory() && e2.isDirectory()) {
            return 1;
        } else if (e1 instanceof File && e2 instanceof Link) {
            return 1;
        } else if (e1 instanceof Link && e2 instanceof File) {
            return -1;
        } else {
            return 0;
        }
    }
}
