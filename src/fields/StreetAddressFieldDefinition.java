package fields;

public class StreetAddressFieldDefinition extends CompositeFieldDefinition{

	/*public StreetAddressFieldDefinition(String name){
		super(name);
	}*/
	
	public StreetAddressFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
	//SEQ	COMPONENT NAME				Data Type	Usage	LEN		Conditional Predicate	Value Set	COMMENTS
		this.components = new Hl7FieldDefinition[]{
	//1		Street or Mailing Address	ST			R		1..120
			Hl7FieldGenerator.define("ST").withName("StreetOrMailingAddress").required().length(1, 120),
	//2		Street Name					ST			O
			Hl7FieldGenerator.define("ST").withName("StreetName").optional(),
	//3		Dwelling Number				ST			O
			Hl7FieldGenerator.define("ST").withName("DwellingNumber").optional()
		};
	}

	public String getFieldType(){
		return "SAD";
	}
}
