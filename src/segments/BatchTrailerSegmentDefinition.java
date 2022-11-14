package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class BatchTrailerSegmentDefinition extends Hl7SegmentDefinition{

	public BatchTrailerSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("ST").withName("BatchMessageCount").length(0, 10).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("BatchComment").length(0, 80).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("NM").withName("BatchTotals").length(0, 100).cardinality(0, 1).optional(),
		};
	}

	public String getSegmentType(){
		return "BTS";
	}

}
