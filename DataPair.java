
public class DataPair {
	//variables that hold the name and corresponding stat
	private String m_name;
	private int m_stat;
	
	//constructor that sets corresponding variables
	public DataPair(String name, int stat){
		m_name = name;
		m_stat = stat;
	}
	
	//returns the name of the Datapair
	public String getName(){
		return m_name;
	}
	
	//returns the stat associated with the datapair
	public int getStat(){
		return m_stat;
	}
}
