#include<bits/stdc++.h>
using namespace std;
const int maxn = 2e5+5;

int n;
int p[maxn],w[maxn],d[maxn];

long long f(long long pos) {
    long long res = 0;
    for(int i=1;i<=n;++i){
        long long pos1 = pos-d[i];
        long long pos2 = pos+d[i];
        long long tim = min(abs(pos1-p[i]),abs(pos2-p[i]));
        if(pos1<=p[i]&&p[i]<=pos2)tim=0;
        res += tim*w[i];
    }
    return res;
}

long long calc(){
    long long L = p[1], R = p[1];
    for(int i=2;i<=n;++i)L=min(1ll*p[i],L),R=max(1ll*p[i],R);
    if(R-L+1<=4){
        long long ans = f(L);
        for(int i=L+1;i<=R;++i){
            ans=max(ans,f(i));
        }
        return ans;
    }
    while(L+3<R){
        long long mid = (L+R)/2;
        long long midmid = (L+mid)/2;

        long long fmid = f(mid);
        long long fmidmid = f(midmid);

        if(fmid<fmidmid){
            L=midmid;
        }else{
            R=mid;
        }
    }
    long long ans = f(L);
    ans=min(ans,f(L+1));
    ans=min(ans,f(L+2));
    ans=min(ans,f(R));
    return ans;
}

int main(){
    scanf("%d",&n);
    for(int i=1;i<=n;++i)scanf("%d%d%d",p+i,w+i,d+i);
    printf("%lld\n",calc());
    return 0;
}
