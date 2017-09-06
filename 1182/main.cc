#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;
const int maxn = 101;
int n, m;
bool orig[maxn][maxn], g[maxn][maxn], vis[maxn], color[maxn];
vvi comp, members, ans;
int dp[maxn][maxn][maxn];
vi backpointer[maxn][maxn][maxn];

void die() {
  cout << "No solution" << endl;
  exit(0);
}

void color_component(int cur, vi& col) {
  if(vis[cur]) return;
  vis[cur] = true;
  ++col[color[cur]];
  members.back().push_back(cur);
  for(int i=0; i<n; ++i) {
    if(cur == i || !g[i][cur]) continue;
    if(vis[i] && color[i] == color[cur]) die();
    color[i] = !color[cur];
    color_component(i, col);
  }
}

int calc(int u, int am1, int am2) {
  if(u == m) return abs(am1-am2);
  int& ref = dp[u][am1][am2];
  if(ref != -1) return ref;
  ref = 129319;
  int cand1 = calc(u+1, am1+comp[u][0], am2+comp[u][1]);
  int cand2 = calc(u+1, am1+comp[u][1], am2+comp[u][0]);
  if(cand1 < cand2) {
    backpointer[u][am1][am2] = {u+1, am1+comp[u][0], am2+comp[u][1]};
  }
  else {
    backpointer[u][am1][am2] = {u+1, am1+comp[u][1], am2+comp[u][0]};
  }
  ref = min(cand1, cand2);
  return ref;
}

bool cmp_v(vi a, vi b) {
	return a == b;
}

void build_answer(int u, int am1, int am2) {
  if(u == m) return;
  vi backp = backpointer[u][am1][am2];
  vi cand1 = {u+1, am1+comp[u][0], am2+comp[u][1]};
  vi cand2 = {u+1, am1+comp[u][1], am2+comp[u][0]};
 	int to_am1 = backp == cand1 ? 0 : 1;
	for(int x : members[u]) {
    if(!color[x]) ans[to_am1].push_back(x);
    else ans[1 - to_am1].push_back(x);
  }
  build_answer(backp[0], backp[1], backp[2]);
}

bool clique(vi& subset) {
  for(int u : subset) {
    for(int v : subset) {
      if(u != v && (!orig[u][v] || !orig[v][u])) return false;
    }
  }
  return true;
}

int main() {
  ios_base::sync_with_stdio(0); cin.tie(0);
  cin >> n;
  for(int i=0; i<n; ++i) {
    int adj;
    while(cin >> adj && adj) {
      --adj;
      orig[i][adj] = true;
    }
  }
  for(int i=0; i<n; ++i) {
    for(int j=0; j<n; ++j) {
      if(!orig[i][j] || !orig[j][i]) g[i][j] = true;
    }
  }
  // part 1, label components and find impossibility
  for(int i=0; i<n; ++i) {
    if(!vis[i]) {
      members.push_back(vi());
      vi col(2);
      color_component(i, col);
      comp.push_back(col);
    }
  }
  // end of part 1
  // part 2, dynamic programming over size of components plus answer
  // reconstruction
  m = int(members.size());
  ans = vvi(2, vi());
  memset(dp, 0xff, sizeof(dp));
  calc(0, 0, 0);
  build_answer(0, 0, 0);
  assert(clique(ans[0]));
  assert(clique(ans[1]));
  for(int k=0; k<2; ++k) {
    cout << ans[k].size();
    for(int x : ans[k]) cout << " " << x+1;
    cout << endl;
  }
}
