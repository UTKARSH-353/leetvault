class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));
        queue<pair<pair<int,int>, int>> q;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 1;
                    q.push({{i, j}, 0});
                }
            }
        }
        int max_time = 0;
        int row[4] = {-1, 0, 1, 0};
        int col[4] = {0, 1, 0, -1};
        while(!q.empty()){
            int r = q.front().first.first;
            int c = q.front().first.second;
            int time = q.front().second;
            q.pop();
            max_time = max(max_time, time);
            for(int i = 0; i < 4; i++){
                int nr = r + row[i];
                int nc = c + col[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m &&
                   vis[nr][nc] == 0 && grid[nr][nc] == 1){
                    
                    vis[nr][nc] = 1;
                    grid[nr][nc] = 2;   
                    q.push({{nr, nc}, time + 1});
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return max_time;
    }
};
