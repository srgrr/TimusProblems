#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;
const int maxn = 1e5 + 9;
const int mod = 1e9 + 7;


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
       while(tree[pos] < 0ll) tree[pos] += mod;
       tree[pos] %= mod;
       pos += (pos & -pos);
    }
  }

  ll prefix(int pos) {
    ll ret = 0ll;
    while(pos > 0) {
      ret += tree[pos];
      while(ret < 0ll) ret += mod;
      ret %= mod;
      pos -= (pos & -pos);
    }
    return ret;
  }

  ll intsum(int ql, int qr) {
    ll ret = prefix(qr) - prefix(ql - 1);
    while(ret < 0ll) ret += mod;
    ret %= mod;
    return ret;
  }

  ll val(int p) {
    return intsum(p, p);
  }

};

ll fastpow(ll b, ll e) {
  if(e == 0ll) return 1ll;
  if(e == 1ll) return b;
  ll ret = fastpow((b * b) % mod, e / 2ll);
  if(e%2ll) {
    ret *= b;
  }
  return ret % mod;
}

int main() {
  srand(time(NULL));
  ios_base::sync_with_stdio(0); cin.tie(0);

  string alphabet = "abcdefghijklmnopqrstuvwxyz";

  random_shuffle(alphabet.begin(), alphabet.end());

  map< char, ll > index;

  int ix = 0;

  for(char x : alphabet) {
    index[x] = ix++;
  }

  vll pow26mod(maxn, 1ll);
  for(int i = 1; i < maxn; ++i) {
    pow26mod[i] = 26ll * pow26mod[i - 1];
    pow26mod[i] %= mod;
  }

  string s;
  cin >> s;
  s = "#" + s + "#";
  int n = int(s.size()) - 2;
  fenwick prefix(n), suffix(n);
  for(int i = 1; i <= n; ++i) {
    prefix.insert(i, (pow26mod[i - 1] * index[s[i]]) % mod);
    suffix.insert(i, (pow26mod[i - 1] * index[s[n - i + 1]]) % mod);
  }
  int m;
  cin >> m;
  while(m--) {
    string q;
    cin >> q;
    if(q == "change") {
      int i; char a;
      cin >> i >> a;
      prefix.insert(i, -prefix.val(i));
      prefix.insert(i, (pow26mod[i - 1] * index[a]) % mod);
      suffix.insert(n - i + 1, -suffix.val(n - i + 1));
      suffix.insert(n - i + 1, (pow26mod[n - i] * index[a]) % mod);
    }
    else {
      int l, r;
      cin >> l >> r;
      ll h1 = (prefix.intsum(l, r) * fastpow(pow26mod[l - 1], mod - 2)) % mod;
      ll h2 = (suffix.intsum(n - r + 1, n - l + 1) * fastpow(pow26mod[n - r], mod - 2)) % mod;
      cout << (h1 == h2 ? "Yes" : "No") << endl;
    }
  }

}
