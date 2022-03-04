public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(43);
        bst.insert(26);
        bst.insert(22);
        bst.insert(31);
        bst.insert(68);
        bst.insert(67);
        bst.insert(95);


        bst.printInOrder();

        bst.deleteKey(95);
        
        System.out.println();

        bst.printInOrder();

    } // end main
} // end class
