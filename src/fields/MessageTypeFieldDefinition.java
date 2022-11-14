package fields;

public class MessageTypeFieldDefinition extends CompositeFieldDefinition{

	/*public MessageTypeFieldDefinition(String name){
		super(name);
	}*/
	
	public MessageTypeFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
	//SEQ	COMPONENT NAME		Data Type	Usage	LEN		Conditional Predicate	Value Set				COMMENTS
		this.components = new Hl7FieldDefinition[]{
	//1		Message Code		ID			R		3..3							HL70076 (constrained)
			Hl7FieldGenerator.define("ID").withName("MessageCode").required().length(3, 3),
	//2		Trigger Event		ID			R		3..3							HL70003 (constrained)
			Hl7FieldGenerator.define("ID").withName("TriggerEvent").required().length(3, 3),
	//3		Message Structure	ID			R		3..7							HL70354 (constrained)
			Hl7FieldGenerator.define("ID").withName("MessageStructureId").required().length(3, 7)
		};
	}

	public String getFieldType(){
		return "MSG";
	}
}
