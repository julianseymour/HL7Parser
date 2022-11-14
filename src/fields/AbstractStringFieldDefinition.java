package fields;

import java.util.LinkedList;

public abstract class AbstractStringFieldDefinition extends Hl7FieldDefinition{
	
	public Object parse(String value){
		return value;
	}
	
	public AbstractStringFieldDefinition(String name){
		super(name);
	}
	
	public AbstractStringFieldDefinition(){
		super();
	}
	
	public LinkedList<Object> parseRepeated(String blob){
		String[] repeated = blob.split("\\~");
		LinkedList<Object> list = new LinkedList<Object>();
		for(int i = 0; i < repeated.length; i++){
			list.add(this.parse(repeated[i]));
		}
		return list;
	}
}
