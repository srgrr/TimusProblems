#include <iostream>
#include <vector>
#include <set>
using namespace std;

struct union_find {
  vector< int > g;
  vector< int > k;
  int n;
  union_find(int _n) {
    n = _n;
    g = vector< int >(n);
    k = vector< int >(n, 1);
    for(int i = 0; i < n; ++i) {
      g[i] = i;
    }
  }

  int rep(int u) {
    if(g[u] == u) return u;
    return g[u] = rep(g[u]);
  }

  int count(int u) {
    return k[rep(u)];
  }

  void join(int u, int v) {
    int ru = rep(u), rv = rep(v);
    if(ru != rv) {
      k[rv] += k[ru];
      g[ru]  = rv;
    }
  }

};

int main() {
    int n, m;
    cin >> n >> m;
    union_find cc(n);
    set<pair<int,int>> excluded;
    vector<pair<int, int>> edges;
    for (int i = 0; i < m; ++i) {
        int u, v;
        cin >> u >> v;
        --u, --v;
        //if (u > v) swap(u, v);
        edges.push_back({u, v});
    }
    int q;
    cin >> q;
    vector<int> queries(q), ans(q);
    for (int &x: queries) {
        cin >> x;
        --x;
        excluded.insert(edges[x]);
    }
    int cur = n;
    for (auto uv: edges) {
        int u = uv.first, v = uv.second;
        if (excluded.count({u, v})) continue;
        if (cc.rep(u) != cc.rep(v)) {
            --cur;
            cc.join(u, v);
        }
    }
    for (int i = q - 1; i >= 0; --i) {
        ans[i] = cur;
        auto edge = edges[queries[i]];
        int u = edge.first, v = edge.second;
        if (cc.rep(u) != cc.rep(v)) {
            --cur;
            cc.join(u, v);
        }
    }
    for (int x: ans) {
        cout << x << " ";
    }
    cout << endl;
}