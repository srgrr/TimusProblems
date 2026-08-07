#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

const int MAXN = 501;
const int inf = 10000000;

int n, k;
int wb[MAXN][2], dp[MAXN][MAXN];

int calc(int p, int s) {
    if (p == n && s == k) {
        return 0;
    }
    if (p == n || s == k) {
        return inf;
    }
    int& ref = dp[p][s];
    if (ref == -1) {
        ref = inf;
        int cw = 0, cb = 0;
        for (int i = p; i < n; ++i) {
            cw += wb[i][0];
            cb += wb[i][1];
            ref = min(ref, cw * cb + calc(i + 1, s + 1));
        }
    }
    return ref;
}

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; ++i) {
        int x;
        cin >> x;
        ++wb[i][x];
    }
    memset(dp, 0xff, MAXN * MAXN * sizeof(int));
    cout << calc(0, 0) << endl;
}
