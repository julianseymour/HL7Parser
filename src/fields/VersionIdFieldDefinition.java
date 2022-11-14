package fields;

public class VersionIdFieldDefinition extends CompositeFieldDefinition{

	/*public VersionIdFieldDefinition(String name){
		super(name);
	}*/
	
	public VersionIdFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
	//SEQ	COMPONENT NAME				Data Type	Usage	LEN		Conditional Predicate	Value Set				COMMENTS
		this.components = new Hl7FieldDefinition[]{
	//1		Version ID					ID			R		5..5							HL70104 (constrained)
			Hl7FieldGenerator.define("ID").withName("VersionId").required().length(5, 5),
	//2		Internationalization Code	CE			O
			Hl7FieldGenerator.define("CE").withName("InternationalizationCode").optional(),
	//3		International Version ID	CE			O
			Hl7FieldGenerator.define("CE").withName("InternationalVersionId").optional()
		};
	}

	public String getFieldType(){
		return "VID";
	}
}
