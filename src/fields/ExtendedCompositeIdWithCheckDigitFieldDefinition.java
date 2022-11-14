package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class ExtendedCompositeIdWithCheckDigitFieldDefinition extends CompositeFieldDefinition{

	/*public ExtendedCompositeIdWithCheckDigitFieldDefinition(String name){
		super(name);
	}*/
	
	public ExtendedCompositeIdWithCheckDigitFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
	//SEQ	COMPONENT NAME					Data Type	Usage	LEN		Conditional Predicate				Value set	COMMENTS
	this.components = new Hl7FieldDefinition[]{
	//1		ID Number						ST			R		15
		Hl7FieldGenerator.define("ST").withName("IdNumber").required().length(15, 15),
	//2		Check Digit						ST			O
		Hl7FieldGenerator.define("ST").withName("CheckDigit").optional(),
	//3		Check Digit Scheme				ID			C(O/X)			If CX. 2 (check digit) is valued	HL70061
		Hl7FieldGenerator.define("ID").withName("CheckDigitScheme").conditional(
			new ConditionalPredicate(){
				public String evaluate(Hl7ComponentInterface context) {
					return context.hasComponentValue("CheckDigit") ?
						UsageConformance.USAGE_OPTIONAL :
						UsageConformance.USAGE_UNSUPPORTED;
				}
			}
		),
	//4		Assigning Authority				HD			R													HL70363
		Hl7FieldGenerator.define("HD").withName("AssigningAuthority").required(),
	//5		Identifier Type					ID			R		2..5										HL70203
		Hl7FieldGenerator.define("ID").withName("IdentifierType").required().length(2, 5),
	//6		Assigning Facility				HD			O
		Hl7FieldGenerator.define("HD").withName("AssigningFacility").optional(),
	//7		Effective Date					DT			O
		Hl7FieldGenerator.define("DT").withName("EffectiveDate").optional(),
	//8		Expiration Date					DT			O
		Hl7FieldGenerator.define("DT").withName("ExpirationDate").optional(),
	//9		Assigning Jurisdiction			CWE			O
		Hl7FieldGenerator.define("CWE").withName("AssigningJurisdiction").optional(),
	//10	Assigning Agency or Department	CWE			O
		Hl7FieldGenerator.define("CWE").withName("AssigningAgencyOrDepartment").optional()
		};
	}

	public String getFieldType(){
		return "CX";
	}
}
