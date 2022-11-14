package segments;

import java.util.Arrays;
import java.util.Optional;

import core.CompositeElementInterface;
import core.DefinedInterface;
import core.Hl7ComponentInterface;
import core.Hl7ElementDefinition;
import core.Hl7RegexHelper;
import fields.CompositeField;
import fields.Hl7FieldDefinition;

public class Hl7Segment implements DefinedInterface, Hl7ComponentInterface, Hl7SegmentInterface{

	protected Optional<Object>[] components;
	protected Hl7SegmentDefinition definition;
	protected String segmentType;
	
	public Hl7Segment(Hl7SegmentDefinition definition){
		if(definition != null){
			this.setDefinition(definition);
			this.setSegmentType(definition.getSegmentType());
		}
	}
	
	public int getDepth(){
		return 1;
	}
	
	public String setSegmentType(String type){
		return this.segmentType = type;
	}
	
	public boolean hasSegmentType(){
		return this.segmentType != null;
	}
	
	public String getSegmentType(){
		try{
			if(!this.hasSegmentType()){
				throw new Exception("Segment type is undefined");
			}
			return this.segmentType;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public Object getComponentValue(String name){
		return this.getComponentValue(this.getComponentNumber(name));
	}
	
	public Object getComponent(int i){
		return this.components[i];
	}
	
	public Object getComponent(String name){
		return this.getComponent(this.getComponentNumber(name));
	}
	
	public boolean hasComponentValue(int i){
		return this.components != null 
				&& i < this.components.length 
				&& this.components[i] instanceof Optional 
				&& this.components[i].isPresent();
	}
	
	public boolean hasComponentValue(String name){
		int i = this.getComponentNumber(name);
		return this.hasComponentValue(i);
	}

	public boolean hasSubcomponentValue(String name1, String name2){
		return this.hasComponentValue(name1) && this.getComponent(name1) instanceof CompositeElementInterface && ((CompositeField)this.getComponent(name1)).hasComponentValue(name2);
	}

	public Object getSubcomponentValue(String name1, String name2){
		return ((CompositeField)this.getComponentValue(name1)).getComponentValue(name2);
	}

	public Object getSubcomponentValue(int i, int j){
		return ((CompositeField)this.getComponentValue(i)).getComponentValue(j);
	}
	
	public int getComponentValueInt(String name){
		return (int)this.getComponentValue(name);
	}

	public int getComponentNumber(String name){
		return this.getDefinition().getComponentNumber(name);
	}
	
	public String getComponentName(int i){
		return this.getDefinition().getComponentName(i);
	}
	
	public boolean hasDefinition(){
		return this.definition != null && this.definition instanceof Hl7SegmentDefinition;
	}
	
	public Hl7SegmentDefinition getDefinition(){
		try{
			if(!this.hasDefinition()){
				throw new Exception("Segment definition is undefined");
			}
			return this.definition;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public Object getComponentValue(int i){
		String f = "Hl7Segment.getComponentValue(int)";
		try{
			//System.out.println(f+": About to check if we have a component #"+i);
			if(!this.hasComponentValue(i)){
				System.out.println(Arrays.toString(this.components));
				System.out.println(this.components[i]);
				throw new Exception(f+": Value for component #"+i+" is undefined");
			}
			return this.components[i].get();
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public String getComponentValueString(int i){
		return (String) this.getComponentValue(i);
	}
	
	public String getComponentValueString(String name){
		return (String) this.getComponentValue(name);
	}

	public String getSubcomponentValueString(int i, int j){
		return (String) this.getSubcomponentValue(i, j);
	}
	
	public String getSubcomponentValueString(String name1, String name2){
		return (String) this.getSubcomponentValue(name1, name2);
	}
	
	public Hl7SegmentDefinition setDefinition(Hl7SegmentDefinition definition){
		return this.definition = definition;
	}

	public Hl7ElementDefinition setDefinition(Hl7ElementDefinition definition){
		return this.setDefinition((Hl7SegmentDefinition) definition);
	}
	
	public void parse(String s){
		try{
			String[] splat = s.split("\\|");
			if(splat.length < 1){
				throw new Exception("Unable to split string by vertical bar");
			}
			//System.out.println("Parsing segment "+this.getSegmentType()+". About to print split string");
			/*for(int i = 0; i < splat.length; i++){
				System.out.println(splat[i]);
			}*/
			Hl7SegmentDefinition def = this.getDefinition();
			int cc = def.getComponentCount();
			@SuppressWarnings("unchecked")
			Optional<Object>[] components = new Optional[cc];
			//components[0] = Optional.of(splat[0]); //this.getSegmentType();
			for(int i = 1; i < cc && i < splat.length; i++){
				if(splat[i].equals("|")){
					throw new Exception("Vertical bar at position "+i);
				}else if(splat[i].equals("") || splat[i] == null){
					//System.out.println("Null or empty string at position "+i);
					continue;
				}
				Hl7FieldDefinition cd = def.getComponent(i-1);
				//System.out.println("Component #"+i+" is "+cd.getName()+". About to parse \""+splat[i]+"\"");
				if(cd.isRepeatable() && Hl7RegexHelper.isJoined(splat[i], "\\~")){
					System.out.println("Repetition pttern match for "+splat[i]);
					components[i-1] = Optional.of(cd.parseRepeated(splat[i]));
				}else{
					Object component = cd.parse(splat[i]);
					components[i-1] = Optional.of(component);
				}
			}
			this.components = components;
			return;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
	}

	public int getComponentCount(){
		return this.components == null ? 0 : this.components.length;
	}
	
	public String toString(){
		String ret = this.getSegmentType();
		Hl7SegmentDefinition def = this.getDefinition();
		for(int i = 0; i < def.getComponentCount(); i++){
			Hl7FieldDefinition fd = def.getComponent(i);
			ret += "|";
			if(this.hasComponentValue(i)){
				ret += fd.convertString(this.getComponentValue(i));
			}
		}
		return ret;
	}
}
