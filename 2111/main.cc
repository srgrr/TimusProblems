#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long int ll;

int main() {
  int n;
  scanf("%d", &n);
  vector< int > v(n);
  ll total_cargo = 0ll;
  for(int& x: v) {
    scanf("%d", &x);
    total_cargo += ll(x);
  }
  reverse(v.begin(), v.end());
  ll ans = 0ll;
  for(int x: v) {
    ans += total_cargo * ll(x) + (total_cargo - ll(x)) * ll(x);
    total_cargo -= ll(x);
  }
  printf("%lld\n", ans);
}
