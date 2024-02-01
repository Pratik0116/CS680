package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement e1, FSElement e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
