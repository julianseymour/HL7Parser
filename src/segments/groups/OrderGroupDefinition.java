package segments.groups;

import core.Hl7ComponentDefinition;
import segments.Hl7SegmentGenerator;

public class OrderGroupDefinition extends SegmentGroupDefinition{

	public OrderGroupDefinition(Hl7SegmentGenerator gen){
		super(gen);
	}

	public String getName(){
		return "Order";
	}

	protected void generateComponents(){
		Hl7SegmentGenerator gen = this.getSegmentGenerator();
		this.components = new Hl7ComponentDefinition[]{
			gen.define("ORC").cardinality(1, 1).required(),
			gen.define("TQ1").cardinality(0, 1).optional(),
			gen.define("TQ2").cardinality(0, 1).optional(),
			gen.define("RXA").cardinality(1, 1).required(),
			gen.define("RXR").cardinality(0, 1).requiredEmpty(),
			gen.observationGroup().requiredEmpty()
		};
	}
	
}
