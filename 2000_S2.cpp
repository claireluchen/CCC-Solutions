//Simulation
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int maxn = 1e5 + 10;

int n;
vector<double> stream;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> n;
  for (int i = 0; i < n; i++){
    int s = 0;
    cin >> s;
    stream.push_back(s);
  }

  int instruction = 0;
  cin >> instruction;
  while (instruction != 77){
    if (instruction == 88){
      int s = 0;
      cin >> s;
      double sum = stream[s - 1] + stream[s];
      stream.erase(stream.begin() + s - 1); stream.erase(stream.begin() + s - 1);
      stream.insert(stream.begin() + s - 1, sum);
    }else if (instruction == 99){
      int s, p;
      cin >> s >> p;
      double left = stream[s - 1] * (double) p / 100;
      double right = stream[s - 1] - left;
      stream.erase(stream.begin() + s - 1);
      stream.insert(stream.begin() + s - 1, left);
      stream.insert(stream.begin() + s, right);
    }
    cin >> instruction;
  }

  for (int i = 0; i < stream.size(); i++){
    int ans = (int) (stream[i] + 0.5);
    cout << ans << " ";
  }

  return 0;
}
