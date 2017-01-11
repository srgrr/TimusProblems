#include <bits/stdc++.h>
using namespace std;

int dp[9][82];

int calc(int d, int s) {
	if(s<0) return 0;
	if(d == 9) return s==0 ? 1 : 0;
	int& ref = dp[d][s];
	if(ref != -1) return ref;
	ref = 0;
	for(int i=0; i<=9; ++i) {
		ref += calc(d+1, s-i);
	}
	return ref;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    memset(dp, 0xff, sizeof(dp));
    int s; cin >> s;
    int ans = calc(0, s);
    if(s == 1) ++ans;
    cout << ans << endl;
}
