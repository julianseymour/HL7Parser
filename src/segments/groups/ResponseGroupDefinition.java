package segments.groups;

import core.Hl7ComponentDefinition;
import segments.Hl7SegmentGenerator;

public class ResponseGroupDefinition extends SegmentGroupDefinition{
	
	public ResponseGroupDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7ComponentDefinition[]{
			gen.patientIdentifierGroup().optional(),
			gen.immunizationHistoryGroup().cardinality(0, 1).optional()
		};
	}

	public String getName(){
		return "Response";
	}

}
