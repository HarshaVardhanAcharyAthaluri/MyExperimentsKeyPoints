import java.nio.file.*;
import java.io.*;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\91770\\Downloads\\");
		File files[] = file.listFiles();
		
		for(File item:files) {
			  if (item.getName().contains(".mp4")) {
		       Files.copy(Paths.get("C:\\Users\\91770\\Downloads\\"+item.getName()), Paths.get("C:\\Users\\91770\\Downloads\\ZoomDownloads\\"+File.separator+item.getName()), StandardCopyOption.REPLACE_EXISTING);
			  System.out.println(item.getName() +" Copied ");
		    }
		}
		
		/**File file = new File("C:\\Users\\91770\\Documents\\Zoom");
		File files[] = file.listFiles();
		
		for (File file2 : files) {
				
			if(file2.isDirectory() && file2.getName().contains("JAVA FULL STACK")) {
				File fileitem = new File("C:\\Users\\91770\\Downloads\\"+file2.getName());
				File fileitems[] = fileitem.listFiles();
				for(File item:fileitems) {
					  if (item.getName().contains(".mp4")) {
				       Files.copy(Paths.get("C:\\Users\\91770\\Downloads\\"+file2.getName()+File.separator+item.getName()), Paths.get("C:\\Users\\91770\\Documents\\Zoom\\JavaFullStack"+File.separator+item.getName()), StandardCopyOption.REPLACE_EXISTING);
					  System.out.println(item.getName() +" Copied ");
				    }
				}
			}

		}*/

	}

}
