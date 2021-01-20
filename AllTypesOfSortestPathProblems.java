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

static class Pair implements Comparable<Pair>{
    int wsf;
    String psf;
    Pair(int wsf, String psf){
        this.wsf=wsf;
        this.psf=psf;
    }
    public int compareTo(Pair o){
        return this.wsf-o.wsf;        
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
		
		int s=Integer.parseInt(br.readLine());
		int d=Integer.parseInt(br.readLine());
		int criteria=Integer.parseInt(br.readLine());
		int k=Integer.parseInt(br.readLine());
		boolean  []visited=new boolean[V];
		hashPath(graph,s,d,visited,s+"",0,criteria,k);
	        System.out.println("max weight : "+max );
	        System.out.println("min weight : "+min );
	        System.out.println("max path : "+maxpath );
	        System.out.println("max Path : "+minpath );
	        System.out.println("Min weight from Criteria : "+floorCriteria+" Min path from criteria "+floorpath);
	        
	            System.out.println("Kth Largest Pair : "+pq.peek().wsf+"   "+pq.peek().psf);
	       
		    
		}
	
	catch(Exception e){}
	}
	
	
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
    static String maxpath="";
    static String minpath="";
    static int floorCriteria=Integer.MIN_VALUE;
    static String floorpath="";
	static PriorityQueue<Pair>pq=new PriorityQueue<Pair>();
	static void hashPath(ArrayList<Edge>[]graph,int sr,int de,boolean visited[],String psf,int wsf,int criteria,int k){
	    if(sr==de)
	   {
	       //Path with Max Weight from given source to destination
	      if(wsf>max){
	           max=wsf;
	           maxpath=psf;
	       }
	       //Path with Min Weight from given source to destination
	       if(wsf<min){
	           min=wsf;
	           minpath=psf;
	       }
	       //Path with floor weight from given criteria Weight from given source to destination
	       if(wsf<criteria && wsf>floorCriteria){
	           floorCriteria=wsf;
	           floorpath=psf;
	           
	       }
	       //Path with kth largest  Weight from given source to destination
	       if(pq.size()<k)
	    pq.add(new Pair(wsf,psf));
	    else if(pq.peek().wsf<wsf){
	        pq.poll();
	   pq.add(new Pair(wsf,psf));

	    }
	   }
	   
 	   visited[sr]=true;
	   for(Edge edge:graph[sr]){
	       if(visited[edge.d]==false){
	           //Recursively call function
	       hashPath(graph,edge.d,de,visited,psf+edge.d,wsf+edge.n,criteria,k);
	           
	       }
	   }
	   visited[sr]=false;
	}
}
