package com.onefit.HashtableAndArrays;

import java.util.LinkedList;
import java.util.List;

public class ZeroMatrix {

	public static void main(String[] args) {

		check4x4Matrix();
		checkWhenFirstColHasZero();
	}
	
	public static void checkWhenFirstColHasZero() {
		int[][] inputMatrix = {
				{ 1, 2, 0, 4 },
				{ 1, 2, 3, 4 },
				{ 0, 2, 3, 4 },
				{ 1, 2, 3, 4 },
				{ 1, 2, 2, 4 },
		};
		
		int[][] outputMatrix = {
				{ 0, 0, 0, 0 },
				{ 0, 2, 0, 4 },
				{ 0, 0, 0, 0 },
				{ 0, 2, 0, 4 },
				{ 0, 2, 0, 4 },
		};
		
		MakeZeroRowsAndColumns(inputMatrix);
		
		assert compareMatrixes(inputMatrix, outputMatrix);
	}
	
	public static void check4x4Matrix() {
		int[][] inputMatrix = {
				{ 1, 2, 3, 4 },
				{ 1, 2, 3, 4 },
				{ 1, 0, 3, 4 },
				{ 1, 2, 3, 4 },
				{ 1, 2, 0, 4 },
		};
		
		int[][] outputMatrix = {
				{ 1, 0, 0, 4 },
				{ 1, 0, 0, 4 },
				{ 0, 0, 0, 0 },
				{ 1, 0, 0, 4 },
				{ 0, 0, 0, 0 },
		};
		
		MakeZeroRowsAndColumns(inputMatrix);
		
		assert compareMatrixes(inputMatrix, outputMatrix);
	}
	
	public static boolean compareMatrixes(int[][] input, int[][] output) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] != output[i][j]) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	static class Tuple {
		public final int row;
		public final int col;
		public Tuple(int row, int col) {
			this.col = col;
			this.row = row;
		}
	}

	private static void MakeZeroRowsAndColumns(int[][] input) {
		//TODO checks for edge cases
		boolean shouldSetFirstRowToZero = false;
		boolean shouldSetFirstColToZero = false;
		for (int row = 0; row < input.length; row ++) {
			if (input[row][0] == 0) {
				shouldSetFirstColToZero = true;
				break;
			}			
		}
		
		for (int col = 0; col < input[0].length; col ++) {
			if (input[0][col] == 0) {
				shouldSetFirstRowToZero = true;
				break;
			}			
		}
		
		for (int i = 1; i < input.length; i++) {
			for (int j = 1; j < input[0].length; j++) {
				if (input[i][j] == 0) {
					input[i][0] = 0;
					input[0][j] = 0;
				}
			}			
		}
		
		for (int row = 0; row < input.length; row ++) {
			if (input[row][0] == 0) {
				for (int i = 0 ; i < input[0].length; i ++) {
					input[row][i] = 0;
				}
			}			
		}
		for (int col = 0; col < input[0].length; col ++) {
			if (input[0][col] == 0) {
				for (int i = 0 ; i < input.length; i ++) {
					input[i][col] = 0;
				}
			}			
		}
		
		if (shouldSetFirstColToZero) {
			for (int row = 0; row < input.length; row ++) {
				input[row][0] = 0;		
			}
		}
		if (shouldSetFirstRowToZero) {
			for (int col = 0; col < input[0].length; col ++) {
				input[0][col] = 0;		
			}
		}
	}
	
	private static void MakeZeroRowsAndColumns_WithTuple(int[][] input) {
		//TODO checks for edge cases
		List<Tuple> zeroIndex = new LinkedList<Tuple>();
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == 0) {
					zeroIndex.add(new Tuple(i, j));
				}
			}			
		}
		for (Tuple index: zeroIndex) {
			for (int row = 0 ; row < input.length; row ++) {
				input[row][index.col] = 0;
			}
			for (int col = 0 ; col < input[0].length; col ++) {
				input[index.row][col] = 0;
			}
		}
	}

}
