import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HomeRunHTMLRpt extends HomeRunTextRpt {

	//uses constructor from parent
	public HomeRunHTMLRpt(String dataFile, String reportFile) {
		super(dataFile, reportFile);
	}
	//generates the html code required
	public void generateReport(ArrayList<DataPair> data){
		try{
			FileWriter output = new FileWriter(m_reportFile);
			BufferedWriter bufferedWriter =
	                new BufferedWriter(output);
			//generates the header needed
			bufferedWriter.write("<html>");
			bufferedWriter.newLine();
			bufferedWriter.write("<body>");
			bufferedWriter.newLine();
			bufferedWriter.write("<table>");
		for (DataPair a : data) {
			//creates the line of HTML code with the proper formating
			bufferedWriter.write("<tr><td>" + a.getName() + "</td><td>" + a.getStat()+ "</td><tr>");
			bufferedWriter.newLine();
			}
		//close the file
			bufferedWriter.close();
		}
		catch(IOException ex){
			System.out.println("Error with file");
		}
	}
	

}
