//Dynamic programming
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn = 1e5 + 5;

int m, n; //hole length m, n clubs
int clubs[maxn], arr[maxn];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0); 
  cin >> m >> n;
  for (int i = 0; i < n; i++) cin >> clubs[i];
  for (int i = 1; i <= m; i++) arr[i] = 6000;

  for (int i = 1; i <= m; i++){
    for (int j = 0; j < n; j++){
      if (clubs[j] <= i){
        arr[i] = min(arr[i], 1 + arr[i - clubs[j]]);
      }
    }
  }

  if (arr[m] != 6000) 
    cout << "Roberta wins in " << arr[m] << " strokes." << endl;
  else 
    cout << "Roberta acknowledges defeat." << endl;
  
  return 0;
}
