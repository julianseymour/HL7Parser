package segments.groups;

import core.Hl7ComponentDefinition;
import segments.Hl7SegmentGenerator;

public class ImmunizationHistoryGroupDefinition extends SegmentGroupDefinition{

	public ImmunizationHistoryGroupDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	public String getName(){
		return "ImmunizationHistory";
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7ComponentDefinition[]{
			gen.define("PV1").cardinality(0, 1).optional(),
			gen.define("IN1").cardinality(0, 0).unsupported(),
			gen.orderGroup().requiredEmpty()
		};
	}
}
