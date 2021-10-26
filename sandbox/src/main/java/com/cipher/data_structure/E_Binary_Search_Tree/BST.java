package com.cipher.data_structure.E_Binary_Search_Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 17:21 2018/10/26
 */
@SuppressWarnings("unchecked")
public class BST<E extends Comparable> {

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            node = new Node(e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }

    public void levelOrder() {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node cur = queue.remove();
                System.out.println(cur.e);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    public void inOrderNR() {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    Node curr = stack.pop();
                    System.out.println(curr.e);
                    root = curr.right;
                }
            }
        }
    }

    public void preOrderNR() {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    System.out.println(root.e);
                    stack.push(root);
                    root = root.left;
                } else {
                    Node curr = stack.pop();
                    root = curr.right;
                }
            }
        }
    }

    public void postOrderNR2() {
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            Node peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.push((peek.right));
            } else {
                Node temp = stack.pop();
                System.out.println(temp.e);
                cur = temp;
            }
        }
    }

    public void postOrderNR() {
        LinkedList<E> list = new LinkedList<>();
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    list.addFirst(root.e);
                    stack.push(root);
                    root = root.right;
                } else {
                    Node curr = stack.pop();
                    root = curr.left;
                }
            }
        }
        for (E e : list) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 2, 4, 8};
        for (Integer i : nums) {
            bst.add(i);
        }
//        bst.inOrderNR();
//        bst.preOrderNR();
        bst.preOrderNR();
    }

}
