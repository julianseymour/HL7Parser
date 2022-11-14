package fields;

public class FormattedTextFieldDefinition extends AbstractStringFieldDefinition{

	public FormattedTextFieldDefinition(String name){
		super(name);
	}
	
	public FormattedTextFieldDefinition(){
		super();
		//1 Formatted Text Data 1..65536
			this.length(1, 65536);
	}

	public String getFieldType(){
		return "FT";
	}
	
}
