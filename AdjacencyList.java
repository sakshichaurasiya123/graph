/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		//System.out.println("GfG!");
		Scanner in=new Scanner(System.in);
		int V=5;
		ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer>>(V);
		for(int i=0; i<V; i++){
		    adj.add(new ArrayList<Integer>());
		}
		addEdge(adj,0,1);
		addEdge(adj,0,2);
		addEdge(adj,1,2);
		addEdge(adj,1,3);
		printgraph(adj);
		
	}
	static void addEdge(ArrayList<ArrayList<Integer>>adj,int u,int v){
	    adj.get(u).add(v);
	    adj.get(v).add(u);
	}
	static void printgraph(ArrayList<ArrayList<Integer>>adj){
	    for(int i=0; i<adj.size(); i++){
	        for(int j=0; j<adj.get(i).size(); j++){
	            System.out.print((adj.get(i).get(j))+" ");
	        }
	        System.out.println();
	    }
	}
	
}
