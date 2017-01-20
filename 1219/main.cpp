#include <bits/stdc++.h>
using namespace std;

int main() {
  srand( time(NULL) );
  set<int> avail;
  for(int i=0; i<26; ++i) avail.insert(i);
  vector<int> freq(26, 0);
  for(int i=0; i<1000000; ++i) {
    int nxt = rand()%26;
    while(!avail.count(nxt)) nxt = rand()%26;
    if(++freq[nxt] == 40000) avail.erase(nxt);
    cout << char(nxt+'a');
  }
  cout << endl;
}
