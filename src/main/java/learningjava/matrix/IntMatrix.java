package learningjava.matrix;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntMatrix implements NDimMatrix {
	private final static Integer N = 2;

	private List<NDimMatrix> vectors = new ArrayList<>();

	public IntMatrix(int[][] matrix) {
		for (int[] vector : matrix) {
			this.vectors.add(new IntVector(vector));
		}
	}

	public IntMatrix(List<NDimMatrix> matrix) {
		this.vectors = matrix;
	}

	@Override
	public int getNumOfDimensions() {
		return N;
	}

	@Override
	public int getSize(int p_dim) {
		switch (p_dim) {
			case 0:
				return this.vectors.size();
			case 1:
				return this.vectors.get(0).getSize(0);
			default:
				return 0;
		}
	}

	@Override
	public int getScalarAt(List<Integer> p_indices) {
		return this.vectors.get(p_indices.remove(0)).getScalarAt(p_indices);
	}

	@Override
	public NDimMatrix add(NDimMatrix p_matrix) {
		if (p_matrix.getClass() != IntMatrix.class) {
			throw new ClassCastException();
		}

		return new IntMatrix(IntStream.range(0, this.vectors.size())
				.mapToObj( i -> this.vectors.get(i).add(p_matrix.getSubMatrices().get(i)) )
				.collect(
					() -> new ArrayList<NDimMatrix>(),
					(l, i) -> l.add(i),
					(l1, l2) -> l1.addAll(l2)
				)
		);
	}

	@Override
	public NDimMatrix scaleBy(int p_value) {
		return new IntMatrix(this.vectors.stream().map( v -> v.scaleBy(p_value) )
				.collect(
						() -> new ArrayList<NDimMatrix>(),
						(l, i) -> l.add(i),
						(l1, l2) -> l1.addAll(l2)
				)
		);
	}

	@Override
	public List<NDimMatrix> getSubMatrices() {
		return this.vectors;
	}

	@Override
	public String toString() {
		return String.join("; ", this.vectors.stream().map( v -> v.toString() ).collect(Collectors.toList())) + ";";
	}

	@Override
	public boolean equals (Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) { return false; }
		IntMatrix intMatrix= (IntMatrix) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder();
		IntStream.range(0, this.vectors.size())
				.forEach( i -> equalsBuilder.append(this.getSubMatrices().get(i), intMatrix.getSubMatrices().get(i)) );
		return equalsBuilder.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.vectors);
		return builder.hashCode();
	}
}
