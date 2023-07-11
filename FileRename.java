import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.StringTokenizer;

public class FileRename {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\91770\\Downloads\\ZoomDownloads\\");
		File files[] = file.listFiles();

		for (File item : files) {
			String fileName = item.getName();
			String fileNameDate = new StringTokenizer(fileName, "-").nextToken().substring(7).substring(2);
			String fileNameMonth = new StringTokenizer(fileName, "-").nextToken().substring(7);
			fileNameMonth = fileNameMonth.substring(0, fileNameMonth.length() - 2);
			switch (fileNameMonth) {
			case "05":
				System.out.println(fileNameDate + "_May");
				break;
			case "06":
				System.out.println(fileNameDate + "_June");
				break;
			case "07":
				System.out.println(fileNameDate + "_July");
				break;
			}
		}
	}
}
