package core;

public interface Hl7ComponentInterface{

	public abstract Object getComponentValue(String name);
	public abstract boolean hasComponentValue(String name);
	public abstract boolean hasSubcomponentValue(String name1, String name2);
	public abstract Object getSubcomponentValue(String name1, String name2);
	public abstract int getComponentValueInt(String name);
	public abstract String getComponentValueString(String name);
}
