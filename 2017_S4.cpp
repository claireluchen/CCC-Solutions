//Graph theory, MST
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
const int N = 100005;

struct pipe{
	long long len;
	int id, x, y;
	bool in_MST;
};
vector<pipe> pipes;

bool cmp(pipe a, pipe b) {
	if (a.len == b.len) {
		return a.id < b.id;
	}
	return a.len < b.len;
}

int dsu_fa[N];
int getf(int x) {
	if (dsu_fa[x] == x) return x;
	dsu_fa[x] = getf(dsu_fa[x]);
	return dsu_fa[x];
}

vector<int> edge[N];
long long maxlen = 0, maxlen2 = 0;

int dep[N], fa[N][20];
long long maxf[N][20];

int n, m; long long d;

void dfs(int x, int father) {
	for (int idx: edge[x]) {
		pipe p = pipes[idx];
		int y;
		if (p.x == x) y = p.y; else y = p.x;
		if (y == father) continue;

		fa[y][0] = x;
		if (p.id < n) maxf[y][0] = 0; else maxf[y][0] = p.len;
		dep[y] = dep[x] + 1;
		dfs(y, x);
	}
}

long long query(int x, int y) {
	long long res = 0;
	if (dep[x] < dep[y]) {
		int tmp = x; x = y; y = tmp;
	}
	for (int i = 19; i >= 0; i--) {
		if (dep[fa[x][i]] >= dep[y]) {
			res = max(res, maxf[x][i]);
			x = fa[x][i];
		}
		if (x == y) return res;
	}
	for (int i = 19; i >= 0; i--) {
		if (fa[x][i] != fa[y][i]) {
			res = max(res, maxf[x][i]);
			res = max(res, maxf[y][i]);
			x = fa[x][i]; y = fa[y][i];
		}
	}
	res = max(res, maxf[x][0]);
	res = max(res, maxf[y][0]);
	return res;
}

int main() {

	cin >> n >> m >> d;
	for (int i = 1; i <= m; i++) {
		int x, y; long long len;
		cin >> x >> y >> len;
		pipes.push_back(pipe{ len,i, x, y, false });
	}

	sort(pipes.begin(), pipes.end(), cmp);

	for (int i = 1; i <= n; i++) dsu_fa[i] = i;
	int count = 0;
	int old_count = 0;
	for (int i = 0; i < m; i++) {
		int x = pipes[i].x, y = pipes[i].y;
		int fx = getf(x), fy = getf(y);
		if (fx == fy) continue;

		pipes[i].in_MST = true;
		dsu_fa[fx] = fy;
		if (pipes[i].id < n) old_count++;
		edge[x].push_back(i);
		edge[y].push_back(i);
		count++;
		if (count == n - 2) maxlen2 = pipes[i].len;
		if (count == n - 1) {
			maxlen = pipes[i].len;
			break;
		}
	}

	dep[1] = 1;
	dfs(1, 0);

	for (int k = 1; k < 20; k++) {
		for (int i = 1; i <= n; i++) {
			fa[i][k] = fa[fa[i][k - 1]][k - 1];
			maxf[i][k] = max(maxf[i][k - 1], maxf[fa[i][k - 1]][k - 1]);
		}
	}

	int ans = n - 1 - old_count;
	if (ans == 0) {
		cout << ans << endl;
		return 0;
	}

	long long min_len = -maxlen + max((long long)0, maxlen - d);

	for (int i = 0; i < m; i++) {
		if (pipes[i].id >= n || pipes[i].in_MST) continue;
		long long replace_len = query(pipes[i].x, pipes[i].y);

		long long now_maxlen = 0;
		if (replace_len == maxlen) {
			now_maxlen = max(maxlen2, pipes[i].len);
		}
		else {
			now_maxlen = max(maxlen, pipes[i].len);
		}
		if (-now_maxlen + max((long long)0, now_maxlen - d) + pipes[i].len - replace_len == min_len) {
			ans--;
			break;
		}
	}
	cout << ans << endl;

	return 0;

}
