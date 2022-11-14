package fields;

public class CodedElementTextOnlyFieldDefinition extends CompositeFieldDefinition{

	/*public CodedElementTextOnlyFieldDefinition(String name){
		super(name);
	}*/
	
	public CodedElementTextOnlyFieldDefinition(){
		super();
	}
	
	protected void generateComponents() {
			//SEQ	Component Name			Data Type	Usage	LEN 	Comments
		this.components = new Hl7FieldDefinition[]{
			//1		Identifier				ST			X
				Hl7FieldGenerator.define("ST").withName("Identifier").unsupported(),
			//2		Text 					ST			R		999		Human readable text that is not further processed. It may be stored by the receiving system.
				Hl7FieldGenerator.define("ST").withName("Text").required().length(999, 999),
			//3		Name of Coding			ID			X
				Hl7FieldGenerator.define("ID").withName("NameOfCoding").unsupported(),
			//4		Alternate Identifier	ST			X
				Hl7FieldGenerator.define("ST").withName("AlternateIdentifier").unsupported(),
			//5		Alternate Text			ST			X
				Hl7FieldGenerator.define("ST").withName("AlternateText").unsupported(),
			//6		Name of Alternate		ID			X
				Hl7FieldGenerator.define("ID").withName("NameOfAlternate").unsupported()
		};
	}

	public String getFieldType(){
		return "CE_TX";
	}
}
