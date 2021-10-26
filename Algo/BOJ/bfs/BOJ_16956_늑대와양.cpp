#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
char a[501][501];
bool check[501][501];
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int r, c;
	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		cin >> a[i];
	}
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (a[i][j] == 'W') {
				int x = i;
				int y = j;
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || nx >= r || ny >= c || ny < 0) {
						continue;
					}
					if (a[nx][ny] == '.') {
						a[nx][ny] = 'D';
					}
					else if (a[nx][ny] == 'S') {
						cout << 0 << '\n';
						return 0;
					}
					else {
						continue;
					}
				}
			}
		}
	}
	cout << 1 << '\n';
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cout << a[i][j];
		}
		cout << '\n';
	}

	return 0;
}