#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;

int main() {
  ios_base::sync_with_stdio(0); cin.tie(0);
  int n;
  cin >> n;
  n = 1<<n;
  map<string, int> m;
  int mf = 0;
  for(int i = 0; i < n; ++i) {
    string x;
    cin >> x >> x;
    ++m[x];
    mf = max(mf, m[x]);
  }
  int k = 0, ans = 0;
  while(mf <= n / (1<<k)) {
    ans = k;
    ++k;
  }
  cout << ans << endl;
}
