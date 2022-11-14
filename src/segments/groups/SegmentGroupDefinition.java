package segments.groups;

import core.CompositeElementInterface;
import core.Hl7ComponentDefinition;
import segments.Hl7SegmentGenerator;

public abstract class SegmentGroupDefinition extends Hl7ComponentDefinition implements CompositeElementInterface{
	
	protected Hl7SegmentGenerator segmentGenerator;
	
	public SegmentGroupDefinition(){
		String f = "SegmentGroupDefinition()";
		try{
			throw new Exception(f+": Illegal constructor call");
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
	}
	
	public SegmentGroupDefinition(Hl7SegmentGenerator gen){
		String f = "SegmentGroupDefinition(Hl7SegmentDenerator)";
		try{
			this.setSegmentGenerator(gen);
			if(!this.hasSegmentGenerator()){
				throw new Exception(f+": Segment generator is undefined in constructor");
			}
			this.generateComponents();
			/*for(int i = 0; i < this.getComponentCount(); i++){
				Hl7ComponentDefinition fd = this.getComponent(i);
				if(!fd.hasMaxCardinality() || fd.getMaxCardinality() > 1){
					System.out.println("Segment/group "+fd.getName()+" of group "+this.getName()+" has a max cardinality of "+fd.getMaxCardinality());
				}
			}*/
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
	}
	
	public int getComponentNumber(String name){
		return this.numbers.get(name);
	}

	public String getComponentName(int i){
		return this.getComponent(i).getName();
	}
	
	public Hl7SegmentGenerator setSegmentGenerator(Hl7SegmentGenerator sg){
		return this.segmentGenerator = sg;
	}
	
	public boolean hasSegmentGenerator(){
		return this.segmentGenerator != null && this.segmentGenerator instanceof Hl7SegmentGenerator;
	}
	
	public Hl7SegmentGenerator getSegmentGenerator(){
		String f = "SegmentGroupDefinition.getSegmentGenerator()";
		try{
			if(!this.hasSegmentGenerator()){
				throw new Exception(f+": HL7 segment generator is undefined");
			}
			return this.segmentGenerator;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public int getComponentCount(){
		return this.components == null ? 0 : this.components.length;
	}
}
