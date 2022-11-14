package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class FileTrailerSegmentDefinition extends Hl7SegmentDefinition{

	public FileTrailerSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("NM").withName("FileBatchCount").length(0, 10).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ST").withName("FileTrailerComment").length(0, 80).cardinality(0, 1).optional()
		};
	}

	public String getSegmentType(){
		return "FTS";
	}

}
