//binary search
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn = 1e5 + 10;

ll n;
vector<ll> p, w, d;

ll time(ll x){ //total time to travel to position x
  ll t = 0;
  for (int i = 0; i < p.size(); i++){
    ll leftRange = p[i] - d[i];
    ll rightRange = p[i] + d[i];
    if (leftRange <= x && rightRange >= x) continue;
    t += min(abs(leftRange - x), abs(rightRange - x)) * w[i];
  }
  return t;
}

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> n;
  p.resize(n); w.resize(n); d.resize(n);
  ll l = 0x3f3f3f3f, r = 0;
  for (int i = 0; i < n; i++){
    cin >> p[i] >> w[i] >> d[i];
    l = min(l, p[i]);
    r = max(r, p[i]);
  }

  while (l < r){
    ll mid = (l + r) / 2;
    if (time(mid) > time(mid + 1)){
      l = mid + 1;
    }else{
      r = mid;
    }
  }
  
  ll ans = time(l);
  ans = min(ans, time(r));
  cout << ans << endl;

  return 0;
}
