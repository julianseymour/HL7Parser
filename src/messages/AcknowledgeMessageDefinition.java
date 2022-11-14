package messages;

import segments.Hl7SegmentDefinition;
import segments.Hl7SegmentGenerator;

public class AcknowledgeMessageDefinition extends Hl7MessageDefinition{

	public AcknowledgeMessageDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7SegmentDefinition[]{
			gen.header(),
			gen.define("SFT").cardinality(0, 1).optional(),
			gen.define("MSA").cardinality(1, 1).required(),
			gen.define("ERR").requiredEmpty(),
			gen.define("ZSA").cardinality(1, 1).optional()
		};
	}

	public String getMessageType(){
		return "ACK";
	}
}
