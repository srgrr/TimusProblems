#include <bits/stdc++.h>
using namespace std;

int main(int argc, char** argv) {
  srand(time(NULL));
  int n = atoi(argv[1]);
  cout << n << endl;
  for(int i=0; i<5*n; ++i) {
    cout << rand()%20000 - 20000 << " " << rand()%20000 - 20000 << endl;
  }
}
