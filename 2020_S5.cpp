//Graph theory (BFS)
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 1e3 + 5;
const int mod = 1e9 + 7;

int arr[maxn][maxn];
queue<pair<int, int>> q;
bool vis[maxn][maxn];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  int n, m; cin >> n >> m;
  for (int i = 1; i <= n; i++) 
    for (int j = 1; j <= m; j++)
      cin >> arr[i][j];

  q.push({1, 1});
  vis[1][1] = true;
  while (!q.empty()){
    pair<int, int> vt = q.front(); q.pop();
    int x = vt.first, y = vt.second;
    if (x > n || y > m) continue;
    int num = arr[x][y];
    for (int i = 1; i <= sqrt(num); i++){
      if (num % i == 0){
        if (i <= n && (num/i) <= m && vis[i][num/i]) continue;
        else if (i <= n && (num/i) <= m){
          q.push({i, num/i});
          vis[i][num/i] = true;
        }
        if (i <= m && (num/i) <= n && vis[num/i][i]) continue;
        else if (i <= m && (num/i) <= n){
          q.push({num/i, i});
          vis[num/i][i] = true;
        }
      }
    }    
  }
  
  if (vis[n][m]) cout << "yes" << endl;
  else cout << "no" << endl;
  return 0;
}
