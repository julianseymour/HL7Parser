package fields;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;

public class ErrorLocationFieldDefinition extends CompositeFieldDefinition{

	/*public ErrorLocationFieldDefinition(String name){
		super(name);
	}*/
	
	public ErrorLocationFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
		//SEQ	COMPONENT NAME			Data Type	Usage	LEN		Conditional Predicate						COMMENTS
		//1	Segment ID				ST 			R		3..3												The 3-character name for the segment (i.e. PID)
			Hl7FieldGenerator.define("ST").withName("SegmentId").required().length(3, 3),
		//2	Segment Sequence		NM 			R		1.2
			Hl7FieldGenerator.define("NM").withName("SeqmentSequence").required().length(1, 2),
		//3	Field Position			NM 			C(R/RE)	2		If ERL.4 (Field Repetition) is valued		This should not be populated if the error refers to the whole segment.
			Hl7FieldGenerator.define("NM").withName("FieldPosition").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("FieldRepitition") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_REQUIRED_EMPTY;
					}
				}
			),
		//4	Field Repetition		NM 			C(R/RE)	2		If ERL.5 (Component Number) is valued
			Hl7FieldGenerator.define("NM").withName("FieldRepitition").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("ComponentNumber") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_REQUIRED_EMPTY;
					}
				}
			).length(2, 2),
		//5	Component Number		NM 			C(R/RE)	2		If ERL.6 (Sub-Component Number) is valued	Should be populated ONLY when a particular component cause the error.
			Hl7FieldGenerator.define("NM").withName("ComponentNumber").conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("SubcomponentNumber") ?
							UsageConformance.USAGE_REQUIRED :
							UsageConformance.USAGE_REQUIRED_EMPTY;
					}
				}
			).length(2, 2),
		//6	Sub-Component Number	NM			RE		2													Should be populated ONLY when a particular sub-component cause the error.
			Hl7FieldGenerator.define("NM").withName("SubcomponentNumber").requiredEmpty().length(2, 2)
		};
		
	}

	@Override
	public String getFieldType(){
		return "ERL";
	}
}
