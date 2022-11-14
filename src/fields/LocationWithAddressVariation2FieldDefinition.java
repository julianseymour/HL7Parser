package fields;

public class LocationWithAddressVariation2FieldDefinition extends CompositeFieldDefinition{

	/*public LocationWithAddressVariation2FieldDefinition(String name){
		super(name);
	}*/
	
	public LocationWithAddressVariation2FieldDefinition(){
		super();
	}
	
	protected void generateComponents(){
	//SEQ	COMPONENT NAME					Data Type	Usage	LEN	Conditional Predicate	Value Sets	COMMENTS
		this.components = new Hl7FieldDefinition[]{
	//1		Point of Care					IS			O												This represents the location within a facility that the service was provided. This is not the clinic site where an event occurred.
		Hl7FieldGenerator.define("IS").withName("PointOfCare").optional(),
	//2		Room							IS			O
		Hl7FieldGenerator.define("IS").withName("Room").optional(),
	//3		Bed								IS			O
		Hl7FieldGenerator.define("IS").withName("Bed").optional(),
	//4		Facility						HD			R									HL70362		This represents the location that the service was provided. For example the clinic.
		Hl7FieldGenerator.define("HD").withName("Facility").required(),
	//5		Location Status					IS			O
		Hl7FieldGenerator.define("IS").withName("LocationStatus").optional(),
	//6		Patient Location Type			IS			O
		Hl7FieldGenerator.define("IS").withName("PatientLocationType").optional(),
	//7		Building						IS			O
		Hl7FieldGenerator.define("IS").withName("Building").optional(),
	//8		Floor							IS			O
		Hl7FieldGenerator.define("IS").withName("Floor").optional(),
	//9		Street Address					ST			O
		Hl7FieldGenerator.define("ST").withName("StreetAddress").optional(),
	//10	Other Designation				ST			O
		Hl7FieldGenerator.define("ST").withName("OtherDesignation").optional(),
	//11	City							ST			O
		Hl7FieldGenerator.define("ST").withName("City").optional(),
	//12	State or Province				ST			O
		Hl7FieldGenerator.define("ST").withName("StateOrProvince").optional(),
	//13	Zip or Postal Code				ST			O
		Hl7FieldGenerator.define("ST").withName("ZipOrPostalCode").optional(),
	//14	Country							ID			O
		Hl7FieldGenerator.define("ID").withName("Country").optional(),
	//15	Address Type					ID			O
		Hl7FieldGenerator.define("ID").withName("AddressType").optional(),
	//16	Other Geographic Designation	ST			O
		Hl7FieldGenerator.define("ST").withName("OtherGeographicDesignation").optional()
		};
	}

	public String getFieldType(){
		return "LA2";
	}
}
