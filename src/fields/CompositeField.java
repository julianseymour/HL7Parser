package fields;

import java.util.Arrays;
import java.util.Optional;

import core.CompositeElementInterface;
import core.DefinedInterface;
import core.Hl7ElementDefinition;
import core.Hl7RegexHelper;

public class CompositeField implements CompositeElementInterface, DefinedInterface{

	protected Optional<Object>[] components;
	protected CompositeFieldDefinition definition;
	
	public CompositeField(CompositeFieldDefinition definition){
		if(definition != null){
			this.setDefinition(definition);
		}
	}
	
	public int getDepth(){
		return this.getDefinition().getDepth();
	}
	
	public String getName(){
		return this.getDefinition().getName();
	}
	
	public String getRegexFieldSeparator(){
		return this.getDefinition().getRegexFieldSeparator();
	}
	
	public Object parse(String value){
		String f = "CompositeField.parse(String)";
		try{
			boolean print = false;
			if(value.equals("|")){
				throw new Exception("Field \""+this.getName()+"\" received a vertical bar");
			}
			CompositeFieldDefinition def = this.getDefinition();
			String delimiter = this.getRegexFieldSeparator();
			if(print){
				int depth = this.getDepth();
				System.out.println(f+": Depth is "+depth+", delimiter is \""+delimiter+"\". About to parse value \""+value+"\" for field "+this.getName());
			}
			//System.out.println("Component count for field "+def.getName()+" is "+count);
			int count;
			boolean joined = Hl7RegexHelper.isJoined(value, delimiter);
			if(joined){
				//System.out.println(f+": value \""+value+"\" contains a delimiter, will split before parsing");
				count = def.getComponentCount();
			}else{
				//System.out.println(f+": value \""+value+"\" does not contain a delimiter, will only parse the first component");
				count = 1;
			}
			@SuppressWarnings("unchecked")
			Optional<Object>[] components = new Optional[count];
			if(joined){
				String[] splat = value.split(delimiter);
				for(int i = 0; i < count && i < splat.length; i++){
					Hl7FieldDefinition cd = def.getComponent(i);
					components[i] = Optional.of(cd.parse(splat[i]));
				}
			}else{
				//System.out.println("Composite field "+this.getName()+" does not have any delimiters, assuming we are only parsing the first field");
				if(!def.hasComponent(0)){
					if(def.getComponentCount() == 0){
						throw new Exception(f+": "+def.getFieldType()+" definition \""+def.getName()+"\"  not have any components");
					}
					//System.out.println(f+": definition does not have a component 0");
					for(int i = 0; i < def.getComponentCount(); i++){
						Hl7FieldDefinition fd = def.getComponent(i);
						System.out.println(fd.getFieldType() + " " + fd.getName());
					}
					throw new Exception();
				}
				Hl7FieldDefinition cd = def.getComponent(0);
				components[0] = Optional.of(cd.parse(value));
			}
			this.components = components;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public boolean hasDefinition(){
		return this.definition != null && this.definition instanceof CompositeFieldDefinition;
	}
	
	public CompositeFieldDefinition getDefinition(){
		try{
			if(!this.hasDefinition()){
				throw new Exception("Field definition is undefined");
			}
			return this.definition;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public int getComponentNumber(String name){
		return this.getDefinition().getComponentNumber(name);
	}
	
	public String getComponentName(int i){
		return this.getDefinition().getComponentName(i);
	}
	
	public Object getComponentValue(String name){
		return this.getComponent(this.getComponentNumber(name));
	}
	
	public Object getComponentValue(int i){
		String f = "Hl7Segment.getComponentValue(int)";
		try{
			if(!this.hasComponentValue(i)){
				throw new Exception(f+": Value for component "+i+" is undefined");
			}
			return this.getComponent(i);
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public Object getComponent(int i){
		return this.components[i].get();
	}
	
	public Object getComponent(String name){
		return this.getComponent(this.getComponentNumber(name));
	}
	
	public boolean hasComponentValue(String name){
		return this.hasComponentValue(this.getComponentNumber(name));
	}

	public boolean hasComponentValue(int i){
		try{
			return this.components != null 
					&& i < this.components.length 
					&& this.components[i] instanceof Optional 
					&& this.components[i].isPresent();
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return false;
	}
	
	public CompositeFieldDefinition setDefinition(CompositeFieldDefinition definition){
		return this.definition = definition;
	}
	
	public Hl7ElementDefinition setDefinition(Hl7ElementDefinition definition){
		return this.setDefinition((CompositeFieldDefinition) definition);
	}
	
	public String toString(){
		return this.getName()+":"+Arrays.toString(this.components);
	}

	public int getComponentCount(){
		return this.components == null ? 0 : this.components.length;
	}
}
