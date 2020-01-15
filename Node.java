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
public class Node {
    int weight;
    Node next;
    public Node(int weight){
        this.weight=weight;
        this.next=null;
    }
}
