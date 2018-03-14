#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;

struct edge {
  int u, dis;
  double w;
};

struct cmp_edge {
  bool operator()(edge& a, edge& b) {
    if(a.dis != b.dis)
      return a.dis > b.dis;
    return a.w < b.w;
  }
};

int main() {
  ios_base::sync_with_stdio(0); cin.tie(0);
  cout.setf(ios::fixed);
  cout.precision(16);
  int n, m;
  cin >> n >> m;
  int s, t;
  cin >> s >> t;
  vector< vector< edge  > > g(n + 1, vector< edge >());
  vector< double > prob(n + 1, 0.0);
  prob[s] = 1.0;
  vi dis(n + 1, n + 1);
  dis[s] = 0;
  while(m--) {
    int u, v;
    cin >> u >> v;
    double p;
    cin >> p;
    g[u].push_back({v, 0, 1.0 - p / 100.0});
    g[v].push_back({u, 0, 1.0 - p / 100.0});
  }
  vi par(n + 1, -1);
  priority_queue< edge, vector< edge >, cmp_edge > q;
  q.push({s, 0, 1.0});
  while(!q.empty()) {
    auto cur_edge = q.top();
    q.pop();
    int v = cur_edge.u;
    for(edge& e : g[v]) {
      int adj = e.u;
      if(dis[v] + 1 < dis[adj] ||
      (dis[v] + 1 == dis[adj] && prob[v] * e.w > prob[adj])) {
        dis[adj] = dis[v] + 1;
        prob[adj] = prob[v] * e.w;
        par[adj] = v;
        q.push({adj, dis[adj], prob[adj]});
      }
    }
  }
  vi ans;
  int cur = t;
  while(cur != -1) {
    ans.push_back(cur);
    cur = par[cur];
  }
  cout << ans.size() << " " << 1.0 - prob[t] << endl;
  reverse(ans.begin(), ans.end());
  for(int i = 0; i < int(ans.size()); ++i) {
    if(i > 0) cout << " ";
    cout << ans[i];
  }
  cout << endl;
}
