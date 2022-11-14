package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class EntityIdentifierFieldDefinition extends CompositeFieldDefinition{

	/*public EntityIdentifierFieldDefinition(String name){
		super(name);
	}*/
	
	public EntityIdentifierFieldDefinition(){
		super();
	}
	
	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
		//SEQ	COMPONENT NAME		Data Type	Usage	LEN		Conditional Predicate					Value Set				COMMENTS
		//1	Entity Identifier	ST			R		1..199
			Hl7FieldGenerator.define("ST").withName("EntityIdentifier").required().length(1, 199),
		//2	Namespace ID		IS			C(R/O)	20		If EI.3 (Universal Id) is not valued	HL70363
			Hl7FieldGenerator.define("IS").withName("NameSpaceId").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("UniversalId") ?
							UsageConformance.USAGE_REQUIRED
							: UsageConformance.USAGE_OPTIONAL;
					}
				}
			).length(20, 20),
		//3	Universal ID		ST			C(R/O)	199		If EI.2 (Namespace ID) is not valued
			Hl7FieldGenerator.define("ST").withName("UniversalId").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return !context.hasComponentValue("NamespaceId") ? 
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_OPTIONAL;
					}
				}
			).length(199, 199),
		//4	Universal ID Type	ID			C(R/X)	6		If EI.3 (Universal Id) is valued		HL70301 (constrained)
			Hl7FieldGenerator.define("ID").withName("UniversalIdType").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("UniversalId") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			).length(6, 6)
		};
	}

	public String getFieldType(){
		return "EI";
	}
}
