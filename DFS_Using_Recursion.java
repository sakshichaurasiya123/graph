/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		//System.out.println("GfG!");
		Scanner in=new Scanner(System.in);
		int V=in.nextInt();
		ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer>>(V);
		for(int i=0; i<V; i++){
		    adj.add(new ArrayList<Integer>());
		}
		    addEdge(adj,0,1);
		    addEdge(adj,0,2);
		    addEdge(adj,1,2);
		   // addEdge(adj,3,4);
		    
		    DFS(adj,V);
		
		
	}
	static void DFS(ArrayList<ArrayList<Integer>>adj,int V){
	    int visited[]=new int[V];
	    for(int i=0; i<V; i++){
	        if(visited[i]!=1)
            DFSrec(adj,i,visited);	        
	    }
	    
	}
	static void DFSrec(ArrayList<ArrayList<Integer>>adj,int s,int visited[]){
	    visited[s]=1;
	   // int u=adj.get(s);
	    System.out.print(s);
	    for(int r:adj.get(s)){
	        if(visited[r]!=1)
	        DFSrec(adj,r,visited);
	    }
	        //System.out.println();
	    
	}
	static void addEdge(ArrayList<ArrayList<Integer>>adj,int u,int v){
	   adj.get(u).add(v);
	   adj.get(v).add(u);
	}
}
