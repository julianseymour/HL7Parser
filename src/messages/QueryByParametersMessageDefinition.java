package messages;

import segments.Hl7SegmentDefinition;
import segments.Hl7SegmentGenerator;

public class QueryByParametersMessageDefinition extends Hl7MessageDefinition{

	public QueryByParametersMessageDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7SegmentDefinition[]{
			gen.header(),
			gen.define("SFT").optional(),
			gen.define("QPD").cardinality(1, 1).required(),
			gen.define("RCP").cardinality(1, 1).required(),
			gen.define("DSC").optional()
		};
	}

	public String getMessageType(){
		return "QBP";
	}
}
