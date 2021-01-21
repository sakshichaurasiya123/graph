import java.io.*;
import java.util.*;
public class Main{
    //Creation of Edge with including source destination and weight
static class Edge{
    int s;
    int d;
    int n;
    Edge(int s,int d,int n){
        this.s=s;
        this.d=d;
        this.n=n;
    }
}
// Creation of Pair for compairng Weight of different path

static class Pair{
    int v;
    String psf;
    Pair(int v, String psf){
        this.v=v;
        this.psf=psf;
    }
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
		
		int src=Integer.parseInt(br.readLine());
		 Stack<Pair>s=new Stack<>();
	    boolean visited[]=new boolean[V];
	    s.push(new Pair(src,src+""));
	    while(s.size()>0){
	        Pair rem=s.pop();
	        if(visited[rem.v]==true)
	            continue;
	       visited[rem.v]=true;
	       System.out.println("Source : "+rem.v+" Path: "+rem.psf);
	       for(Edge e:graph[rem.v]){
	           if(visited[e.d]==false)
	                s.push(new Pair(e.d,e.d+rem.psf));
	       }
	    }
	   
	    }
	catch(Exception e){}
	}
}
		
		
		
		
