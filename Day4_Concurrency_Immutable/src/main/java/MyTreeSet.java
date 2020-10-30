public class MyTreeSet<T> {
    private Node<T> root;

    public MyTreeSet() {
    }

    public Node<T> find(int key) {
        Node<T> current = root;

        while (current.getKey() != key) {
            if (current.getKey() < key) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    @SuppressWarnings("unchecked")
    public void insert(int key, T data) {
        Node<T> node = new Node<T>(key, data);

        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node prev;

            while (true) {
                prev = current;

                if (key < prev.getKey()) {
                    current = current.getLeftChild();

                    if (current == null) {
                        prev.setLeftChild(node);
                        return;
                    }
                } else {
                    current = current.getRightChild();

                    if (current == null) {
                        prev.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }
}
