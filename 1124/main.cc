#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;

void
compute_scc(int u, vvi& g, vi& ind, vi& low, stack< int >& st, vector< bool >& in, vvi& sccs) {
  static int cur = 0;
  if(ind[u] != -1) return;
  ind[u] = cur++;
  low[u] = ind[u];
  st.push(u);
  in[u] = true;
  for(int adj : g[u]) {
    compute_scc(adj, g, ind, low, st, in, sccs);
    if(in[adj]) {
      low[u] = min(low[u], low[adj]);
    }
  }
  if(ind[u] == low[u]) {
    vi scc;
    int v;
    do {
      v = st.top();
      st.pop();
      in[v] = false;
      scc.push_back(v);
    } while(v != u);
    sccs.push_back(scc);
  }
}

int main() {
  ios_base::sync_with_stdio(0); cin.tie(0);
  int m, n;
  cin >> m >> n;
  int ans = 0;
  vvi g(m, vi());
  for(int i = 0; i < m; ++i) {
    for(int j = 0; j < n; ++j) {
      int x;
      cin >> x, --x;
      if(i != x) {
        ++ans;
        g[i].push_back(x);
      }
    }
  }
  vector< int > dfs_ind(m, -1), dfs_low(m, m + 1);
  stack< int > scc_stack;
  vector< bool > in(m, false);
  int scc_amount = 0;
  for(int i = 0; i < m; ++i) {
    if(dfs_ind[i] == -1) {
      vvi sccs;
      compute_scc(i, g, dfs_ind, dfs_low, scc_stack, in, sccs);
      for(vi scc : sccs) {
        if(scc.size() > 1) {
          ++scc_amount;
        }
      }
    }
  }
  cout << max(0, ans + scc_amount - 1) << endl;
}
