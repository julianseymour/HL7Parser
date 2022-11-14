package fields;

public class DateFieldDefinition extends AbstractStringFieldDefinition{

	public DateFieldDefinition(String name){
		super(name);
	}
	
	public DateFieldDefinition(){
		super();
		this.length(4, 8);
	}

	public String getFieldType(){
		return "DT";
	}

	/*
	As of v 2.3, the number of digits populated specifies the precision using the format specification YYYY[MM[DD]]). Thus:
		• Four digits are used to specify a precision of "year"
		• Six are used to specify a precision of "month"
		• Eight are used to specify a precision of "day."
	*/
	
}
