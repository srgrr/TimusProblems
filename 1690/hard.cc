#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv) {
  int n = atoi(argv[1]);
  cout << n << endl;
  for(int i=0; i<2*n; ++i) {
    cout << i << " " << i << endl;
  }
  for(int i=0; i<3*n; ++i) {
    cout << rand()%20000 - 10000 << " " << rand()%20000 - 10000 << endl;
  }
}
