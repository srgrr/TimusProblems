#include <bits/stdc++.h>
using namespace std;

bool isLetter(char x) {
  return (x>='A' && x<='Z') || (x>='a' && x<='z');
}

void printReversed(vector<char>& w) {
  for(int i=(int)w.size()-1; i>=0; --i) printf("%c",w[i]);
}

int main() {
  char x;
  vector<char> w;
  while(scanf("%c",&x)!=EOF) {
    if(!isLetter(x)) {
      printReversed(w);
      printf("%c",x);
      w = vector<char>();
    }
    else {
       w.push_back(x);
    }
  }
  printReversed(w);
}
