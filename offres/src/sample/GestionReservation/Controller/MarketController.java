package sample.GestionReservation.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sample.connection.DataBase;
import sample.main.Main;
import sample.main.MultiDatePicker;
import sample.main.MyListener;
import sample.GestionReservation.model.Fruit;
import sample.GestionReservation.model.Hotel;

import java.util.Date;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MarketController implements Initializable {
    @FXML
    private VBox chosenFruitCard;

    @FXML
    private Label fruitNameLable;

    @FXML
    private Label fruitPriceLabel;

    public MarketController() {
        connection = (Connection) DataBase.conDB();
    }

    @FXML
    private ImageView fruitImg;

    @FXML
    private Label connlabel;
    @FXML
    private ScrollPane scroll;

    @FXML
    private TextField textrech;

    @FXML
    private Button btnrech;

    @FXML
    private Label idlab;

    @FXML
    private GridPane grid;

    @FXML
    private ComboBox coboType;

    @FXML
    private ComboBox cobonbr;

    @FXML
    private Button idaddtocar;


    @FXML
    private TextField textrechprice;

    @FXML
    private TextField textrechcolor;

    @FXML
    private Label labD;

    @FXML
    private DatePicker dateF;

    @FXML
    private Label labF;

    @FXML
    private Label labPr;

    @FXML
    private Label labCo;

    MultiDatePicker multiDatePicker = new MultiDatePicker().withRangeSelectionMode();
    @FXML
    private DatePicker dateD = multiDatePicker.getDatePicker();






    private String idFruitReserv;
    private String idHotelReserv;



    ObservableList<Fruit> dataList;
    ObservableList<Hotel> dataListHotel;
    ItemController itemController;
    ItemHotel itemHotel;
    ItemFruit itemFruit;

    Connection connection;


    private Image image;
    private MyListener myListener;
    private MyListener myList;

    public void executeQuery(String query) {

        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        private List<Fruit> getData() {
            List<Fruit> fruits = new ArrayList<>();
            Fruit fruit;

            fruit = new Fruit();
            fruit.setName("Kiwi");
            fruit.setPrice(2.99);
            fruit.setImgSrc("../img/kiwi.png");
            fruit.setColor("6A7324");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Coconut");
            fruit.setPrice(3.99);
            fruit.setImgSrc("../img/coconut.png");
            fruit.setColor("A7745B");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Peach");
            fruit.setPrice(1.50);
            fruit.setImgSrc("../img/peach.png");
            fruit.setColor("F16C31");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Grapes");
            fruit.setPrice(0.99);
            fruit.setImgSrc("../img/grapes.png");
            fruit.setColor("291D36");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Watermelon");
            fruit.setPrice(4.99);
            fruit.setImgSrc("../img/watermelon.png");
            fruit.setColor("22371D");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Orange");
            fruit.setPrice(2.99);
            fruit.setImgSrc("../img/orange.png");
            fruit.setColor("FB5D03");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("StrawBerry");
            fruit.setPrice(0.99);
            fruit.setImgSrc("../img/strawberry.png");
            fruit.setColor("80080C");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Mango");
            fruit.setPrice(0.99);
            fruit.setImgSrc("../img/mango.png");
            fruit.setColor("FFB605");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Cherry");
            fruit.setPrice(0.99);
            fruit.setImgSrc("../img/cherry.png");
            fruit.setColor("5F060E");
            fruits.add(fruit);

            fruit = new Fruit();
            fruit.setName("Banana");
            fruit.setPrice(1.99);
            fruit.setImgSrc("../img/banana.png");
            fruit.setColor("E7C00F");
            fruits.add(fruit);

            return fruits;
        }
    */
    public ObservableList<Hotel> getHotelList() {
        ObservableList<Hotel> hotelList = FXCollections.observableArrayList();


        String query = "SELECT * FROM hotel";

        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Hotel hotels;

            while (rs.next()) {
                hotels = new Hotel(rs.getString("idH"), rs.getString("nom"), rs.getInt("etoile"), rs.getString("hebergement"), rs.getString("lieu"), rs.getString("Path_image"), rs.getString("Path_video"), rs.getString("chambre"), rs.getDouble("prix"));

                hotelList.add(hotels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelList;
    }


    public ObservableList<Fruit> getFruitList() {
        ObservableList<Fruit> clientList = FXCollections.observableArrayList();


        //  String query = "SELECT name ,imgSrc,price,color FROM resevation r join fruit f on (f.idF=r.idF) ";
        String query = "select * from fruit WHERE date BETWEEN '"+dateD.getValue()+"' AND '"+dateF.getValue()+"'";
        System.out.println(query);

        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Fruit fruit;

            while (rs.next()) {
                fruit = new Fruit(rs.getString("idF"), rs.getString("name"), rs.getString("imgSrc"), rs.getDouble("price"), rs.getString("color"),rs.getDate("date"));

                clientList.add(fruit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientList;
    }
    public ObservableList<Fruit> getFruitList2() {
        ObservableList<Fruit> clientList = FXCollections.observableArrayList();


        //  String query = "SELECT name ,imgSrc,price,color FROM resevation r join fruit f on (f.idF=r.idF) ";
        String query = "select * from fruit ";


        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Fruit fruit;

            while (rs.next()) {
                fruit = new Fruit(rs.getString("idF"), rs.getString("name"), rs.getString("imgSrc"), rs.getDouble("price"), rs.getString("color"), rs.getDate("date") );
                clientList.add(fruit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientList;
    }



    private void setChosenFruit(Fruit fruit) {
        fruitNameLable.setText(fruit.getName());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
        image = new Image("file:///" + fruit.getImgSrc() + "");
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }


    public static List<Date> getDaysBetweenDates(Date startdate, Date enddate)
    {
        List<Date> dates = new ArrayList<Date>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startdate);

        while (calendar.getTime().before(enddate))
        {
            Date result = (Date) calendar.getTime();
            dates.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }


    void search_fruit() {

        dataList = getFruitList();



        System.out.println(textrech.getText());






     /*  List<LocalDate> dates = Stream.iterate(d, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(d, f))
                .collect(Collectors.toList());
        System.out.println(dates);*/


     //   Predicate<Fruit> byname = fruit -> fruit.getName().toLowerCase().contains(textrech.getText().toLowerCase());
        //  Predicate<Fruit> byprice = fruit -> fruit.getPrice() == Double.valueOf(textrechprice.getText()) ;
     //   Predicate<Fruit> bycolor = fruit -> fruit.getColor().toLowerCase().contains(textrechcolor.getText().toLowerCase());
       // Predicate<Fruit> bydate = date -> date.);



    //   List<Date> datee =  getDaysBetweenDates(d,f);
    //    System.out.println(datee.size());
/*
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.plusDays(99);
 */
       // long diffInDays = ChronoUnit.DAYS.between(start, end);

      //  System.out.println(diffInDays);  // 99





        var r = dataList.stream().collect(Collectors.toList());
        grid.getChildren().clear();
        afficher(r);
        System.out.println(r);

     //   var result = dataList.stream().filter(byname)
       //         .collect(Collectors.toList());

      //  var result3 = dataList.stream().filter(byname).filter(bycolor)
      //          .collect(Collectors.toList());


/*
        System.out.println(result);
        if (textrech.getText().isEmpty()) {
            grid.getChildren().clear();
            afficher(r);

        } else {
            if (textrechprice.getText().isEmpty()) {
                if (textrechcolor.getText().isEmpty()) {


                    grid.getChildren().clear();
                    afficher(result);
                } else {
                    grid.getChildren().clear();
                    afficher(result3);
                }


            } else {
                Predicate<Fruit> byprice = fruit -> fruit.getPrice() == Double.valueOf(textrechprice.getText());

                if (textrechcolor.getText().isEmpty()) {
                    var result1 = dataList.stream().filter(byname).filter(byprice)
                            .collect(Collectors.toList());

                    grid.getChildren().clear();
                    afficher(result1);
                } else {
                    var result2 = dataList.stream().filter(byname).filter(bycolor).filter(byprice)
                            .collect(Collectors.toList());
                    grid.getChildren().clear();
                    afficher(result2);

                }
            }


        }

 */
    }
    void search_fruit2() {

        dataList = getFruitList2();



        System.out.println(textrech.getText());









          Predicate<Fruit> byname = fruit -> fruit.getName().toLowerCase().contains(textrech.getText().toLowerCase());
        //  Predicate<Fruit> byprice = fruit -> fruit.getPrice() == Double.valueOf(textrechprice.getText()) ;
          Predicate<Fruit> bycolor = fruit -> fruit.getColor().toLowerCase().contains(textrechcolor.getText().toLowerCase());









        var r = dataList.stream().collect(Collectors.toList());


          var result = dataList.stream().filter(byname)
                .collect(Collectors.toList());

         var result3 = dataList.stream().filter(byname).filter(bycolor)
                 .collect(Collectors.toList());



        System.out.println(result);
        if (textrech.getText().isEmpty()) {
            grid.getChildren().clear();
            afficher2(r);

        } else {
            if (textrechprice.getText().isEmpty()) {
                if (textrechcolor.getText().isEmpty()) {


                    grid.getChildren().clear();
                    afficher2(result);
                } else {
                    grid.getChildren().clear();
                    afficher2(result3);
                }


            } else {
                Predicate<Fruit> byprice = fruit -> fruit.getPrice() == Double.valueOf(textrechprice.getText());

                if (textrechcolor.getText().isEmpty()) {
                    var result1 = dataList.stream().filter(byname).filter(byprice)
                            .collect(Collectors.toList());

                    grid.getChildren().clear();
                    afficher2(result1);
                } else {
                    var result2 = dataList.stream().filter(byname).filter(bycolor).filter(byprice)
                            .collect(Collectors.toList());
                    grid.getChildren().clear();
                    afficher2(result2);

                }
            }


        }


    }

    void search_hotel() {

        dataListHotel = getHotelList();







        Predicate<Hotel> bylieu = hotel -> hotel.getNom().toLowerCase().contains(textrech.getText().toLowerCase());

        Predicate<Hotel> bychambre = hotel -> hotel.getChambre().toLowerCase().contains(textrechcolor.getText().toLowerCase());


        var r = dataListHotel.stream().collect(Collectors.toList());
        var result = dataListHotel.stream().filter(bylieu)
                .collect(Collectors.toList());

        var result3 = dataListHotel.stream().filter(bylieu).filter(bychambre)
                .collect(Collectors.toList());


        System.out.println(result);
        if (textrech.getText().isEmpty()) {
            grid.getChildren().clear();
            afficherHotels(r);

        } else {
            if (textrechprice.getText().isEmpty()) {
                if (textrechcolor.getText().isEmpty()) {


                    grid.getChildren().clear();
                    afficherHotels(result);
                } else {
                    grid.getChildren().clear();
                    afficherHotels(result3);
                }


            } else {
                Predicate<Hotel> byprix = hotel -> hotel.getPrix() == Double.valueOf(textrechprice.getText());

                if (textrechcolor.getText().isEmpty()) {
                    var result1 = dataListHotel.stream().filter(bylieu).filter(byprix)
                            .collect(Collectors.toList());

                    grid.getChildren().clear();
                    afficherHotels(result1);
                } else {
                    var result2 = dataListHotel.stream().filter(bylieu).filter(byprix).filter(bychambre)
                            .collect(Collectors.toList());
                    grid.getChildren().clear();
                    afficherHotels(result2);

                }
            }


        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {



        textrechprice.setVisible(false);
        textrechcolor.setVisible(false);
        labD.setVisible(false);
        labF.setVisible(false);

        dateD.setVisible(false);
        dateF.setVisible(false);


        ObservableList<String> listType = FXCollections.observableArrayList("Paris", "Tunis", "Tripoli", "Dubai", "Madrid");

        coboType.getSelectionModel().select("Pays");
        coboType.setItems(listType);

        ObservableList<Integer> listNbr = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7);

        cobonbr.getSelectionModel().select("Nombre jours ");
        cobonbr.setItems(listNbr);


        if (connection == null) {
            connlabel.setTextFill(Color.TOMATO);
            connlabel.setText("Server Error : Check");
        } else {
            connlabel.setTextFill(Color.GREEN);
            connlabel.setText("Server is up : Good to go");
        }



        afficher(getFruitList());


    }

    @FXML
    void handelrech(ActionEvent event) {
/*
        off.setOnAction(e -> {
            btnrech.setOnAction(t -> {
               search_fruit();

            });

        });
*/
    }


    void afficher(List<Fruit> Fruits) {


        if (Fruits.size() > 0) {
            setChosenFruit(Fruits.get(0));


            myListener = new MyListener() {
                @Override
                public void onClickListener(Fruit fruit) {
                    setChosenFruit(fruit);

                    idFruitReserv = fruit.getIdF();


                }

                @Override
                public void onClickListener2(Fruit fruit) {

                }

                @Override
                public void onClickk(Hotel hotel) {

                }
            };

        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < Fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                itemController = fxmlLoader.getController();
                itemController.setData(Fruits.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                //  grid.getChildren();
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);


                GridPane.setMargin(anchorPane, new Insets(Fruits.size()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void afficher2(List<Fruit> Fruits) {


        if (Fruits.size() > 0) {
            setChosenFruit(Fruits.get(0));


            myListener = new MyListener() {
                @Override
                public void onClickListener(Fruit fruit) {



                }

                @Override
                public void onClickListener2(Fruit fruit) {
                    setChosenFruit(fruit);

                    idFruitReserv = fruit.getIdF();
                }

                @Override
                public void onClickk(Hotel hotel) {

                }
            };

        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < Fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/fruit.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                itemFruit = fxmlLoader.getController();
                itemFruit.setDataF(Fruits.get(i) , myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                //  grid.getChildren();
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);


                GridPane.setMargin(anchorPane, new Insets(Fruits.size()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void afficherHotels(List<Hotel> hotels) {


        if (hotels.size() > 0) {
            setChosenHotel(hotels.get(0));


            myList = new MyListener() {
                @Override
                public void onClickk(Hotel hotel) {
                    setChosenHotel(hotel);

                    idHotelReserv = hotel.getId();


                }
                @Override
                public void onClickListener(Fruit fruit) {

                }

                @Override
                public void onClickListener2(Fruit fruit) {

                }


            };

        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < hotels.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/hotel.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                itemHotel= fxmlLoader.getController();
                itemHotel.setDataH(hotels.get(i), myList);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                //  grid.getChildren();
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);


                GridPane.setMargin(anchorPane, new Insets(hotels.size()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setChosenHotel(Hotel hotel) {
        fruitNameLable.setText(hotel.getNom());
        fruitPriceLabel.setText(Main.CURRENCY + hotel.getPrix());

        image = new Image("file:///" + hotel.getPath_image() + "");
        fruitImg.setImage(image);


        chosenFruitCard.setStyle("-fx-background-color: #9DA4A4  ;\n" +
                "    -fx-background-radius: 30;");

    }


    @FXML
    void btnaddtocar(ActionEvent event) {

        System.out.println(idFruitReserv);
        System.out.println(idHotelReserv);




    }

    @FXML
    void btnevent(ActionEvent event) {

    }

    @FXML
    void btnhot(ActionEvent event) {
        grid.getChildren().clear();
        afficherHotels(getHotelList());

        labD.setVisible(false);
        labF.setVisible(false);
        dateD.setVisible(false);
        dateF.setVisible(false);
        textrechprice.setVisible(true);
        textrechcolor.setVisible(true);
        textrechprice.setPromptText("Write Price");
        textrechcolor.setPromptText("Write Color");

        btnrech.setOnAction(t -> {
            search_hotel();

        });
    }

    @FXML
    void btnoff(ActionEvent event) {

        grid.getChildren().clear();
        afficher(getFruitList());
        textrechprice.setVisible(false);
        textrechcolor.setVisible(false);

        labD.setVisible(true);
        labF.setVisible(true);
        dateD.setVisible(true);
        dateF.setVisible(true);

        btnrech.setOnAction(t -> {
            search_fruit();

        });
    }

    @FXML
    void btntrans(ActionEvent event) {
        grid.getChildren().clear();

    }

    @FXML
    void btnvol(ActionEvent event) {

        grid.getChildren().clear();
        afficher2(getFruitList2());
        labD.setVisible(false);
        labF.setVisible(false);
        dateD.setVisible(false);
        dateF.setVisible(false);
        textrechprice.setVisible(true);
        textrechcolor.setVisible(true);
        textrechprice.setPromptText("Write Price");
        textrechcolor.setPromptText("Write Color");
        btnrech.setOnAction(t -> {
            search_fruit2();

        });


    }


}