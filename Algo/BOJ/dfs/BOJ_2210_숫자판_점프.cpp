#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <set>
using namespace std;
int a[5][5];
int dx[] = { 0,1,0,-1 };
int dy[] = { 1,0,-1,0 };
set <int> ans;

void go(int x, int y, int num, int len) {
	if (len == 6) {
		ans.insert(num);
		return;
	}
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < 5 && nx >= 0 && ny >= 0 && ny < 5)
		{
			go(nx, ny, num * 10 + a[nx][ny], len + 1);
		}
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			cin >> a[i][j];
		}
	}

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++)
		{
			go(i, j, a[i][j], 1);
		}
	}
	cout << ans.size() << '\n';

	return 0;
}