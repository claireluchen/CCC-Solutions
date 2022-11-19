//string hashing
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn = 2e5 + 5, mod = 1e9 + 7, b1 = 131, b2 = 137;
string n, h;
ll hsh1[maxn], hsh2[maxn], pw1[maxn], pw2[maxn];
vector<int> f1(26), f2(26);
unordered_set<ll> st;

ll getHash(int l, int r){
  ll h1 = (hsh1[r] - hsh1[l - 1] * pw1[r - l + 1] % mod + mod) % mod;
  ll h2 = (hsh2[r] - hsh2[l - 1] * pw2[r - l + 1] % mod + mod) % mod;
  return (h1 << 31) | h2;
}

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> n >> h;
  for (int i = 0; i < n.size(); i++) f1[n[i] - 'a']++;
  pw1[0] = 1; pw2[0] = 1;
  for (int i = 1; i <= h.size(); i++){
    pw1[i] = pw1[i - 1] * b1 % mod;
    pw2[i] = pw2[i - 1] * b2 % mod;
    hsh1[i] = (hsh1[i - 1] * b1 + h[i - 1] - 'a') % mod;
    hsh2[i] = (hsh2[i - 1] * b2 + h[i - 1] - 'a') % mod; 
  }
  for (int i = 1; i <= h.size(); i++){
    f2[h[i - 1] - 'a']++;
    if (i > n.size()) f2[h[i - n.size() - 1] - 'a']--;
    if (i >= n.size() && f1 == f2) st.insert(getHash(i - n.size() + 1, i));
  }


  cout << st.size() << endl;
  return 0;
}
