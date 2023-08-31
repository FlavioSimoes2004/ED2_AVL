public class Node <t>{
    
    private t info;
    private int fatBal;
    private Node<t> left, right;

    Node(t info){
        this.info = info;
        this.fatBal = 0;
        this.left = null;
        this.right = null;
    }

    Node(t info, Node<t> left, Node<t> right){
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    t getInfo(){
        return info;
    }

    int getFatBal(){
        return fatBal;
    }

    Node<t> getLeft(){
        return left;
    }

    Node<t> getRight(){
        return right;
    }

    void setInfo(t info){
        this.info = info;
    }

    void setFatBal(int fatBal){
        this.fatBal = fatBal;
    }

    void setLeft(Node<t> left){
        this.left = left;
    }

    void setRight(Node<t> right){
        this.right = right;
    }
}