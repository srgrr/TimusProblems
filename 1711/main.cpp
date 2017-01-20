#include <bits/stdc++.h>
using namespace std;

string v[16][3], ans[16];
int p[16];

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n;
    while(cin >> n) {
    	for(int i=0; i<n; ++i) {
    		for(int j=0; j<3; ++j) cin >> v[i][j];
    		sort(v[i], v[i]+3);
    	}
    	queue<int> Q;
    	for(int i=0; i<n; ++i) {
    		int x; cin >> x;
    		Q.push(x-1);
    	}
    	string last = "";
    	bool changes = true;
    	int ix = -1;
    	while(!Q.empty() && changes) {
    		changes = false; ++ix;
    		int cur = Q.front(); Q.pop();
    		for(int i=0; i<3; ++i) {
    			if(v[cur][i] >= last) {
    				changes = true;
    				ans[ix] = v[cur][i];
    				last = ans[ix];
    				break;
    			}
    		}
    	}

    	if(changes) {
    		for(int i=0; i<n; ++i) cout << ans[i] << endl;
    	}
    	else {
    		cout << "IMPOSSIBLE" << endl;
    	}
    }
}
