package segments;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;
import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class PatientIdentifierSegmentDefinition extends Hl7SegmentDefinition{

	public PatientIdentifierSegmentDefinition(){
		super();
	}

	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("SI").withName("SetIdPid").length(4, 4).cardinality(0, 1).required(),
			Hl7FieldGenerator.define("CX").withName("PatientId").cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CX").withName("PatientIdentifierList").withMinCardinality(1).required(),
			Hl7FieldGenerator.define("CX").withName("AlternatePatientId00106").cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("XPN").withName("PatientName").withMinCardinality(1).required(),
			Hl7FieldGenerator.define("XPN").withName("MothersMaidenName").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("TS").withName("DateTimeOfBirth").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("IS").withName("AdministrativeSex").length(1, 1).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("XPN").withName("PatientAlias").cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CE").withName("Race").withMinCardinality(0).requiredEmpty(),
			Hl7FieldGenerator.define("XAD").withName("PatientAddress").length(4, 4).withMinCardinality(0).requiredEmpty(),
			Hl7FieldGenerator.define("IS").withName("CountyCode").length(4, 4).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("XTN").withName("PhoneNumberHome").withMinCardinality(0).requiredEmpty(),
			Hl7FieldGenerator.define("XTN").withName("PhoneNumberBusiness").withMinCardinality(0).optional(),
			Hl7FieldGenerator.define("CE").withName("PrimaryLanguage").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("MaritalStatus").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("Religion").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CX").withName("PatientAccountNumber").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("PatientSocialSecurityNumber").length(9, 16).cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("DLN").withName("DriversLicenseNumberPatient").cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CX").withName("MothersIdentifier").cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("CE").withName("EthnicGroup").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("ST").withName("Birthplace").length(0, 60).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("MultipleBirthIndicator").length(0, 1).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("NM").withName("BirthOrder").length(0, 2).cardinality(0, 1).conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context) {
						return context.hasComponentValue("MultipleBirthIndicator") && context.getComponentValue("MultipleBirthIndicator").equals("Y") ?
							UsageConformance.USAGE_REQUIRED_EMPTY : UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
			Hl7FieldGenerator.define("CE").withName("Citizenship").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("VeteransMilitaryStatus").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("Nationality").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("PatientDeathDateAndTime").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("ID").withName("PatientDeathIndicator").length(0, 1).cardinality(0, 1).conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("PatientDeathDateAndTime") ?
							UsageConformance.USAGE_REQUIRED : UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
			Hl7FieldGenerator.define("ID").withName("IdentityUnknownIndicator").length(0, 1).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("IdentityReliabilityCode").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("LastUpdateDateTime").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("HD").withName("LastUpdateFacility").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("SpeciesCode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("BreedCode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("Strain").length(0, 80).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("ProductionClassCode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("TribalCitizenship").cardinality(0, 1).optional(),
		};
	}

	public String getSegmentType(){
		return "PID";
	}

}
