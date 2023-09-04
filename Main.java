public class Main {
    public static void main(String args[]){
        AVLTree<Integer> tree = new AVLTree<>();
        /*tree.inserir(25);
        tree.inserir(10);
        tree.inserir(30);
        tree.inserir(5);
        tree.inserir(20);
        tree.inserir(28);
        tree.inserir(27);
        tree.inserir(6);
        tree.inserir(4);

        tree.remove(10);
        tree.inserir(5);*/

        tree.inserir(50);
        tree.inserir(25);
        tree.inserir(75);
        tree.inserir(10);
        tree.inserir(30);
        tree.inserir(60);
        tree.inserir(76);
        tree.inserir(12);


        tree.remove(50);
        tree.remove(30);

        tree.passeioEmOrdem();
        System.out.println("");
        tree.passeioPorNivel();
    }
}