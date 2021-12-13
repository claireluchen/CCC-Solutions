//Math, prime numbers
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int t, n;

bool check(int x){
  for (int i = 2; i <= sqrt(x); i++){
    if (x % i == 0) return false;
  }
  return true;
}

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> t;
  while (t--){
    cin >> n;
    int a = 2, b = 0;
    for (;a <= n; a++){
      b = 2 * n - a;
      if (check(a) && check(b)){
        cout << a << " " << b << endl;
        break;
      }
    }
  }
  return 0;
}
