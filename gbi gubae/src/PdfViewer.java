import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PdfViewer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a WebView
       // Create a WebView
WebView webView = new WebView();

// Load the PDF file
String pdfFilePath;  // Replace with the actual path to your PDF file
        pdfFilePath = "C:\\Users\\hp\\Downloads\\Telegram Desktop\\SQL.pdf";
webView.getEngine().load(pdfFilePath);

// Create a layout and add the WebView to it
StackPane root = new StackPane();
root.getChildren().add(webView);

// Set up the stage
Scene scene = new Scene(root, 800, 600);
primaryStage.setTitle("PDF Viewer");
primaryStage.setScene(scene);
primaryStage.show();
    }
}