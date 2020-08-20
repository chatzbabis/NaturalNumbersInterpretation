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
    private boolean canBeAddedToLeafNodeList =true;

    //add a child without the process of interpretation
    public void addSingleChild(Node child){
        child.setParent(this);
        this.children.add(child);
    }
    /*
     *add a children to the tree
     *if the value of child is multiple of 10 or 100,
     *added two children, a node with the same value and
     *a node with the same value plus the value of next Node
     */
    public void addChild(Node child, int nextNumber) {
        if (child.getData()<=9){
            child.setParent(this);
            this.children.add(child);
        }else if (child.getData()<100) {

            if (child.getData()%10!=0) {
                Node child2=new Node(child.getData()-(child.getData()%10));

                child.setParent(this);
                this.children.add(child);

                child2.setParent(this);
                this.children.add(child2);

                child2.addChild(new Node(child.getData()%10),0);
            }else {

                if (nextNumber<10 ){

                    child.setParent(this);
                    this.children.add(child);

                    Node child2=new Node(child.getData()+nextNumber);

                    child2.setParent(this);
                    this.children.add(child2);
                    child2.setCanBeAddedToLeafNodeList(false);

                }else {
                    child.setParent(this);
                    this.children.add(child);
                }
            }
        }else {

            if (child.getData()%100 != 0) {
                child.setParent(this);
                this.children.add(child);

                Node child2 = (new Node(child.getData() - (child.getData() % 100)));
                child2.setParent(this);
                this.children.add(child2);
                child2.addChild(new Node(child.getData() % 100), 0);

                Node child3 = (new Node(child.getData() - (child.getData() % 10)));
                child3.setParent(this);
                this.children.add(child3);
                child3.addChild(new Node(child.getData() % 10), 0);
            }else {
                if (nextNumber<10 && nextNumber!=0) {

                    child.setParent(this);
                    this.children.add(child);

                    Node child2=new Node(child.getData()+nextNumber);
                    child2.setParent(this);
                    this.children.add(child2);
                    child2.setCanBeAddedToLeafNodeList(false);

                }else {
                    child.setParent(this);
                    this.children.add(child);
                }
            }
        }
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

    public boolean isCanBeAddedToLeafNodeList() {
        return canBeAddedToLeafNodeList;
    }

    public void setCanBeAddedToLeafNodeList(boolean addToLeafNode) {
        this.canBeAddedToLeafNodeList = addToLeafNode;
    }

    public Set<Node> getAllLeafNodes() {
        Set<Node> leafNodes = new HashSet<>();
        if (this.children.isEmpty()) {
            leafNodes.add(this);
        } else {
            for (Node child : this.children) {
                leafNodes.addAll(child.getAllLeafNodes());
            }
        }
        return leafNodes;
    }
}