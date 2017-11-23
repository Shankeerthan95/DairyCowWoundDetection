package com.shankeerthan;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.ValueAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private Canvas imageDisplay;

    public Main(){
        imageDisplay =new Canvas(); //HAVE TO handle initial size of canvas later point
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Border Pane is root for this software
        BorderPane root =new BorderPane();
        addNodesToRoot(root);
        Scene imageScene =new Scene(root,Values.DEFAULT_SCENE_WIDTH,Values.DEFAULT_SCENE_HEIGHT);

        //HAVE TO set tile with image name and app name set logo of the software
        styleStage(primaryStage);
        primaryStage.setScene(imageScene);
        primaryStage.show();
    }

    private void addNodesToRoot(BorderPane root){
        /*
        Center: Canvas contains imaged Thremal image and two left and right arrow to jump
                previous and next image
        Bottom :Simple HBOX to show images in folder
        Left  :Nothing
        Right : Like Tool bar contains all functionalities
         */

        //CEnter
        root.setCenter(imageDisplay);

        //Bottom
        HBox imagePositionBox =new HBox();
        imagePositionBox.setMinHeight(Values.IMAGE_POSITION_BOX_HEIGHT);
        root.setBottom(imagePositionBox);

        //Top
        HBox topBox=new HBox();
        topBox.setMinHeight(Values.TOP_BAR_HEIGHT);
        designTopBar(topBox);
        root.setTop(topBox);

        //Right
        VBox rightBox =new VBox();
        rightBox.setMinWidth(Values.RIGHT_BAR_WIDTH);
        root.setRight(rightBox);
    }
    private void styleStage(Stage stage){
        stage.initStyle(StageStyle.DECORATED);
    }
    private void designTopBar(HBox container){
        //Menu button
        Button smallMenuButton =new Button();
        Image menuIcon =new Image("file:"+"Icons/cat.png");
        smallMenuButton.setGraphic(new ImageView(menuIcon));

        //Canvas to show name of the image
        Canvas nameCanvas =new Canvas();
        nameCanvas.setWidth(Values.DEFAULT_NAME_CANVAS_WIDTH);
        nameCanvas.setHeight(Values.DEFAULT_TOP_BAR_NODES_HEIGHT);

        //Zoom Selecton Button
        Button zoomSelectionButton=new Button();
        Image zoomSelectionIcon =new Image("file:"+"Icons/menu.cdr");
        zoomSelectionButton.setGraphic(new ImageView(zoomSelectionIcon));

        //Color pallete Drop down
        ComboBox colorPallete =new ComboBox();
        colorPallete.getItems().addAll("Rain","Rainbow","Ironbow","Fusion","Sepia","Color1","Color2","White Hot","Black Hot","Globow");


        //zoom  button
        Button zoomButton =new Button();
        Image zoomIcon =new Image("file:"+"Icons/zoom.cdr");
        zoomButton.setGraphic(new ImageView(zoomIcon));

        //Rotate left button
        Button rotateLeftButton=new Button();
        Image rotateLeftIcon =new Image("file:"+ "Icons/rotate_left.cdr");
        rotateLeftButton.setGraphic(new ImageView(rotateLeftIcon));

        //Rotate right button
        Button rotateRightButton=new Button();
        Image rotateRightIcon =new Image("file:"+"Icons/rotate_right.cdr");
        rotateRightButton.setGraphic(new ImageView(rotateRightIcon));

        //Crop button
        Button cropButton =new Button();
        Image cropImageIcon=new Image("file:"+ "Icons/crop.cdr");
        cropButton.setGraphic(new ImageView(cropImageIcon));

        //ShowHide side bar  Button
        Button showSidebarButton =new Button();
        Image showSidebarIcon=new Image("file:"+ "Icons/show_sidebar.cdr");
        showSidebarButton.setGraphic(new ImageView(showSidebarIcon));

        //Hide side bar button
        Button hideSidebarButton =new Button();
        Image hideSidebarImageIcon = new Image("file:"+"Icons/hide_sidebar.cdr");
        hideSidebarButton.setGraphic(new ImageView(hideSidebarImageIcon));

        //About us button
        Button aboutUsButton= new Button();
        Image aboutUsIcon =new Image("file:"+"Icons/aboutus.cdr");
        aboutUsButton.setGraphic(new ImageView(aboutUsIcon));


        container.setSpacing(Values.TOP_BOX_SPACING);
        container.getChildren().add(smallMenuButton);
        container.getChildren().add(nameCanvas);
        container.getChildren().add(zoomSelectionButton);
        container.getChildren().add(colorPallete);
        container.getChildren().add(zoomButton);
        container.getChildren().add(rotateRightButton);
        container.getChildren().add(rotateLeftButton);
        container.getChildren().add(cropButton);
        container.getChildren().add(showSidebarButton);
        container.getChildren().add(hideSidebarButton);
        container.getChildren().add(aboutUsButton);
    }
}