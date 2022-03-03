#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;
const int maxn = 1e6 + 5;
const int mod = 1e9 + 7;

int n, cnt;
int sum;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> n;
  if (n % 5 == 0){
    cnt++;
  }
  for (int i = 1; i * 4 <= n; i++){
    sum += 4;
    if ((n - sum) % 5 == 0) cnt++;
  }
  cout << cnt << endl;
  return 0;
}
