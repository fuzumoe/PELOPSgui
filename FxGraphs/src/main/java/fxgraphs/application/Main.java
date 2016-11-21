package fxgraphs.application;

import fxgraphs.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private Controller controller;
	private FXMLLoader loader;
	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.setPrimaryStage(primaryStage);
		mainWindow();
	}

	/**
	 * X this method constructs the scene and the stage to be displayed
	 */
	public void mainWindow() {

		try {

			this.setLoader();
			AnchorPane pane = this.getLoader().load();

			this.setController(loader);
			controller.setMain(this);

			scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("/fxgraphs/view/application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method sets the FXML doc loader objects
	 */
	public void setLoader() {
		
		System.out.println(getClass().getResource("/fxgraphs/view/piechart.fxml").toString());
		loader = new FXMLLoader(getClass().getResource("/fxgraphs/view/LineChart.fxml"));
//		loader = new FXMLLoader(getClass().getResource("/fxgraphs/view/piechart.fxml"));
	}

	/**
	 *
	 * @return
	 */
	public FXMLLoader getLoader() {
		return loader;
	}

	/**
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 *
	 * @param loader
	 */
	public void setController(FXMLLoader loader) {
		this.controller = loader.getController();
	}

	/**
	 *
	 * @return
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 *
	 * @param primaryStage
	 */
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
