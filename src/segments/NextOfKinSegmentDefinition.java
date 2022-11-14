package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class NextOfKinSegmentDefinition extends Hl7SegmentDefinition{

	public NextOfKinSegmentDefinition(){
		super();
	}

	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("SI").withName("SetIdNextOfKin1").length(4, 4).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("XPN").withName("Name").withMinCardinality(1).required(),
			Hl7FieldGenerator.define("CE").withName("Relationship").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("XAD").withName("Address").requiredEmpty(),
			Hl7FieldGenerator.define("XTN").withName("PhoneNumber").requiredEmpty(),
			Hl7FieldGenerator.define("XTN").withName("BusinessPhoneNumber").optional(),
			Hl7FieldGenerator.define("CE").withName("ContactRole").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("DT").withName("StartDate").length(8, 8).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("DT").withName("EndDate").length(8, 8).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("NextOfKinAssociatedPartiesJobTitle").length(60, 60).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("JCC").withName("NextOfKinAssociatedPartiesJobCodeClass").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CX").withName("NextOfKinAssociatedPartiesEmployeeNumber").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XON").withName("OrganizationNameNextOfKin1").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("MartialStatus").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("AdministrativeSex").length(1, 1).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("DateTimeOfBirth").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("LivingDependency").length(2, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("AmbulatoryStatus").length(2, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("Citizenship").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("PrimaryLanguage").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("LivingArrangement").length(2, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("PublicityCode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("ProtectionIndicator").length(1, 1).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("StudentIndicator").length(2, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("Religion").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XPN").withName("MothersMaidenName").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("Nationality").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("EthnicGroup").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("ContactReason").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XPN").withName("ContactPersonsName").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XTN").withName("ContactPersonsTelephoneNumber").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XAD").withName("ContactPersonsAddress").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CX").withName("NextOfKinAssociatedPartysIdentifiers").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("JobStatus").length(2, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("Race").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("Handicap").length(2, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("ContactPersonsSocialSecurityNumber").length(16, 16).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("NextOfKinBirthPlace").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("VipIndicator").length(2, 2).cardinality(0, 1).optional(),
		};
	}

	public String getSegmentType(){
		return "NK1";
	}

}
