package fields;

public class FamilyNameFieldDefinition extends CompositeFieldDefinition{

	/*public FamilyNameFieldDefinition(String name){
		super(name);
	}*/
	
	public FamilyNameFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		//SEQ	COMPONENT NAME						Data Type	Usage	LEN		Conditional Predicate	Value Set	COMMENTS
		this.components = new Hl7FieldDefinition[]{
		//1		Surname								ST			R		1..50
			Hl7FieldGenerator.define("ST").withName("Surname").required().length(1, 50),
		//2		Own Surname Prefix					ST			O
			Hl7FieldGenerator.define("ST").withName("OwnSurnamePrefix").optional(),
		//3		Own Surname							ST			O
			Hl7FieldGenerator.define("ST").withName("OwnSurname").optional(),
		//4		Surname Prefix From Partner/Spouse	ST			O
			Hl7FieldGenerator.define("ST").withName("PartnerSurnamePrefix").optional(),
		//5		Surname From Partner/Spouse			ST			O
			Hl7FieldGenerator.define("ST").withName("PartnerSurname").optional()
		};
	}

	public String getFieldType(){
		return "FN";
	}
}
