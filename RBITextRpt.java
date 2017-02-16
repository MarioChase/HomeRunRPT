import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RBITextRpt extends HomeRunTextRpt {

	public RBITextRpt(String dataFile, String reportFile) {
		super(dataFile, reportFile);
	}
	
	public ArrayList<DataPair> loadData() throws FileNotFoundException, IOException {
		
		ArrayList<DataPair> data = new ArrayList<DataPair>();
		File dataFile = new File("./" + m_dataFile);
		try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
			//grabs the third element int the array
			while (reader.ready()) {
				String[] a = reader.readLine().split(",", -1);
				if (a[2].isEmpty()) 
					a[2] = "0";
				data.add(new DataPair(a[0], Integer.parseInt(a[2])));
			}
		}
		return data;
	}

}
