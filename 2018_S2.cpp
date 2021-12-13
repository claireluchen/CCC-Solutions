//Implementation, 2D array
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int n, arr[100][100];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      cin >> arr[i][j];
  if (arr[0][0] < arr[n - 1][0] && arr[0][0] < arr[0][n - 1]){
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        cout << arr[i][j] << " ";
      }
      cout << "\n";
    }
  }else if (arr[0][n - 1] < arr[n - 1][n - 1] && arr[0][n - 1] < arr[0][0]){
    for (int j = n - 1; j >= 0; j--){
      for (int i = 0; i <= n - 1; i++){
        cout << arr[i][j] << " ";
      }
      cout << "\n";
    }
  }else if (arr[n - 1][n - 1] < arr[0][n - 1] && arr[n - 1][n - 1] < arr[n - 1][0]){
    for (int i = n - 1; i >= 0; i--){
      for (int j = n - 1; j >= 0; j--){
        cout << arr[i][j] << " ";
      }
      cout << "\n";
    }
  }else{
    for (int j = 0; j <= n - 1; j++){
      for (int i = n - 1; i >= 0; i--){
        cout << arr[i][j] << " ";
      }
      cout << "\n";
    }
  }
  return 0;
}
