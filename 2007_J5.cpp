//dynamic programming
//number of ways to reach a hotel = sum of number of ways to reach hotel situated from (current distance - min distance) and (current distance - max distance)
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn = 1e5 + 5;

ll ways[maxn];
int a, b, n, isHotel[maxn];

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0); 
  int temp[] = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
  for (int i = 0; i < 14; i++) isHotel[temp[i]] = true;
  cin >> a >> b >> n;
  for (int i = 0; i < n; i++){
    int t; cin >> t; isHotel[t] = true;
  }
  ways[0] = 1L;
  for (int i = 1; i <= 7000; i++){
    if (!isHotel[i]) continue;
    int lowerbound = max(0, i - b), upperbound = max(0, i - a);
    for (int j = lowerbound; j <= upperbound; j++){
      if (isHotel[j]){
        ways[i] += ways[j];
      }
    }
  }
  cout << ways[7000] << endl;  
  return 0;
}
