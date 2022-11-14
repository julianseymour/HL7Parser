package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class MessageAcknowledgementSegmentDefinition extends Hl7SegmentDefinition{

	public MessageAcknowledgementSegmentDefinition(){
		super();
	}

	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("ID").withName("Acknowledgement").length(2, 2).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("MessageControlId").length(1, 199).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("TextMessage").length(0, 80).cardinality(0, 1).unsupported(),
			Hl7FieldGenerator.define("NM").withName("ExpectedSequenceNumber").length(0, 15).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("Removed").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("ErrorCondition").cardinality(0, 0).unsupported()
		};
	}

	public String getSegmentType(){
		return "MSA";
	}

}
