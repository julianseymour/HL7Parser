package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class CodedElementFieldDefinition extends CompositeFieldDefinition{

	/*public CodedElementFieldDefinition(String name){
		super(name);
	}*/
	
	public CodedElementFieldDefinition(){
		super();
	}
	
	/*
	 * Example usage:
From RXA 5, Administered Code:
|50^DTAP-HIB^CVX^90721^DTAP-HIB^C4|
	 */
	
	public void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			//SEQ	Component Name					Data Type	Usage	LEN		Conditional Predicate 						Value Set	Comments
			//1		Identifier						ST			R		1..50															Identifying Code.
				Hl7FieldGenerator.define("ST").withName("Identifier").required().length(1, 50),
			//2		Text							ST			RE		1..999															Human readable text that may be used to review segment content.
				Hl7FieldGenerator.define("ST").withName("Text").requiredEmpty().length(1, 999),
			//3		Name of Coding System			ID			R		1..20												HL70396		Value set identifier
				Hl7FieldGenerator.define("ID").withName("NameOfCodingSystem").required().length(1, 20),
			//4		Alternate Identifier			ST			O		1..50															Alternate Identifying code.
				Hl7FieldGenerator.define("ST").withName("AlternateIdentifier").optional().length(1,	50),
			//5		Alternate Text 					ST			C(RE/X)	1..999	If CE-4 (Alternate Identifier) is valued				Human readable text.
				Hl7FieldGenerator.define("ST").withName("AlternateText").length(1,	999).conditional(
					new ConditionalPredicate(){
						public String evaluate(Hl7ComponentInterface context){
							return context.hasComponentValue("AlternateIdentifier") ? 
								UsageConformance.USAGE_REQUIRED_EMPTY 
								: UsageConformance.USAGE_UNSUPPORTED;
						}
					}
				),
			//6		Name of Alternate Coding system	ID			C(R/X)	1..20 	If CE-4 (Alternate Identifier) is valued	HL70396		Value set identifier.
				Hl7FieldGenerator.define("ID").withName("NameOfAlternateCodingSystem").length(1,  20).conditional(
					new ConditionalPredicate(){
						public String evaluate(Hl7ComponentInterface context){
							return context.hasComponentValue("AlternateIdentifier") ? 
								UsageConformance.USAGE_REQUIRED 
								: UsageConformance.USAGE_UNSUPPORTED;
						}
					}
				)
		};
	}

	public String getFieldType() {
		return "CE";
	}
}
