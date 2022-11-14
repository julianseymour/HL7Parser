package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class FileHeaderSegmentDefinition extends Hl7SegmentDefinition{

	public FileHeaderSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("ST").withName("FileFieldSeparator").length(1, 1).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("ST").withName("FileEncodingCharacteers").length(4, 4).cardinality(1, 1).required(),
			Hl7FieldGenerator.define("HD").withName("FileSendingApplication").optional(),
			Hl7FieldGenerator.define("HD").withName("FileSendingFacility").optional(),
			Hl7FieldGenerator.define("HD").withName("FileReceivingApplication").optional(),
			Hl7FieldGenerator.define("HD").withName("FileReceivingFacility").optional(),
			Hl7FieldGenerator.define("TS").withName("FileCreationDateTime").cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("FileSecurity").length(0, 40).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("FileNameId").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("FileHeaderComment").length(0, 80).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("FileControlId").length(0, 20).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("ReferenceFileControlId").length(0, 20).optional(),
		};
	}

	public String getSegmentType(){
		return "FHS";
	}

}
