package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class ObservationResultSegmentDefinition extends Hl7SegmentDefinition{

	public ObservationResultSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("SI").withName("SetIdObx").length(1, 4).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ID").withName("ValueType").length(2, 2).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("CE").withName("ObservationIdentifier").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("ObservationSubId").length(0, 20).cardinality(1, 1).requiredEmpty(),
			Hl7FieldGenerator.define("ST").withName("ObservationValue").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("CE").withName("Units").cardinality(0, 1).optional(), //XXX TODO look at official specs
			Hl7FieldGenerator.define("ST").withName("ReferenceRange").length(0, 60).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("AbnormalFlags").length(0, 5).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("NM").withName("Probability").length(0, 5).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("NatureOfAbnormalTest").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("ObservationResultStatus").length(1, 1).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("TS").withName("EffectiveDateOfReferenceRangeValues").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("UserDefinedAccessCheckd").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("DateTimeOfObservation").cardinality(1, 1).requiredEmpty(),
			Hl7FieldGenerator.define("CE").withName("ProducersReference").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XCN").withName("ResponsibleObserver").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("ObservationMethod").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("EI").withName("EquipmentInstanceIdentifier").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("DateTimeOfAnalysis").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("Reserved1").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("Reserved2").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("Reserved3").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XON").withName("PerformingOrganizationName").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XAD").withName("PerformingOrganizationAddress").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XCN").withName("PerformingOrganizationMedicalDirector").cardinality(0, 1).optional()
		};
	}

	public String getSegmentType(){
		return "OBX";
	}

}
