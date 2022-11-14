package segments;

import core.ConditionalPredicate;
import core.Hl7ComponentInterface;
import core.UsageConformance;
import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class PharmacyTreatmentAdministrationSegmentDefinition extends Hl7SegmentDefinition{

	public PharmacyTreatmentAdministrationSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("NM").withName("GiveSubIdCounter").length(1, 4).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("NM").withName("AdministrationSubIdCounter").length(1, 4).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("TS").withName("DateTimeStartOfAdministration").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("TS").withName("DateTimeEndOfAdministration").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("CE").withName("AdministeredCode").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("NM").withName("AdministeredAmount").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("CE").withName("AdministeredUnits").cardinality(0, 1).conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("AdministeredAmount") && context.getComponentValueInt("AdministeredAmount") != 999 ?
							UsageConformance.USAGE_REQUIRED : UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
			Hl7FieldGenerator.define("CE").withName("AdministeredDosageForm").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("AdministrationNotes").withMinCardinality(0).requiredEmpty(),
			Hl7FieldGenerator.define("XCN").withName("AdministeringProvider").cardinality(0, 1).requiredEmpty(), //conditional(), //XXX TODO
			Hl7FieldGenerator.define("LA2").withName("AdministeredAtLocation").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("ST").withName("AdministeredPerTimeUnit").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("NM").withName("AdministeredStrength").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("AdministeredStrengthUnits").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("SubstanceLotNumber").length(0, 20).withMinCardinality(0).requiredEmpty(),
			Hl7FieldGenerator.define("TS").withName("SibstanceExpirationDate").cardinality(0, 1).conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("SubstanceLotNumber") ? 
							UsageConformance.USAGE_REQUIRED : UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
			Hl7FieldGenerator.define("CE").withName("SubstanceManufacturerName").withMinCardinality(0).requiredEmpty(),
			Hl7FieldGenerator.define("CE").withName("SubstanceTreatmentRefusalReason").withMinCardinality(0).conditional(
				new ConditionalPredicate(){
					public String evaluate(Hl7ComponentInterface context){
						return context.hasComponentValue("CompletionStatus") && context.getComponentValue("CompletionStatus").equals("RE") ?
							UsageConformance.USAGE_REQUIRED : UsageConformance.USAGE_OPTIONAL;
					}
				}
			),
			Hl7FieldGenerator.define("CE").withName("Indication").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("CompletionStatus").length(0, 2).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("ID").withName("ActionCodeRxa").length(0, 2).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("TS").withName("SystemEntryDateTime").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("NM").withName("AdministeredDrugStrengthVolume").length(0, 5).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("AdministeredDrugStrengthVolumeUnits").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("AdministeredBarcodeIdentifier").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("PharmacyOrderType").length(0, 1).cardinality(0, 1).optional()
		};
	}

	public String getSegmentType(){
		return "RXA";
	}

}
