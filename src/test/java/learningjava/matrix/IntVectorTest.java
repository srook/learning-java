package learningjava.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class IntVectorTest {

	private NDimMatrix intVector;

	@BeforeEach
	void initVector() {
		this.intVector = new IntVector(new int[]{ 1, 3, 7, 2 });
	}

	@Test
	void getSize_ShouldReturnNumberOfElements() {
		assertEquals(4, this.intVector.getSize(0));
	}

	@Test
	void getScalarAt_ShouldReturnScalarAtPosition() {
		assertEquals(3, this.intVector.getScalarAt(new ArrayList<>(Arrays.asList(1))));
		assertEquals(2, this.intVector.getScalarAt(new ArrayList<>(Arrays.asList(3))));
	}

	@Test
	void add_ShouldAddTwoVectors() {
		NDimMatrix intVector2 = new IntVector(new int[]{ 3, 0, 5, -3 });
		NDimMatrix added = this.intVector.add(intVector2);

		assertEquals(4, added.getScalarAt(new ArrayList<>(Arrays.asList(0))));
		assertEquals(3, added.getScalarAt(new ArrayList<>(Arrays.asList(1))));
		assertEquals(12, added.getScalarAt(new ArrayList<>(Arrays.asList(2))));
		assertEquals(-1, added.getScalarAt(new ArrayList<>(Arrays.asList(3))));
	}

	@Test
	void scaleBy_ShouldScaleVector() {
		NDimMatrix added = this.intVector.scaleBy(3);

		assertEquals(3, added.getScalarAt(new ArrayList<>(Arrays.asList(0))));
		assertEquals(9, added.getScalarAt(new ArrayList<>(Arrays.asList(1))));
		assertEquals(21, added.getScalarAt(new ArrayList<>(Arrays.asList(2))));
		assertEquals(6, added.getScalarAt(new ArrayList<>(Arrays.asList(3))));
	}

	@Test
	void getSubMatrices_ShouldThrowUnsupportedOperationException() {
		assertThrows(UnsupportedOperationException.class, () -> { this.intVector.getSubMatrices(); });
	}

	@Test
	void toString_ShouldJoinVectorValuesUsingSpace() {
		assertEquals("1 3 7 2", this.intVector.toString());
	}

	@Test
	void equals_ShouldBeEqualIfValuesAreEqual() {
		NDimMatrix equalVector = new IntVector(new int[]{1, 3, 7, 2});
		assertTrue(this.intVector.equals(equalVector));
	}

	@Test
	void equals_ShouldNotBeEqualIfValuesAreNotEqual() {
		NDimMatrix equalVector = new IntVector(new int[]{3, 7, 2, 1});
		assertFalse(this.intVector.equals(equalVector));
	}

	@Test
	void hashCode_ShouldBeEqual() {
		NDimMatrix equalVector = new IntVector(new int[]{1, 3, 7, 2});
		assertEquals(this.intVector.hashCode(), equalVector.hashCode());
	}

	@Test
	void hashCode_ShouldBeNotBeEqual() {
		NDimMatrix equalVector = new IntVector(new int[]{2, 1, 3, 7});
		assertNotEquals(this.intVector.hashCode(), equalVector.hashCode());
	}
}
