package educational.c3013.lab6;

public class Task3 {
    public static void main(String[] args) {
        Node<Double> root = new Node<>(1.0);
        Node<Double> node1 = root.addChild(new Node<Double>(1.1));
        Node<Double> node11 = node1.addChild(new Node<Double>(1.11));
        Node<Double> node12 = node1.addChild(new Node<Double>(1.12));
        Node<Double> node121 = node11.addChild(new Node<Double>(1.121));
        Node<Double> node122 = node11.addChild(new Node<Double>(1.122));
        Node<Double> node2 = root.addChild(new Node<Double>(1.2));
        Node<Double> node21 = node2.addChild(new Node<Double>(1.21));
        Node<Double> node211 = node2.addChild(new Node<Double>(1.211));
        Node<Double> node2111 = node2.addChild(new Node<Double>(1.2111));
        Node<Double> node2112 = node2.addChild(new Node<Double>(1.2112));
        Node<Double> node22 = node2.addChild(new Node<Double>(1.22));
        root.printTree(root, " ");
    }
}
