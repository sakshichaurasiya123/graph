
class Solution
{

    public int numIslands(char[][] grid)
    {
        // Code here
        int count=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                numIslend(i,j,grid,visited);
                count++;
                }
            }
        }
        return count;
    }
    public void numIslend(int i,int j,char grid[][],boolean visited[][]){
      if(i<0 || j<0 || i>=grid.length || j>=grid[i].length|| grid[i][j]=='0' || visited[i][j]==true){  
            return;
    }
        visited[i][j]=true;
        
        numIslend(i-1,j,grid,visited);
        numIslend(i,j+1,grid,visited);
        numIslend(i,j-1,grid,visited);
        numIslend(i+1,j,grid,visited);
         numIslend(i+1,j-1,grid,visited);
          numIslend(i+1,j+1,grid,visited);
           numIslend(i-1,j+1,grid,visited);
            numIslend(i-1,j-1,grid,visited);
    }
}
