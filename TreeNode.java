public class TreeNode {
    private Comparable value;  //can be any type of object that implements Comparable
    private TreeNode   left;     //points to left subtree
    private TreeNode   right;    //points to right subtree

    //constructors
    public TreeNode(Comparable value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Comparable v) {
        value = v;
        left = null;
        right = null;
    }

    public Comparable getValue() //accessor methods
    {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    //mutator methods
    public Comparable setValue(Comparable v) {
        value = v;
        return value;
    }

    public TreeNode setLeft(TreeNode l) {
        left = l;
        return this;
    }

    public TreeNode setRight(TreeNode r) {
        right = r;
        return this;
    }
}


