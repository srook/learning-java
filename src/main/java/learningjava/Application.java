package learningjava;

import learningjava.matrix.*;
import learningjava.scalarmatrix.LongScalar;
import learningjava.scalarmatrix.ScalarMatrix;

public class Application {
	public static void main (String[] args) {
		int[][] values = { {1,3}, {3,5}, {5,7} };
		NDimMatrix m1 = new IntMatrix(values);
		System.out.println(m1);
		NDimMatrix m2 = m1.scaleBy(2);
		System.out.println(m2);
		m1 = m1.add(m2);
		System.out.println(m1);
	}
}
