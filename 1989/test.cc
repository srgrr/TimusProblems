#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;

struct fenwick {

  int n;
  vector< ll > tree;

  fenwick(int _n) {
    n = _n;
    tree = vector< ll >(n+1);
  }

  void insert(int pos, ll val) {
    while(pos <= n) {
       tree[pos] += val;
       pos += (pos & -pos);
    }
  }

  ll prefix(int pos) {
    ll ret = 0;
    while(pos > 0) {
      ret += tree[pos];
      pos -= (pos & -pos);
    }
    return ret;
  }

  ll intsum(int ql, int qr) {
    return prefix(qr) - prefix(ql - 1);
  }

  ll val(int p) {
    return intsum(p, p);
  }

};


int main() {
  fenwick f(100);
  f.insert(1, 1);
  f.insert(1, 1);
  f.insert(1, 1);
  f.insert(1, 1);
  cout << f.val(1) << endl;
}
