package fields;

public class TimestampFieldDefinition extends CompositeFieldDefinition{

	/*public TimestampFieldDefinition(String name){
		super(name);
	}*/
	
	public TimestampFieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
		try{
			//SEQ	COMPONENT NAME		Data Type	Usage	LEN	Conditional Predicate	Value Set	COMMENTS
			this.components = new Hl7FieldDefinition[]{
			//1		Time				DTM			R
				Hl7FieldGenerator.define("DTM").withName("Time").required().length(3, 9),
			//2		Degree of Precision	ID			X
				Hl7FieldGenerator.define("ID").withName("DegreeOfPrecision").unsupported()
			};
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
	}

	public String getFieldType(){
		return "TS";
	}
	
	
	//The DTM component of this Time Stamp has the following constraints:
	//	YYYY							R
	//	MM								R
	//	DD								R
	//	HH								O
	//	MM								O
	//	[SS[.S[S[S[S]]]]]				O
	//	+/-ZZZZ							O
}
