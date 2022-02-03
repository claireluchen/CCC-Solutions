//String algorithm (suffix tree)
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
const int maxn = 1e5 + 5;
const int mod = 1e9 + 7;

int n;
string str;

int lcp(string s1, string s2){ //find the length of the longest common prefix. ex: abcd and abcee would have a lcp of 3
  int len = min(s1.length(), s2.length());
  for (int i = 0; i < len; i++){
    if (s1[i] != s2[i]){
      return i;
    }
  }
  return len;
}

int main(){
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);
  
  cin >> n;
  while (n--){
    cin >> str;
    vector<string> vt;
    for (int i = 0; i < str.length(); i++){
      vt.push_back(str.substr(i)); //take every possible suffix
    }
    sort(vt.begin(), vt.end()); //sorted lexicographically so that [i] would have the most lcp with [i - 1]
    int count = vt[0].length();
    for (int i = 1; i < vt.size(); i++){
      count += vt[i].length() - lcp(vt[i - 1], vt[i]); //number of unique substring comparedto the previous one
    }
    cout << ++count << endl; //empty string also counts as a substring
  }
  return 0;
}
