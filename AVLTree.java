import java.util.LinkedList;

public class AVLTree <t extends Comparable<t>>{

    private Node<t> root;
    private boolean status;

    public AVLTree(){
        root = null;
        status = false;
    }

    public void inserir(t info){
        if(root == null)
        {
            root = new Node<t>(info);
            status = true;
        }
        else
        {
            root = inserirNode(root, info);
        }
    }

    private Node<t> inserirNode(Node<t> r, t info){
        if(r == null)
        {
            r = new Node<t>(info);
            status = true;
        }
        else if(info.compareTo(r.getInfo()) < 0) //ESQUERDA
        {
            r.setLeft(inserirNode(r.getLeft(), info));
            if(status)
            {
                switch(r.getFatBal())
                {
                    case 0:
                        r.setFatBal(-1);
                    break;
    
                    case 1:
                        r.setFatBal(0);
                        status = false;
                    break;
    
                    case -1:
                        if(r.getLeft().getFatBal() == -1)
                        {
                            r = rotateSimpleRight(r);
                        }
                        else
                        {
                            r = rotateDoubleRight(r);
                        }
                        status = false;
                    break;
                }
            }
        }
        else //DIREITA
        {
            r.setRight(inserirNode(r.getRight(), info));
            if(status)
            {
                switch(r.getFatBal())
                {
                    case 0:
                        r.setFatBal(1);
                    break;
    
                    case -1:
                        r.setFatBal(0);
                        status = false;
                    break;
    
                    case 1:
                        if(r.getRight().getFatBal() == 1)
                        {
                            r = rotateSimpleLeft(r);
                        }
                        else
                        {
                            r = rotateDoubleLeft(r);
                        }
                        status = false;
                    break;
                }
            }
        }

        return r;
    }

    private Node<t> rotateSimpleLeft(Node<t> a){
        Node<t> b = a.getRight();
        b.setLeft(a);
        a = b;

        a.setFatBal(0);
        return a;
    }

    private Node<t> rotateSimpleRight(Node<t> a){
        Node<t> b = a.getLeft();
        b.setRight(a);
        a = b;

        a.setFatBal(0);
        return a;
    }

    private Node<t> rotateDoubleLeft(Node<t> a){
        Node<t> b, c;
        b = a.getRight();
        c = b.getLeft();

        a.setRight(null);
        b.setLeft(null);
        c.setLeft(a);
        c.setRight(b);

        c = a;

        a.setFatBal(0);
        return a;
    }

    private Node<t> rotateDoubleRight(Node<t> a){
        Node<t> b, c;
        b = a.getLeft();
        c = b.getRight();

        a.setLeft(null);
        b.setRight(null);
        c.setLeft(c);
        c.setRight(a);

        c = a;

        a.setFatBal(0);
        return a;
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