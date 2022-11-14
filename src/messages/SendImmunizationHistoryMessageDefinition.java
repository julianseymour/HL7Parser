package messages;

import core.Hl7ComponentDefinition;
import segments.Hl7SegmentGenerator;

public class SendImmunizationHistoryMessageDefinition extends Hl7MessageDefinition{

	public SendImmunizationHistoryMessageDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7ComponentDefinition[]{
			gen.header().cardinality(1, 1).required(),
			gen.define("SFT").optional(),
			gen.define("PID").cardinality(1, 1).required(),
			gen.define("PD1").cardinality(0, 1).requiredEmpty(),
			gen.define("NK1").requiredEmpty(),
			gen.define("PV1").cardinality(0, 1).requiredEmpty(),
			gen.define("PV2").cardinality(0, 1).optional(),
			gen.define("GT1").cardinality(0, 1).optional(),
			gen.define("IN1").cardinality(0, 1).optional(),
			gen.define("IN2").cardinality(0, 1).optional(),
			gen.define("IN3").cardinality(0, 1).optional(),
			gen.orderGroup().optional()
		};
	}

	public String getMessageType(){
		return "VXU";
	}
}
