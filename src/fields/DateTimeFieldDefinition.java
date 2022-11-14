package fields;

public class DateTimeFieldDefinition extends AbstractStringFieldDefinition{

	public DateTimeFieldDefinition(String name){
		super(name);
	}
	
	public DateTimeFieldDefinition(){
		super();
		this.length(8, 17);
	}

	public String getFieldType(){
		return "DTM";
	}

}
