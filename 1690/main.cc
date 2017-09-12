#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;
const int maxn = 25009;
int n, N;

int main() {
  srand(time(0));
  ios_base::sync_with_stdio(0); cin.tie(0);
  cin >> N;
  n = 5*N;
  vvi ans(4);
  vi vans = {0, 0};
  for(int i=0; i<n; ++i) {
    int x, y;
    cin >> x >> y;
    x += 10000, y += 10000;
    int bucket = 2*(x%2) + y%2;
    ans[bucket].push_back(i+1);
    vans = max(vans, {int(ans[bucket].size()), bucket});
  }
  cout << "OK" << endl;
  for(int i=0; i<N; ++i) {
    if(i>0) cout << " ";
    cout << ans[vans[1]][i];
  }
  cout << endl;
}
