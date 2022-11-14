package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class OrderRequestSegmentDefinition extends Hl7SegmentDefinition{

	public OrderRequestSegmentDefinition(){
		super();
	}

	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("ID").withName("OrderControl").length(2, 2).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("EI").withName("PlacerOrderNumber").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("EI").withName("FillerOrderNumber").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("EI").withName("PlacerGroupNumber").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("OrderStatus").length(0, 2).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("ResponseFlag").length(0, 1).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TQ").withName("QuantityTiming").cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("EIP").withName("Parent").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("DateTimeOfTransaction").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XCN").withName("EnteredBy").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("XCN").withName("VerifiedBy").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XCN").withName("OrderingProvider").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("PL").withName("EnterersLocation").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XTN").withName("CallBackPhoneNumber").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("OrderEffectiveDateTime").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("OrderControlCodeReason").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("EnteringOrganization").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("EnteringDevice").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XCN").withName("ActionBy").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("AdvancedBenificiaryNoticeCode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XON").withName("OrderingFacilityName").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XAD").withName("OrderingFacilityAddress").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XTN").withName("OrderingFacilityPhoneNumber").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XAD").withName("OrderingProviderAddress").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("OrderStatusModifier").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("AdvanceBenificiaryNoticeOverrideReason").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TS").withName("FillersExpectedAvailabilityDateTime").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("ConfidentialityCode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("OrderType").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CNE").withName("EntererAuthorizationMode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("ParentUniversalServiceIdentifier").cardinality(0, 1).optional(),
		};
	}

	public String getSegmentType(){
		return "ORC";
	}

}
