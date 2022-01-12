//Graph theory (Dijkstra's)
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 5005;
const int mod = 1e9 + 7;
 
int n, t, k;
vector<pair<int, int>> adj[maxn];
int dis[maxn];
bool vis[maxn];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> n >> t;
  for (int i = 0; i < t; i++){
    int x, y, c;
    cin >> x >> y >> c;
    adj[x].push_back({-c, y});
    adj[y].push_back({-c, x});
  }
  memset(dis, 0x3f3f3f3f, sizeof(dis));

  cin >> k;
  unordered_map<int, int> prices;
  for (int i = 0; i < k; i++){
    int x, w; cin >> x >> w;
    prices[x] = w;
  }

  int start; cin >> start;
  priority_queue<pair<int, int>> q; //-dist, toNode
  dis[start] = 0;
  q.push({0, start});

  while (!q.empty()){
    int cur = q.top().second; q.pop();
    if (vis[cur]) continue;
    vis[cur] = true;
    for (pair<int, int> nxt : adj[cur]){
      int to = nxt.second, w = -nxt.first;
      if (dis[cur] + w < dis[to]){
        dis[to] = dis[cur] + w;
        q.push({-dis[to], to});
      }
    }
  }

  int ans = 0x3f3f3f3f;
  for (auto p : prices){
    ans = min(ans, dis[p.first] + p.second);
  }
  cout << ans << endl;
  return 0;
}
