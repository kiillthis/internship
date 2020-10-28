class CustomLinkList<E> {
    private Node head;

    public CustomLinkList() {
    }

    @SuppressWarnings("unchecked")
    public void insert(E data){
        Node newNode = new Node(data);
        if(this.head == null){
            head = newNode;
        }else {
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    @SuppressWarnings("unchecked")
    public void insertHead(E data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, E data){
        Node nodeToBeInserted = new Node(data);
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        nodeToBeInserted.setNextNode(node.getNextNode());
        node.setNextNode(nodeToBeInserted);
    }

    @SuppressWarnings("unchecked")
    public void deleteNodeAt(int index){
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
    }
}
