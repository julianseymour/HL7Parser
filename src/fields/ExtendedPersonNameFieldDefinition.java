package fields;

public class ExtendedPersonNameFieldDefinition extends CompositeFieldDefinition{

	/*public ExtendedPersonNameFieldDefinition(String name){
		super(name);
	}*/
	
	public ExtendedPersonNameFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		//SEQ	COMPONENT NAME										Data Type	Usage	LEN	Conditional Predicate	Value Sets	COMMENTS
		this.components = new Hl7FieldDefinition[]{
		//1		Family Name											FN			R
			Hl7FieldGenerator.define("FN").withName("FamilyName").required(),
		//2		Given Name											ST			R		30
			Hl7FieldGenerator.define("ST").withName("GivenName").required().length(30, 30),
		//3		Second and Further Given Names or Initials Thereof	ST			RE		30
			Hl7FieldGenerator.define("ST").withName("FurtherNames").requiredEmpty().length(30, 30),
		//4		Suffix (e.g., JR or III)							ST			O
			Hl7FieldGenerator.define("ST").withName("Suffix").optional(),
		//5		Prefix (e.g., DR)									ST			O
			Hl7FieldGenerator.define("ST").withName("Prefix").optional(),
		//6		Degree (e.g., MD)									IS			X												Use Professional suffix in sequence 14
			Hl7FieldGenerator.define("IS").withName("Degree").unsupported(),
		//7		Name Type Code										ID			RE		1							HL70200
			Hl7FieldGenerator.define("ID").withName("NameTypeCode").requiredEmpty(),
		//8		Name Representation Code							ID			O
			Hl7FieldGenerator.define("ID").withName("NameRepresentationCode").optional(),
		//9		Name Context										CE			O
			Hl7FieldGenerator.define("CE").withName("NameContext").optional(),
		//10	Name Validity Range									DR			X
			Hl7FieldGenerator.define("DR").withName("NameValidityRange").unsupported(),
		//11	Name Assembly Order									ID			O
			Hl7FieldGenerator.define("ID").withName("NameAssemblyOrder").optional(),
		//12	Effective Date										TS			O
			Hl7FieldGenerator.define("TS").withName("EffectiveDate").optional(),
		//13	Expiration Date										TS			O
			Hl7FieldGenerator.define("TS").withName("ExpirationDate").optional(),
		//14	Professional Suffix									ST			O
			Hl7FieldGenerator.define("ST").withName("ProfessionalSuffix").optional()
		};
	}

	public String getFieldType(){
		return "XPN";
	}
}
