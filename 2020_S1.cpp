#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn = 1e5 + 5;

int n;
double ans = -1;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> n;
  pair<ll, ll> arr[n];
  for (int i = 0; i < n; i++){
    int t, p;
    cin >> t >> p;
    arr[i] = {t, p};
  }
  sort(arr, arr + n);
  for (int i = 1; i < n; i++){
    double temp = (double) abs(arr[i].second - arr[i - 1].second) / (arr[i].first - arr[i - 1].first);
    ans = max(ans, temp);
  }

  printf("%f\n", ans);
  return 0;
}
