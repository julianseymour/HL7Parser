package fields;

public class CodedValuesForUserDefinedTablesFieldDefinition extends AbstractStringFieldDefinition{

	public CodedValuesForUserDefinedTablesFieldDefinition(){
		super();
		//1 Coded Value for User-Defined Tables 1..20
		this.length(1,  20);
	}

	public CodedValuesForUserDefinedTablesFieldDefinition(String name){
		super(name);
	}

	public String getFieldType(){
		return "IS";
	}
}
