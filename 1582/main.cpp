#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    double k1, k2, k3; cin >> k1 >> k2 >> k3;
    double ans = 1000.0 * (k1*k2*k3)/(k1*k2 + k1*k3 + k2*k3);
    cout << round(ans) << endl;
}
