import java.io.*;
import java.util.*;
class GFG {
    static ArrayList<ArrayList<Integer>>com=new ArrayList<ArrayList<Integer>>();
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int V=in.nextInt();
		ArrayList<ArrayList<Integer>>virtices=new ArrayList<ArrayList<Integer>>(V);
		for(int i=0; i<V; i++){
		    virtices.add(new ArrayList<>());
		}
		addEdge(virtices,0,1);
		addEdge(virtices,2,3);
		addEdge(virtices,4,5);
		addEdge(virtices,5,6);
		addEdge(virtices,4,6);
	    	Connected(virtices,V);
	    	
	    	System.out.println(com);
	    	
	}
	static void Connected(ArrayList<ArrayList<Integer>>virtices,int V){
	    boolean visited[]=new boolean[V];
        for(int i=0; i<V; i++){
            
            if(visited[i]==false){
                ArrayList<Integer>c=new ArrayList<>();
                connectedGraph(virtices,visited,i,c);
                com.add(c);
            }
        }	    
	}
	static void addEdge(ArrayList<ArrayList<Integer>>edge,int u,int v){
	        edge.get(u).add(v);
	}
	static void connectedGraph(ArrayList<ArrayList<Integer>>virtices,boolean visited[],int s,ArrayList<Integer>c){
        visited[s]=true;
        c.add(s);
        for(int r:virtices.get(s)){
            if(visited[r]==false){
                connectedGraph(virtices,visited,r,c);
            }
        }
	}
}
