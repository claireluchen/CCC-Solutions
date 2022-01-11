//Binary Search, set, greedy algorithm
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 1e5 + 5;
const int mod = 1e9 + 7;
 
int n, p;
set<int> open;
int arr[maxn];
set<int>::iterator it;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> n >> p;
  if (n > p){ //initialize the open gates with -1 to -n while reading in input for g
    for (int i = 1; i <= n; i++){
      open.insert(-i);
      if (i <= p){
        cin >> arr[i];
      }
    }
  }else{
    for (int i = 1; i <= p; i++){
      cin >> arr[i];
      if (i <= n){
        open.insert(-i);
      }
    }
  }
  
  for (int i = 1; i <= p; i++){ //all gate numbers are negative so that lower_bound can be used to find all original gate numbers equal or less than g
    it = open.lower_bound(-1 * arr[i]);
    if (it == open.end()){
      cout << i - 1 << endl;
      return 0;
    }
    open.erase(it);
  }
  cout << p << endl;
  return 0;
}
