public class Main {
    public static void main(String args[]){
        AVLTree<Integer> tree = new AVLTree<>();

        tree.inserir(5);
        tree.inserir(3);
        tree.inserir(8);
        tree.inserir(2);
        tree.inserir(4);
        tree.inserir(7);
        tree.inserir(10);
        tree.inserir(1);
        tree.inserir(6);
        tree.inserir(9);
        tree.inserir(11);

        tree.remove(4); //certo
        tree.remove(8); //certo
        tree.remove(6); //certo

        tree.passeioEmOrdem();
        System.out.println("");
        tree.passeioPorNivel();
    }
}