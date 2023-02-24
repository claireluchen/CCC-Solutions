//dp
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 5e3 + 5;
const int mod = 1e9 + 7;

int ans[maxn], dp[maxn][maxn], dp2[maxn][maxn], h[maxn];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  int n; cin >> n;
  for (int i = 1; i <= n; i++) {cin >> h[i]; ans[i] = 0x3f3f3f3f;} ans[1] = 0;

  for (int i = 2; i < n; i++){
    for (int j = 1; i - j >= 1 && i + j <= n; j++){
      dp[i-j][i+j] = dp[i-j+1][i+j-1] + abs(h[i-j] - h[i+j]);
      ans[2*j+1] = min(ans[2*j+1], dp[i-j][i+j]);
    }
  }

  for (int i = 1; i < n; i++){
    for (int j = 1; i-j+1 >= 1 && i+j <= n; j++){
      if (j == 1) dp[i-j+1][i+j] = abs(h[i] - h[i+1]);
      else dp[i-j+1][i+j] = dp[i-j+2][i+j-1] + abs(h[i-j+1] - h[i+j]);
      ans[2*j] = min(ans[2*j], dp[i-j+1][i+j]);
    }
  }

  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
  return 0;
}
