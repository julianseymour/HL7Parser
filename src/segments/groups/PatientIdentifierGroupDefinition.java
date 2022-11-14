package segments.groups;

import core.Hl7ComponentDefinition;
import segments.Hl7SegmentGenerator;

public class PatientIdentifierGroupDefinition extends SegmentGroupDefinition{

	public PatientIdentifierGroupDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	public String getName(){
		return "PatientIdentifier";
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7ComponentDefinition[]{
			gen.define("PID").cardinality(1, 1).required(),
			gen.define("PD1").cardinality(0, 1).requiredEmpty(),
			gen.define("NK1").requiredEmpty()
		};
	}

}
