package organizer;

//import java.awt.Desktop;
import java.io.File;
//import java.io.IOException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Uploader {
//	private static Desktop desktop = Desktop.getDesktop();
	
	public Uploader() {
		// TODO Auto-generated constructor stub
	}
	
	static void openFile(File file) {
//		desktop.open(file);
		Media media = new Media((file).toURI().toString());
		MediaPlayer player = new MediaPlayer(media);
		player.play();
    }
	
	public static void configureFileChooser(FileChooser fileChooser) {      
		fileChooser.setTitle("Choose a Music File");
		
		fileChooser.setInitialDirectory(
				new File(System.getProperty("user.home"))
		);                 
		
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Audio Files", "*.mp3")
		);
	}
}
