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
public class Dao {

    public int getIndex(int i, int[][] arr) {
        //int index=-1;
        for (int x = 0; x < 11; x++) {
            if (i == arr[x][0]&&arr[x][4]==0) {
                arr[x][4]+=1;
                return x;
            }
        }
        return 0;
    }

    public int getParent(int[][] arr) {
        for (int i = 0; i < 11; i++) {
            if (arr[i][0] == 0) {
                return i;
            }
        }
        return 0;
    }

    public void insertNewNode(int[][] arr, int a, int b, int c) {
        int index = this.getParent(arr);
        if (index != 0) {
            arr[index][0] = c;
            arr[index][2] = a;
            arr[index][3] = b;
        }
    }
    
    public int[] findChild(int i,int[][] arr){
        int j=0;
        int[] bit={9,9,9,9,9,9};
        int parent=arr[i][1];
        while(parent!=-1){
            if(arr[parent][2]==i){                
                bit[j]=0;
            }else if(arr[parent][3]==i){
                bit[j]=1;
            }
            j++;
            i=parent;
            parent=arr[parent][1];
        }
        return bit;
    }
}
