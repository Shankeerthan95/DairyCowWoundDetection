package com.shankeerthan;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.MalformedURLException;

public class Main extends Application {
    private Canvas imageDisplay;
    private Stage stage;
    public Main(){
        imageDisplay =new Canvas(); //HAVE TO handle initial size of canvas later point
        imageDisplay.getStyleClass().add("imagecanvas");
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Get reference of primaryStage to use in code further
        stage=primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        //Border Pane is root for this software
        BorderPane root =new BorderPane();
        root.getStyleClass().add("scene");
        root.getStylesheets().add("file:StyleSheet/style1.css");
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
        designBottomBox(imagePositionBox);
        root.setBottom(imagePositionBox);

        //Top
        HBox topBox=new HBox();
        topBox.setMinHeight(Values.TOP_BAR_HEIGHT);
        designTopBar(topBox);
        root.setTop(topBox);

        //Right
        VBox rightBox =new VBox();
        rightBox.setMinWidth(Values.RIGHT_BAR_WIDTH);
        designRightBox(rightBox);
        root.setRight(rightBox);
    }
    private void styleStage(Stage stage){
        stage.initStyle(StageStyle.DECORATED);
    }
    private void designTopBar(HBox container){
        //Menu button
        Button smallMenuButton =new Button();
        handleSmallMenuButton(smallMenuButton,container);
        Image menuIcon =new Image("file:"+"Icons/menu.png");
        ImageView menuIconView =new ImageView(menuIcon);
        smallMenuButton.setGraphic(new ImageView(menuIcon));

        //Canvas to show name of the image
        Canvas nameCanvas =new Canvas();
        nameCanvas.setWidth(Values.DEFAULT_NAME_CANVAS_WIDTH);
        nameCanvas.setHeight(Values.DEFAULT_TOP_BAR_NODES_HEIGHT);

        //Zoom Selecton Button
        Button zoomSelectionButton=new Button();
        handleZoomSelectionButton(zoomSelectionButton,container);
        Image zoomSelectionIcon =new Image("file:"+"Icons/menu.png");
        zoomSelectionButton.setGraphic(new ImageView(zoomSelectionIcon));

        //Color pallete Drop down
        ComboBox colorPallete =new ComboBox();
        colorPallete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("fgfdgf");
            }
        });
        colorPallete.getStyleClass().add("combobox");
        colorPallete.getItems().addAll("Rain","Rainbow","Ironbow","Fusion","Sepia","Color1","Color2","White Hot","Black Hot","Globow");


        //zoom  button
        Button zoomButton =new Button();
        Image zoomIcon =new Image("file:"+"Icons/zoom.png");
        zoomButton.setGraphic(new ImageView(zoomIcon));

        //Rotate left button
        Button rotateLeftButton=new Button();
        Image rotateLeftIcon =new Image("file:"+"Icons/rotate_left.png" );
        rotateLeftButton.setGraphic(new ImageView(rotateLeftIcon));

        //Rotate right button
        Button rotateRightButton=new Button();
        Image rotateRightIcon =new Image("file:"+"Icons/rotate_right.png");
        rotateRightButton.setGraphic(new ImageView(rotateRightIcon));

        //Crop button
        Button cropButton =new Button();
        Image cropImageIcon=new Image("file:"+ "Icons/crop.png");
        cropButton.setGraphic(new ImageView(cropImageIcon));

        //ShowHide side bar  Button
        Button showSidebarButton =new Button();
        Image showSidebarIcon=new Image("file:"+ "Icons/show_sidebar.png");
        showSidebarButton.setGraphic(new ImageView(showSidebarIcon));

        //Hide side bar button
        Button hideSidebarButton =new Button();
        Image hideSidebarImageIcon = new Image("file:"+"Icons/hide_sidebar.png");
        hideSidebarButton.setGraphic(new ImageView(hideSidebarImageIcon));

        //About us button
        Button aboutUsButton= new Button();
        Image aboutUsIcon =new Image("file:"+"Icons/about_us.png");
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
    private void designBottomBox(HBox container){
        //It has a slider to show position of current image in particular directory
        Slider positionShower =new Slider();
        positionShower.setOrientation(Orientation.HORIZONTAL);
        //sET slider to have width lesser than Stage widdth
        positionShower.setPrefWidth(Values.DEFAULT_SCENE_WIDTH-Values.POSITION_SLIDER_OFFSET);

        container.setPadding(new Insets(Values.POSITION_SLIDER_OFFSET));
        container.getChildren().add(positionShower);
    }

    private void designRightBox(VBox container){

        //Temperature cursor
        Button temperatureCursorButton=new Button();
        Image temperatureCursorIcon=new Image("file:"+"Icons/cursor.png");
        temperatureCursorButton.setGraphic(new ImageView(temperatureCursorIcon));


        //Temperature Range Setting
        Button temperatureRangeButton=new Button();
        Image temperatureRangeIcon =new Image("file:"+"Icons/tem_range.png");
        temperatureRangeButton.setGraphic(new ImageView(temperatureRangeIcon));

        //Label to show Temperature Unit
        Label temperatureUnitLabel=new Label();

        //Label to show current low point of range
        Label lowPointLabel=new Label();

        //label to show current temperature high point of range
        Label highPointLabel =new Label();

        //Compare with visual image
        Button comapareButton =new Button();
        Image compareIcon =new Image("file:"+"Icons/compare.png");
        comapareButton.setGraphic(new ImageView(compareIcon));

        //Print Image
        Button printImageButton=new Button();
        Image printImageIcon=new Image("file:"+"Icons/print.png");
        printImageButton.setGraphic(new ImageView(printImageIcon));

        //Save Image
        Button saveImageButton =new Button();
        Image saveImageIcon =new Image("file:"+"Icons/sava.png");
        saveImageButton.setGraphic(new ImageView(saveImageIcon));

        //Open Image
        Button openImageButton =new Button();
        Image openImageIcon =new Image("file:"+"Icons/open_image.png");
        openImageButton.setGraphic(new ImageView(openImageIcon));

        //Open Folder
        Button openFolderbutton=new Button();
        Image openFolderIcon =new Image("file:"+"Icons/open_image_folder.png");
        openFolderbutton.setGraphic(new ImageView(openImageIcon));

        //Copy Image
        Button copyImageButton =new Button();
        Image copyImageIcon =new Image("file:"+"Icons/copy.png");
        copyImageButton.setGraphic(new ImageView(copyImageIcon));

        //Properties
        Button propertiesButton=new Button();
        Image propertiesIcon =new Image("file:"+"Icons/info.png");
        propertiesButton.setGraphic(new ImageView(propertiesIcon));

        container.setSpacing(Values.SIDE_BOX_SPACING);
        container.setPadding(new Insets(Values.SIDE_BOX_PADDING_TOP_BOTTOM,0,0,0));
        container.getChildren().add(temperatureCursorButton);
        container.getChildren().add(temperatureRangeButton);
        container.getChildren().add(temperatureUnitLabel);
        container.getChildren().add(lowPointLabel);
        container.getChildren().add(highPointLabel);
        container.getChildren().add(comapareButton);
        container.getChildren().add(printImageButton);
        container.getChildren().add(saveImageButton);
        container.getChildren().add(openImageButton);
        container.getChildren().add(openFolderbutton);
        container.getChildren().add(copyImageButton);
        container.getChildren().add(propertiesButton);


    }
    private void handleSmallMenuButton(Button button,Node root){
        /*
        If this button is clicked show a Context
        menu with some options
         */
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ContextMenu contextMenu =new ContextMenu();
                MenuItem loadMenuItem =new MenuItem("Load......");//Load image from pictures directory
                MenuItem saveMenuItem =new MenuItem("Save......");//Save showing image in current directoty
                MenuItem openMenuItem =new MenuItem("Open......");//Open an image from user Selection

                contextMenu.getItems().addAll(loadMenuItem,saveMenuItem,openMenuItem);
                contextMenu.show(root, Side.TOP,Values.SMALL_MENU_DX,Values.SMALL_MENU_DY);

                loadMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                    }
                });
                saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("save");
                    }
                });
                openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FileChooser fileChooser =new FileChooser();
                        fileChooser.setTitle("Open  Thermal Image");
                        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("png","*.png"),new
                                FileChooser.ExtensionFilter("jpg","*.jpg"),new FileChooser.ExtensionFilter("jpeg","*.jpeg"));
                        File file =fileChooser.showOpenDialog(stage);
                        if(file!=null){
                            try {
                                final  Image image =new Image(file.toURI().toURL().toExternalForm());
                                imageDisplay.setHeight(image.getHeight());
                                imageDisplay.setWidth(image.getWidth());
                                imageDisplay.getGraphicsContext2D().drawImage(image,0,0);
                                System.out.println(imageDisplay.getWidth()+"  "+imageDisplay.getWidth());
                                 /*
                             Start a new Thread to do imaging
                              */
                                    Thread imagingThread =new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            ColorSeparator colorSeparator =new ColorSeparator();
                                            colorSeparator.regionOfInterestDetector(image, Color.WHITE,.1);
                                            colorSeparator.edgeMarker(imageDisplay.getGraphicsContext2D(),Color.RED);
                                        }
                                    });
                                    imagingThread.start();
                                    //imagingThread.join();

                            } catch (MalformedURLException e) {
                                System.out.println(e);
                            }

                        }
                    }
                });

            }
        });
    }
    private void handleZoomSelectionButton(Button button,Node root){
        //If this button is clicked shows vertical slider to user
        //set zoom
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ContextMenu sliderDisplay =new ContextMenu();
                Slider zoomSelection=new Slider();
                zoomSelection.setOrientation(Orientation.VERTICAL);
                CustomMenuItem slider=new CustomMenuItem(zoomSelection);
                sliderDisplay.getItems().add(slider);
                sliderDisplay.show(root,Side.TOP,Values.SLIDER_DX,Values.SLIDER_DY);
            }
        });
    }
}