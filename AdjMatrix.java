import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjMatrix {


    public  static class Edges implements Comparable<Edges> {
        int u;
        int v;
        int w;
        Edges(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }

        @Override
        public int compareTo(Edges o) {
            return this.w-o.w;
        }
    }
    int v;
    int[][] matrix;
    AdjMatrix(int v){
        this.v = v;
        matrix = new int[v][v];
        edge = new Edges[v*(v-1)/2];
    }

    int edgecnt =-1;
    void addEdge(int source,int destination, int w){
        matrix[source][destination]=w;
        matrix[destination][source]=w;
        // edge[++edgecnt] = new Edges(source, destination, w);
    }
    void populateEdge(){
        for (int i=0; i<v; i++){
            for(int j=0; i<v-1; j++){
                if(matrix[i][j] != 0){
                    //add only unique edges
                    edge[edgecnt++] = new Edges(i,j,matrix[i][j]);
                }
            }
        }
    }
 void krushkall(){
    int parentcnt[] = new int[v];
    int size[] =  new int[v];
    int [][]mst =  new int[v][v];
    for(int i =0; i<v; i++){
        parent[i] =-1;
    }
    Arrays.sort(edge);
    int edgecounter  =0;
    int edgeTaken =1;
    while (edgeTaken<v){
        Edges e =  edge[edgecounter++];
        int uabsroot = find(e.u, parent);
        int vabsroot = find(e.v, parent);
        if(uabsroot ==  vabsroot){
            continue;
        }
        mst[e.u][e.v] = e.w;
        mst[e.v][e.u] = e.w;
        edgeTaken++;
        union(uabsroot, vabsroot, parent, size);




    }  

    
 }
     void union(int uabsroot, int vabsroot, int[]parent, int[]size){
        if(size[uabsroot]> size[vabsroot]){
            parent[vabsroot] = uabsroot;
        }
        else if(size[uabsroot]< size[vabsroot]){
            parent[uabsroot] = vabsroot;
        }
        else{
            parent[uabsroot] = vabsroot;
            size[vabsroot]++;
        }

    }
    int find(int x){
        if(parent[x] == -1){
         return x;
        }
        return parent[x] = find(parent[x]);
    }

 

    void printmatrix(){
        for(int i=0;i<v;i++){
            System.out.print(i+"is connected to ");
            for(int j=0;j<v;j++){
                if(matrix[i][j]!=0){
                    System.out.print(j+" ");

                }
            }
            System.out.println();
        }
    }
    List<Integer> getAdjNodes(int i){
        List<Integer> list=new ArrayList<>();
        for(int j=0;j<v;j++){
            if(matrix[i][j]!=0){
                list.add(j);

            }
        }

        return list;
    }

   
    void BFS(int source){
        queuep q=new queuep(v);
        boolean[] visited=new boolean[v];
        visited[source]=true;
        q.enqueue(source);
        while (!q.isempty()) {
            int u=q.dequeue();
            System.out.println(u);
            for(int i=0;i<v;i++){
                if(matrix[u][i]!=0){
                    if(!visited[i]){
                        q.enqueue(i); 
                        visited[i]=true;
                    }
                }
            }

            
        }  
     }
     void dfs(boolean[] visited,int source){
        visited[source]=true;
        System.out.println(source);
        for(int j=0;j<v;j++){
            if(matrix[source][j]!=0){
                if(!visited[j]){
                    dfs(visited, j);
                }
            }
        }

     }

     void DFS(int source){
        boolean[] visited=new boolean[v];
        dfs(visited, source); 

     }

     int shortestPath(int source,int destination){
        queuep q=new queuep(v);
        boolean[] visited=new boolean[v];
        int dist[]=new int[v];
        int prepath[]=new int[v];
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
            prepath[i]=-1;
        }
        dist[source]=0;
        visited[source]=true;
        q.enqueue(source);
        while(!q.isempty()){
            int u=q.dequeue();
            for(int j=0;j<v;j++){
                if(matrix[u][j]!=0){
                    if(!visited[j]){
                        if(dist[u]+1<dist[j]){
                            dist[j]=dist[u]+1;
                            prepath[j]=u;
                            q.enqueue(j);
                            visited[j]=true;
                        }

                    }
                }
            }
        }
        Stack<Integer> stk = new Stack<>();
        stk.push(destination);
        int x=prepath[destination];
        while (x!=-1) {
            stk.push(x);
            x =prepath[x];
           
            
        }
        System.out.println("printing path");
        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
        return dist[destination];
     }

     int dijakStra(int source, int destination) {
        int dist[] = new int[v];
        int prevpath[] = new int[v];
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }
        dist[source] = 0;
        for(int i = 0; i < v; i++) {
            int u = findMinVertex(visited, dist);
            visited[u] = true;
            for(int j = 0; j < v; j++) {
                if(matrix[u][j]!=0){
                    if(!visited[j] && dist[u]+ matrix[u][j]<dist[j]){
                        dist[j] = dist[u] + matrix[u][j];
                        prevpath[j] = u;
                    }
                }

        }

     }
     Stack<Integer> stk = new Stack<>();
     stk.push(destination);
     int x=prevpath[destination];
     while (x!=-1) {
         stk.push(x);
         x=prevpath[x];
        
         
     }
     System.out.println("printing path");
     while(!stk.isEmpty()){
         System.out.println(stk.pop());
     }
     return dist[destination];

    }
     int findMinVertex(boolean visited[], int dist[]) {
        int minvertex = -1;
        for(int i = 0; i < v; i++) {
            if(!visited[i]&& dist[i]!= Integer.MAX_VALUE && (minvertex == -1 || dist[i]<dist[minvertex])) {
                minvertex = i;
            }
        }
        return minvertex;
     }
     int  topSort(){
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(matrix[i][j]!=0){
                    indegree[j]++;
                }
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            q.add(i);
        }
        int cnt=0;
        while(!q.isEmpty()){
            int u =q.poll();
           cnt++;
            System.out.println(u);
            for(int j=0; j<v;j++){
                if(matrix[u][j]!=0){
                    indegree[j]--;
                    if(indegree[j]==0){
                        q.add(j);
                    } 
                }
            }
        }
        if(cnt==v){
            return -1;
        }
        return 1;
     }




     int prims(int source) {
        int dist[] = new int[v];
        int parent[] = new int[v];
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        dist[source] = 0;
        for(int i = 0; i < v; i++) {
            int u = findMinVertex(visited, dist);
            visited[u] = true;
            for(int j = 0; j < v; j++) {
                if(matrix[u][j]!=0){
                    if(!visited[j] && matrix[u][j]<dist[j]){
                        dist[j] = matrix[u][j];
                        parent[j] = u;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        AdjMatrix matrix = new AdjMatrix(6);
        matrix.addEdge(0,1,10);
        // matrix.addEdge(0,2);
        // matrix.addEdge(0,5);
        // matrix.addEdge(1,3);
        // matrix.addEdge(2,3);
        // matrix.addEdge(2,5);
        // matrix.addEdge(3,4);
        // matrix.addEdge(4,5);
        // matrix.addEdge(2,5);
        matrix.printmatrix();
        matrix.BFS(0);
        System.out.println(matrix.getAdjNodes(0));
    

    }

    
}