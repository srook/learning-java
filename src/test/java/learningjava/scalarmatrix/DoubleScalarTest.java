package learningjava.scalarmatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleScalarTest {

	private Scalar scalar = new DoubleScalar(7);

	@Test
	void asDouble_ShouldReturnDouble() {
		assertEquals((double) 7, this.scalar.asDouble());
	}

	@Test
	void asLong_ShouldReturnDouble() {
		assertEquals((long) 7, this.scalar.asLong());
	}

	@Test
	void add_ShouldReturnDoubleScalar() {
		assertTrue(this.scalar.add(new LongScalar(5)) instanceof DoubleScalar);
		assertTrue(this.scalar.add(new DoubleScalar(5)) instanceof DoubleScalar);
	}

	@Test
	void mul_ShouldReturnLongScalar() {
		assertTrue(this.scalar.mul(new LongScalar(5)) instanceof DoubleScalar);
		assertTrue(this.scalar.mul(new DoubleScalar(5)) instanceof DoubleScalar);
	}

	@Test
	void hashCode_shouldBeEqualForSameValue() {
		DoubleScalar scalar2 = new DoubleScalar(7);
		assertEquals(scalar2.hashCode(), this.scalar.hashCode());
	}

	@Test
	void hashCode_shouldNotBeEqualForDifferentValue() {
		DoubleScalar scalar2 = new DoubleScalar(10);
		assertNotEquals(scalar2.hashCode(), this.scalar.hashCode());
	}

	@Test
	void equals_ShouldBeEqual() {
		DoubleScalar scalar2 = new DoubleScalar(7);
		assertTrue(scalar2.equals(this.scalar));
	}

	@Test
	void equals_ShouldNotBeEqual() {
		DoubleScalar scalar2 = new DoubleScalar(8);
		assertFalse(scalar2.equals(this.scalar));
	}

}
