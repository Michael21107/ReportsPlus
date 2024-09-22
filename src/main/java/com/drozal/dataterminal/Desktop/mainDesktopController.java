package com.drozal.dataterminal.Desktop;

import com.drozal.dataterminal.DataTerminalHomeApplication;
import com.drozal.dataterminal.Desktop.Utils.AppUtils.DesktopApp;
import com.drozal.dataterminal.Desktop.Utils.WindowUtils.CustomWindow;
import com.drozal.dataterminal.Launcher;
import com.drozal.dataterminal.Windows.Apps.CalloutViewController;
import com.drozal.dataterminal.Windows.Apps.CourtViewController;
import com.drozal.dataterminal.Windows.Apps.LogViewController;
import com.drozal.dataterminal.Windows.Main.actionController;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import static com.drozal.dataterminal.Desktop.Utils.AppUtils.AppUtils.editableDesktop;
import static com.drozal.dataterminal.Desktop.Utils.WindowUtils.WindowManager.createFakeWindow;

public class mainDesktopController {
	
	@javafx.fxml.FXML
	private Button button1;
	@javafx.fxml.FXML
	private BorderPane taskBar;
	@javafx.fxml.FXML
	private HBox taskBarApps;
	@javafx.fxml.FXML
	private AnchorPane bottomBar;
	@javafx.fxml.FXML
	private AnchorPane desktopContainer;
	@javafx.fxml.FXML
	private VBox container;
	
	double verticalSpacing = 100.0;
	
	private void addAppToDesktop(AnchorPane root, AnchorPane newApp, int appIndex) {
		AnchorPane.setLeftAnchor(newApp, 28.0);
		AnchorPane.setTopAnchor(newApp, 31.0 + (appIndex * verticalSpacing));
		root.getChildren().add(newApp);
	}
	
	public void initialize() {
		button1.setOnAction(event -> editableDesktop = !editableDesktop);
		
		DesktopApp desktopAppObj = new DesktopApp("Main App", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane newApp = desktopAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					CustomWindow mainApplicationWindow = createFakeWindow(desktopContainer,
					                                                      "Windows/Main/DataTerminalHome-view.fxml",
					                                                      "Primary", true, 1, false, taskBarApps);
					
					DataTerminalHomeApplication.controller = (com.drozal.dataterminal.Windows.Main.actionController) mainApplicationWindow.controller;
				}
			}
		});
		addAppToDesktop(desktopContainer, newApp, 0);
		
		DesktopApp notesAppObj = new DesktopApp("Notes", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane notesApp = notesAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					CustomWindow mainApp = createFakeWindow(desktopContainer, "Windows/Other/notes-view.fxml",
					                                        "Notes Application", true, 2, true, taskBarApps);
					actionController.notesViewController = (com.drozal.dataterminal.Windows.Other.NotesViewController) mainApp.controller;
				}
			}
		});
		addAppToDesktop(desktopContainer, notesApp, 1);
		
		DesktopApp settingsAppObj = new DesktopApp("Settings", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane settingsApp = settingsAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					createFakeWindow(desktopContainer, "Windows/Settings/settings-view.fxml", "Settings Application",
					                 true, 2, true, taskBarApps);
				}
			}
		});
		addAppToDesktop(desktopContainer, settingsApp, 2);
		
		DesktopApp updatesAppObj = new DesktopApp("Updates", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane updatesApp = updatesAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					createFakeWindow(desktopContainer, "Windows/Misc/updates-view.fxml", "Settings Application", true,
					                 2, true, taskBarApps);
				}
			}
		});
		addAppToDesktop(desktopContainer, updatesApp, 3);
		
		DesktopApp debugLogsAppObj = new DesktopApp("Output Logs", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane debugLogsApp = debugLogsAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					createFakeWindow(desktopContainer, "Windows/Misc/output-view.fxml", "Application Logs", false, 2,
					                 true, taskBarApps);
				}
			}
		});
		addAppToDesktop(desktopContainer, debugLogsApp, 4);
		
		DesktopApp lookupSettingsAppObj = new DesktopApp("Lookup Config", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane lookupSettingsApp = lookupSettingsAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					createFakeWindow(desktopContainer, "Windows/Settings/probability-settings-view.fxml",
					                 "Lookup Probability Config", false, 2, true, taskBarApps);
				}
			}
		});
		addAppToDesktop(desktopContainer, lookupSettingsApp, 5);
		
		DesktopApp logBrowserAppObj = new DesktopApp("Log Browser", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane logBrowserApp = logBrowserAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					CustomWindow logapp = createFakeWindow(desktopContainer, "Windows/Apps/log-view.fxml", "Log Viewer",
					                                       true, 2, true, taskBarApps);
					LogViewController.logController = (LogViewController) logapp.controller;
				}
			}
		});
		addAppToDesktop(desktopContainer, logBrowserApp, 6);
		
		DesktopApp calloutManagerAppObj = new DesktopApp("Callouts", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane calloutManagerApp = calloutManagerAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					CustomWindow logapp = createFakeWindow(desktopContainer, "Windows/Apps/callout-view.fxml",
					                                       "Callout Manager", true, 2, true, taskBarApps);
					CalloutViewController.calloutViewController = (CalloutViewController) logapp.controller;
				}
			}
		});
		addAppToDesktop(desktopContainer, calloutManagerApp, 7);
		
		DesktopApp courtAppObj = new DesktopApp("CourtCase", new Image(
				Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/icons/Logo.png")));
		AnchorPane courtApp = courtAppObj.createDesktopApp(mouseEvent -> {
			if (!editableDesktop) {
				if (mouseEvent.getClickCount() == 2) {
					CustomWindow logapp = createFakeWindow(desktopContainer, "Windows/Apps/court-view.fxml",
					                                       "Court Case Manager", true, 2, true, taskBarApps);
					CourtViewController.courtViewController = (CourtViewController) logapp.controller;
				}
			}
		});
		addAppToDesktop(desktopContainer, courtApp, 8);
		
		Platform.runLater(() -> {
			// todo add ability for custom image
			Image image = new Image(
					Launcher.class.getResourceAsStream("/com/drozal/dataterminal/imgs/desktopBackground.jpg"));
			BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
			                                                      BackgroundRepeat.NO_REPEAT,
			                                                      BackgroundPosition.DEFAULT,
			                                                      new BackgroundSize(100, 100, true, true, false,
			                                                                         true));
			
			container.setBackground(new Background(backgroundImage));
		});
	}
	
	public AnchorPane getDesktopContainer() {
		return desktopContainer;
	}
	
	public Button getButton1() {
		return button1;
	}
	
	public BorderPane getTaskBar() {
		return taskBar;
	}
	
	public HBox getTaskBarApps() {
		return taskBarApps;
	}
}