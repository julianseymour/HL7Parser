package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class BatchHeaderSegmentDefinition extends Hl7SegmentDefinition{

	public BatchHeaderSegmentDefinition(){
		super();
	}

	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("ST").withName("BatchFieldSeparator").length(1, 1).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("BatchEncodingCharacters").length(3, 3).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("HD").withName("BatchSendingApplication").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("HD").withName("BatchSendingFacility").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("HD").withName("BatchReceivingApplication").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("HD").withName("BatchReceivingFacility").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("BatchCreationDateTime").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("BatchSecurity").length(0, 40).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("BatchNameIdType").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("BatchComment").length(0, 80).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("BatchControlId").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("ReferenceBatchControlId").length(0, 20).cardinality(0, 1).optional()
		};
	}

	public String getSegmentType(){
		return "BHS";
	}
}
