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
	// sets the variables to store needed values
	protected String m_dataFile;
	protected String m_reportFile;

	// Constructor for the report
	public HomeRunTextRpt(String dataFile, String reportFile) {
		m_dataFile = dataFile;
		m_reportFile = reportFile;
	}

	public ArrayList<DataPair> loadData() throws FileNotFoundException, IOException {
		ArrayList<DataPair> data = new ArrayList<DataPair>();
		// finds file to be read in current working directory
		File dataFile = new File("./" + m_dataFile);
		// reads the file
		try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
			while (reader.ready()) {
				String[] a = reader.readLine().split(",", -1);
				// gets the second element of the array to get the proper value
				if (a[1].isEmpty())
					a[1] = "0";
				// parse the second value to get a usable integer value
				data.add(new DataPair(a[0], Integer.parseInt(a[1])));
			}
		}
		return data;
	}

	public void generateReport(ArrayList<DataPair> data) {
		// creates and writes the values from data to the text file
		try {
			FileWriter output = new FileWriter(m_reportFile);
			BufferedWriter bufferedWriter = new BufferedWriter(output);
			//for each loop to write proper lines
			for (DataPair a : data) {
				bufferedWriter.write(a.getName() + " " + a.getStat());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException ex) {
			//when something goes wrong
			System.out.println("Error with file");
		}

	}
}
