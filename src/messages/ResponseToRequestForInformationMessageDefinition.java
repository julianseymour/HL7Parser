package messages;

import core.Hl7ComponentDefinition;
import segments.Hl7SegmentGenerator;

public class ResponseToRequestForInformationMessageDefinition extends Hl7MessageDefinition{

	public ResponseToRequestForInformationMessageDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7ComponentDefinition[]{
			gen.header().cardinality(1, 1).required(),
			gen.define("MSA").cardinality(1, 1).required(),
			gen.define("ERR").cardinality(0, 1).optional(),
			gen.define("QAK").cardinality(1, 1).required(),
			gen.define("QPD").cardinality(1, 1).required(),
			gen.responseGroup().cardinality(0, 1).optional()
		};
	}

	public String getMessageType(){
		return "RSP";
	}
}
