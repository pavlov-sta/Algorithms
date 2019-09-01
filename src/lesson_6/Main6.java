package lesson_6;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class Main6 {

    public static void main(String[] args) {
        dZ();
        //testTree();
        /*Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);

        tree.display();

        tree.remove(60);

        tree.display();*/

       /* TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(44);
        treeSet.add(45 );
        treeSet.add(11);
        treeSet.add(20);
        treeSet.add(30);

        for (Integer integer: treeSet){
            System.out.println(integer);
        }*/

        TreeSet<Person> treeSet = new TreeSet<>(Comparator.comparing(Person::getId));
        treeSet.add(new Person(33, "Alex33"));
        treeSet.add(new Person(12, "Alex22"));
        treeSet.add(new Person(25, "Alex55"));

        for (Person person : treeSet) {
            System.out.println(person);
        }
    }

    private static void testTree() {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(70);
        tree.add(67);
        tree.add(81);
        tree.add(40);
        tree.add(31);
        tree.add(45);
        tree.add(55);
        tree.add(57);

        System.out.println("Root is 60: " + tree.find(60));
        System.out.println("Find 70: " + tree.find(70));
        System.out.println("Find 31: " + tree.find(31));
        System.out.println("Find 555: " + tree.find(555));

//        tree.traverse(Tree.TraverseMode.IN_ORDER);
//        System.out.println("---------");
        ((TreeImpl) tree).inOrderLoop();
//        System.out.println("---------");

//        tree.forEach(System.out::println);
//        for (Integer integer : tree) {
//            System.out.println(integer);
//        }
//        tree.display();
    }
    public static void dZ() {
        Random rand = new Random();
        int treeCount = 20;
        int maxLevel = 4;
        int nodeCount = (int) (Math.pow(2, maxLevel) - 1);

        int maxValue = 25;

        int balancedTreeCount = 0;

        boolean treeView = false;

        for (int i = 0; i < treeCount; i++) {
            Tree<Integer> theTree = new TreeImpl<>(maxLevel);
            initTree(rand, nodeCount, maxValue, theTree);
            if (theTree.isBalanced()) {
                balancedTreeCount++;
                if (!treeView) {
                    treeView = true;
                    theTree.display();
                }
            }
        }

        System.out.println("Balanced Tree Count = " + ((balancedTreeCount / (treeCount * 1.0)) * 100) + "%");

    }

    private static void initTree(Random rand, int nodeCount, int maxValue, Tree theTree) {
        for (int j = 0; j < nodeCount; j++) {
            theTree.add(rand.nextInt(maxValue * 2 + 1) - maxValue);
        }
    }

}
