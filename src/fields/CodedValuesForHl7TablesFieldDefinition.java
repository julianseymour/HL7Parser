package fields;

public class CodedValuesForHl7TablesFieldDefinition extends AbstractStringFieldDefinition{

	public CodedValuesForHl7TablesFieldDefinition(){
		super();
		//1 Coded Value for HL7-defined Tables 1..15
		this.length(1, 15);
	}
	
	public CodedValuesForHl7TablesFieldDefinition(String name){
		super(name);
	}

	public String getFieldType(){
		return "ID";
	}
}
