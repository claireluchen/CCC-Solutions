//Implementation, map
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int n;
map<string, string> nameMap;
vector<string> nameList;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> n;
  for (int i = 0; i < n; i++){
    string name; cin >> name;
    nameList.push_back(name);
  }
  for (int i = 0; i < n; i++){
    string name; cin >> name;
    nameMap[nameList[i]] = name;
  }
  for (int i = 0; i < n; i++){
    string n1 = nameList[i], n2 = nameMap[n1];
    if (nameMap[n2] != n1 || n1 == n2){
      cout << "bad" << endl; return 0;
    }
  }

  cout << "good" << endl;
	return 0;
}
