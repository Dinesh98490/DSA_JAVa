public class Disjoint {
    int parent[];
    int size[];
    int v;
    public Disjoint(int v){
        this.v = v;
        size = new int [v];
        parent = new int [v];
        for (int i=0; i<v; i++){
            parent[i] =-1;
        }
    }

    void cycleDetection(int u,  int v){

        int uabsroot = find(u);
        int vabsroot = find(v);
        if (uabsroot == vabsroot){
            System.out.println("cycle detected");
        }
        union(uabsroot, vabsroot);
    }

    void union(int uabsroot, int vabsroot){
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

    public static void main(String[] args){
        Disjoint ds  = new Disjoint(4);
        ds.cycleDetection(0, 1);
        ds.cycleDetection(0, 2);
        ds.cycleDetection(2, 3);
        ds.cycleDetection(1, 3);
        
    }
    
}
