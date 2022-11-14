package core;

import java.util.Optional;

public abstract class Hl7ComponentDefinition extends Hl7ElementDefinition{

	public abstract String getName();
	
	protected Optional<ConditionalPredicate> conditionalPredicate;
	protected Optional<Integer> minLength;
	protected Optional<Integer> maxLength;
	protected String usageSymbol;
	protected Optional<Integer> minCardinality;
	protected Optional<Integer> maxCardinality;

	public int setMinLength(int min){
		try{
			if(min < 0){
				throw new Exception("Minimum length cannot be less than 0 for field "+this.getName()+"\"");
			}else if(this.hasMaxLength() && this.getMaxLength() < min){
				throw new Exception("Minimum length cannot exceed maximum for field \""+this.getName()+"\"");
			}
			this.minLength = Optional.of(min);
			return min;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return -1;
	}
	
	public boolean hasMinLength(){
		return this.minLength instanceof Optional<?> && this.minLength.isPresent();
	}
	
	public int getMinLength(){
		if(!this.hasMinLength()){
			return 0;
		}
		return this.minLength.get();
	}
	
	public int setMaxLength(int max){
		try{
			if(max < 1){
				throw new Exception("Maximum length cannot be less than 1 for field "+this.getName()+"\"");
			}else if(this.hasMinLength() && this.getMinLength() > max){
				throw new Exception("Maximum length cannot be less than minimum for field \""+this.getName()+"\"");
			}
			this.maxLength = Optional.of(max);
			return max;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return -1;
	}
	
	public boolean hasMaxLength(){
		return this.maxLength instanceof Optional<?> && this.maxLength.isPresent();
	}
	
	public int getMaxLength(){
		try{
			if(!this.hasMaxLength()){
				throw new Exception("Maximum length is undefined for field \""+this.getName()+"\"");
			}
			return this.maxLength.get();
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return -1;
	}
	
	public String setUsageSymbol(String symbol){
		try{
			if(!UsageConformance.validate(symbol)){
				throw new Exception("Invalid usage symbol \""+symbol+"\"");
			}
			return this.usageSymbol = symbol;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return symbol;
	}
	
	public boolean hasUsageSymbol(){
		return this.usageSymbol != null;
	}
	
	public String getUsageSymbol(Hl7ComponentInterface segment){
		try{
			if(this.hasConditionalPredicate()){
				ConditionalPredicate closure = this.getConditionalPredicate();
				return closure.evaluate(segment);
			}
			if(!this.hasUsageSymbol()){
				throw new Exception("Field \""+this.getName()+"\" does not have a usage symbol");
			}
			return this.usageSymbol;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return UsageConformance.USAGE_UNSUPPORTED;
	}
	
	public ConditionalPredicate setConditionalPredicate(ConditionalPredicate closure){
		this.setUsageSymbol(UsageConformance.USAGE_CONDITIONAL);
		this.conditionalPredicate = Optional.of(closure);
		return closure;
	}
	
	public boolean hasConditionalPredicate(){
		return this.conditionalPredicate instanceof Optional<?> && this.conditionalPredicate.isPresent();
	}
	
	public ConditionalPredicate getConditionalPredicate(){
		try{
			if(!this.hasConditionalPredicate()){
				throw new Exception("Conditional predicate is undefined for field \""+this.getName()+"\"");
			}
			return this.conditionalPredicate.get();
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public int setMinCardinality(int min){
		try{
			if(min < 0){
				throw new Exception("Minimum Cardinality cannot be less than 0 for field "+this.getName()+"\"");
			}else if(this.hasMaxCardinality() && this.getMaxCardinality() < min){
				throw new Exception("Minimum Cardinality cannot exceed maximum for field \""+this.getName()+"\"");
			}
			this.minCardinality = Optional.of(min);
			return min;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return -1;
	}
		
	public boolean hasMinCardinality(){
		return this.minCardinality instanceof Optional<?> && this.minCardinality.isPresent();
	}

	public int getMinCardinality(){
		if(!this.hasMinCardinality()){
			return 0;
		}
		return this.minCardinality.get();
	}
	
	public int setMaxCardinality(int max){
		try{
			if(max < 0){
				throw new Exception("Maximum cardinality cannot be less than 0 for field "+this.getName()+"\"");
			}else if(this.hasMinCardinality() && this.getMinCardinality() > max){
				throw new Exception("Miniimum cardinality cannot exceed maximum for field \""+this.getName()+"\"");
			}
			this.maxCardinality = Optional.of(max);
			return max;
		}catch(Throwable x){
			x.printStackTrace();
			System.exit(-1);
		}
		return -1;
	}
		
	public boolean hasMaxCardinality(){
		return this.maxCardinality instanceof Optional<?> && this.maxCardinality.isPresent();
	}

	public int getMaxCardinality(){
		if(!this.hasMaxCardinality()){
			return 0;
		}
		return this.maxCardinality.get();
	}
	
	public String getSegmentType(){
		try{
			throw new Exception("For compatiblity purposes with SegmentGroupValidator only");
		}catch(Throwable x){
			System.err.println(x.toString());
			x.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
	
	public Hl7ComponentDefinition conditional(ConditionalPredicate closure){
		this.setConditionalPredicate(closure);
		return this;
	}
	
	public Hl7ComponentDefinition cardinality(int min, int max){
		this.setMinCardinality(min);
		this.setMaxCardinality(max);
		return this;
	}
	
	public Hl7ComponentDefinition usage(String symbol){
		this.setUsageSymbol(symbol);
		return this;
	}
	
	public Hl7ComponentDefinition optional(){
		return this.usage(UsageConformance.USAGE_OPTIONAL);
	}
	
	public Hl7ComponentDefinition required(){
		return this.usage(UsageConformance.USAGE_REQUIRED);
	}
	
	public Hl7ComponentDefinition requiredEmpty(){
		return this.usage(UsageConformance.USAGE_REQUIRED_EMPTY);
	}
	
	public Hl7ComponentDefinition unsupported(){
		return this.usage(UsageConformance.USAGE_UNSUPPORTED);
	}
	
	public Hl7ComponentDefinition length(int min, int max){
		this.setMinLength(min);
		this.setMaxLength(max);
		return this;
	}
	
	public Hl7ComponentDefinition withMinCardinality(int min){
		this.setMinCardinality(min);
		return this;
	}
}
