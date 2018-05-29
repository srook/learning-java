package learningjava.scalarmatrix;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class LongScalar implements Scalar {
	private final long value;

	public LongScalar(int val) {
		this.value = (long) val;
	}

	public LongScalar(long val) {
		this.value = val;
	}

	@Override
	public long asLong() {
		return this.value;
	}

	@Override
	public double asDouble() {
		return (double) this.value;
	}

	@Override
	public Scalar add(Scalar val) {
		if (val instanceof  DoubleScalar) {
			return new DoubleScalar(this.asDouble() + val.asDouble());
		}
		else {
			return new LongScalar(this.asLong() + val.asLong());
		}
	}

	@Override
	public Scalar mul(Scalar val) {
		if (val instanceof  DoubleScalar) {
			return new DoubleScalar(this.asDouble() * val.asDouble());
		}
		else {
			return new LongScalar(this.asLong() * val.asLong());
		}
	}

	@Override
	public String toString() {
		return Long.toString(this.value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) { return false; }

		return new EqualsBuilder()
				.append(this.asLong(), ((Scalar) obj).asLong())
				.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.value);
		return builder.hashCode();
	}
}
