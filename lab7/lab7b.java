import java.util.*;
import java.io.*;

class BinaryTree {
    String label;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(String label) {
        this.label = label;
        this.left = null;
        this.right = null;
    }
}

public class lab7b {
    public static int parseIndex = 0;

    public static BinaryTree construct(String expression) {
        if(expression.charAt(parseIndex + 1) != ')') {
            parseIndex++;
            String label = "";
            while(expression.charAt(parseIndex) != '(' && expression.charAt(parseIndex) != ')') {
                label += expression.charAt(parseIndex);
                parseIndex++;
            }
            parseIndex--;
            BinaryTree node = new BinaryTree(label);
            parseIndex++;
            node.left = construct(expression);
            parseIndex++;
            node.right = construct(expression);
            parseIndex++;
            return node;
        }
        parseIndex++;
        return null;
    }

    public static void inorder(BinaryTree t) {
        if (t == null) { return; }
        inorder(t.left);
        System.out.print(t.label + " ");
        inorder(t.right);
    }

    public static void preorder(BinaryTree t) {
        if (t == null) { return; }
        System.out.print(t.label + " ");
        preorder(t.left);
        preorder(t.right);    }

    public static void postorder(BinaryTree t) {
        if (t == null) { return; }
        postorder(t.left);
        postorder(t.right);
        System.out.print(t.label + " ");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = br.readLine();
        parseIndex = 0;
        BinaryTree root = construct(line);
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
    }
}