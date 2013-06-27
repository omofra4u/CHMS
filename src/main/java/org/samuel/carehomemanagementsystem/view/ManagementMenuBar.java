package org.samuel.carehomemanagementsystem.view;

import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ManagementMenuBar extends MainMenuBar {
    
    private Menu fileMenu;
    private Menu helpMenu;
    private Menu searchMenu;
    private Menu referralsMenu;
    
    public ManagementMenuBar(ParentContainer owner){
        
        initialiseMenuBar();
        BorderPane parent = (BorderPane)owner;
        parent.getChildren().add(this);
    }

    private void initialiseMenuBar() {
        
        fileMenu = new Menu("File");
        helpMenu = new Menu("Help");
        
        this.getMenus().add(fileMenu);
        this.getMenus().add(helpMenu);
        
    }

    public Menu getFileMenu() {
        return fileMenu;
    }

    public Menu getHelpMenu() {
        return helpMenu;
    }

    public Menu getSearchMenu() {
        return searchMenu;
    }

    public Menu getReferralsMenu() {
        return referralsMenu;
    }

}
