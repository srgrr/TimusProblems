#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;

ll mod = 1e9 + 7;

struct lazy_segment_tree {
  int n;
  vector< ll > tree, pending;

  void push_flag(int l, int r, int id) {
    tree[id] += ll(r - l + 1ll)*pending[id];
    tree[id] %= mod;
    if(l<r) {
      pending[2*id] += pending[id];
      pending[2*id] %= mod;
      pending[2*id + 1] += pending[id];
      pending[2*id + 1] %= mod;
    }
    pending[id] = 0.0;
  }

  void add(int ql, int qr, int l, int r, ll val, int id) {
    push_flag(l, r, id);
    if(ql <= l && qr >= r) {
      pending[id] += val;
      pending[id] %= mod;
      push_flag(l, r, id);
      return;
    }
    if(qr < l || r < ql) return;
    int h = (l+r)/2;
    add(ql, qr, l, h, val, 2*id),
    add(ql, qr, h+1, r, val, 2*id + 1);
    tree[id] = (tree[2*id] + tree[2*id + 1]) % mod;
  }

  void add(int ql, int qr, ll val) {
    add(ql, qr, 0, n-1, val, 1);
  }

  ll get(int ql, int qr, int l, int r, int id) {
    push_flag(l, r, id);
    if(ql <= l && qr >= r) return tree[id];
    if(qr <  l || r  < ql) return 0.0;
    int h = (l+r)/2;
    return (get(ql, qr, l, h, 2*id) + get(ql, qr, h+1, r, 2*id + 1)) % mod;
  }

  ll get(int ql, int qr) {
    return get(ql, qr, 0, n-1, 1);
  }

  lazy_segment_tree(int N, int T) {
    n = N;
    tree = vector< ll >(T, 0.0);
    pending = vector< ll >(T, 0.0);
  }
};

void dfs(int u, int par, vvi& g, vi& ident, vi& parv, vi& from, vi& to) {
  static int current = 1;
  from[u] = current;
  parv[u] = par;
  for(int adj : g[u]) {
    if(adj != par) {
      ident[adj] = current++;
    }
  }
  to[u] = current - 1;
  for(int adj : g[u]) {
    if(adj != par) {
      dfs(adj, u, g, ident, parv, from, to);
    }
  }
}

int main() {
  ios_base::sync_with_stdio(0); cin.tie(0);
  int n;
  cin >> n;
  lazy_segment_tree lst(n, 4 * n);
  vll vals(n);
  for(int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    vals[i] = x;
  }
  vvi g(n, vi());
  vi ident(n, 0), par(n), from(n), to(n);
  par[0] = -1;
  for(int i = 1; i < n; ++i) {
    int u, v;
    cin >> u >> v, --u, --v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  dfs(0, -1, g, ident, par, from, to);
  for(int i = 0; i < n; ++i) {
    lst.add(ident[i], ident[i], vals[i]);
  }
  int q;
  cin >> q;
  while(q--) {
    int t, p;
    cin >> t >> p, --p;
    int parid = par[p] != -1 ? ident[par[p]] : -1;
    int pid = ident[p];
    if(t == 1) {
      auto val = lst.get(pid, pid);
      if(from[p] <= to[p]) {
        lst.add(from[p], to[p], val);
      }
      if(parid != -1) {
        lst.add(parid, parid, val);
      }
    }
    else {
      cout << lst.get(pid, pid) << endl;
    }
  }
}
