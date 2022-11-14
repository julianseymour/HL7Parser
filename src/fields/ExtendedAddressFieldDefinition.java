package fields;

public class ExtendedAddressFieldDefinition extends CompositeFieldDefinition{
	
	/*public ExtendedAddressFieldDefinition(String name){
		super(name);
	}*/
	
	public ExtendedAddressFieldDefinition(){
		super();
	}
	
	protected void generateComponents() {
		this.components = new Hl7FieldDefinition[]{
	//SEQ	COMPONENT NAME					Data Type	Usage	LEN		Conditional Predicate	Value Sets						COMMENTS
	//1 	Street Address 					SAD			RE
		Hl7FieldGenerator.define("SAD").withName("StreetAddress").requiredEmpty(),
	//2 	Other Designation				ST			RE		1..120
		Hl7FieldGenerator.define("ST").withName("OtherDesignation").length(1, 120),
	//3 	City							ST			RE		1..50
		Hl7FieldGenerator.define("ST").withName("City").requiredEmpty().length(1, 50),
	//4 	State or Province				ST			RE		1..50							US Postal Service state codes	Two character USPS codes, for example: AL, AK, ME
		Hl7FieldGenerator.define("ST").withName("StateOrProvince").requiredEmpty().length(1, 50),
	//5 	Zip or Postal Code				ST			RE		1..12
		Hl7FieldGenerator.define("ST").withName("ZipOrPostalCode").requiredEmpty().length(1, 12),
	//6 	Country							ID			RE		3..3							HL70399							Empty defaults to USA
		Hl7FieldGenerator.define("ID").withName("Country").requiredEmpty().length(3, 3),
	//7 	Address Type					ID			R		1..3							HL70190
		Hl7FieldGenerator.define("ID").withName("AddressType").required().length(1, 3),
	//8 	Other Geographic Designation	ST			O
		Hl7FieldGenerator.define("ST").withName("OtherGeographicDesignation").optional(),
	//9 	County/Parish Code				IS			O
		Hl7FieldGenerator.define("IS").withName("CountyParishCode").optional(),
	//10 	Census Tract					IS			O
		Hl7FieldGenerator.define("IS").withName("CensusTract").optional(),
	//11 	Address Representation Code		ID			O
		Hl7FieldGenerator.define("ID").withName("AddressRepresentationCode").optional(),
	//12 	Address Validity Range			DR			X																	deprecated as of v 2.5
		Hl7FieldGenerator.define("DR").withName("AddressValidityRange").unsupported(),
	//13 	Effective Date					TS			O
		Hl7FieldGenerator.define("TS").withName("EffectiveDate").optional(),
	//14 	Expiration Date					TS			O
		Hl7FieldGenerator.define("TS").withName("ExpirationDate").optional(),
		};
	}

	public String getFieldType(){
		return "XAD";
	}
}
