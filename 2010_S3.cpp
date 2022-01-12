//Greedy algorithm, binary search
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 1e3 + 5;
const int mod = 1e9 + 7;
 
int n, k;
int pos[maxn];

bool isValid(int d){
  for (int i = 0; i < n; i++){ //since the houses are in a circle, check every possible "starting" point
    int cnt = 1, dist = 0, prev = pos[i]; //dist is the distance from the left end of the "current" firehose
    for (int j = 0; j < n; j++){
      int idx = (i + j) % n;
      dist += (pos[idx] - prev + 1000000) % 1000000;
      prev = pos[idx];
      if (dist > 2 * d){
        dist = 0;
        cnt++;
      }
    }
    if (cnt <= k){
      return true;
    }
  }

  return false;
}

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> n;
  for (int i = 0; i < n; i++) cin >> pos[i];
  cin >> k;

  sort(pos, pos + n);
  int l = 0, r = pos[n - 1], mid;
  while (l < r){
    mid = (l + r) / 2;
    if (isValid(mid)) r = mid;
    else l = mid + 1;
  }
  if (isValid(l)) cout << l << endl;
  else cout << r << endl;
  
  return 0;
}
