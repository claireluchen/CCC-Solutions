//Implementation, stack
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 1e5 + 5;
const int mod = 1e9 + 7;
 
int t, n;
int arr[maxn];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> t;
  while (t--){
    cin >> n;
    int lake = 0;
    stack<int> branch;
    for (int i = 1; i <= n; i++){
      cin >> arr[i];
    }
    for (int i = n; i > 0; i--){
      int cur = arr[i];
      if (lake + 1 == cur) {
        lake++;
      }else{ //if it can't go straight down into the lake, it might be able to wait-it-out in the branch
       //it's either directly discarding and resulting in "No" (may be invalid) or pushing it aide to the branch in case it can join properly later. choose the latter.
        while (!branch.empty()){
          if (branch.top() == lake + 1){
            lake++;
            branch.pop();
          }else{
            break;
          }
        }
        if (lake + 1 == cur) lake++;
        else branch.push(cur);
      }
    }
    while (!branch.empty()){
      if (branch.top() == lake + 1){
        lake++;
        branch.pop();
      }else{
        break;
      }
    }
    if (branch.empty()) cout << "Y" << endl;
    else cout << "N" << endl;
  }
  return 0;
}
