package fields;

public class ProcessingTypeFieldDefinition extends CompositeFieldDefinition{

	/*public ProcessingTypeFieldDefinition(String name){
		super(name);
	}*/
	
	public ProcessingTypeFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		//SEQ	COMPONENT NAME	Data Type	Usage	LEN		Conditional Predicate	Value Set	COMMENTS
		this.components = new Hl7FieldDefinition[]{
		//1		Processing ID	ID			R		1..1							HL70103
			Hl7FieldGenerator.define("ID").withName("ProcessingId").required().length(1,  1),
		//2		Processing Mode	ID			O
			Hl7FieldGenerator.define("ID").withName("ProcessingMode").optional()
		};
	}

	public String getFieldType(){
		return "PT";
	}
}
