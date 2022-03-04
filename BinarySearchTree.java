public class BinarySearchTree {

    // BST root
    Node root;
    

    // Constructor
    BinarySearchTree() {
        root = null;
    }


    // insertNode() wrapper method
    void insert(int key) {
        root = insertNode(root, key);
    }

    Node insertNode(Node root, int key) {
        // Return new node if tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Else recur down the tree
        if (key < root.key) {
            root.left = insertNode(root.left, key);
        } else if (key > root.key) {
            root.right = insertNode(root.right, key);
        }

        return root;

    } // end insertNode


    // Inorder BST traversal
    void printInOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }


    // Delete key from BST
    void deleteKey(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        // If empty BST
        if (root == null) return root;

        // Recur down the tree
        if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else {
            // Found our Node to delete

            // Node with one or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children, get smallest in right subtree
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.key);
        }

        return root;
    }

    
    private int minValue(Node root) {
        if (root.left == null) {
            return root.key;
        } else {
            return minValue(root.left);
        }
    }

} // end class
