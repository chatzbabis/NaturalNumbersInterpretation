package models;

import java.util.*;

/**
 *
 * @author w w w. j a v a g i s t s . c o m
 *
 */
public class Node {

    private Integer data;

    private List<Node> children = new ArrayList<>();

    private Node parent = null;

    public Node(Integer data) {
        this.data = data;
    }

    //if addToLeafNodeList is false then this Node will not have children
    private boolean addToLeafNodeList=true;

    //add a child without the process of interpretation
    public Node addSingleChild(Node child){
        child.setParent(this);
        this.children.add(child);
        return child;
    }
    /*
     *add a children to the tree
     *if the value of child is multiple of 10 or 100,
     *added two children, a node with the same value and
     *a node with the same value plus the value of next Node
     */
    public Node addChild(Node child, Integer nextNumber) {
        if (child.data<=9){
        child.setParent(this);
        this.children.add(child);
        }else if (child.data>=10 && child.data<100){

            Node child1=child;

            if (child.getData()%10!=0){
            Node child2=new Node(child.data-(child.data%10));

            child1.setParent(this);
            this.children.add(child1);

            child2.setParent(this);
            this.children.add(child2);

            child2.addChild(new Node(child.data%10),0);
            }else{

                if (nextNumber<10 ){

                    child1.setParent(this);
                    this.children.add(child1);

                    Node child2=new Node(child.data+nextNumber);

                    child2.setParent(this);
                    this.children.add(child2);
                    child2.setAddToLeafNodeList(false);

                }else{
                    child1.setParent(this);
                    this.children.add(child1);
                }
            }
        }else if (child.data>=100){

            Node child1=child;

            if (child.getData()%100!=0) {
                child1.setParent(this);
                this.children.add(child1);

                Node child2 = (new Node(child.data - (child.data % 100)));
                child2.setParent(this);
                this.children.add(child2);
                child2.addChild(new Node(child.data % 100), 0);

                Node child3 = (new Node(child.data - (child.data % 10)));
                child3.setParent(this);
                this.children.add(child3);
                child3.addChild(new Node(child.data % 10), 0);
            }else{
                if (nextNumber<10 && nextNumber!=0){

                    child1.setParent(this);
                    this.children.add(child1);

                    Node child2=new Node(child.data+nextNumber);
                    child2.setParent(this);
                    this.children.add(child2);
                    child2.setAddToLeafNodeList(false);

                }else{
                    child1.setParent(this);
                    this.children.add(child1);
                }
            }
        }
        return child;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Integer getData() {
        return data;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isAddToLeafNodeList() {
        return addToLeafNodeList;
    }

    public void setAddToLeafNodeList(boolean addToLeafNode) {
        this.addToLeafNodeList = addToLeafNode;
    }

    public Set<Node> getAllLeafNodes() {
        Set<Node> leafNodes = new HashSet<Node>();
        if (this.children.isEmpty()) {
            leafNodes.add(this);
        } else {
            for (Node child : this.children) {
                leafNodes.addAll(child.getAllLeafNodes());
            }
        }
        return leafNodes;
    }



//    public static void printAllRootToLeafPaths(Node node, ArrayList<Integer> path, Boolean withoutRoot, Boolean forInternational)
//    {
//
//
//        if(node==null)
//        {
//
//            return;
//        }
//        path.add(node.getData());
//
//
//
//        if(node.getChildren().isEmpty())
//
//        {
//            System.out.print("Interpretationn :");
//
//            if (forInternational) {
//
//                System.out.print("0030");
//            }
//
//            if (withoutRoot){
//                for(int i=1; i<=path.size()-1; i++){
//                    System.out.print(path.get(i));
//
//                }
//
//
//            }else {
//                for (Integer digit : path
//                ) {
//                    System.out.print(digit);
//                }
//
//
//            }
//            int lengthOfInterpetation=0;
//            for (Integer digit:path
//                 ) {
//                lengthOfInterpetation += String.valueOf(digit).length();
//
//            }
//            if (lengthOfInterpetation==10){
//            System.out.print(" Valid");
//        }else{
//                System.out.print(" Invalid");
//            }
//            System.out.println();
//
//
//        }
//        else
//        {
//
//            for (Node child:node.getChildren()
//                 ) {
//
//                printAllRootToLeafPaths(child,new ArrayList(path),withoutRoot,forInternational);
//            }
//
//
//        }
//
//
//
//
//    }


}