package fields;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import core.CompositeElementInterface;

public abstract class CompositeFieldDefinition extends Hl7FieldDefinition implements CompositeElementInterface{

	public CompositeFieldDefinition(){
		super();
		//String f = "CompositeFieldDefinition()";
		try{
			//System.out.println(f+": entered for field "+this.getFieldType());
			this.generateComponents();
			Map<String, Integer> numbers = new HashMap<String, Integer>();
			for(int i = 0; i < this.getComponentCount(); i++){
				numbers.put(this.getComponent(i).getName(), i);
			}
			this.numbers = numbers;
			//System.out.println(f+": "+this.getFieldType()+" field has "+this.getComponentCount()+" components");
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
	}
	
	public int setDepth(int depth){
		super.setDepth(depth);
		for(int i = 0; i < this.getComponentCount(); i++){
			this.getComponent(i).setDepth(this.getDepth()+1);
		}
		return depth;
	}
	
	public int getComponentNumber(String name){
		return this.numbers.get(name);
	}
	
	public String getComponentName(int i){
		return ((Hl7FieldDefinition) this.getComponent(i)).getName();
	}
	
	public Object parse(String value){
		try{
			if(value.equals("|")){
				throw new Exception("Field \""+this.getName()+"\" received a vertical bar");
			}
			CompositeField cf = new CompositeField(this);
			cf.parse(value);
			return cf;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public LinkedList<Object> parseRepeated(String blob){
		String[] repeated = blob.split("\\~");
		LinkedList<Object> list = new LinkedList<Object>();
		for(int i = 0; i < repeated.length; i++){
			list.add((CompositeField)this.parse(repeated[i]));
		}
		return list;
	}
	
	public Hl7FieldDefinition getComponent(int i){
		return (Hl7FieldDefinition) super.getComponent(i);
	}
	
	public Hl7FieldDefinition getComponent(String name){
		return this.getComponent(this.getComponentNumber(name));
	}
	
	public int getComponentCount(){
		return this.components == null ? 0 : this.components.length;
	}
	
	public String getRegexFieldSeparator(){
		try{
			int depth = this.getDepth();
			switch(depth){
				case 2:
					return "\\^";
				case 3:
					return "&";
				default:
					throw new Exception("Invalid depth "+depth);
			}
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public String getStringFieldSeparator(){
		try{
			int depth = this.getDepth();
			switch(depth){
				case 2:
					return "^";
				case 3:
					return "&";
				default:
					throw new Exception("Invalid depth "+depth);
			}
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public String convertString(Object value){
		String f = "CompositeFieldDefinition.convertString()";
		try{
			if(value instanceof LinkedList){
				return super.convertString(value);
			}else if(!(value instanceof CompositeField)){
				throw new Exception(f+": Value must be either a linked list or composite field");
			}
			CompositeField cf = (CompositeField) value;
			String ret = "";
			for(int i = 0; i < this.getComponentCount(); i++){
				Hl7FieldDefinition fd = this.getComponent(i);
					if(i > 0){
						ret += this.getStringFieldSeparator();
					}
				if(cf.hasComponentValue(i)){
					ret += fd.convertString(cf.getComponentValue(i));
				}
			}
			return ret;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public boolean hasComponent(int i){
		return i < this.getComponentCount();
	}
}
