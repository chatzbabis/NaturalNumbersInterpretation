package utils;

import models.Node;

import java.util.ArrayList;
import java.util.List;

public class PrintTree {

    //find all the paths of tree and put them to a List
    private static List<String> findPathsInTheTree(Node root) {
        List<String> interpretations=new ArrayList<>();
        List<Node> finalLeaves=new ArrayList<>();
        finalLeaves.addAll(root.getAllLeafNodes());
        String finalNumber;
        for(Node leaf : finalLeaves) {
            finalNumber=String.valueOf(leaf.getData());
            Node parent = leaf.getParent();
            while(parent != null) {
                finalNumber = String.valueOf(parent.getData()).concat(finalNumber);
                parent = parent.getParent();
            }
            interpretations.add((finalNumber));
        }
        return interpretations;
    }

    //print all intepretations
    //if isInternationalCall is true put "0030" at the beginning of each path
    public static void printInterpretations(Node root,boolean isInternationalCall){
        List<String> pathsOfTree=findPathsInTheTree(root);
        int n=1;
        for (String path:pathsOfTree
             ) {
            System.out.print("Interpretation "+n+": ");
            if (isInternationalCall){
                System.out.print("0030"+path);
            }
            if (path.length()==10){
                System.out.println(" Valid");
            }else{
                System.out.println(" Invalid");
            }
            n++;
        }
    }
}
