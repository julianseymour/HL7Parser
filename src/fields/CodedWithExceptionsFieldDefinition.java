package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class CodedWithExceptionsFieldDefinition extends CompositeFieldDefinition{

	/*public CodedWithExceptionsFieldDefinition(String name){
		super(name);
	}*/
	
	public CodedWithExceptionsFieldDefinition(){
		super();
	}
	
	protected void generateComponents() {
		//SEQ	Component Name						Data Type	Usage		LEN		Conditional Predicate				Value Set	Comments
		this.components = new Hl7FieldDefinition[]{
		//1		Identifier 							ST			R			1..999										Identifying Code.
			Hl7FieldGenerator.define("ST").withName("Identifier").required().length(1, 999),
		//2		Text 								ST			RE			1..999										Human readable text that is not further used.
			Hl7FieldGenerator.define("ST").withName("Text").requiredEmpty().length(1,  999),
		//3		Name of Coding						ID			C(R/X)		1..20	If CWE.1(Identifier) is valued				HL70396
			Hl7FieldGenerator.define("ID").withName("NameOfCoding").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("Identifier") ? 
							UsageConformance.USAGE_REQUIRED 
							: UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			),
		//4		Alternate Identifier				ST			O			1..999															Alternate Identifying coded.
			Hl7FieldGenerator.define("ST").withName("AlternateIdentifier").optional(),
		//5		Alternate Text						ST			C(RE/X)		1..999	If CWE.4 (Alternate Identifier) is valued				Human readable text that is not further used.
			Hl7FieldGenerator.define("ST").withName("AlternateText").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("AlternateIdentifier") ? 
							UsageConformance.USAGE_REQUIRED_EMPTY 
							: UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			),
		//6		Name of Alternate System			ID			C(R/X)		1..20	If CWE.4 (Alternate Identifier) is valued							HL70396
			Hl7FieldGenerator.define("ID").withName("NameOfAlternateSystem").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("AlternateIdentifier") ? 
							UsageConformance.USAGE_REQUIRED 
							: UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			).length(1, 20),
		//7		Coding System Version Id			ST			O
			Hl7FieldGenerator.define("ST").withName("CodingSystemVersionId").optional(),
		//8		Alternate Coding System Version Id	ST			O
			Hl7FieldGenerator.define("ST").withName("AlternateCodingSystemVersionId").optional(),
		//9		Original Text 						ST			O
			Hl7FieldGenerator.define("ST").withName("OriginalText").optional()
		};
	}

	public String getFieldType(){
		return "CWE";
	}
}
