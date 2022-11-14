package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class PharmacyTreatmentRouteSegmentDefinition extends Hl7SegmentDefinition{

	public PharmacyTreatmentRouteSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("CE").withName("Route").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("CWE").withName("AdministrationSite").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("CE").withName("AdministrationDevice").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("AdministrationMethod").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("RoutingInstruction").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("AdministrationSiteModifier").cardinality(0, 1).optional()
		};
	}

	public String getSegmentType(){
		return "RXR";
	}

}
