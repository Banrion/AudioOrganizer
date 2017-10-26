package organizer;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

		GridPane root = new GridPane();
		root.add(textField, 0, 0);
		root.add(chooseFileBtn, 0, 1);
//		root.getChildren().addAll(textField, chooseFileBtn);
		root.setPadding(new Insets(15));

	     BorderPane borderPane = new BorderPane();
	     borderPane.setCenter(root);
		primaryStage.setTitle("Hello World!");
		Scene scene = new Scene(borderPane, 1000, 600);
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
