package segments;

import fields.Hl7FieldDefinition;

public class EmptySegmentDefinition extends Hl7SegmentDefinition{

	public String getSegmentType(){
		return "?";
	}

	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{};
	}
}
