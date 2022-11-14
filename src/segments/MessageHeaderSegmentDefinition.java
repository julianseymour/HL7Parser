package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class MessageHeaderSegmentDefinition extends Hl7SegmentDefinition{

	public MessageHeaderSegmentDefinition(){
		super();
	}

	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
			//Hl7FieldGenerator.define("ST").withName("FieldSeparator").length(1, 1).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("EncodingCharacters").length(4, 4).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("HD").withName("SendingApplication").length(0, 20).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("HD").withName("SendingFacility").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("HD").withName("ReceivingApplication").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("HD").withName("ReceivingFacility").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("TS").withName("DateTimeOfMessage").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("Security").length(0, 40).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("MSG").withName("MessageType").length(15, 15).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("MessageControlId").length(16, 199).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("PT").withName("ProcessingId").length(1, 3).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("VID").withName("VersionId").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("NM").withName("SequenceNumber").length(0, 15).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("ContinuationPointer").length(0, 180).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("AcceptAcknowledgementType").length(0, 2).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("ID").withName("ApplicationAcknowledgementType").length(0, 2).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("ID").withName("CountryCode").length(0, 3).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("CharacterSet").length(0, 16).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CE").withName("PrincipalLanguageOfMessage").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("AlternateCharacterSetHandlingScheme").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("EI").withName("MessageProfileIdentifier").required(),
			Hl7FieldGenerator.define("XON").withName("ResponsibleSendingOrganization").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("XON").withName("ResponsibleReceivingOrganization").cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("HD").withName("SendingNetworkAddress").optional(),
			Hl7FieldGenerator.define("HD").withName("ReceivingNetworkAddress").optional()
		};
	}

	public String getSegmentType() {
		return "MSH";
	}

}
