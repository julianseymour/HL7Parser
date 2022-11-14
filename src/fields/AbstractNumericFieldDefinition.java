package fields;

import java.util.LinkedList;

public abstract class AbstractNumericFieldDefinition extends Hl7FieldDefinition{
	
	public AbstractNumericFieldDefinition(String name){
		super(name);
	}
	
	public AbstractNumericFieldDefinition(){
		super();
	}
	
	public Object parse(String value){
		return Double.parseDouble(value);
	}
	
	public LinkedList<Object> parseRepeated(String blob){
		String[] repeated = blob.split("\\~");
		LinkedList<Object> list = new LinkedList<Object>();
		for(int i = 0; i < repeated.length; i++){
			list.add((Double)this.parse(repeated[i]));
		}
		return list;
	}
}
