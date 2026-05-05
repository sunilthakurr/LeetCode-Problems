class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidColumn(board) && isValidSubBox(board);
    }

    private boolean isValidRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValid(board[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            char[] row = new char[9];
            for (int j = 0; j < board.length; j++) {
                row[j] = board[j][i];
            }
            if (!isValid(row)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSubBox(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j+= 3) {
                
                char[] row = new char[9];
                int idx = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        row[idx++] = board[x][y];
                    }
                }
                if (!isValid(row)) {
                    return false;
                }
            }
        }
        return true;
    } 

    private boolean isValid(char[] board) {
        Set<Character> set = new HashSet<>();

        for (char ch: board) {
            if (ch == '.') continue;
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}