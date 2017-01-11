#include <bits/stdc++.h>
using namespace std;

int dp[11][11][40][40];

int calc(int l, int r, int sl, int sr) {
	if(l>r) return sl == sr ? 1 : 0;
	int& ref = dp[l][r][sl][sr];
	if(ref != -1) return ref;
	ref = 0;
	for(int dl=0; dl<=9; ++dl) {
		for(int dr=0; dr<=9; ++dr) {
			ref += calc(l+1, r-1, sl+dl, sr+dr);
		}
	}
	return ref;
}

int main() {
	memset(dp, 0xff, sizeof(dp));
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n; cin >> n;
    cout << calc(1, n, 0, 0) << endl;
}
