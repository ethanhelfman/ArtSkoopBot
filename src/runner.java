import java.io.File;
import java.io.IOException;
import org.apache.commons.lang3.text.WordUtils;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class runner {

	public static void main(String[] args) throws IOException, TwitterException {
		//tester();
		post();
	}
	
	public static void post() throws TwitterException, IOException {
		fetcher ft = new fetcher();
		File fl = new File("temp.jpg");
		Twitter twitter = TwitterFactory.getSingleton();
		StatusUpdate status = new StatusUpdate(WordUtils.capitalize(ft.color + " " + ft.band));
		status.setMedia(fl);
		twitter.updateStatus(status);
		System.out.println("Posted!");
	}
	
	public static void tester() throws IOException, TwitterException {
		for(int i = 0; i < 25; i++) {
			post();
		}
	}

}
