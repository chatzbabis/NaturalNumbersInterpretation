package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import models.*;

import static utils.PrintTree.printInterpretations;

public class Interpretations {
    public static void interpretations(List<Integer> phone,boolean isInternationalsCalls){
            Node root = new Node(phone.get(0));
        if (phone.get(0)==2 || (phone.get(0)>=20 && phone.get(0)<=29)) {
            root.addSingleChild(new Node(phone.get(1)));
            allInterpretations(phone,root,2);
            printTree(root,false,isInternationalsCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalsCalls);
        }else if(phone.get(0)>=200 && phone.get(0)<=299){
            allInterpretations(phone,root,1);
            printTree(root,false,isInternationalsCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalsCalls);
        }
        if ((phone.get(0)==69 || phone.get(0)==6) && phone.get(1)!=9){
            allInterpretations(phone,root,1);
            printTree(root,false,isInternationalsCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalsCalls);
        }else if(phone.get(0)==6 && phone.get(1)==9){
            root.addSingleChild(new Node(phone.get(1)));
            allInterpretations(phone,root,2);
            //printTree(root,false,isInternationalsCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalsCalls);
        }else if(phone.get(0)>=690 && phone.get(0)<=699){

            allInterpretations(phone,root,0);
           // printTree(root,true,isInternationalsCalls);
            System.out.println("------------------------");
            printInterpretations(root,isInternationalsCalls);
        }



    }



    public static void allInterpretations(List<Integer> phone, Node root, int Indexprice){
        for (int i = Indexprice; i < phone.size(); i++) {

            Set<Node> allLeafNodes=root.getAllLeafNodes();
            for (Node leafNode:allLeafNodes) {
                if (i==phone.size()-1){
                    if(!leafNode.isAddToLeafNode()){continue;}
                    leafNode.addChild(new Node(phone.get(i)),0);

                }
                else {
                    if (!leafNode.isAddToLeafNode()) {
                        leafNode.setAddToLeafNode(true);
                        continue;
                    }
                    leafNode.addChild(new Node(phone.get(i)), phone.get(i + 1));


                }


            }


        }


    }

    public static void printTree(Node root, Boolean printWithoutRoot, boolean forEkswteriko){
        ArrayList<Integer> paths= new ArrayList<Integer>();
        Node.printAllRootToLeafPaths(root,paths,printWithoutRoot,forEkswteriko);
        System.out.println(paths);
    }
}
