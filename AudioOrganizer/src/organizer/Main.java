package organizer;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		Button chooseFileBtn = new Button();
		chooseFileBtn.setText("Load a Music File");
		final FileChooser fileChooser = new FileChooser();
		final TextField textField = new TextField ();
		
		chooseFileBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				textField.clear();
				Uploader.configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(primaryStage);
                
                if (file != null) {
                    Uploader.openFile(file);
                    printLog(textField, file);
                }
			}
		});
		
		StackPane root = new StackPane();
		root.getChildren().addAll(textField, chooseFileBtn);
		
		Scene scene = new Scene(root, 1000, 600);
		
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	 private void printLog(TextField textField, File file) {
		 if (file == null) {
			 return;
		 }
		 
		 textField.appendText(file.getAbsolutePath());
	 }

	public static void main(String[] args) {
		launch(args);
	}
}
