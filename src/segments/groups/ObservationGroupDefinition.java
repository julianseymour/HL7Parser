package segments.groups;

import core.Hl7ComponentDefinition;
import segments.Hl7SegmentGenerator;

public class ObservationGroupDefinition extends SegmentGroupDefinition{

	public ObservationGroupDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	public String getName(){
		return "Observation";
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7ComponentDefinition[]{
			gen.define("OBX").cardinality(1, 1).required(),
			gen.define("NTE").cardinality(0, 1).requiredEmpty()
		};
	}

}
