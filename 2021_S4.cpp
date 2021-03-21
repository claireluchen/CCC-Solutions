#include<bits/stdc++.h>
using namespace std;
const int maxn = 2e5+5;

int n,w,d;
int dis[maxn],per[maxn];
vector<int>G[maxn];
bool vis[maxn];
queue<int>Q;
multiset<int>Dist;
inline void bfs(int s){
    //memset(vis,0,sizeof(vis));
    memset(dis,0x3f,sizeof(int)*(n+1));
    while(!Q.empty())Q.pop();
    vis[s]=1;
    dis[s]=0;
    Q.push(s);
    while(!Q.empty()){
        int u = Q.front();
        Q.pop();
        for(int i=0;i<G[u].size();++i){
            int v=G[u][i];
            if(!vis[v]){
                dis[v]=dis[u]+1;
                vis[v]=1;
                Q.push(v);
            }
        }
    }
}

int main(){
    scanf("%d%d%d",&n,&w,&d);
    for(int i=1;i<=w;++i){
        int A,B;
        scanf("%d%d",&A,&B);
        G[B].push_back(A);
    }
    for(int i=1;i<=n;++i){
        scanf("%d",per+i);
    }
    bfs(n);
    for(int i=1;i<=n;++i){
        Dist.insert(i+dis[per[i]]);
    }
    while(d--){
        multiset<int>::iterator it;
        int x,y;
        scanf("%d%d",&x,&y);
        int fx = per[x], fy = per[y];
        swap(per[x],per[y]);
        it = Dist.find(x+dis[fx]);
        Dist.erase(it);
        it = Dist.find(y+dis[fy]);
        Dist.erase(it);
        Dist.insert(x+dis[per[x]]);
        Dist.insert(y+dis[per[y]]);
        printf("%d\n",( *Dist.begin() )-1);
    }
    return 0;
}
