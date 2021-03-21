#include<bits/stdc++.h>
using namespace std;

const int maxn = 5e6 + 5;
map<int,int> row, col;

int main() {
    int m, n, k;
    scanf("%d%d%d", &m,&n,&k);
    string op;
    int tmp;
    for(int i = 0; i < k; ++i) {
        cin>>op;
        scanf("%d", &tmp);
        if(op[0] == 'R') {
            row[tmp]^=1;
            if(row[tmp]==0)row.erase(tmp);
        }
        else {
            col[tmp]^=1;
            if(col[tmp]==0)col.erase(tmp);
        }
    }
    long long res = 1ll*row.size()*(1ll*n-col.size());
    res += 1ll*(m-row.size())*col.size();
    printf("%lld\n",res);
    return 0;
}
