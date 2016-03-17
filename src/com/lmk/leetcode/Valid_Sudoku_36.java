package com.lmk.leetcode;

public class Valid_Sudoku_36 {
	 public boolean isValidSudoku(char[][] board) {
	     boolean result = true;
	     int column = board[0].length;
	     int row = board.length;
	     boolean[] flags;
	     
	     boolean[][] xiaoFlags = new boolean[10][10];
	     
	     for (int i = 0; i < row; i++) {
	    	 flags = new boolean[10];
		     for (int j = 0; j < flags.length; j++) {
				flags[j] = false;
			}
			for (int j = 0; j < column; j++) {
				if(board[i][j] != '.'){
					int number = Integer.valueOf(board[i][j]+"");
					if (!flags[number]){
						flags[number] = true;
					}else {
						return false;
					}
				}
				xiaoFlags[i][j] = false;//初始化 小 九宫格 的hash数组
			}
			
		}
	     for (int i = 0; i < column; i++) {
	    	 flags = new boolean[10];
		     for (int j = 0; j < flags.length; j++) {
				flags[j] = false;
			}
			for (int j = 0; j < row; j++) {
				
				if(board[j][i] != '.'){
					//对列进行判断
					int number = Integer.valueOf(board[j][i]+"");
					if (!flags[number]){
						flags[number] = true;
					}else {
						return false;
					}
					//对小九宫格进行判断
					int xuhao = i/3 * 3 + j/3;
					if (!xiaoFlags[xuhao][number]){
						xiaoFlags[xuhao][number] = true;
					}else {
						return false;
					}
				}
			}
		}
	    
	     
	     
	    return result;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Valid_Sudoku_36 test = new Valid_Sudoku_36();
		String[] boardStr = {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		char[][] board = StrToChar(boardStr);
		System.out.println(test.isValidSudoku(board));
	}
	private static char[][] StrToChar(String[] boardStr) {
		char[][] board = new char[boardStr.length][];
		
		for (int i = 0; i < boardStr.length; i++) {
			String temp = boardStr[i];
			board[i] = new char[temp.length()];
			for (int j = 0; j < temp.length(); j++) {
				char c = temp.charAt(j);
				board[i][j] = c;
				System.out.print(c+ " ");
			}
			System.out.println();
		}
		return board;
	}

}
