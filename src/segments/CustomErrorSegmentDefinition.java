package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class CustomErrorSegmentDefinition extends Hl7SegmentDefinition{

	public CustomErrorSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("CE").withName("CustomAcknowledgementCode").cardinality(1, 1).required(), //optional(),
			Hl7FieldGenerator.define("CX").withName("MessageIdentifierList").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CX").withName("PatientIdentifierList").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CX").withName("ActionsPerformedList").cardinality(0, 1).optional()
		};
	}

	public String getSegmentType() {
		return "ZSA";
	}
}
