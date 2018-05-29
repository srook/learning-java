package learningjava.scalarmatrix;

public interface Scalar {
	long asLong();
	double asDouble();
	Scalar add(Scalar val);
	Scalar mul(Scalar val);
}
