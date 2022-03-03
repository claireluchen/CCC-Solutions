//Implementation, map
#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;
const int maxn = 1e5 + 5;
const int mod = 1e9 + 7;

int x, y, z, cnt;
string n1, n2, n3;
map<string, int> g;
pair<string, string> same[maxn], diff[maxn];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> x;
  for (int i = 0; i < x; i++){
    cin >> n1 >> n2;
    same[i] = {n1, n2};
  }
  cin >> y;
  for (int j = 0; j < y; j++){
    cin >> n1 >> n2;
    diff[j] = {n1, n2};
  }
  cin >> z;
  for (int i = 0; i < z; i++){
    cin >> n1 >> n2 >> n3;
    g[n1] = g[n2] = g[n3] = i;
  }
  for (int i = 0; i < x; i++){
    if (g[same[i].first] != g[same[i].second]){
      cnt++;
    }
  }
  for (int i = 0; i < y; i++){
    if (g[diff[i].first] == g[diff[i].second]){
      cnt++;
    }
  }
  cout << cnt << endl;
  return 0;
}
