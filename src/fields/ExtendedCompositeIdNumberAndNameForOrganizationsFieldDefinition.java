package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class ExtendedCompositeIdNumberAndNameForOrganizationsFieldDefinition extends CompositeFieldDefinition{

	/*public ExtendedCompositeIdNumberAndNameForOrganizationsFieldDefinition(String name){
		super(name);
	}*/
	
	public ExtendedCompositeIdNumberAndNameForOrganizationsFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
		//SEQ	COMPONENT NAME				Data Type	Usage	LEN		Conditional Predicate							Value Set	COMMENTS
		//1		Organization Name			ST			RE		1..50
			Hl7FieldGenerator.define("ST").withName("OrganizationName").requiredEmpty().length(1, 50),
		//2		Organization Name Type Code	IS			O
			Hl7FieldGenerator.define("IS").withName("OrganizationNameTypeCode").optional(),
		//3		ID Number								X
			Hl7FieldGenerator.define("NM").withName("IdNumber").unsupported(),
		//4		Check Digit								O
			Hl7FieldGenerator.define("NM").withName("CheckDigit").optional(),
		//5		Check Digit Scheme						O
			Hl7FieldGenerator.define("ST").withName("CheckDigitScheme").optional(),
		//6		Assigning Authority			HD			C(R/O)			If XON.10 (Organization Identifier) is valued				The Assigning Authority is used to identify the system, application or organization that assigned the ID in Component 10.
			Hl7FieldGenerator.define("HD").withName("AssigningAuthority").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("OrganizationIdentifier") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
		//7		Identifier Type Code		ID			C(R/X)	2..5	If XON.10 (Organization Identifier) is valued	HL70203
			Hl7FieldGenerator.define("ID").withName("IdentifierTypeCode").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("OrganizationIdentifier") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			).length(2, 5),
		//8		Assigning Facility			HD			O
			Hl7FieldGenerator.define("HD").withName("AssigningFacility").optional(),
		//9		Name Representation Code	ID			O
			Hl7FieldGenerator.define("ID").withName("NameRepresentationCode").optional(),
		//10	Organization Identifier		ST			C(R/RE)	1..20	If XON.1 (Organization Name) is not valued
			Hl7FieldGenerator.define("ST").withName("OrganizationIdentifier").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return !context.hasComponentValue("OrganizationName") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_REQUIRED_EMPTY;
					}
				}
			).length(1, 20)
		};
		
	}

	public String getFieldType(){
		return "XON";
	}
}
