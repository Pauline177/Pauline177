/**
 * @author paulinemakoma
 * Assignment: Percolation
 * date: 02/08/2020
 */
package perc;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int T;
    private double[] percentage;

    public PercolationStats(int N, int T) {
        
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.T = T;
        this.percentage = new double[T];
        for (int i = 0; i < T; i++) {
            int count = 0;
            Percolation percolation = new Percolation(N);
            while (!percolation.percolates()) {
                int x, y;
                do {
                    x = StdRandom.uniform(N) + 1;
                    y = StdRandom.uniform(N) + 1;
                } while (percolation.isOpen(x, y));
                percolation.open(x, y);
                count++;
            }
            percentage[i] = (double) count / N / N;
        }
    }

    public double mean() {
        return StdStats.mean(percentage);
    }

    public double stddev() {
        return StdStats.stddev(percentage);
    }
    
    public double confidenceLo() {
        return StdStats.mean(percentage) - 1.96 * StdStats.stddev(percentage) / Math.sqrt(T);
    }

    public double confidenceHi() {
        return StdStats.mean(percentage) + 1.96 * StdStats.stddev(percentage) / Math.sqrt(T);
    }

    public static void main(String[] args) {
        int n = 2;
        int t = 10000;
        PercolationStats stats = new PercolationStats(n, t);
        System.out.println(stats.mean() + "");
        System.out.println(stats.stddev() + "");
        System.out.println(stats.confidenceLo() + " " + stats.confidenceHi());
    }
}
