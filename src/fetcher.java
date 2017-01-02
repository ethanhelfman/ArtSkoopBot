import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class fetcher {
	
	final private int COLOR_LINES = 1301;
	final private int BAND_LINES = 20035;
	public String color;
	public String band;
	public Image img;
	
	public fetcher() throws IOException {
		color = getColor();
		band = getBand();
		img = getImage();
	}
	
	private String getColor() throws FileNotFoundException {
		int count = 1;
		File colors = new File("Colors.csv");
		Scanner kb = new Scanner(colors);
		int line = (int)(Math.random() * COLOR_LINES + 1);
		String cl = "";
		while(count != line) {
			cl = kb.nextLine();
			count++;
		}
		kb.close();
		cl.replaceAll("\\(.*?\\) ?", "");
		return cl;
	}
	
	private String getBand() throws FileNotFoundException {
		int words = (int)(Math.random() * 3 + 1);
		File word = new File("Bands.csv");
		Scanner kb = new Scanner(word);
		String band2 = "";
		for(int i = 0; i < words; i++) {
			kb = new Scanner(word);
			int count = 1;
			String str = "";
			int line = (int)(Math.random() * BAND_LINES + 1);
			while(count != line && kb.hasNextLine()) {
				str = kb.nextLine();
				count++;
			}
			band2 += str + " ";
		}
		band2 = band2.substring(0, band2.length() - 1);
		kb.close();
		return band2;
	}
	
	private Image getImage() throws IOException {
		File fl = new File("Artworks.csv");
		Scanner kb = new Scanner(fl);
		int imgnum = (int)(Math.random() * 55664 + 1);
		int count = 1;
		String str = "";
		while(count != imgnum && kb.hasNextLine()) {
			str = kb.nextLine();
			count++;
		}
		File fl2 = new File("temp.jpg");
		ImageIO.write(ImageIO.read(new URL(str)), "jpg", fl2);
		kb.close();
	    return ImageIO.read(new URL(str));
	}
}
