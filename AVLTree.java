import java.util.LinkedList;
import java.util.Queue;

public class AVLTree <t extends Comparable<t>>{

    private Node<t> root;

    public AVLTree(){
        root = null;
    }

    public void inserir(t info){
        if(root == null)
        {
            root = new Node<t>(info);
        }
        else
        {
            root = insertNode(root, info);
        }
    }

    private Node<t> insertNode(Node<t> r, t info){
        if(r == null)
        {
            r = new Node<t>(info);
        }
        else if(info.compareTo(r.getInfo()) < 0)
        {
            r.setLeft(insertNode(r.getLeft(), info));
        }
        else
        {
            r.setRight(insertNode(r.getRight(), info));
        }

        checkBal(r);

        if(r.getFatBal() > 1)
        {
            if(r.getRight().getLeft() == null)
            {
                return rodarSimplesEsq(r, r.getRight());
            }
            else
            {
                return rodarDuplaEsq(r, r.getRight().getLeft());
            }
        }
        if(r.getFatBal() < -1)
        {
            if(r.getLeft().getRight() == null)
            {
                return rodarSimplesDir(r, r.getLeft());
            }
            else
            {
                return rodarDuplaDir(r, r.getLeft().getRight());
            }
        }

        return r;
    }

    private int Bal(Node<t> r, int num){
        if(r == null)
        {
            return num;
        }

        int left = Bal(r.getLeft(), num + 1);
        int right = Bal(r.getRight(), num + 1);

        return right - left;
    }

    private void checkBal(Node<t> r){
        if(r.getLeft() == null && r.getRight() == null)
        {
            r.setFatBal(0);
        }
        else if(r.getLeft() != null && r.getRight() != null)
        {
            r.setFatBal(Bal(r, 0));
        }
        else
        {
            if(r.getLeft() == null)
            {
                r.setFatBal(Bal(r, 0));
            }
            else
            {
                r.setFatBal(Bal(r, 0));
            }
        }
    }

    private Node<t> rodarSimplesEsq(Node<t> r, Node<t> right){
        right.setLeft(r);
        right.getLeft().setRight(null);

        checkBal(right.getLeft());
        checkBal(right.getRight());
        checkBal(right);

        return right;        
    }

    private Node<t> rodarSimplesDir(Node<t> r, Node<t> left){
        left.setRight(r);
        left.getRight().setLeft(null);

        checkBal(left.getRight());
        checkBal(left.getLeft());
        checkBal(left);

        return left;
    }

    private Node<t> rodarDuplaEsq(Node<t> x, Node<t> left){
        left.setRight(x.getRight());
        left.getRight().setLeft(null);
        left.setLeft(x);
        left.getLeft().setRight(null);

        checkBal(left.getRight());
        checkBal(left.getLeft());
        checkBal(left);

        return left;
    }

    private Node<t> rodarDuplaDir(Node<t> x, Node<t> right){
        right.setLeft(x.getLeft());
        right.getLeft().setRight(null);
        right.setRight(x);
        right.getRight().setLeft(null);

        checkBal(right.getLeft());
        checkBal(right.getRight());
        checkBal(right);

        return right;
    }

    public void passeioEmOrdem(){
        passeioEmOrdem(root);
    }

    private void passeioEmOrdem(Node<t> r){
        if(r.getLeft() != null)
        {
            passeioEmOrdem(r.getLeft());
        }

        System.out.print(r.getInfo() + ", ");

        if(r.getRight() != null)
        {
            passeioEmOrdem(r.getRight());
        }
    }

    public void passeioPorNivel(){
        if(root != null)
        {
            LinkedList<Node<t>> fila = new LinkedList<>();
            fila.push(root);
            Node<t> current = null;
            while(fila.size() > 0)
            {
                current = fila.removeLast();
                System.out.print(current.getInfo() + ", ");
                if(current.getLeft() != null)
                {
                    fila.push(current.getLeft());
                }
                if(current.getRight() != null)
                {
                    fila.push(current.getRight());
                }
            }
        }
    }
}