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
  int N = n;
  n = 1<<n;
  map<string, int> m;
  int mf = 0;
  for(int i = 0; i < n; ++i) {
    string x;
    cin >> x >> x;
    ++m[x];
    mf = max(mf, m[x]);
  }
  vi f;
  for(auto& kv : m) {
    f.push_back(kv.second);
  }
  sort(f.rbegin(), f.rend());
  int ans = 0;
  for(int i = 0, r = 1; i < N; ++i, ++r) {
    //for(int x : f) cout << x << " "; cout << endl;
    if(f[0] <= n / (1<<r)) {
      ++ans;
    }
    for(int j = 0; j < int(f.size()); ++j) {
      if(f[j] == 0) continue;
      int rem = f[j];
      for(int k = j + 1; k < int(f.size()) && rem > 0; ++k) {
        int to_subtract = min(f[k], rem);
        f[k] -= to_subtract;
        rem  -= to_subtract;
      }
    }
    vi nf;
    for(int x : f) {
      if(x > 0) {
        nf.push_back(x);
      }
    }
    sort(nf.rbegin(), nf.rend());
    f = nf;
  }
  //for(int x : f) cout << x << " "; cout << endl;
  cout << ans << endl;
}
