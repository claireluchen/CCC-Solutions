//ad hoc
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 2000;
const int mod = 1e9 + 7;

int n, m, r, c;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> n >> m >> r >> c;
  char arr[n][m], ch[25];
  for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = 'a';
  for (int i = 0; i < 25; i++) ch[i] = (char) ('b' + i);

  if (n == r){
    if (m % 2 == 0 && c % 2 == 1){
      cout << "IMPOSSIBLE" << endl; return 0;
    }
    for (int j = 0; j < (m - c) / 2; j++){
      for (int i = 0; i < n; i++){
        arr[i][j] = ch[i%25];
        arr[i][m-1-j] = ch[i%25];
      }
    }
    if ((m - c) % 2 == 1){
      for (int i = 0; i < n; i++) arr[i][m/2] = ch[i%25];
    }
  }else if (m == c){
    if (n % 2 == 0 && r % 2 == 1){
      cout << "IMPOSSIBLE" << endl; return 0;
    }
    for (int i = 0; i < (n - r) / 2; i++){
      for (int j = 0; j < m; j++){
        arr[i][j] = ch[j%25];
        arr[n-1-i][j] = ch[j%25];
      }
    }
    if ((n - r) % 2 == 1){
      for (int j = 0; j < m; j++) arr[n/2][j] = ch[j%25];
    }
  }else{
    for (int i = 0; i < n; i++){
      for (int j = 0; j < m; j++){
        if (i < r || j < c) arr[i][j] = 'a';
        else arr[i][j] = ch[(i+j) % 25];
      }
    }
  }
  
  for (int i = 0; i < n; i++){
    for (int j = 0; j < m; j++) cout << arr[i][j];
    cout << endl;
  }
  return 0;
}
