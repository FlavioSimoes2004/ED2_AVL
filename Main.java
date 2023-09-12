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

        tree.inserir(70);
        tree.inserir(43);
        tree.inserir(95);
        tree.inserir(20);
        tree.inserir(61);
        tree.inserir(92);
        tree.inserir(98);
        tree.inserir(11);
        tree.inserir(32);
        tree.inserir(50);
        tree.inserir(91);
        tree.inserir(93);
        tree.inserir(97);
        tree.inserir(99);
        tree.inserir(80);


        tree.remove(70);



        tree.passeioEmOrdem();
        System.out.println("");
        tree.passeioPorNivel();
    }
}