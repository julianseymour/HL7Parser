package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class QueryParameterSegmentDefinition extends Hl7SegmentDefinition{

	public QueryParameterSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("CE").withName("MessageQueryName").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("QueryTag").length(1, 32).required(),
			Hl7FieldGenerator.define("CX").withName("PatientList").requiredEmpty(),
			Hl7FieldGenerator.define("XPN").withName("PatientName").required(), //Empty(),
			Hl7FieldGenerator.define("XPN").withName("PatientMotherMaidenName").requiredEmpty(),
			Hl7FieldGenerator.define("TS").withName("PatientDateOfBirth").requiredEmpty(),
			Hl7FieldGenerator.define("IS").withName("PatientSex").requiredEmpty(),
			Hl7FieldGenerator.define("XAD").withName("PatientAddress").requiredEmpty(),
			Hl7FieldGenerator.define("XTN").withName("PatientHomePhone").requiredEmpty(),
			Hl7FieldGenerator.define("ID").withName("PatientMultipleBirthIndicator").requiredEmpty(),
			Hl7FieldGenerator.define("NM").withName("PatientBirthOrder").requiredEmpty(),
			Hl7FieldGenerator.define("TS").withName("ClientLastUpdatedDate").requiredEmpty(),
			Hl7FieldGenerator.define("HD").withName("ClientLastUpdateFacility").requiredEmpty()
		};
	}

	public String getSegmentType(){
		return "QPD";
	}

}
