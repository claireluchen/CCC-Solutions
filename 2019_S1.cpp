//Implementation
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
string str;
int h, v;

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> str;
  for (int i = 0; i < str.length(); i++){
    if (str[i] == 'H') h++;
    else v++;
  }
  int a = 1, b = 2, c = 3, d = 4;
  if (h % 2 != 0){
    a = 3; b = 4; c = 1; d = 2;
  }
  if (v % 2 != 0){
    int temp = a;
    a = b;
    b = temp;
    temp = c;
    c = d;
    d = temp;
  }
  cout << a << " " << b << endl;
  cout << c << " " << d << endl;
  return 0;
}
