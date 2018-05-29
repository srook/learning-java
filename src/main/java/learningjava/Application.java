package learningjava;

import learningjava.matrix.*;
import learningjava.scalarmatrix.LongScalar;
import learningjava.scalarmatrix.ScalarMatrix;

public class Application {
	public static void main (String[] args) {
		System.out.println("Matrix sample");
		int[][] values = { {1,3}, {3,5}, {5,7} };
		NDimMatrix m1 = new IntMatrix(values);
		System.out.println(m1);
		NDimMatrix m2 = m1.scaleBy(2);
		System.out.println(m2);
		m1 = m1.add(m2);
		System.out.println(m1);

		System.out.println();
		System.out.println("ScalarMatrix sample");
		long[][] values1 = { {1,2}, {3,4}, {5,6} };
		double[][] values2 = { {7.5, 8.5}, {9.5,10.5}, {11.5,12.5} };
		ScalarMatrix sm1 = new ScalarMatrix(values1);
		ScalarMatrix sm2 = new ScalarMatrix(values2);
		System.out.println(sm1);
		sm1.add(sm2);
		System.out.println(sm1);
		sm1.scaleBy(new LongScalar(2));
		System.out.println(sm1);
	}
}
