class Solution {
 public int removeStones(int[][] stones) {
    int n=stones.length;
    int rank[]=new int[n];
    int parent[]=new int[n];
    for(int i=0;i<n;i++){
        parent[i]=i;
        rank[i]=1;
    }
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                union(i,j,parent,rank);
            }
        }
    }
    int c=0;
    for(int i=0;i<n;i++){
        if(parent[i]==i)c++;
    }
    return n-c;
}
public void union(int u,int v,int parent[],int rank[]){
    u=findPar(u,parent);
    v=findPar(v,parent);
    if(u!=v){
        if(rank[u]<rank[v]){
            parent[u]=v;
        }
        else if(rank[v]<rank[u]){
            parent[v]=u;
        }
        else{
            parent[u]=v;
            rank[u]++;
        }
    }
}
public int findPar(int node,int parent[]){
    if(node==parent[node]){
        return node;
    }
    return parent[node]=findPar(parent[node],parent);
}
}