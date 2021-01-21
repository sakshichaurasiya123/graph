/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Edge  {
    int s;int d;int w;
    Edge(int s,int d,int w){
        this.s=s;
        this.d=d;
        this.w=w;
    }
    public	static class Pair implements Comparable<Pair>{
	    int v;
	    int wsf;
	    int psf;
	    Pair(int v,int psf,int wsf){
	        this.v=v;
	        this.psf=psf;
	        this.wsf=wsf;
	    }
	    public int compareTo(Pair o){
	        return this.wsf-o.wsf;
	    }
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
		
		int src=Integer.parseInt(br.readLine());
		int d=Integer.parseInt(br.readLine());
	
		  PriorityQueue<Pair>p=new PriorityQueue<Pair>();
	    p.add(new Pair(src,-1,0));
	    boolean visited[]=new boolean[V];
	    while(p.size()>0){
	    Pair rem=p.poll();
	    if(visited[rem.v]==true){
	        continue;
	    }
	       visited[rem.v]=true;
	       if(rem.psf!=-1)
	   System.out.println("Virtex : "+rem.v+"Path show Far : "+rem.psf+"  Wait so far : "+rem.wsf);
	   for(Edge e: graph[rem.v]){
	       if(visited[e.d]==false){
	           p.add(new Pair(e.d,rem.v,e.w));
	       }
	   }
	    }
	    System.out.println(p);
	
	    }
	catch(Exception e){}
	}

    
}
