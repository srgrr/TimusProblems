#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;
const int maxm = 10009;

void dfs(vvi& g, int u, vi& ans) {
  ans.push_back(u);
  queue< int > q;
  // Si hemos vaciado un vertice tenemos la garantia de que hemos ido y vuelto
  // de este, dadas las condiciones del input (indg = outdg y 1 SCC)
  while(!g[u].empty()) {
    int cur = g[u].back();
    g[u].pop_back();
    q.push(cur);
    u = cur;
  }
  while(!q.empty()) {
    // Pongamos que en la cola hay A - B - C - D - E
    // Si al vertice C le quedan dos aristas que le llevan a un tour
    // que no hemos explorado con el while anterior (e.g C - F - G - C)
    // lo meteremos al hacer dfs(C), ya que descubriremos el path y
    // tendremos A - B - C - F - G - C - D - E
    dfs(g, q.front(), ans);
    q.pop();
  }
}

int main() {
  ios_base::sync_with_stdio(0); cin.tie(0);
  int n;
  cin >> n;
  vvi g(maxm, vi());
  // Esta forma de dar el input garantiza que todos los vertices tienen el mismo
  // grado de entrada y salida. Este dato, juntamente con que el grafo es fuertemente
  // conexo, garantiza la existencia de un tour euleriano
  int v0;
  while(n--) {
    int m;
    cin >> m >> v0;
    while(m--) {
      int v1;
      cin >> v1;
      g[v0].push_back(v1);
      v0 = v1;
    }
  }
  vi ans;
  dfs(g, v0, ans);
  cout << ans.size() - 1;
  for(int x : ans) cout << " " << x;
  cout << endl;
}
