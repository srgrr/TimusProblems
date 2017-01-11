#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000000;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    vector<bool> sieve(maxn, true);
    sieve[0] = sieve[1] = false;
    vector<int> primes;
    for(int i=2; i<maxn; ++i) {
    	if(sieve[i]) {
    		primes.push_back(i);
    		for(int j=i+i; j<maxn; j += i) {
    			sieve[j] = false;
    		}
    	}
    }
    int k; cin >> k;
    while(k--) {
    	int x; cin >> x; --x;
    	cout << primes[x] << endl;
    }
}
