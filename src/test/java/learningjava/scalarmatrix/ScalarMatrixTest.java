package learningjava.scalarmatrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ScalarMatrixTest {

	private ScalarMatrix matrix1;
	private ScalarMatrix matrix2;
	private ScalarMatrix matrix3;
	private ScalarMatrix matrix4;

	@BeforeEach
	public void initMatrix() {
		long[][] values1 = { {1,2}, {3,4}, {5,6} };
		double[][] values2 = { {7.5,8.5}, {9.5,10.5}, {11.5,12.5} };
		double[][] values3 = { {8.5,10.5}, {12.5,14.5}, {16.5,18.5} };
		double[][] values4 = { {17.0,21.0}, {25.0,29.0}, {33.0,37.0} };

		this.matrix1 = new ScalarMatrix(values1);
		this.matrix2 = new ScalarMatrix(values2);
		this.matrix3 = new ScalarMatrix(values3);
		this.matrix4 = new ScalarMatrix(values4);
	}

	@Test
	void toString_ShouldPrintScalarMatrix() {
		assertEquals("1 2; 3 4; 5 6;", this.matrix1.toString());
		assertEquals("7.5 8.5; 9.5 10.5; 11.5 12.5;", this.matrix2.toString());
	}

	@Test
	void getScalarAt_ShouldReturnValueAtPosition() {
		assertEquals(new LongScalar(2), this.matrix1.getScalarAt(new ArrayList<>(Arrays.asList(0, 1))));
		assertEquals(new DoubleScalar(9.5), this.matrix2.getScalarAt(new ArrayList<>(Arrays.asList(1, 0))));
	}

	@Test
	void getRowCount_ShouldReturnNumberOfRows() {
		assertEquals(3, this.matrix1.getRowCount());
	}

	@Test
	void getColCount_ShouldReturnNumberOfColumns() {
		assertEquals(2, this.matrix1.getColCount());
	}

	@Test
	void add_ShouldAddMatrix() {
		this.matrix1.add(this.matrix2);

		assertEquals(new DoubleScalar(8.5), this.matrix1.getScalarAt(new ArrayList<>(Arrays.asList(0,0))));
		assertEquals(new DoubleScalar(12.5), this.matrix1.getScalarAt(new ArrayList<>(Arrays.asList(1,0))));
		assertEquals(new DoubleScalar(14.5), this.matrix1.getScalarAt(new ArrayList<>(Arrays.asList(1,1))));
		assertEquals(new DoubleScalar(18.5), this.matrix1.getScalarAt(new ArrayList<>(Arrays.asList(2,1))));

		assertTrue(this.matrix1.equals(this.matrix3));
	}

	@Test
	void scaleBy_ShouldScaleMatrix() {
		this.matrix3.scaleBy(new LongScalar(2));

		assertEquals(new DoubleScalar(17), this.matrix3.getScalarAt(new ArrayList<>(Arrays.asList(0,0))));
		assertEquals(new DoubleScalar(25), this.matrix3.getScalarAt(new ArrayList<>(Arrays.asList(1,0))));
		assertEquals(new DoubleScalar(29), this.matrix3.getScalarAt(new ArrayList<>(Arrays.asList(1,1))));
		assertEquals(new DoubleScalar(37), this.matrix3.getScalarAt(new ArrayList<>(Arrays.asList(2,1))));

		assertTrue(this.matrix3.equals(this.matrix4));
	}

	@Test
	void hashCode_ShouldBeEqual() {
		long[][] values = { {1,2}, {3,4}, {5,6} };
		ScalarMatrix matrix = new ScalarMatrix(values);
		assertEquals(this.matrix1.hashCode(), matrix.hashCode());
	}

	@Test
	void equals_ShouldReturnTrue() {
		long[][] values = { {1,2}, {3,4}, {5,6} };
		ScalarMatrix matrix = new ScalarMatrix(values);
		assertTrue(this.matrix1.equals(matrix));
	}
}
