import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StopWords {
	
	 List<String> stopwords;

	 StopWords() throws IOException {
	        stopwords = Files.readAllLines(Paths.get("stopwords.txt"));
	    }

	    boolean is_stopword(String token){
	        boolean ret = this.stopwords.contains(token);
	        if(ret){
	            System.out.println("Skipping Stop word : '" + token+"'");
	        }
	        return ret;
	    }

}
