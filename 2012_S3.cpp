//Sorting, implementation
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 1e3 + 5;
const int mod = 1e9 + 7;
 
int n;
int freq[maxn];
vector<pair<int, int>> vt;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> n; int maxVal = 0;
  for(int i = 0; i < n; i++){
    int cur; cin >> cur;
    freq[cur]++;
    maxVal = max(maxVal, cur);
  }
  
  for (int i = 1; i <= maxVal; i++){
    if (freq[i] != 0){
      vt.push_back({freq[i], i});
    }
  }

  sort(vt.begin(), vt.end());
  if (vt[vt.size() - 1].first == vt[vt.size() - 2].first){ //more than one highest freq
    int f = vt[vt.size() - 1].first;
    for (int i = vt.size() - 1; i >= 0; i--){
      if (vt[i].first != f){
        cout << abs(vt[vt.size() - 1].second - vt[i + 1].second) << endl;
        return 0;
      }
    }
    cout << abs(vt[vt.size() - 1].second - vt[0].second) << endl;
  }else{ //one highest freq
    if (vt.size() >= 3 && vt[vt.size() - 2].first == vt[vt.size() - 3].first){ //more than one 2nd highest freq
      int highestFreqVal = vt[vt.size() - 1].second;
      int highestFreq2 = vt[vt.size() - 2].first;
      int mx = vt[vt.size() - 2].second;
      for (int i = vt.size() - 3; i >= 0; i--){
        if (vt[i].first != highestFreq2){
          int mn = vt[i + 1].second;
          cout << max(abs(highestFreqVal - mx), abs(highestFreqVal - mn)) << endl;
          return 0;
        }
      }
      cout << max(abs(highestFreqVal - mx), abs(highestFreqVal - vt[0].second)) << endl;

    }else{
      cout << abs(vt[vt.size() - 1].second - vt[vt.size() - 2].second) << endl;
    }
  }
  return 0;
}
