package segments;

import fields.Hl7FieldDefinition;
import fields.Hl7FieldGenerator;

public class NoteSegmentDefinition extends Hl7SegmentDefinition{

	public NoteSegmentDefinition(){
		super();
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			Hl7FieldGenerator.define("SI").withName("SetIdNote").length(0, 4).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("ID").withName("SourceOfComment").length(0, 8).cardinality(0, 1).optional(),
			Hl7FieldGenerator.define("FT").withName("Comment").cardinality(1, 1).required(),
			Hl7FieldGenerator.define("CE").withName("CommentType").cardinality(0, 1).optional()
		};
	}

	public String getSegmentType() {
		return "NTE";
	}
}
