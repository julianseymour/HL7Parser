package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class ResponseControlParameterSegmentDefinition extends Hl7SegmentDefinition{

	public ResponseControlParameterSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("ID").withName("QueryPriority").length(0, 1).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CQ").withName("QuantityLimitedRequest").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("ResponseModality").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("ExecutionAndDeliveryTime").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("MofifyIndicator").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("SRT").withName("SortByField").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("SegmentGroupInclusion").optional()
		};
	}

	public String getSegmentType(){
		return "RCP";
	}

}
