import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HomeRunTextRpt {
	protected String m_dataFile;
	protected String m_reportFile;

	public HomeRunTextRpt(String dataFile, String reportFile) {
		m_dataFile = dataFile;
		m_reportFile = reportFile;
	}

	public ArrayList<DataPair> loadData() throws FileNotFoundException, IOException {
		ArrayList<DataPair> data = new ArrayList<DataPair>();
		File dataFile = new File("./" + m_dataFile);
		try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
			while (reader.ready()) {
				String[] a = reader.readLine().split(",", -1);
				if (a[1].isEmpty()) 
					a[1] = "0";
				data.add(new DataPair(a[0], Integer.parseInt(a[1])));
			}
		}
		return data;
	}

	public void generateReport(ArrayList<DataPair> data) {
		try{
			FileWriter output = new FileWriter(m_reportFile);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(output);
		for (DataPair a : data) {
			bufferedWriter.write(a.getName() + " " + a.getStat());
			bufferedWriter.newLine();
			}
			bufferedWriter.close();
		}
		catch(IOException ex){
			System.out.println("Error with file");
		}
		
	}
}
