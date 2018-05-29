package learningjava.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntMatrixTest {
	private NDimMatrix intMatrix;

	@BeforeEach
	void initVector() {
		int[][] values = { {1,3}, {3,5}, {5,7} };
		this.intMatrix = new IntMatrix(values);
	}

	@Test
	void getSize_ReturnsSizeForDimension() {
		assertEquals(3, this.intMatrix.getSize(0));
		assertEquals(2, this.intMatrix.getSize(1));
	}

	@Test
	void getScalarAt_ShouldReturnScalarAtPosition() {
		List<Integer> list = new ArrayList<>();
		assertEquals(7, this.intMatrix.getScalarAt(new ArrayList<>(Arrays.asList(2,1))));
	}

	@Test
	void add_ShouldAddTwoMatrices() {
		int[][] values = { {2,6}, {6,10}, {10,14} };
		NDimMatrix intMatrix2 = new IntMatrix(values);
		NDimMatrix added = this.intMatrix.add(intMatrix2);

		assertEquals(3, added.getScalarAt(new ArrayList<>(Arrays.asList(0,0))));
		assertEquals(15, added.getScalarAt(new ArrayList<>(Arrays.asList(1,1))));
		assertEquals(15, added.getScalarAt(new ArrayList<>(Arrays.asList(2,0))));
		assertEquals(21, added.getScalarAt(new ArrayList<>(Arrays.asList(2,1))));
	}

	@Test
	void scaleBy_ShouldScaleMatrix() {
		NDimMatrix scale = this.intMatrix.scaleBy(2);

		assertEquals(2, scale.getScalarAt(new ArrayList<>(Arrays.asList(0,0))));
		assertEquals(10, scale.getScalarAt(new ArrayList<>(Arrays.asList(1,1))));
		assertEquals(10, scale.getScalarAt(new ArrayList<>(Arrays.asList(2,0))));
		assertEquals(14, scale.getScalarAt(new ArrayList<>(Arrays.asList(2,1))));
	}

	@Test
	void toString_ShouldJoinVectors() {
		assertEquals("1 3; 3 5; 5 7;", this.intMatrix.toString());
	}

	@Test
	void equals_ShouldBeEqualIfAllValuesAreSame() {
		int[][] values = { {1,3}, {3,5}, {5,7} };
		assertTrue(this.intMatrix.equals(new IntMatrix(values)));
	}

	@Test
	void equals_ShouldBeNotEqualIfAllValuesAreNotSame() {
		int[][] values = { {1,3}, {3,5}, {5,6} };
		assertFalse(this.intMatrix.equals(new IntMatrix(values)));
	}

	@Test
	void hashCode_ShouldBeSameForEqualMatrices() {
		int[][] values = { {1,3}, {3,5}, {5,7} };
		assertEquals(this.intMatrix.hashCode(), new IntMatrix(values).hashCode());
	}
}
