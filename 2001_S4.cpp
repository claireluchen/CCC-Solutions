/*
a circle can be determined using 3 points and to use the formula below, we connect the dots to form a triangle with side lengths a, b, c
to determine the radius of the circle, use r = abc/4*sqrt(s(s-a)(s-b)(s-c)) where s = (a+b+c)/2
*/
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n;

double dis(int x1, int y1, int x2, int y2){
  return sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
}

int main() {
  ios_base::sync_with_stdio(false); 
  cin.tie(0); cout.tie(0);

  cin >> n;
  double arr[2][n], r = 0;
  for (int i = 0; i < n; i++) cin >> arr[0][i] >> arr[1][i];
  //since the data is small, we can try every 3 points
  for (int i = 0; i < n; i++){
    for (int j = i + 1; j < n; j++){
      for (int k = j + 1; k < n; k++){
        double a = dis(arr[0][i], arr[1][i], arr[0][j], arr[1][j]);
        double b = dis(arr[0][j], arr[1][j], arr[0][k], arr[1][k]);
        double c = dis(arr[0][i], arr[1][i], arr[0][k], arr[1][k]);
        double s = (a + b + c) / 2;
        if (s == 0 || (s - a) * (s - b) * (s - c) < 0) continue; //check for division by zero or negative value inside sqrt
        //if an obtuse triangle is formed (checked using pythagorean theorem), it means that the longest edge can be the diameter of the circle
        if (a * a + b * b < c * c){
          r = max(r, c / 2);
          continue;
        }
        if (a * a + c * c < b * b){
          r = max(r, b / 2);
          continue;
        }
        if (b * b + c * c < a * a){
          r = max(r, a / 2);
          continue;
        }
        //otherwise we use the formula given above to find the radius of the circle formed using the three edges
        r = max(r, a * b * c / (4 * sqrt(s * (s - a) * (s - b) * (s - c))));

      }
    }
  }
  cout << fixed << setprecision(2) << 2 * r << endl;
  return 0;
}
