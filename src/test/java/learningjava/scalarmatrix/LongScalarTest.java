package learningjava.scalarmatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongScalarTest {

	private static final Scalar scalar = new LongScalar(7);

	@Test
	void asDouble_ShouldReturnDouble() {
		assertEquals((double) 7, this.scalar.asDouble());
	}

	@Test
	void asLong_ShouldReturnDouble() {
		assertEquals((long) 7, this.scalar.asLong());
	}

	@Test
	void add_ShouldReturnLongScalar() {
		assertTrue(this.scalar.add(new LongScalar(5)) instanceof LongScalar);
	}

	@Test
	void add_ShouldReturnDoubleScalar() {
		assertTrue(this.scalar.add(new DoubleScalar(5)) instanceof DoubleScalar);
	}

	@Test
	void mul_ShouldReturnLongScalar() {
		assertTrue(this.scalar.mul(new LongScalar(5)) instanceof LongScalar);
	}

	@Test
	void mul_ShouldReturnDoubleScalar() {
		assertTrue(this.scalar.mul(new DoubleScalar(5)) instanceof DoubleScalar);
	}

	@Test
	void hashCode_shouldBeEqualForSameValue() {
		LongScalar scalar2 = new LongScalar(7);
		assertEquals(scalar2.hashCode(), this.scalar.hashCode());
	}

	@Test
	void hashCode_shouldNotBeEqualForDifferentValue() {
		LongScalar scalar2 = new LongScalar(10);
		assertNotEquals(scalar2.hashCode(), this.scalar.hashCode());
	}

	@Test
	void equals_ShouldBeEqual() {
		LongScalar scalar2 = new LongScalar(7);
		assertTrue(scalar2.equals(this.scalar));
	}

	@Test
	void equals_ShouldNotBeEqual() {
		LongScalar scalar2 = new LongScalar(8);
		assertFalse(scalar2.equals(this.scalar));
	}
}
