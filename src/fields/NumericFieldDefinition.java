package fields;

public class NumericFieldDefinition extends AbstractNumericFieldDefinition{

	public NumericFieldDefinition(String name){
		super(name);
	}
	
	public NumericFieldDefinition(){
		super();
		this.length(1, 16);
	}

	public String getFieldType(){
		return "NM";
	}
}
