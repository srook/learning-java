package learningjava.scalarmatrix;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DoubleScalar implements Scalar {
	private final double value;

	public DoubleScalar(int val) {
		this.value = (double) val;
	}

	public DoubleScalar(double val) {
		this.value = val;
	}

	@Override
	public long asLong() {
		return (long) this.value;
	}

	@Override
	public double asDouble() {
		return this.value;
	}

	@Override
	public Scalar add(Scalar val) {
		return new DoubleScalar(this.asDouble() + val.asDouble());
	}

	@Override
	public Scalar mul(Scalar val) {
		return new DoubleScalar(this.asDouble() * val.asDouble());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) { return false; }

		return new EqualsBuilder()
				.append(this.asDouble(), ((Scalar) obj).asDouble())
				.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.value);
		return builder.hashCode();
	}

	@Override
	public String toString() {
		return Double.toString(this.value);
	}
}
