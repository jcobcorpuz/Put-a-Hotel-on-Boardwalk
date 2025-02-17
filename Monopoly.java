public class Monopoly {
    public static void main(String[] args){
        CircularLinkedList<String> monopolyBoard = new CircularLinkedList<>();

        monopolyBoard.append("Go");
        monopolyBoard.append("Mediterranean Avenue");
        monopolyBoard.append("Community Chest");
        monopolyBoard.append("Baltic Avenue");
        monopolyBoard.append("Income Tax");

        monopolyBoard.printAllNodes();

        System.out.println("\nCurrent Position: " + monopolyBoard.getCurrentNode());
        monopolyBoard.step();
        System.out.println("After 1 step: " + monopolyBoard.getCurrentNode());

        monopolyBoard.step();
        monopolyBoard.step();
        monopolyBoard.step();
        System.out.println("After a few more steps: " + monopolyBoard.getCurrentNode());

        for (int i = 0; i < 37; i++){
            monopolyBoard.step();
        }
        System.out.println("After 37 steps: " + monopolyBoard.getCurrentNode());
    }
}

class Node<T>{
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList<T>{
    private Node<T> head = null;
    private Node<T> tail = null;
    private Node<T> current = null;

    public void append(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        if(current == null){
            current = head;
        }
    }

    public T getCurrentNode(){
        if (current != null){
            return current.data;
        }
        else{
            return null;
        }
    }

    public void step(){
        if (current != null){
            current = current.next;
        }
    }

    public void printAllNodes(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }

        Node<T> temp = head;
        System.out.print(temp.data + " -> ");
        temp = temp.next;

        while (temp != head){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
}

