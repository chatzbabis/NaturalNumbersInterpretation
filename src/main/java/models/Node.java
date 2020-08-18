package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author w w w. j a v a g i s t s . c o m
 *
 */
public class Node {

    private Integer data = null;

    private List<Node> children = new ArrayList<>();

    private Node parent = null;

    public Node(Integer data) {
        this.data = data;
    }

    private boolean addToLeafNode=true;

    public Node addSingleChild(Node child){
        child.setParent(this);
        this.children.add(child);
        return child;
    }

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
                    child2.setAddToLeafNode(false);

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
                    child2.setAddToLeafNode(false);

                }
            }



        }
        return child;
    }

    public void addChildren(List<Node> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public List<Node> getChildren() {
        return children;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isAddToLeafNode() {
        return addToLeafNode;
    }

    public void setAddToLeafNode(boolean addToLeafNode) {
        this.addToLeafNode = addToLeafNode;
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



    public static void printAllRootToLeafPaths(Node node, List<Integer> path, Boolean withoutRoot, Boolean forInternational)
    {
        if(node==null)
        {
            return;
        }
        path.add(node.getData());



        if(node.getChildren().isEmpty())
        {
            if (forInternational) {
                System.out.print("0030");
            }
            if (withoutRoot){
                for(int i=1; i<=path.size()-1; i++){
                    System.out.print(path.get(i));
                }
                System.out.println();
            }else {
                for (Integer digit : path
                ) {
                    System.out.print(digit);
                }
                System.out.println();
            }

            return;
        }
        else
        {
            for (Node parent:node.getChildren()
                 ) {

                printAllRootToLeafPaths(parent,new ArrayList(path),withoutRoot,forInternational);
            }


        }
    }

}