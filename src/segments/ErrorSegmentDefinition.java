package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class ErrorSegmentDefinition extends Hl7SegmentDefinition{

	public ErrorSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("ELD").withName("ErrorCodeAndLocation").cardinality(0, 0).unsupported(),
			Hl7FieldGenerator.define("ERL").withName("ErrorLocation").length(0, 18).cardinality(0, 1).requiredEmpty(),
			Hl7FieldGenerator.define("CWE").withName("Hl7ErrorCode").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ID").withName("Severity").length(2, 2).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("CWE").withName("ApplicationErrorCode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("ApplicationErrorParameter").length(0, 80).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TX").withName("DiagnosticInformation").length(0, 2048).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("TX").withName("UserMessage").length(0, 250).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("IS").withName("InformPersonIndicator").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("OverrideType").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("CWE").withName("OverrideReasonCode").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("XTN").withName("HelpDeskContactPoint").cardinality(0, 1).optional()
		};
	}

	public String getSegmentType(){
		return "ERR";
	}
}
