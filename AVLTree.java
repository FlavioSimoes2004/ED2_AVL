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
        a.setRight(b.getLeft());
        b.setLeft(a);
        a.setFatBal(0);

        a = b;
        return a;
    }

    private Node<t> rotateSimpleRight(Node<t> a){
        Node<t> b = a.getLeft();
        a.setLeft(b.getRight());
        b.setRight(a);
        a.setFatBal(0);
        
        a = b;
        return a;
    }

    private Node<t> rotateDoubleLeft(Node<t> a){
        Node<t> b, c;
        b = a.getRight();
        c = b.getLeft();

        b.setLeft(c.getRight());
        c.setRight(b);
        a.setRight(c.getLeft());
        c.setLeft(a);
        if(c.getFatBal() == 1)
        {
            a.setFatBal(-1);
        }
        else
        {
            a.setFatBal(0);
        }
        if(c.getFatBal() == -1)
        {
            b.setFatBal(1);
        }
        else
        {
            b.setFatBal(0);
        }
        
        a = c;
        a.setFatBal(0);
        return a;
    }

    private Node<t> rotateDoubleRight(Node<t> a){
        Node<t> b, c;
        b = a.getLeft();
        c = b.getRight();

        b.setRight(c.getLeft());
        c.setLeft(b);
        a.setLeft(c.getRight());
        c.setRight(a);
        if(c.getFatBal() == -1)
        {
            a.setFatBal(1);
        }
        else
        {
            a.setFatBal(0);
        }
        if(c.getFatBal() == 1)
        {
            b.setFatBal(-1);
        }
        else
        {
            b.setFatBal(0);
        }

        a = c;
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

    public void remove(t info){
        if(root == null)
        {
            System.out.println("VAZIO");
        }
        else
        {
            status = true;
            root = removeNode(root, info);
            status = false;
        }
    }

    private Node<t> removeNode(Node<t> r, t info){
        if(r != null)
        {
            int compare = info.compareTo(r.getInfo());
            if(compare == 0)
            {
                r = removeNode(r);
                if(r != null)
                {
                    Node<t> right = r.getRight();
                    Node<t> left = r.getLeft();
                    if(left != null && right != null)
                    {
                        if((left.getFatBal() == 1 || left.getFatBal() == -1) && (right.getFatBal() == 1 || right.getFatBal() == -1))
                        {
                            r.setFatBal(0);
                        }
                        else if(left.getFatBal() == 0)
                        {
                            if(left.getLeft() == null)
                            {
                                r.setFatBal(1);
                            }
                            else
                            {
                                r.setFatBal(0);
                            }
                        }
                        else if(right.getFatBal() == 0)
                        {
                            if(right.getRight() == null)
                            {
                                r.setFatBal(-1);
                            }
                            else
                            {
                                r.setFatBal(0);
                            }
                        }
                    }
                }
            }
            else if(compare < 0)
            {
                r.setLeft(removeNode(r.getLeft(), info));
                if(r.getLeft() == null && r.getRight() == null)
                {
                    r.setFatBal(0);
                }
                else if(r.getLeft() == null)
                {
                    r.setFatBal(r.getFatBal() + 1);

                    switch(r.getRight().getFatBal())
                    {
                        case 1:
                            r = rotateSimpleLeft(r);
                        break;

                        case -1:
                            r = rotateDoubleLeft(r);
                        break;

                        case 0:
                            if(r.getFatBal() == 2)
                            {
                                r = rotateSimpleLeft(r);
                            }
                            status = false;
                        break;
                    }
                }
            }
            else
            {
                r.setRight(removeNode(r.getRight(), info));
                if(r.getRight() == null && r.getLeft() == null)
                {
                    r.setFatBal(0);
                }
                else if(r.getRight() == null)
                {
                    r.setFatBal(r.getFatBal() - 1);
                    switch(r.getLeft().getFatBal())
                    {
                        case -1:
                            r = rotateSimpleRight(r);
                        break;

                        case 1:
                            r = rotateDoubleRight(r);
                        break;

                        case 0:
                            if(r.getFatBal() == -2)
                            {
                                r = rotateSimpleRight(r);
                            }
                            status = false;
                        break;
                    }
                }
            }
        }

        return r;
    }

    private Node<t> removeNode(Node<t> r){
        if(r.getLeft() == null && r.getRight() == null) //SEM FILHOS
        {
            return null;
        }
        else if(r.getLeft() == null)
        {
            return r.getRight();
        }
        else if(r.getRight() == null)
        {
            return r.getLeft();
        }
        else //TEM AMBOS
        {
            Node<t> pai, filho;
            pai = r;
            filho = pai.getLeft();
            while(filho.getRight() != null)
            {
                pai = filho;
                filho = filho.getRight();
            }

            if(r.getLeft().equals(filho))
            {
                pai.setLeft(filho.getLeft());
                pai.setFatBal(0); //SE GETLEFT == NULL
                if(pai.getLeft() != null)
                {
                    pai.setFatBal(-1);
                }
            }
            else
            {
                pai.setRight(filho.getLeft());
                pai.setFatBal(pai.getFatBal() - 1);
            }

            filho.setLeft(r.getLeft());
            filho.setRight(r.getRight());
            filho.setFatBal(r.getFatBal());
            r = filho;
            
            return r;
        }
    }
}