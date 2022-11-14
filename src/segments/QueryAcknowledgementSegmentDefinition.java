package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class QueryAcknowledgementSegmentDefinition extends Hl7SegmentDefinition{

	public QueryAcknowledgementSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("ST").withName("QueryTag").length(0, 32).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ID").withName("QueryResponseStatus").length(0, 2).cardinality(0, 1).required(), //Empty(),
			Hl7FieldGenerator.define("CE").withName("MessageQueryName").cardinality(0, 1).optional(), //required(),
			Hl7FieldGenerator.define("NM").withName("HitCount").length(0, 10).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("NM").withName("ThisPayload").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("NM").withName("HitsRemaining").length(0, 10).cardinality(0, 1).optional()
		};
	}

	public String getSegmentType(){
		return "QAK";
	}

}
