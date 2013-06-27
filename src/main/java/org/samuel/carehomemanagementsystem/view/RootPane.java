package org.samuel.carehomemanagementsystem.view;

import java.util.ArrayList;
import java.util.List;

import org.samuel.carehomemanagementsystem.domainModel.ServiceUser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class RootPane extends BorderPane implements ParentContainer{
    
    ManagementMenuBar menuBar;
    public RootPane(){
        initialiseComponents();
    }

    private void initialiseComponents() {
        VBox mainBox = new VBox();
        HBox menuBarBox = createMenuBar();
        HBox toolBarBox = createToolBar();
        menuBarBox.getChildren().add(menuBar);
        mainBox.getChildren().addAll(menuBarBox, toolBarBox);
        this.setTop(mainBox);
        this.setCenter(createCenterLayout());
        this.setLeft(createLeftLayout());
        this.setBottom(createButtomLayout());
    }

    private Node createButtomLayout() {
        HBox bottomBox = new HBox();
        bottomBox.getChildren().add(new Button("Bottom"));
        return bottomBox;
    }

    private Node createLeftLayout() {
        VBox leftLayout = new VBox();
        ObservableList<String> names = FXCollections.observableList(getServiceUsers());
        ListView list = new ListView(names);
        list.setManaged(isResizable());
        leftLayout.setVgrow(list, Priority.SOMETIMES);
        leftLayout.getChildren().add(list);
        return leftLayout;
    }

    private Node createCenterLayout() {
        StackPane ceneterPane = new StackPane();
        ceneterPane.setId("centerPane");
        return ceneterPane;
    }

    private HBox createMenuBar() {
        HBox menuBox = new HBox();
        menuBar = new ManagementMenuBar(this);
        addMenuItems();
        menuBox.setHgrow(menuBar, Priority.ALWAYS);
        return menuBox;
    }
    
    private HBox createToolBar() {
        HBox box = new HBox();
        ToolBar toolBar = new ToolBar(new Button("Print"), new Button("Service Users"),
                                      new Separator(), new Button("Infor"));
        box.setHgrow(toolBar, Priority.ALWAYS);
        box.getChildren().add(toolBar);
        return box;
    }

    public void addMenuItems(){
        
        MenuItem open = new MenuItem("Open");
        menuAccelerator(open, "Ctrl + O");
        menuBar.getFileMenu().getItems().add(open);
        MenuItem exit = new MenuItem("Exit");
        menuAccelerator(exit, "Ctrl + X");
        menuBar.getFileMenu().getItems().add(exit);
    }
    
    private void menuAccelerator(MenuItem menuItem, String text){
        menuItem.setAccelerator(KeyCombination.keyCombination(text));
    }
    
    private List<String> getServiceUsers(){
        List<String> su = new ArrayList<>();
        
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        su.add("Samuel");
        
        return su;
    }

}
