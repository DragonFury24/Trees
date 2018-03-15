public class Tree {
    private TreeNode myRoot;

    public Tree() {
        myRoot = null;
    }

    //pre: root points to an in-order Binary Search Tree
    //post:adds x to the tree such that the tree is still an in-order Binary Search Tree

    public void add(Comparable x) {
        myRoot = addHelper(myRoot, x);
    }

    private TreeNode addHelper(TreeNode root, Comparable x) {
        //************COMPLETE THIS METHOD*****************************
        if (root == null)
            return root = new TreeNode(x);

        if (root.getValue().compareTo(x) > 0)
            root.setLeft(addHelper(root.getLeft(), x));

        if (root.getValue().compareTo(x) < 0)
            root.setRight(addHelper(root.getRight(), x));

        //************************************************************
        return root;
    }

    //pre: root points to an in-order Binary Search Tree
    //post:removes x from the tree such that the tree is still an in-order Binary Search Tree

    public void remove(Comparable x) {
        myRoot = removeHelper(myRoot, x);
    }

    private TreeNode removeHelper(TreeNode root, Comparable x) {
        //************COMPLETE THIS METHOD****************************
        if (root == null)
            return null;

        if (root.getValue().compareTo(x) > 0) { //x is less than value of root, move to left side of tree
            root.setLeft(removeHelper(root.getLeft(), x));
        }
        else if (root.getValue().compareTo(x) < 0) { //x is greater than value of root, move to right side of tree
            root.setRight(removeHelper(root.getRight(), x));
        }
        else if (root.getValue().compareTo(x) == 0) {
            if (isLeaf(root)) { //root has no children; just set it to null
                root = null;
            } else if (oneKid(root)) {  //root has 1 child; set it to that child
                if (root.getLeft() != null)
                    root = root.getLeft();
                else if (root.getRight() != null)
                    root = root.getRight();
            } else { //root has 2 children; find the last node of the tree; copy value of the last node into root; delete that last node
                TreeNode temp = maxNode(root.getLeft());
                root.setValue(temp.getValue());
                root.setLeft(removeHelper(root.getLeft(), temp.getValue()));
            }
        }
        //************************************************************
        return root;
    }

    //pre: root points to an in-order Binary Search Tree
    //post:shows the elements of the tree such that they are displayed in prefix order

    public void showPreOrder() {
        preOrderHelper(myRoot);
        System.out.println();
    }

    private void preOrderHelper(TreeNode root) {
        //************COMPLETE THIS METHOD****************************
        if (root != null) {
            System.out.print(root.getValue() + " ");
            preOrderHelper(root.getLeft());
            preOrderHelper(root.getRight());
        }
        //************************************************************
    }

    //pre: root points to an in-order Binary Search Tree
    //post:shows the elements of the tree such that they are displayed in infix order

    public void showInOrder() {
        inOrderHelper(myRoot);
        System.out.println();
    }

    private void inOrderHelper(TreeNode root) {
        if (root != null) {
            inOrderHelper(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrderHelper(root.getRight());
        }
    }

    //pre: root points to an in-order Binary Search Tree
    //post:shows the elements of the tree such that they are displayed in postfix order

    public void showPostOrder() {
        postOrderHelper(myRoot);
        System.out.println();

    }

    public boolean contains(Comparable x) {
        if (searchHelper(myRoot, x) == null)
            return false;
        return true;
    }

    private void postOrderHelper(TreeNode root) {
        //************COMPLETE THIS METHOD****************************
        if (root != null) {
            postOrderHelper(root.getLeft());
            postOrderHelper(root.getRight());
            System.out.print(root.getValue() + " ");
        }
        //************************************************************
    }

    private TreeNode maxNode(TreeNode root) {
        if (root.getLeft() == null)
            return root;

        return maxNode(root.getLeft());
    }


    //pre: root points to an in-order Binary Search Tree
    //post:returns whether or not x is found in the tree


    private TreeNode searchHelper(TreeNode root, Comparable x) {
        //************COMPLETE THIS METHOD****************************
        if (root == null)
            return null;

        if (root.getValue().compareTo(x) == 0)
            return root;

        if (root.getValue().compareTo(x) > 0)
            return searchHelper(root.getRight(), x);

        return searchHelper(root.getLeft(), 0);
        //************************************************************
    }

    //pre: root points to an in-order Binary Search Tree
    //post:returns a reference to the parent of the node that contains x, returns null if no such node exists
    //THIS WILL BE CALLED IN THE METHOD removeRecur
    private TreeNode searchParent(TreeNode root, Comparable x) {
        //************COMPLETE THIS METHOD****************************
        if (root == null)
            return root;

        if (root.getLeft().getValue().compareTo(x) == 0)
            return root;

        if (root.getRight().getValue().compareTo(x) == 0)
            return root;

        if (root.getValue().compareTo(x) > 0)
            return searchParent(root.getLeft(), x);
        //************************************************************
        return searchParent(root.getRight(), x);
    }

    //post: determines if root is a leaf or not O(1)
    private boolean isLeaf(TreeNode root) {
        //************COMPLETE THIS METHOD****************************
        return root.getLeft() == null && root.getRight() == null;
        //************************************************************
    }

    //post: returns true if only one child O(1)

    private boolean oneKid(TreeNode root) {
        //************COMPLETE THIS METHOD****************************
        if (root == null)
            return false;

        if (root.getLeft() != null && root.getRight() != null)
            return false;

        if (root.getLeft() != null)
            return true;

        if (root.getRight() != null)
            return true;

        return false;
        //************************************************************
    }

    //pre: root points to an in-order Binary Search Tree
    //post:returns the number of nodes in the tree

    public int size() {
        return sizeHelper(myRoot);
    }

    private int sizeHelper(TreeNode root) {
        //************COMPLETE THIS METHOD****************************
        if (root == null)
            return 0;

        return 1 + sizeHelper(root.getLeft()) + sizeHelper(root.getRight());
        //************************************************************
    }

    public int height() {
        return heightHelper(myRoot);
    }

    //pre: root points to an in-order Binary Search Tree
    //post:returns the height (depth) of the tree

    public int heightHelper(TreeNode root) {
        //************COMPLETE THIS METHOD****************************
        if (root == null)
            return -1;

        return  1 + Math.max(heightHelper(root.getLeft()), heightHelper(root.getRight()));
        //************************************************************
    }

    //EXTRA CREDIT
    //pre: root points to an in-order Binary Search Tree
    //post:returns true if p is an ancestor of c, false otherwise

    public boolean isAncestor(TreeNode root, Comparable p, Comparable c) {
        return false;
    }

    //EXTRA CREDIT
    //pre: root points to an in-order Binary Search Tree
    //post:shows all elements of the tree at a particular depth

    public void printLevel(TreeNode root, int level) {

    }

    //Nothing to see here...move along.
    private String temp;

    private void inOrderHelper2(TreeNode root) {
        if (root != null) {
            inOrderHelper2(root.getLeft());
            temp += (root.getValue() + ", ");
            inOrderHelper2(root.getRight());
        }
    }

    public String toString() {
        temp = "";
        inOrderHelper2(myRoot);
        if (temp.length() > 1)
            temp = temp.substring(0, temp.length() - 2);
        return "[" + temp + "]";
    }
}