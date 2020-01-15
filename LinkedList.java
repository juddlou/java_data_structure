/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HuffmanTree;

/**
 *
 * @author juddlou
 */
public class LinkedList {

    Node first;
    Node last;

    public void insert(int weight) {
        Node newNode = new Node(weight);
        if (this.first == null) {
            first = newNode;
            last = newNode;
            return;
        }
        if (newNode.weight <= first.weight) {
            newNode.next = first;
            first = newNode;
        }
        if (newNode.weight >= last.weight) {
            last.next = newNode;
            last = newNode;
            return;
        }
        Node current = first;
        while (current.next != null) {
            if (newNode.weight > current.weight && newNode.weight <= current.next.weight) {
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
        }
    }

    public int dequeue() {
        int i = -1;
        if (first != null) {
            i = first.weight;
            first = first.next;
        }
        return i;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print(current.weight + "\t");
            current = current.next;
        }
        System.out.println("\n");
    }

    public boolean moreThanNode() {
        if (first.next == null) {
            return false;
        } else {
            return true;
        }
    }
}
