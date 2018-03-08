import javafx.application.Application;
import javafx.stage.Stage;
import view.fx.FxView;

public class FXApp extends Application  {
    private int size = 3;

    public void launch(){
        launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FxView view = new FxView(size);
        view.show();
    }
}
