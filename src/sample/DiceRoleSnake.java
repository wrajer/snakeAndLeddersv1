package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane; //u niego pobralo to automatycznie
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//nie chcemy awt jesli nampobierze

public class DiceRoleSnake extends Application {

    public int rand; //zmianna losowa
    public Label randResult;

    public int cirPos[][] = new int [10][10];
    public  int leadderPosition[][] = new int [6][3];

    public static final int Tile_Size =  80;
    public static final int width = 10;
    public static final int height = 10;

    public Circle player1;
    public Circle player2;

    public int playerPosition1 =1;
    public int playerPosition2 =1;

    public boolean player1Turn = true;
    public boolean player2Turn = true;

    public static int player1XPos = 40 ;
    public static int player1YPos = 740 ;

    public static int player2XPos = 40 ;
    public static int player2YPos = 740 ;  //TE POZYCJA NALEZY USPRAWNIC O WIELKOSCI OGOLNE NIE LICZBOWE

    public boolean gameStart = false;

    private Group tileGroup = new Group();

    private Parent createContent() { //tworzy na widok, wczesniej usunal defoltowy klase tworzenia
        Pane root = new Pane ();
        root.setPrefSize(width*Tile_Size, height*Tile_Size+80 ); //size of window
        root.getChildren().addAll(tileGroup);

        //pentla tworzaca poszczegole pola na naszym oknie, jednak nie rozumim setTranslate oraz childern aleok
        for (int i =0; i< height; i++) {
            for (int j =0; j< width; j++) {
                Tile tile = new Tile(Tile_Size,Tile_Size);
                tile.setTranslateX(j* Tile_Size);
                tile.setTranslateY(i* Tile_Size);
                tileGroup.getChildren().add(tile);
            }
        }

        player1 = new Circle (40);
        player1.setId("player1");
        player1.getStyleClass().add("style.css");
        player1.setTranslateX(player1XPos);
        player1.setTranslateY(player1YPos);


        tileGroup.getChildren().addAll(player1);
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Snake and Ladders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
