package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class HierarchicDesignatorFieldDefinition extends CompositeFieldDefinition{

	/*public HierarchicDesignatorFieldDefinition(String name){
		super(name);
	}*/
	
	public HierarchicDesignatorFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		//SEQ	COMPONENT NAME		Data Type	Usage	LEN		Conditional Predicate						Value Set						COMMENTS
		this.components = new Hl7FieldDefinition[]{
		//1		Namespace ID		IS			C(R/O)	1..20	If the HD.2 (Universal ID) is not valued	HL70300 HL70361 HL70362 HL70363	This field is used for a locally defined name/id. It may be used as previous version 2.3.1 Implementation Guide specified. The value set used depends on usage.
			Hl7FieldGenerator.define("IS").withName("NamespaceId").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return !context.hasComponentValue("UniversalId") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_OPTIONAL;
					}
				}
			).length(1, 20),
		//2		Universal ID		ST			C(R/O)	1..199	If the HD.1 (Namespace ID) is not valued
			Hl7FieldGenerator.define("ST").withName("UniversalId").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return !context.hasComponentValue("NamespaceId") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_OPTIONAL;
					}
				}
			).length(1, 199),
		//3		Universal ID Type	ID			C(R/X)	1..6	If the HD.2 (Universal ID) is valued 		HL70301 (Constrained)
			Hl7FieldGenerator.define("ID").withName("UniversalIdType").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("UniversalId") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_UNSUPPORTED;
					}
				}
			).length(1, 6)
		};
	}

	public String getFieldType(){
		return "HD";
	}
}
