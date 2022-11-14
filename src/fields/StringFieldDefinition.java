package fields;

public class StringFieldDefinition extends AbstractStringFieldDefinition{
	
	public StringFieldDefinition(String name){
		super(name);
	}
	
	public StringFieldDefinition(){
		super();
	}

	public String getFieldType(){
		return "ST";
	}
}
