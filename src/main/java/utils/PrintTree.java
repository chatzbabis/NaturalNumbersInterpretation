package utils;

import models.Node;

import java.util.List;

import static utils.Interpretations.findPathsInTheTree;

public class PrintTree {

    //print all interpretations
    //if isInternationalCall is true put "0030" at the beginning of each path
    public static void printInterpretations(Node root,boolean isInternationalCall){
        List<String> pathsOfTree=findPathsInTheTree(root);
        int n=1;
        for (String path:pathsOfTree) {
            System.out.print("Interpretation "+n+": ");
            if (isInternationalCall) {
                System.out.print("0030"+path);
            }else {
                System.out.print(path);
            }
            if (path.length()==10) {
                System.out.println(" Valid");
            }else {
                System.out.println(" Invalid");
            }
            n++;
        }
    }
}
