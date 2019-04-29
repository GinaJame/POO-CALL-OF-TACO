import java.util.Optional;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
public class Main extends Application{
    private Scene intro = new Intro(this);
    private Scene perso= new Persona(this);
    private Scene mapa,mapa_2,mapa_3;
    private Stage mainStage;
    private Taco taquito;
    private SceneBatalla sb;

    public static void main(String[]args){
        launch(args);
    }
    public void start(Stage primaryStage){
        mainStage=primaryStage;
        mainStage.setTitle("CALL OF TACO");
        mainStage.setScene(intro);
        mainStage.show();
    }
    public void setScene2(){
        mainStage.setScene(perso);
    }
    public void setScene3(int x, int y){
        if(x==9&&y==9){setScene4(0,0);}else{
            Personaje secuaz= new Jitomate(); 
            Boss boss= new Ensalada();
            mapa = new Mapa(taquito, this,x,y,secuaz,boss,0,8,3);
            mainStage.setScene(mapa);
        }     
    }
    public void setScene4(int x1, int y1){
        Personaje secuaz= new Trumpito(); 
        Boss boss= new HotDog();
        mapa_2 = new Mapa2(taquito,this,x1,y1,secuaz,boss,2,7,4);
        mainStage.setScene(mapa_2);
    }
    public void setScene5(int x2, int y2){
        Personaje secuaz= new Muro(); 
        Boss boss= new Gringa();
        mapa_3 = new Mapa3(taquito,this,x2,y2,secuaz,boss,4,5,5);
        mainStage.setScene(mapa_3);
    }
    public void setTaco(Taco taquito){
        this.taquito=taquito;
    }
    public Taco getTaquito(){
        return taquito;
    }
    public void pelear(Personaje p, int xx, int yy){
        sb= new SceneBatalla(taquito,p,xx,yy,this);
        mainStage.setScene(sb);
    }
    

    
}