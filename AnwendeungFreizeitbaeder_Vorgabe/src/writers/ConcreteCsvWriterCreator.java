package writers;

public class ConcreteCsvWriterCreator extends WriterCreator {

	@Override
	public ConcreteCsvWriterProduct factoryMethod() {
		return new ConcreteCsvWriterProduct();
	}

}
