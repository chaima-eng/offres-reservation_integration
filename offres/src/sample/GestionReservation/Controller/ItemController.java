package sample.GestionReservation.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.main.Main;
import sample.main.MyListener;
import sample.GestionReservation.model.Fruit;
import sample.GestionReservation.model.Hotel;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private Label idlab;



    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(fruit);


    }
    private Hotel hotel;
    private Fruit fruit;
    private MyListener myListener;
    private MyListener myList;


    public void setData(Fruit fruit, MyListener myListener) {
        this.fruit = fruit;
        this.myListener = myListener;
        nameLabel.setText(fruit.getName());
        priceLable.setText(Main.CURRENCY + fruit.getPrice());
        idlab.setText(fruit.getIdF());
        Image image = new Image("file:///"+fruit.getImgSrc()+"");
        img.setImage(image);
    }
   /* public void setDataH(Hotel hotel, MyListener myList) {
        this.hotel = hotel;
        this.myList = myList;
        nameLabel.setText(hotel.getNom());
        priceLable.setText(Main.CURRENCY + hotel.getPrix());
        idlab.setText(hotel.getId());
        Image image = new Image("file:///"+hotel.getPath_image()+"");
        img.setImage(image);
    }
*/





}
