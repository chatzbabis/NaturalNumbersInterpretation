package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import models.*;

import static utils.PrintTree.printInterpretations;

public class Interpretations {

    /*check the value of the first number of phoneNumber and then calculate each case and then
     call allInteprentation for the calculation and after that print the tree.
     if InternationalCalls is true then call printTree to print the phoneNumber with "0030" in the beginning */
    public static void firstDigitCases(List<Integer> phone,boolean isInternationalCalls){
            Node root = new Node(phone.get(0));
        if (phone.get(0)==2 || (phone.get(0)>=20 && phone.get(0)<=29)) {
            root.addSingleChild(new Node(phone.get(1)));
            allInterpretations(phone,root,2);
            //printTree(root,false,isInternationalCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalCalls);
        }else if(phone.get(0)>=200 && phone.get(0)<=299){
            allInterpretations(phone,root,1);
           // printTree(root,false,isInternationalCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalCalls);
        }
        if ((phone.get(0)==69 || phone.get(0)==6) && phone.get(1)!=9){
            allInterpretations(phone,root,1);
            //printTree(root,false,isInternationalCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalCalls);
        }else if(phone.get(0)==6 && phone.get(1)==9){
            root.addSingleChild(new Node(phone.get(1)));
            allInterpretations(phone,root,2);
            //printTree(root,false,isInternationalCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalCalls);
        }else if(phone.get(0)>=690 && phone.get(0)<=699){

            allInterpretations(phone,root,0);
           // printTree(root,true,isInternationalCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalCalls);
        }



    }


    //add children to the leaf of the tree
    //run the phone list from indexValue depending on each case of first digits
    public static void allInterpretations(List<Integer> phone, Node root, int IndexValue){
        for (int i = IndexValue; i < phone.size(); i++) {

            Set<Node> allLeafNodes=root.getAllLeafNodes();
            for (Node leafNode:allLeafNodes) {
                if (i==phone.size()-1){
                    if(!leafNode.isAddToLeafNodeList()){continue;}
                    leafNode.addChild(new Node(phone.get(i)),0);

                }
                else {
                    //if leafNode.isAddToLeafNodeList()==false then does not add the next node as a child to this.node
                    //because the value of node was multiple of 10 or 100 and the value of next node added to this.Node value
                    //make it true to add following node as a child
                    if (!leafNode.isAddToLeafNodeList()) {
                        leafNode.setAddToLeafNodeList(true);
                        continue;
                    }
                    leafNode.addChild(new Node(phone.get(i)), phone.get(i + 1));


                }


            }


        }


    }

//    public static void printTree(Node root, Boolean printWithoutRoot, boolean forEkswteriko){
//        ArrayList<Integer> paths= new ArrayList<Integer>();
//        Node.printAllRootToLeafPaths(root,paths,printWithoutRoot,forEkswteriko);
//        System.out.println(paths);
//    }
}
