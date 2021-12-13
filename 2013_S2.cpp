//Simple math
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int n, w, arr[100005];
ll sum;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> w >> n;
  for (int i = 1; i <= n; i++){
    cin >> arr[i];
  }
  for (int i = 1; i <= n; i++){
    int cur = arr[i];
    if (i <= 4){
      sum += cur;
      if (sum > w){
        cout << i - 1 << endl;
        return 0;
      }
    }else{
      sum += cur;
      sum -= arr[i - 4];
      if (sum > w){
        cout << i - 1 << endl;
        return 0;
      }
    }
  }
  cout << n << endl;
  return 0;
}
