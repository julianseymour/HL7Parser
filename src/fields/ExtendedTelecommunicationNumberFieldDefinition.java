package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class ExtendedTelecommunicationNumberFieldDefinition extends CompositeFieldDefinition{

	/*public ExtendedTelecommunicationNumberFieldDefinition(String name){
		super(name);
	}*/
	
	public ExtendedTelecommunicationNumberFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		//SEQ	COMPONENT NAME						Data Type	Usage	LEN		Conditional Predicate											Value Set	COMMENTS
			this.components = new Hl7FieldDefinition[]{
		//1		Telephone Number					ST			X																							Deprecated as of 2.3
			Hl7FieldGenerator.define("ST").withName("TelephoneNumber").unsupported(),
		//2		Telecommunication Use Code			ID			R																				HL70201
			Hl7FieldGenerator.define("ID").withName("TelecommunicationUseCode").required(),
		//3		Telecommunication Equipment Type	ID			RE																				HL70202
			Hl7FieldGenerator.define("ID").withName("TelecommunicationEquipmentType").requiredEmpty(),
		//4		Email Address						ST			C(R/X)	1..199	If the XTN-2 (Telecommunication Use Code) is valued “NET”
			Hl7FieldGenerator.define("ST").withName("EmailAddress").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.getComponentValue("TelecommunicationUseCose").equals("NET") ?
							UsageConformance.USAGE_REQUIRED_EMPTY :
							UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			).length(1, 199),
		//5		Country Code						NM			O
			Hl7FieldGenerator.define("NM").withName("CountryCode").optional(),
		//6		Area/City Code						NM			C(RE/X)	5		If the XTN-2 (Telecommunication Use Code) is valued not “NET”
			Hl7FieldGenerator.define("NM").withName("AreaCityCode").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return !context.getComponentValue("TelecommunicationUseCose").equals("NET") ?
							UsageConformance.USAGE_REQUIRED_EMPTY :
							UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			),
		//7		Local Number						NM			C(R/X)	9		If the XTN-2 (telecommunication use code) is valued not “NET”
			Hl7FieldGenerator.define("NM").withName("LocalNumber").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return !context.getComponentValue("TelecommunicationUseCose").equals("NET") ?
							UsageConformance.USAGE_REQUIRED_EMPTY :
							UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			).length(9, 9),
		//8		Extension							NM			O
			Hl7FieldGenerator.define("NM").withName("Extension").optional(),
		//9		Any Text							ST			O
			Hl7FieldGenerator.define("ST").withName("AnyText").optional(),
		//10	Extension Prefix					ST			O
			Hl7FieldGenerator.define("ST").withName("ExtensionPrefix").optional(),
		//11	Speed Dial Code						ST			O
			Hl7FieldGenerator.define("ST").withName("SpeedDialCode").optional(),
		//12	Unformatted Telephone number		ST			O
			Hl7FieldGenerator.define("ST").withName("UnformattedTelephoneNumber").optional()
		};
	}

	public String getFieldType(){
		return "XTN";
	}
}
