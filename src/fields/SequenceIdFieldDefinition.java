package fields;

public class SequenceIdFieldDefinition extends UnsignedIntegerFieldDefinition{

	public SequenceIdFieldDefinition(String name){
		super(name);
	}
	
	public SequenceIdFieldDefinition(){
		super();
		//1 Sequence ID NM 1..4
		this.length(1, 4);
	}

	@Override
	public String getFieldType() {
		// TODO Auto-generated method stub
		return "SI";
	}
}
