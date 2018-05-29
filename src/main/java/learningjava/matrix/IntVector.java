package learningjava.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IntVector implements NDimMatrix {
	private final static Integer N = 1;
	private int[] vector;

	public IntVector(int[] values) {
		this.vector = values;
	}

	@Override
	public int getNumOfDimensions() {
		return N;
	}

	@Override
	public int getSize(int p_dim) {
		return this.vector.length;
	}

	@Override
	public int getScalarAt(List<Integer> p_indices) {
		if (p_indices.size() != 1) {
			throw new IllegalArgumentException();
		}
		return this.vector[p_indices.get(0)];
	}

	@Override
	public NDimMatrix add(NDimMatrix p_matrix) {
		if (p_matrix.getClass() != IntVector.class) {
			throw new ClassCastException();
		}

		List<Integer> addedVector = new ArrayList<>();
		IntStream.range(0, this.getSize(0))
				.forEach( i -> {
					List<Integer> atList = new ArrayList<Integer>(Arrays.asList(i));
					addedVector.add(this.getScalarAt(atList) + p_matrix.getScalarAt(atList));
				});
		return new IntVector(addedVector.stream().mapToInt(Integer::intValue).toArray());
	}

	@Override
	public NDimMatrix scaleBy(int p_value) {
		return new IntVector(IntStream.of(this.vector).map(i -> i * p_value).toArray());
	}

	@Override
	public List<NDimMatrix> getSubMatrices() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return IntStream.of(this.vector).mapToObj(Integer::toString).collect(Collectors.joining(" "));
	}

	@Override
	public boolean equals (Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) { return false; }
		IntVector intVector = (IntVector) obj;
		if (intVector.getSize(0) != this.vector.length) { return false; }

		int[] obj_vector = new int[this.vector.length];
		IntStream.range(0, this.getSize(0))
				.forEach( i -> obj_vector[i] = intVector.getScalarAt(new ArrayList<>(Arrays.asList(i))) );
		return new EqualsBuilder()
				.append(this.vector, obj_vector)
				.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.vector);
		return builder.hashCode();
	}
}
