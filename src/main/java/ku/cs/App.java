package ku.cs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "Rainbow", 800, 600);
        configRoute();
        FXRouter.goTo("home");
    }

    private static void configRoute() {
        String packageStr = "ku/cs/";
        FXRouter.when("home", packageStr+"home.fxml");
        FXRouter.when("supply", packageStr+"supply.fxml");
        FXRouter.when("addProduct", packageStr+"addProduct.fxml");
        FXRouter.when("createProduct", packageStr+"createProduct.fxml");
        FXRouter.when("buyProduct", packageStr+"buyProduct.fxml");
        FXRouter.when("pre_order", packageStr+"pre_order.fxml");
        FXRouter.when("delivery", packageStr+"delivery.fxml");
        FXRouter.when("confirm", packageStr+"confirm.fxml");
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}