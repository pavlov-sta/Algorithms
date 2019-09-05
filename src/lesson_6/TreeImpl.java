package lesson_6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;


    private int maxLevel;

    public TreeImpl() {
        this(0);
    }

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public boolean find(E value) {
        return doFind(value).current != null;
    }

    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);

        NodeAndParent nodeAndParent = doFind(value);
        Node<E> previous = nodeAndParent.parent;

        if (maxLevel != 0 && nodeAndParent.parentLevel == maxLevel) {
            return false;
        }

        if (nodeAndParent.isEmpty()) {
            this.root = node;
            return true;
        } else if (nodeAndParent.current != null) {
            return false;
        } else if (previous.shouldBeLeft(value)) {
            previous.setLeftChild(node);
        } else {
            previous.setRightChild(node);
        }

        size++;
        return true;
    }

    private NodeAndParent doFind(E value) {
        if (isEmpty()) {
            return new NodeAndParent(null, null, 0);
        }

        Node<E> parent = null;
        Node<E> current = this.root;
        int level = 0;
        do {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent, level);
            }

            parent = current;
            level++;
            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        } while (current != null);

        return new NodeAndParent(null, parent, level);
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removedNode = nodeAndParent.current;

        if (removedNode == null) {
            return false;
        }
        else if (removedNode.isLeaf()) {
            removeLeafNode(parent, removedNode);
        }
        else if ( removedNode.hasOnlySingleChild() ) {//removedNode.L != null || removedNode.R != null
            removeNodeWithSingleChild(parent, removedNode);
        }
        else {
            removeCommonNode(parent, removedNode);
        }

        size--;
        return true;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(successor);
        }
        else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node<E> parent, Node<E> removedNode) {
        Node<E> childNode = removedNode.getLeftChild() != null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();

        if (removedNode == root) {
            root = childNode;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(childNode);
        }
        else {
            parent.setRightChild(childNode);
        }
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if (removedNode == root) {
            root = null;
        }
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(null);
        }
        else {
            parent.setRightChild(null);
        }
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mode: " + mode);
        }
    }

    private void inOrder(Node<E> current) {
        inOrder(root, System.out::println);
    }

    public void inOrderLoop() {
        Node<E> current = root;
        Stack<Node<E>> stack = new Stack<>();
        while (current != null || !stack.empty()) {
            if (!stack.empty()) {
                current = stack.pop();
                System.out.println(current.getValue());
                if (current.getRightChild() != null) current = current.getRightChild();
                else current = null;
            }
            while (current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }
        }
    }

    private void inOrder(Node<E> current, Consumer<E> action) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild(), action);
        action.accept(current.getValue());
        inOrder(current.getRightChild(), action);
    }

    private void preOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        System.out.println(current.getValue());
        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
    }

    private void postOrder(Node<E> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        inOrder(current.getRightChild());
        System.out.println(current.getValue());
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<E> queue = new LinkedList<>();

            {
                inOrder(root, queue::add);
            }

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public E next() {
                return queue.remove();
            }
        };
    }

    private class NodeAndParent {
        Node<E> current;
        Node<E> parent;
        int parentLevel;

        public NodeAndParent(Node<E> current, Node<E> parent, int parentLevel) {
            this.current = current;
            this.parent = parent;
            this.parentLevel = parentLevel;
        }

        public boolean isEmpty() {
            return current == null && parent == null;
        }
    }
}
