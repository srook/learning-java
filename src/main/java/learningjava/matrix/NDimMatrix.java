package learningjava.matrix;

import java.util.List;

public interface NDimMatrix {
	int getNumOfDimensions();
	int getSize(int p_dim);
	int getScalarAt(List<Integer> p_indices);
	NDimMatrix add(NDimMatrix p_matrix);
	NDimMatrix scaleBy(int p_value);
	List<NDimMatrix> getSubMatrices();
	String toString();
	boolean equals(Object o);
}
