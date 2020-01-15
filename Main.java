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
public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Dao dao = new Dao();
        int[] arr = {5, 32, 18, 7, 25, 13};
        int[][] Huffman = new int[11][5];
        for (int i = 0; i < arr.length; i++) {
            Huffman[i][0] = arr[i];
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 1; j < 4; j++) {
                Huffman[i][j] = -1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            list.insert(arr[i]);
        }

        while (list.moreThanNode()) {
            int min1 = list.dequeue();
            int min2 = list.dequeue();
            int sum = min1 + min2;
            list.insert(sum);
            int index1 = dao.getIndex(min1, Huffman);
            int index2 = dao.getIndex(min2, Huffman);
            int parent = dao.getParent(Huffman);
            Huffman[index1][1] = parent;
            Huffman[index2][1] = parent;
            dao.insertNewNode(Huffman, index1, index2, sum);
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(Huffman[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            int[] bit = dao.findChild(i, Huffman);
            System.out.print("Node"+i+":");
            for (int j = bit.length - 1; j >= 0; j--) {
                if (bit[j] != 9) {
                    System.out.print(bit[j]);
                }
            }
            System.out.println();
        }
    }
}
