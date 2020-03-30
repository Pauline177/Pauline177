/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elmsort;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.introcs.StdIn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author dhunter3
 */
public class ElmSort {
    public static final Comparator BY_WEIGHT = new WeightComparator();
    public static final Comparator BY_NAME = new NameComparator();

    public ArrayList getElements() {
        ArrayList<ElementNode> el = FileReader.readCSV("Elements.csv");
        ElementNode[] theEls = (ElementNode[]) el.toArray();
        Insertion.sort(theEls);
        el = new ArrayList(Arrays.asList(theEls));
        return el;
    }

    public ArrayList getNameSorted() {
        ArrayList<ElementNode> el = FileReader.readCSV("Elements.csv");
        Object[] theEls = el.toArray();
        //Sort the elements by name
        return el;
    }

    public ArrayList getWeightSorted() {
        ArrayList el = FileReader.readCSV("Elements.csv");
        Object[] theEls = el.toArray();
        //Sort by weight
        return el;
    }

    private static class WeightComparator implements Comparator<ElementNode> {

        @Override
        public int compare(ElementNode o1, ElementNode o2) {
            return -1;//change this to compare them by weight
        }
    }
    private static class NameComparator implements Comparator<ElementNode> {

        @Override
        public int compare(ElementNode o1, ElementNode o2) {
            return -1;//change this to compare the elements by name
        }
    }

}
