package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import models.*;

import static utils.PrintTree.printInterpretations;

public class Interpretations {

    /*check the value of the first number of phoneNumber and then calculate each case and then
     call allInterpretation for the calculation and after that print the tree.
     if InternationalCalls is true then call printTree to print the phoneNumber with "0030" in the beginning */
    public static void beginInterpretation(List<Integer> phoneNumbersInList, boolean isInternationalCall){
        Node root = new Node(phoneNumbersInList.get(0));
        // begin check from first digit
        if (phoneNumbersInList.get(0)==2 || (phoneNumbersInList.get(0)>=20 && phoneNumbersInList.get(0)<=29)) {
            root.addSingleChild(new Node(phoneNumbersInList.get(1)));
            addChildrenToLeafNodes(phoneNumbersInList,root,2);

            printInterpretations(root,isInternationalCall);
        }else if(phoneNumbersInList.get(0)>=200 && phoneNumbersInList.get(0)<=299){
            addChildrenToLeafNodes(phoneNumbersInList,root,1);

            printInterpretations(root,isInternationalCall);
        }
        if ((phoneNumbersInList.get(0)==69 || phoneNumbersInList.get(0)==6) && phoneNumbersInList.get(1)!=9){
            addChildrenToLeafNodes(phoneNumbersInList,root,1);

            printInterpretations(root,isInternationalCall);
        }
        else if(phoneNumbersInList.get(0)==6 && phoneNumbersInList.get(1)==9){
            root.addSingleChild(new Node(phoneNumbersInList.get(1)));
            addChildrenToLeafNodes(phoneNumbersInList,root,2);

            printInterpretations(root,isInternationalCall);
        }
        else if(phoneNumbersInList.get(0)>=690 && phoneNumbersInList.get(0)<=699){

            addChildrenToLeafNodes(phoneNumbersInList,root,0);

            printInterpretations(root,isInternationalCall);
        }
    }


    //add children to the leaf of the tree
    //parse the phone list from beginIndex depending on each case of first digits
    public static void addChildrenToLeafNodes(List<Integer> phoneNumbersInList, Node root, int beginIndex){
        for (int i = beginIndex; i < phoneNumbersInList.size(); i++) {

            Set<Node> allLeafNodes=root.getAllLeafNodes();
            for (Node leafNode:allLeafNodes) {
                if (i==phoneNumbersInList.size()-1){
                    if(!leafNode.isCanBeAddedToLeafNodeList()){continue;}
                    leafNode.addChild(new Node(phoneNumbersInList.get(i)),0);
                }
                else {
                    //if leafNode.isAddToLeafNodeList()==false then does not add the next node as a child to this.node
                    //because the value of node was multiple of 10 or 100 and the value of next node added to this.Node value
                    //make it true to add following node as a child
                    if (!leafNode.isCanBeAddedToLeafNodeList()) {
                        leafNode.setCanBeAddedToLeafNodeList(true);
                        continue;
                    }
                    leafNode.addChild(new Node(phoneNumbersInList.get(i)), phoneNumbersInList.get(i + 1));
                }
            }
        }
    }

    //find all the paths of tree and put them to a List
    public static List<String> findPathsInTheTree(Node root) {
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
}
