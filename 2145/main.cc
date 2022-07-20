#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long int ll;


int main() {
  int n;
  scanf("%d", &n);
  vector< int > A(n), B(n);
  for(int& x: A) {
    scanf("%d", &x);
  }
  sort(A.begin(), A.end());
  for(int& x: B) {
    scanf("%d", &x);
  }
  sort(B.begin(), B.end());
  ll p, ans = 1ll;
  scanf("%lld", &p);
  for(int i = 0; i < n; ++i) {
    int idx = upper_bound(B.begin(), B.end(), A[i]) - B.begin() - i;
    ans *= ll(idx);
    ans %= p;
  }
  printf("%lld\n", ans);
}
