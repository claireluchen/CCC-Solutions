//Interval DP
//dp[i][j] represents the max score possible using i balls using pins starting at/after j
//sum[i] is precalculated and represents the sum of score of the next w pins, starting at i
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 3e4 + 5;
const int mod = 1e9 + 7;
 
int t, n, k, w;
int sum[maxn], pin[maxn], dp[505][maxn];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> t;
  while(t--){
    cin >> n >> k >> w; //n pins, k balls, w width
    memset(sum, 0, sizeof(sum));
    memset(pin, 0, sizeof(pin));
    for (int i = 0; i < 505; i++) memset(dp[i], 0, sizeof(dp[i]));

    for (int i = 0; i < n; i++) cin >> pin[i];
    for (int i = 0; i < w; i++) sum[0] += pin[i];
    for (int i = 1; i + w - 1 < n; i++) sum[i] = sum[i - 1] - pin[i - 1] + pin[i + w - 1];
    for (int i = n - w + 1; i < n; i++) sum[i] = sum[i - 1] - pin[i - 1];

    for (int i = 1; i <= k; i++){
      for (int j = n - 1; j >= 0; j--){
        if (j + w >= n) dp[i][j] = sum[j];
        else dp[i][j] = max(dp[i - 1][j + w] + sum[j], dp[i][j + 1]);
      }
    }
    cout << dp[k][0] << endl;
  }

  return 0;
}
