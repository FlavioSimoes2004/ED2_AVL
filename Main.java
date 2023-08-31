public class Main {
    public static void main(String args[]){
        AVLTree<Integer> tree = new AVLTree<>();
        tree.inserir(25);
        tree.inserir(10);
        tree.inserir(30);
        tree.inserir(5);
        tree.inserir(20);
        tree.inserir(28);
        tree.inserir(27);

        tree.passeioEmOrdem();
        System.out.println("");
        tree.passeioPorNivel();
    }
}