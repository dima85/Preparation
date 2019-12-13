package com.onefit.HashtableAndArrays;

import javax.naming.OperationNotSupportedException;

public class RotateMatrix {

	public static void main(String[] args) throws Exception {
		test4x4Matrix();
		test3x3Matrix();
		test2x2SimpleMatrix();
		test1x1Matrix();
		testEmptyMatrix();
		testNonSquareMatrix();
	}
	
	private static void testNonSquareMatrix() throws Exception {
		int[][] inputMatrix = {
				{ 1, 2, 3 },
				{ 3, 4, 3 }
		};

		try {
			RotateMatrix(inputMatrix);
		} catch (OperationNotSupportedException exception) {
			
		}		
	}
	
	private static void testEmptyMatrix() throws Exception {
		int[][] inputMatrix = new int[0][0];
		int[][] outputMatrix  = new int[0][0];
		
		assertEquals(RotateMatrix(inputMatrix), outputMatrix);		
	}
	
	private static void test1x1Matrix() throws Exception {
		int[][] inputMatrix = {
				{ 1 }
		};
		int[][] outputMatrix = {
				{ 1 }
		};
		
		assertEquals(RotateMatrix(inputMatrix), outputMatrix);		
	}

	private static void test2x2SimpleMatrix() throws Exception {
		int[][] inputMatrix = {
				{ 1, 2 },
				{ 3, 4 }
		};
		int[][] outputMatrix = {
				{ 3, 1 },
				{ 4, 2 }
		};
		
		assertEquals(RotateMatrix(inputMatrix), outputMatrix);
	}
	
	private static void test4x4Matrix() throws Exception {
		int[][] inputMatrix = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16}
		};
		int[][] outputMatrix = {
				{ 13, 9, 5, 1 },
				{ 14, 10, 6, 2 },
				{ 15, 11, 7, 3 },
				{ 16, 12, 8, 4 }
		};
		
		assertEquals(RotateMatrix(inputMatrix), outputMatrix);
	}
	
	private static void test3x3Matrix() throws Exception {
		int[][] inputMatrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		int[][] outputMatrix = {
				{ 7, 4, 1 },
				{ 8, 5, 2 },
				{ 9, 6, 3 }
		};
		
		assertEquals(RotateMatrix(inputMatrix), outputMatrix);
	}

	private static void assertEquals(int[][] matrix1, int[][] matrix2) throws Exception {
		if (matrix1 == null && matrix2 == null) {
			return;
		}
		int lenght = matrix1.length;
		
		for (int i = 0; i < lenght; i++) {
			for (int j = 0; j < lenght; j++) {
				if (matrix1[i][j] != matrix2[i][j]) {
					throw new Exception("Matrixes are not equal");
				}
			}
		}
	}
	
	private static int[][] RotateMatrix(int[][] matrix) throws OperationNotSupportedException {
		if (matrix == null) {
			return null;
		}
		if (matrix.length == 0) {
			return matrix;
		}
		if (matrix.length != matrix[0].length) {
			throw new OperationNotSupportedException("Matrix should be squared");
		}
		
		int length = matrix.length;
		int[] temp = new int[length]; 
		for (int layer = 0; layer < length / 2; layer++) {
			int start = layer;
			int end = length - layer;
		
			//Save top into temp
			for (int j = start; j < end; j++) {
				temp[j] = matrix[start][j];
			}
			//Copy left to top
			for (int j=end - 1, i = start; j >= start; j--, i++) {
				matrix[layer][j] =  matrix[i][layer];
			}
			
			//Copy bottom to left
			for (int i = start; i < end; i++) {
				matrix[i][layer] = matrix[end - 1][i];
			}
			
			//Copy right to bottom
			for (int j = end - 1, i = start; j >= start; j--, i++) {
				matrix[end - 1][i] = matrix[j][end - 1];
			}

			//Copy top to right
			for (int i = start; i < end; i++) {
				matrix[i][end - 1] = temp[i];
			}			
		}
		return matrix;
	}
	
	private static int[][] RotateMatrix_MoreSpace(int[][] inputMatrix) throws OperationNotSupportedException {
		if (inputMatrix == null) {
			return null;
		}
		if (inputMatrix.length == 0) {
			return inputMatrix;
		}
		if (inputMatrix.length != inputMatrix[0].length) {
			throw new OperationNotSupportedException("Matrix should be squared");
		}
		int lenght = inputMatrix.length;
		int[][] outputMatrix = new int[lenght][lenght];
		
		for (int i = 0; i < lenght; i++) {
			for (int j = 0; j < lenght; j++) {
				outputMatrix[i][j] = inputMatrix[lenght - j - 1][i];
			}
		}
		
		return outputMatrix;
	}

}
