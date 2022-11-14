package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class ExtendedCompositeIdNumberAndNameForPersonsFieldDefinition extends CompositeFieldDefinition{

	/*public ExtendedCompositeIdNumberAndNameForPersonsFieldDefinition(String name){
		super(name);
	}*/
	
	public ExtendedCompositeIdNumberAndNameForPersonsFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
		//SEQ	COMPONENT NAME										Data Type	Usage	LEN		Conditional Predicate										Value Set	COMMENTS
		//1		ID Number											ST			C(R/RE) 1..15	If XCN.2.1 (Surname) and XCN.3 (Given Name) are not valued
			Hl7FieldGenerator.define("ST").withName("IdNumber").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return !context.hasSubcomponentValue("FamilyName", "Surname") 
							&& !context.hasComponentValue("GivenName") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_REQUIRED_EMPTY;
					}
				}
			).length(1, 15),
		//2		Family Name											FN			RE
			Hl7FieldGenerator.define("FN").withName("FamilyName").requiredEmpty(),
		//3		Given Name											ST			RE		30
			Hl7FieldGenerator.define("ST").withName("GivenName").requiredEmpty().length(30, 30),
		//4		Second and Further Given Names or Initials Thereof	ST			RE		30
			Hl7FieldGenerator.define("ST").withName("FurtherNames").requiredEmpty().length(30, 30),
		//5		Suffix (e.g., JR or III)							ST			O
			Hl7FieldGenerator.define("ST").withName("Suffix").optional(),
		//6		Prefix (e.g., DR)									ST			O
			Hl7FieldGenerator.define("ST").withName("Prefix").optional(),
		//7		Degree (e.g., MD)									IS			X																						Use Professional suffix in sequence 21.
			Hl7FieldGenerator.define("IS").withName("Degree").unsupported(),
		//8		Source Table										IS			O
			Hl7FieldGenerator.define("IS").withName("SourceTable").optional(),
		//9		Assigning Authority									HD			C(R/X)			If the XCN-1 (id number) is valued							HL70363		Note that the subcomponent separator is & when HD is a component of another data type.
			Hl7FieldGenerator.define("HD").withName("AssigningAuthority").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("IdNumber") ? 
						UsageConformance.USAGE_REQUIRED :
						UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			),
		//10	Name Type Code										ID			RE		1																	HL70200
			Hl7FieldGenerator.define("ID").withName("NameTypeCode").requiredEmpty().length(1, 1),
		//11	Identifier Check Digit								ST			O
			Hl7FieldGenerator.define("ST").withName("IdentifierCheckDigit").optional(),
		//12	Check Digit Scheme									ID			C(O/X)			If XCN-11 (check digit identifier) is valued
			Hl7FieldGenerator.define("ID").withName("CheckDigitScheme").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("IdentifierCheckDigit") ?
							UsageConformance.USAGE_OPTIONAL :
							UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			),
		//13	Identifier Type Code								ID			O
			Hl7FieldGenerator.define("ID").withName("IdentifierTypeCode").optional(),
		//14	Assigning Facility									HD			O
			Hl7FieldGenerator.define("HD").withName("AssigningFacility").optional(),
		//15	Name Representation Code							ID			O
			Hl7FieldGenerator.define("ID").withName("NameRepresentationCode").optional(),
		//16	Name Context										CE			O
			Hl7FieldGenerator.define("CE").withName("NameContext").optional(),
		//17	Name Validity Range									DR			X
			Hl7FieldGenerator.define("DR").withName("NameValidityRange").unsupported(),
		//18	Name Assembly Order									ID			X
			Hl7FieldGenerator.define("ID").withName("NameAssemblyOrder").unsupported(),
		//19	Effective Date										TS			O
			Hl7FieldGenerator.define("TS").withName("EffectiveDate").optional(),
		//20	Expiration Date										TS			O
			Hl7FieldGenerator.define("TS").withName("ExpirationDate").optional(),
		//21	Professional Suffix									ST			O
			Hl7FieldGenerator.define("ST").withName("ProfessionalSuffix").optional(),
		//22	Assigning Jurisdiction								CWE			O
			Hl7FieldGenerator.define("CWE").withName("AssigningJurisdiction").optional(),
		//23	Assigning Agency or Department						CWE			O
			Hl7FieldGenerator.define("CWE").withName("AssigningAgencyOrDepartment").optional(),
		};
	}

	public String getFieldType(){
		return "XCN";
	}
}
