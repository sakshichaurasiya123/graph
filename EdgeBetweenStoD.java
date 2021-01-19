/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Edge{
    int s;
    int d;
    int n;
    Edge(int s,int d,int n){
        this.s=s;
        this.d=d;
        this.n=n;
    }

	public static void main (String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int V=Integer.parseInt(br.readLine());
		ArrayList<Edge>[]graph=new ArrayList[V];
		for(int i=0; i<V; i++)
		    graph[i]=new ArrayList<Edge>();
		int edge=Integer.parseInt(br.readLine());
		
		for(int i=0; i<edge; i++){
		    String part[]=br.readLine().split(" ");
		    int v1=Integer.parseInt(part[0]);
		    int v2=Integer.parseInt(part[1]);
		    int wt=Integer.parseInt(part[2]);
		
		graph[v1].add(new Edge(v1,v2,wt));
		graph[v2].add(new Edge(v2,v1,wt));
		}
		
		int s=Integer.parseInt(br.readLine());
		int d=Integer.parseInt(br.readLine());
		
		boolean  []visited=new boolean[V];
		boolean res=hashPath(graph,s,d,visited);
		System.out.println(res);
	}
	
	catch(Exception e){}
	}
	static boolean hashPath(ArrayList<Edge>[]graph,int s,int de,boolean visited[]){
	    if(s==de)
	        return true;
	   visited[s]=true;
	   for(Edge edge:graph[s]){
	       if(visited[edge.d]==false){
	           boolean r=hashPath(graph,edge.d,de,visited);
	           if(r==true)
	                return true;
	       }
	   }
	   return false;
	}
}
