public class Main {
    public static void main(String args[]){
        AVLTree<Integer> tree = new AVLTree<>();
        tree.inserir(25);
        tree.inserir(10);
        tree.inserir(30);
        tree.inserir(5);
        tree.inserir(20);
        tree.inserir(28);
        tree.inserir(27); //simplesDir
        /*tree.inserir(25);
        tree.inserir(10);
        tree.inserir(30);
        tree.inserir(20);
        tree.inserir(28);
        tree.inserir(22);*/ //simplesEsq
        /*tree.inserir(25);
        tree.inserir(10);
        tree.inserir(30);
        tree.inserir(5);
        tree.inserir(20);
        tree.inserir(27);
        tree.inserir(28);*/ //rodarDuplaDir
        /*tree.inserir(10);
        tree.inserir(5);
        tree.inserir(20);
        tree.inserir(30);
        tree.inserir(25);*/ //rodarDuplaEsq

        /*tree.inserir(2);
        tree.inserir(1);
        tree.inserir(4);
        tree.inserir(5);
        tree.inserir(9);
        tree.inserir(3);*/

        tree.passeioEmOrdem();
        System.out.println("");
        tree.passeioPorNivel();
    }
}