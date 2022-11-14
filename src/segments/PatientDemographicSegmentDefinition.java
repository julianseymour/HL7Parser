package segments;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;
import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class PatientDemographicSegmentDefinition extends Hl7SegmentDefinition{

	public PatientDemographicSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("IS").withName("LivingDependency").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("LivingArrangement").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XON").withName("PatientPrimaryFacility").length(0, 250).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XCN").withName("PatientPrimaryCareProviderNameAndIdNum").length(0, 250).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("StudentIndicator").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("Handicap").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("LivingWillCode").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("OrganDonorCode").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("SeparateBill").length(0, 1).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CX").withName("DuplicatePatient").length(0, 250).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("PublicityCode").length(0, 250).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("ID").withName("ProtectionIndicator").length(0, 1).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("DT").withName("ProtectionIndicatorEffectiveDate").length(0, 8).cardinality(0, 1).conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("ProtectionIndicator") ?
							UsageConformance.USAGE_REQUIRED : UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
			Hl7FieldGenerator.define("XON").withName("PlaceOfWorship").length(0, 250).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("AdvanceDirectiveCode").length(0, 250).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("IisStatus").length(0, 1).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("DT").withName("ImmunizationInformationStatusEffectiveDate").length(8, 8).cardinality(0, 1).conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("IisStatus") ?
							UsageConformance.USAGE_REQUIRED : UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
			Hl7FieldGenerator.define("DT").withName("PublicityCodeEffectiveDate").length(8, 8).cardinality(0, 1).conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("PublicityCode") ?
							UsageConformance.USAGE_REQUIRED : UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
			Hl7FieldGenerator.define("IS").withName("MilitaryBranch").length(0, 5).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("MilitaryRankGrade").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("MilitaryStatus").length(0, 3).cardinality(0, 1).optional(),
		};
	}

	public String getSegmentType(){
		return "PD1";
	}
}
