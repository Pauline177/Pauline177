/**
 * @author: paulinemakoma
 * Assignment: Percolation
 * date: 02/08/2020
 */

package perc;
// Program Percolation
// Author Christian Makoma
// Created Feb 11, 2020

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[] grid;
	private WeightedQuickUnionUF percolationChecker;
	private WeightedQuickUnionUF unionFind;
	private int size;
	private int virtualTop;
	private int virtualBottom;
	
	/**
	 * Create N by N grid, with all sites blocked
	 * @param N length and width
	 */
	public Percolation(int N) {
		if (N < 1) throw new IllegalArgumentException("Size must be greater than 0");
		size = N;
		virtualTop = N*N;
		virtualBottom = N*N + 1;
		percolationChecker = new WeightedQuickUnionUF((N*N) + 2);
		unionFind = new WeightedQuickUnionUF((N*N) + 1);
		grid = new boolean[N*N];
		for (int i = 0; i < N*N; i++) {
			grid[i] = false;
		}
	}
	
	/**
	 * @param i row
	 * @param j column
	 */
	public void open(int i, int j) {
		isValidInput(i, j);
		grid[oneDimensional(i, j)] = true;
		
		if (j < size - 1  && isOpen(i, j + 1))
			union(oneDimensional(i, j), oneDimensional(i, j) + 1);
		
		if (j > 0 && isOpen(i, j - 1))
			union(oneDimensional(i, j), oneDimensional(i, j) - 1);
		
		if (i > 0 && isOpen(i - 1, j))
			union(oneDimensional(i, j), oneDimensional(i, j) - size);
		else if (i == 0)
			union(oneDimensional(i, j), virtualTop);
		
		if (i < size - 1 && isOpen(i + 1, j))
			union(oneDimensional(i, j), oneDimensional(i, j) + size);
		else if (i == size - 1)
			percolationChecker.union(oneDimensional(i, j), virtualBottom);
	}
	
	/** 
	 * @param i row
	 * @param j column
	 * @return true or false
	 */
	public boolean isOpen(int i, int j) {
		isValidInput(i, j);
		return grid[oneDimensional(i, j)] == true;
	}
	
	/**
	 * @param i row
	 * @param j column
	 * @return true or false
	 */
	public boolean isFull(int i, int j) {
		isValidInput(i, j);
		return unionFind.connected(oneDimensional(i, j), virtualTop);
	}
	
	/**
	 * Checking for percolation
	 * @return
	 */
	public boolean percolates() {
		return percolationChecker.connected(virtualTop, virtualBottom);
	}
	
	private int oneDimensional(int i, int j) {
		return (i * size) + j;
	}
	
	/**
	 * @param i row
	 * @param j column
	 */
	private void isValidInput(int i, int j) {
		if (i < 0 || i > (size-1))
			throw new IndexOutOfBoundsException("row index i = " + i + " must be between 0 and " + (size-1));
		if (j < 0 || j > (size-1))
			throw new IndexOutOfBoundsException("column index j = " + j + " must be between 0 and " + (size-1));
	}
	
	private void union(int p, int q) {
		percolationChecker.union(p, q);
		unionFind.union(p, q);
	}

}