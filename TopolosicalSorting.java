/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
 class Edge  {
    int s;
    int d;
    int w;
    Edge(int s,int d,int w){
        this.s=s;
        this.d=d;
        this.w=w;
    }
	public static void main (String[] args){
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
		

	
		  boolean visited[]=new boolean[V];
		  Stack<Integer>s=new Stack<Integer>();
		 
		  for(int i=0; i<V; i++){
		      if(visited[i]==false)
		            topolosical(graph,i,s,visited);
		  }
		  while(s.size()>0){
		      System.out.print(s.pop()+" ");
		  }
	    }
	catch(Exception e){}
	}
    static void topolosical(ArrayList<Edge>[]graph,int src, Stack<Integer>s,boolean visited[]){
          visited[src]=true;
          for(Edge e: graph[src]){
              if(visited[e.d]==false)
                topolosical(graph,e.d,s,visited);
          }
          s.push(src);
    }
    
}
