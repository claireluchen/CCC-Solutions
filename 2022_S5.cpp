//Tree DP, DFS
#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;
const int maxn = 2e5 + 5;
const int INF = 2e8 + 5;

string p;
vector<int> edge[maxn];
int c[maxn];
ll f[maxn][6];

void dfs(int x, int fa) {
    if (p[x - 1] == 'N') {
        f[x][2] = 0;
        f[x][3] = c[x];
        f[x][4] = f[x][5] = INF;

        ll sum0 = c[x], sum1 = 0;
        for (int y : edge[x]) {
            if (y == fa) continue;
            dfs(y, x);
            sum0 += min(min(min(f[y][0], f[y][1]), min(f[y][2], f[y][3])), min(f[y][4], f[y][5]));
            sum1 += min(min(f[y][0], f[y][1]), min(f[y][4], f[y][5]));
            f[x][2] += min(min(f[y][0], f[y][1]), min(f[y][4], f[y][5]));
            f[x][3] += min(min(min(f[y][0], f[y][1]), min(f[y][2], f[y][3])), min(f[y][4], f[y][5]));
        }

        f[x][0] = INF;
        for (int y : edge[x]) {
            if (y == fa) continue;
            f[x][0] = min(f[x][0],sum0 - min(min(min(f[y][0], f[y][1]), min(f[y][2], f[y][3])), min(f[y][4], f[y][5]))
            + min(f[y][0], f[y][5]));
        }

        f[x][1] = INF;
        for (int y : edge[x]) {
            if (y == fa) continue;
            f[x][1] = min(f[x][1], sum1 - min(min(f[y][0], f[y][1]), min(f[y][4], f[y][5])) + min(f[y][0], f[y][5]));
        }
        return;
    } else {
        f[x][0] = f[x][1] = f[x][2] = f[x][3] = INF;
        f[x][4] = 0;
        f[x][5] = c[x];

        for (int y : edge[x]) {
            if (y == fa) continue;
            dfs(y, x);
            f[x][4] += min(min(f[y][0], f[y][1]), min(f[y][4], f[y][5]));
            f[x][5] += min(min(min(f[y][0], f[y][1]), min(f[y][2], f[y][3])), min(f[y][4], f[y][5]));
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false); 
    cin.tie(0); cout.tie(0);
    int n; cin >> n;
    for (int i = 1; i < n; i++) {
        int a, b; cin >> a >> b;
        edge[a].push_back(b);
        edge[b].push_back(a);
    }
    cin >> p;
    for (int i = 1; i <= n; i++) cin >> c[i];

    dfs(1, 0);
    cout << min(min(f[1][0], f[1][1]), min(f[1][4], f[1][5])) << endl;
    
    return 0;
}
