package fields;

public class CompositeQuantityWithUnitsFieldDefinition extends CompositeFieldDefinition{

	/*public CompositeQuantityWithUnitsFieldDefinition(String name){
		super(name);
	}*/
	
	public CompositeQuantityWithUnitsFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		this.components = new Hl7FieldDefinition[]{
			//1	Quantity	NM	R	16
				Hl7FieldGenerator.define("NM").withName("Quantity").required().length(1, 16),
			//2	Units		CE	R		HL7 0126 (constrained)
				Hl7FieldGenerator.define("CE").withName("Units").required()
		};
	}

	public String getFieldType(){
		return "CQ";
	}
}
