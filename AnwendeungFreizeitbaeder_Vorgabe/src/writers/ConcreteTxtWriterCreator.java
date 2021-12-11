package writers;

public class ConcreteTxtWriterCreator extends WriterCreator {

	@Override
	public ConcreteTxtWriterProduct factoryMethod() {
		return new ConcreteTxtWriterProduct();
	}

}
