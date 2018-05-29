package learningjava.scalarmatrix;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ScalarMatrix {
	private Scalar[][] matrix;

	public ScalarMatrix(Scalar[][] matrix) {
		this.matrix = matrix;
	}

	public ScalarMatrix(long[][] matrix) {
		this.matrix = Arrays.stream(matrix).map(v -> LongStream.of(v).mapToObj(l -> new LongScalar(l)).toArray(Scalar[]::new)).toArray(Scalar[][]::new);
	}

	public ScalarMatrix(double[][] matrix) {
		this.matrix = Arrays.stream(matrix).map(v -> DoubleStream.of(v).mapToObj(l -> new DoubleScalar(l)).toArray(Scalar[]::new)).toArray(Scalar[][]::new);
	}

	public Scalar getScalarAt(List<Integer> p_indices) {
		return this.matrix[p_indices.get(0)][p_indices.get(1)];
	}

	public int getRowCount() {
		return this.matrix.length;
	}

	public int getColCount() {
		return this.matrix[0].length;
	}

	public void add(ScalarMatrix p_matrix) {
		if (this.getRowCount() != p_matrix.getRowCount() || this.getColCount() != p_matrix.getColCount()) {
			throw new IllegalArgumentException();
		}

		this.matrix = IntStream.range(0, this.getRowCount())
				.mapToObj(i -> IntStream.range(0, this.getColCount())
						.mapToObj(j -> this.matrix[i][j].add(p_matrix.getScalarAt(new ArrayList<>(Arrays.asList(i, j)))))
						.toArray(Scalar[]::new)
				).toArray(Scalar[][]::new);
	}

	public void scaleBy(Scalar p_value) {
		this.matrix = IntStream.range(0, this.getRowCount())
				.mapToObj(i -> IntStream.range(0, this.getColCount())
						.mapToObj(j -> this.matrix[i][j].mul(p_value))
						.toArray(Scalar[]::new)
				).toArray(Scalar[][]::new);
	}

	public String toString() {
		return Arrays.stream(this.matrix)
				.map( v -> Arrays.stream(v).map( s -> s.toString() ).collect(Collectors.joining(" ")) )
				.collect(Collectors.joining("; ")) + ";";
	}

	public boolean equals (Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) { return false; }

		ScalarMatrix scalarMatrix= (ScalarMatrix) obj;
		EqualsBuilder equalsBuilder = new EqualsBuilder();
		IntStream.range(0, this.getRowCount())
				.forEach(i -> IntStream.range(0, this.getColCount())
						.forEach(j -> equalsBuilder.append(this.matrix[i][j], scalarMatrix.getScalarAt(new ArrayList<>(Arrays.asList(i, j)))))
				);
		return equalsBuilder.isEquals();
	}

	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.matrix);
		return builder.hashCode();
	}

}
