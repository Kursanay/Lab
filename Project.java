/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author MI
 */
public class Project extends Application {
    
    VBox vbox = new VBox();
    VBox vboxm = new VBox();
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IllegalArgumentException{
        
        HBox hboxForLanguages = new HBox();
        
        RadioButton rbKAZ=new RadioButton("KAZ");
        Image image=new Image("file:C:/Users/MI/Documents/NetBeansProjects/Проект/IMG/KAZ.JPG");  
        ImageView view=new ImageView(image);
        view.setFitHeight(25);
        view.setFitWidth(25);
        rbKAZ.setGraphic(view);
        rbKAZ.setTextFill(Color.BLACK);
        rbKAZ.setContentDisplay(ContentDisplay.LEFT);
        rbKAZ.setStyle("-fx-border-color: black");
        rbKAZ.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbENG=new RadioButton("ENG");
        Image image1=new Image("file:C:/Users/MI/Documents/NetBeansProjects/Проект/IMG/ENG.JPG");  
        ImageView view1=new ImageView(image1);
        view1.setFitHeight(25);
        view1.setFitWidth(25);
        rbENG.setGraphic(view1);
        rbENG.setTextFill(Color.BLACK);
        rbENG.setContentDisplay(ContentDisplay.LEFT);
        rbENG.setStyle("-fx-border-color: black");
        rbENG.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbRUS=new RadioButton("RUS");
        Image image2=new Image("file:C:/Users/MI/Documents/NetBeansProjects/Проект/IMG/RUS.JPG");  
        ImageView view2=new ImageView(image2);
        view2.setFitHeight(25);
        view2.setFitWidth(25);
        rbRUS.setGraphic(view2);
        rbRUS.setTextFill(Color.BLACK);
        rbRUS.setContentDisplay(ContentDisplay.LEFT);
        rbRUS.setStyle("-fx-border-color: black");
        rbRUS.setPadding(new Insets(5,10,5,5));
        
        hboxForLanguages.getChildren().addAll(rbKAZ, rbENG, rbRUS);
        
        vbox.getChildren().addAll(hboxForLanguages);
       
        ToggleGroup group=new ToggleGroup();
        rbKAZ.setToggleGroup(group);
        rbENG.setToggleGroup(group);
        rbRUS.setToggleGroup(group);
       
        rbKAZ.setOnAction(e -> {
            vboxm.getChildren().clear();
            if(rbKAZ.isSelected())
                try {
                   kaz();
                } 
                catch (FileNotFoundException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
           
       
        rbENG.setOnAction(e -> {
            vboxm.getChildren().clear();
            if(rbENG.isSelected())
                try {
                    eng();
                } 
                catch (FileNotFoundException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
       
        rbRUS.setOnAction(e -> {
            vboxm.getChildren().clear();
            if(rbRUS.isSelected())
                try {
                    rus();
                } 
                catch (FileNotFoundException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
       
        //Image sdu=new Image("file:C:/Users/MI/Documents/NetBeansProjects/Проект/sdu1.JPG");  
        vbox.setStyle("-fx-background-image: url('file:C:/Users/MI/Documents/NetBeansProjects/Проект/sdup.JPG')");
       
        Scene scene=new Scene(vbox);
        
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void eng() throws FileNotFoundException {
         
        HBox hboxForDegrees = new HBox();
        VBox vboxForDegrees = new VBox(5);
        
        GridPane gridPaneForBachelor=new GridPane();
        GridPane gridPaneForMaster=new GridPane();
        GridPane gridPaneForPhD=new GridPane();
        
        TextField tfentForEng=new TextField();
        TextField tffpostForEng=new TextField();
        TextField tffnumberForEng=new TextField();
        TextField tfmpostForEng=new TextField();
        TextField tfmnumberForEng=new TextField();
        
        TextField tfgpam=new TextField();
        
        TextField tfgpap=new TextField();
        
        RadioButton rbBachelor=new RadioButton("Bahcelor's degree");
        rbBachelor.setTextFill(Color.BLACK);
        rbBachelor.setPadding(new Insets(5,10,10,10));
        
        RadioButton rbMaster=new RadioButton("Master's degree");
        rbMaster.setTextFill(Color.BLACK);
        rbMaster.setPadding(new Insets(5,10,10,10));
        
        RadioButton rbPhD=new RadioButton("PhD's degree");
        rbPhD.setTextFill(Color.BLACK);
        rbPhD.setPadding(new Insets(5,10,10,10));
        
        ToggleGroup groupForDegrees=new ToggleGroup();
        rbBachelor.setToggleGroup(groupForDegrees);
        rbMaster.setToggleGroup(groupForDegrees);
        rbPhD.setToggleGroup(groupForDegrees);
        
        rbBachelor.setOnAction(e -> {
            
            vboxForDegrees.getChildren().clear();
            vboxForDegrees.getChildren().add(gridPaneForBachelor);
            
            if(rbBachelor.isSelected()) 
               gridPaneForBachelor.add(new Label("ENTER YOUR ENT SCORE :"), 0, 0);
               gridPaneForBachelor.add(tfentForEng,1,0);
           
               gridPaneForBachelor.add(new Label("INFORMATION ABOUT PARENTS :"), 0, 1);
               gridPaneForBachelor.add(new Label("FATHER: "), 0, 2);
               gridPaneForBachelor.add(new Label("POST: "), 0,3);
               gridPaneForBachelor.add(tffpostForEng,1,3);
               gridPaneForBachelor.add(new Label("NUMBER OF PHONE: "), 0, 4);
               gridPaneForBachelor.add(tffnumberForEng,1,4);
               
               gridPaneForBachelor.add(new Label("MOTHER:"), 0, 5);
               gridPaneForBachelor.add(new Label("POST :"), 0, 6);
               gridPaneForBachelor.add(tfmpostForEng,1,6);
               gridPaneForBachelor.add(new Label("NUMBER OF PHONE:"), 0, 7);
               gridPaneForBachelor.add(tfmnumberForEng,1,7);
            });
     
        rbMaster.setOnAction((ActionEvent e) -> {
            
            vboxForDegrees.getChildren().clear();
            vboxForDegrees.getChildren().add(gridPaneForMaster);
            
            if(rbMaster.isSelected())
                gridPaneForMaster.add(new Label("ENTER YOUR GPA :"), 0, 0);
                gridPaneForMaster.add(tfgpam,1,0);
        });
       
        rbPhD.setOnAction(e -> {
            
            vboxForDegrees.getChildren().clear();
            vboxForDegrees.getChildren().add(gridPaneForPhD);
            
            if(rbPhD.isSelected()) 
                gridPaneForPhD.add(new Label("ENTER YOUR GPA :"), 0, 0);
                gridPaneForPhD.add(tfgpap,1,0);
        });
        
        hboxForDegrees.getChildren().addAll(rbBachelor, rbMaster, rbPhD);

        GridPane gridPaneForEng=new GridPane();
        TextField tfnameForEng=new TextField();
        TextField tfsurnameForEng=new TextField();
        TextField tfplaceForEng=new TextField();
        TextField tfnationalityForEng=new TextField();
        TextField tfnumberForEng=new TextField();
        TextField tfmailForEng=new TextField();
        Button btConfirm = new Button("Confirm");
        Label label1 = new Label();
        Label label2 = new Label();

        gridPaneForEng.setHgap(5);
        gridPaneForEng.setVgap(5);
        gridPaneForEng.add(new Label("NAME: "),0,0);
        gridPaneForEng.add(tfnameForEng,1,0);
        gridPaneForEng.add(new Label("SURNAME: "),0,1);
        gridPaneForEng.add(tfsurnameForEng,1,1);
        gridPaneForEng.add(new Label("PLEASE,CHOOSE FACULTY: "),0,3);
       
        ComboBox<String> comboForEng=new ComboBox();
        File fileForEng=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\faculty.txt");
        Scanner scForEng=new Scanner(fileForEng);
        while(scForEng.hasNextLine()){
            comboForEng.getItems().addAll(scForEng.nextLine());}
        gridPaneForEng.add(comboForEng,1,3);
       
        ComboBox<String> lawForEng=new ComboBox();
        File file1ForEng=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Speciality\\Law.txt");
        Scanner sc1ForEng=new Scanner(file1ForEng);
        while(sc1ForEng.hasNextLine()){
            lawForEng.getItems().addAll(sc1ForEng.nextLine());}
       
        ComboBox<String> philForEng=new ComboBox();
        File file2ForEng=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Speciality\\Phil.txt");
        Scanner sc2ForEng=new Scanner(file2ForEng);
        while(sc2ForEng.hasNextLine()){
            philForEng.getItems().addAll(sc2ForEng.nextLine());}
       
        ComboBox<String> engForEng=new ComboBox();
        File file3ForEng=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Speciality\\Engineering.txt");
        Scanner sc3ForEng=new Scanner(file3ForEng);
        while(sc3ForEng.hasNextLine()){
            engForEng.getItems().addAll(sc3ForEng.nextLine());}
       
        ComboBox<String> ecoForEng=new ComboBox();
        File file4ForEng=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Speciality\\Economic.txt");
        Scanner sc4ForEng=new Scanner(file4ForEng);
        while(sc4ForEng.hasNextLine()){
            ecoForEng.getItems().addAll(sc4ForEng.nextLine());}
       
        comboForEng.setOnAction(e -> {
            if(comboForEng.getValue().equals("Faculty of Law and Social sciences")){
                gridPaneForEng.add(new Label("PLEASE,CHOOSE SPECIALITY: "),0,4);
                if (gridPaneForEng.contains(0, 4))
                    gridPaneForEng.getChildren().remove(philForEng);
                    gridPaneForEng.getChildren().remove(engForEng);
                    gridPaneForEng.getChildren().remove(ecoForEng);
                gridPaneForEng.add(lawForEng, 1,4);}
            if(comboForEng.getValue().equals("Faculty of Education and Humanities")){
                gridPaneForEng.add(new Label("PLEASE,CHOOSE SPECIALITY: "),0,4);
                if (gridPaneForEng.contains(0, 4))
                    gridPaneForEng.getChildren().remove(lawForEng);
                    gridPaneForEng.getChildren().remove(engForEng);
                    gridPaneForEng.getChildren().remove(ecoForEng);
                gridPaneForEng.add(philForEng, 1,4);}
            if(comboForEng.getValue().equals("Faculty of Engineering and Natural sciences")){
                gridPaneForEng.add(new Label("PLEASE,CHOOSE SPECIALITY: "),0,4);
                if (gridPaneForEng.contains(0, 4))
                    gridPaneForEng.getChildren().remove(lawForEng);
                    gridPaneForEng.getChildren().remove(philForEng);
                    gridPaneForEng.getChildren().remove(ecoForEng);
                gridPaneForEng.add(engForEng, 1,4);}
            if(comboForEng.getValue().equals("SDU Business school")){
                gridPaneForEng.add(new Label("PLEASE,CHOOSE SPECIALITY: "),0,4);
                if (gridPaneForEng.contains(0, 4))
                    gridPaneForEng.getChildren().remove(lawForEng);
                    gridPaneForEng.getChildren().remove(philForEng);
                    gridPaneForEng.getChildren().remove(engForEng);
                gridPaneForEng.add(ecoForEng, 1,4);}
        });

        gridPaneForEng.add(new Label("INFORMATION ABOUT YOURSELF: "), 0,9);
        gridPaneForEng.add(new Label("PLEASE,CHOOSE SEX: "), 0,10);
        gridPaneForEng.add(new Label("DATA OF BIRTH: "), 0,11);
        
        HBox hboxForSex = new HBox();
        RadioButton rbMaleForEng=new RadioButton("Male");
        rbMaleForEng.setTextFill(Color.BLACK);
        rbMaleForEng.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbFemaleForEng=new RadioButton("Female");
        rbFemaleForEng.setTextFill(Color.BLACK);
        rbFemaleForEng.setPadding(new Insets(5,10,5,5));
        
        ToggleGroup groupForSex=new ToggleGroup();
        rbMaleForEng.setToggleGroup(groupForSex);
        rbFemaleForEng.setToggleGroup(groupForSex);
        
        hboxForSex.getChildren().addAll(rbMaleForEng, rbFemaleForEng);
        gridPaneForEng.add(hboxForSex,1,10);
       
        HBox hboxForBD = new HBox();
       
        ComboBox<Integer> dayForEng=new ComboBox();
        dayForEng.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
       
        ComboBox<String> monthForEng=new ComboBox();
        monthForEng.getItems().addAll("January","February","March","April","May",
             "June","July","August","September","October","November","December");
        
        ComboBox<Integer> yearForEng=new ComboBox();
        yearForEng.getItems().addAll(1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,
                1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004);
       
        hboxForBD.getChildren().addAll(new Label("Day: "),dayForEng,new Label("   Month: "),monthForEng,new Label("   Year: "),yearForEng);
        gridPaneForEng.add(hboxForBD, 1, 11);
      
        gridPaneForEng.add(new Label("PLACE OF BIRTH: "),0,12);
        gridPaneForEng.add(tfplaceForEng,1,12);

        gridPaneForEng.add(new Label("ENTER YOUR NATIONALITY: "),0,13);
        gridPaneForEng.add(tfnationalityForEng,1,13);

        gridPaneForEng.add(new Label("ENTER YOUR PHONE NUMBER: "),0,14);
        gridPaneForEng.add(tfnumberForEng,1,14);

        gridPaneForEng.add(new Label("ENTER YOUR YOUR EMAIL ADDRESS: "),0,15);
        gridPaneForEng.add(tfmailForEng,1,15);
        
        btConfirm.setOnAction(e->{
            if(tfnameForEng.getText().equals("") && tfsurnameForEng.getText().equals("")){
                label1.setText("Please fill in all");
                label1.setTextFill(Color.RED);
                vboxm.getChildren().add(label1);
            }
            else{
                try{
                    PrintWriter pw = new PrintWriter(tfnameForEng.getText()+"_"+tfsurnameForEng.getText()+".txt","UTF-8");
                    
                    pw.println("Name: "+tfnameForEng.getText());
                    pw.println("Surname: "+tfsurnameForEng.getText());
                    pw.println("Faculty: "+comboForEng.getValue());
                    
                    if(comboForEng.getValue().equals("Faculty of Law and Social sciences"))
                        pw.println("Speciality: "+lawForEng.getValue());
                    else if(comboForEng.getValue().equals("Faculty of Education and Humanities"))
                        pw.println("Speciality: "+philForEng.getValue());
                    else if(comboForEng.getValue().equals("Faculty of Engineering and Natural sciences"))
                        pw.println("Speciality: "+engForEng.getValue());
                    else if(comboForEng.getValue().equals("SDU Business school"))
                        pw.println("Speciality: "+ecoForEng.getValue());
                    
                    if(rbMaleForEng.isSelected())
                        pw.println("Gender: Male");
                    else
                        pw.println("Gender: Female");
                    
                    pw.println("Date of Birthday: "+dayForEng.getValue()+"."+monthForEng.getValue()+"."+yearForEng.getValue());
                    pw.println("Place of Birthday: "+tfplaceForEng.getText());
                    pw.println("Nationality: "+tfnationalityForEng.getText());
                    pw.println("Number: "+tfnumberForEng.getText());
                    pw.println("E-mail: "+tfmailForEng.getText());
                    
                    if(rbBachelor.isSelected()){
                        pw.println("Degree: Bachelor");
                        pw.println("Ent score: "+tfentForEng.getText());
                        pw.println("Information about parents:");
                        pw.println("Father: ");
                        pw.println("Post: "+tffpostForEng.getText());
                        pw.println("Number of phone: "+tffnumberForEng.getText());
                        pw.println("Mother: ");
                        pw.println("Post: "+tfmpostForEng.getText());
                        pw.println("Number of phone: "+tfmnumberForEng.getText());
                    }
                        
                    else if(rbMaster.isSelected()){
                        pw.println("Degree: Master");
                        pw.println("GPA score: "+tfgpam.getText());
                    }
                        
                    else if(rbPhD.isSelected()){
                        pw.println("Degree: PhD");
                        pw.println("GPA score: "+tfgpap.getText());
                    }
                    pw.close();
                    label2.setText("Done!");
                    label2.setTextFill(Color.GREEN);
                    vboxm.getChildren().add(label2);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
        });
      
        vboxm.getChildren().addAll(hboxForDegrees, gridPaneForEng, vboxForDegrees,btConfirm);
        vboxm.setPadding(new Insets(5,10,10,10));
        vbox.getChildren().add(vboxm);
        
    }
    
    public void rus() throws FileNotFoundException{
         
        HBox hboxForDegreesRus = new HBox();
        VBox vboxForDegreesRus = new VBox();
        
        GridPane gridPaneForBachelorRus=new GridPane();
        GridPane gridPaneForMasterRus=new GridPane();
        GridPane gridPaneForPhDRus=new GridPane();
        
        TextField tfentForRus=new TextField();
        TextField tffpostForRus=new TextField();
        TextField tffnumberForRus=new TextField();
        TextField tfmpostForRus=new TextField();
        TextField tfmnumberForRus=new TextField();
        
        TextField tfgpamForRus=new TextField();
        
        TextField tfgpapForRus=new TextField();
        
        RadioButton rbBachelorForRus=new RadioButton("Бакалавриат");
        rbBachelorForRus.setTextFill(Color.BLACK);
        rbBachelorForRus.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbMasterForRus=new RadioButton("Магистратура");
        rbMasterForRus.setTextFill(Color.BLACK);
        rbMasterForRus.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbPhDForRus=new RadioButton("Докторантура");
        rbPhDForRus.setTextFill(Color.BLACK);
        rbPhDForRus.setPadding(new Insets(5,10,5,5));
        
        ToggleGroup groupForDegreesRus=new ToggleGroup();
        rbBachelorForRus.setToggleGroup(groupForDegreesRus);
        rbMasterForRus.setToggleGroup(groupForDegreesRus);
        rbPhDForRus.setToggleGroup(groupForDegreesRus);
        
        rbBachelorForRus.setOnAction(e -> {
            vboxForDegreesRus.getChildren().clear();
            vboxForDegreesRus.getChildren().add(gridPaneForBachelorRus);
            if(rbBachelorForRus.isSelected()) 
                gridPaneForBachelorRus.add(new Label("ВВЕДИТЕ БАЛЛ ЕНТ :"), 0, 0);
                gridPaneForBachelorRus.add(tfentForRus,1,0);

                gridPaneForBachelorRus.add(new Label("ИНФОРМАЦИЯ О РОДИТЕЛЯХ :"), 0, 1);
                gridPaneForBachelorRus.add(new Label("ОТЕЦ: "), 0, 2);
                gridPaneForBachelorRus.add(new Label("ДОЛЖНОСТЬ: "), 0, 3);
                gridPaneForBachelorRus.add(tffpostForRus,1,3);
                gridPaneForBachelorRus.add(new Label("НОМЕР ТЕЛЕФОНА: "), 0, 4);
                gridPaneForBachelorRus.add(tffnumberForRus,1,4);

                gridPaneForBachelorRus.add(new Label("МАТЬ:"), 0, 5);
                gridPaneForBachelorRus.add(new Label("ДОЛЖНОСТЬ :"), 0, 6);
                gridPaneForBachelorRus.add(tfmpostForRus,1,6);
                gridPaneForBachelorRus.add(new Label("НОМЕР ТЕЛЕФОНА:"), 0, 7);
                gridPaneForBachelorRus.add(tfmnumberForRus,1,7);
        });

        rbMasterForRus.setOnAction(e -> {
            vboxForDegreesRus.getChildren().clear();
            vboxForDegreesRus.getChildren().add(gridPaneForMasterRus);
            if(rbMasterForRus.isSelected()) 
                gridPaneForMasterRus.add(new Label("ВВЕДИТЕ GPA :"), 0, 0);
                gridPaneForMasterRus.add(tfgpamForRus,1,0);
        });
        rbPhDForRus.setOnAction(e -> {
            vboxForDegreesRus.getChildren().clear();
            vboxForDegreesRus.getChildren().add(gridPaneForPhDRus);
            
            if(rbPhDForRus.isSelected()) 
                gridPaneForPhDRus.add(new Label("ВВЕДИТЕ GPA :"), 0, 0);
                gridPaneForPhDRus.add(tfgpapForRus,1,0);
        });

        hboxForDegreesRus.getChildren().addAll(rbBachelorForRus, rbMasterForRus, rbPhDForRus);
        
        GridPane gridPaneForRus=new GridPane();
        TextField tfnameForRus=new TextField();
        TextField tfsurnameForRus=new TextField();
        TextField tfplaceForRus=new TextField();
        TextField tfnationalityForRus=new TextField();
        TextField tfnumberForRus=new TextField();
        TextField tfmailForRus=new TextField();
        Button btConfirmForRus = new Button("Confirm");
        Label label1ForRus = new Label();
        Label label2ForRus = new Label();

        gridPaneForRus.setHgap(5);
        gridPaneForRus.setVgap(5);
        gridPaneForRus.add(new Label("ИМЯ: "),0,0);
        gridPaneForRus.add(tfnameForRus,1,0);
        gridPaneForRus.add(new Label("ФАМИЛИЯ: "),0,1);
        gridPaneForRus.add(tfsurnameForRus,1,1);
        gridPaneForRus.add(new Label("ПОЖАЛУЙСТА,ВЫБЕРИТЕ ФАКУЛЬТЕТ: "),0,3);
       
        ComboBox<String> comboForRus=new ComboBox();
        File fileForRus=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\факультет.txt");
        Scanner scForRus=new Scanner(fileForRus);
        while(scForRus.hasNextLine()){
            comboForRus.getItems().addAll(scForRus.nextLine());}
        gridPaneForRus.add(comboForRus,1,3);
       
        ComboBox<String> lawForRus=new ComboBox();
        File file1ForRus=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Специальность\\юрфак.txt");
        Scanner sc1ForRus=new Scanner(file1ForRus);
        while(sc1ForRus.hasNextLine()){
            lawForRus.getItems().addAll(sc1ForRus.nextLine());}
       
        ComboBox<String> philForRus=new ComboBox();
        File file2ForRus=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Специальность\\Филфак.txt");
        Scanner sc2ForRus=new Scanner(file2ForRus);
        while(sc2ForRus.hasNextLine()){
            philForRus.getItems().addAll(sc2ForRus.nextLine());}
       
        ComboBox<String> engForRus=new ComboBox();
        File file3ForRus=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Специальность\\инженерный.txt");
        Scanner sc3ForRus=new Scanner(file3ForRus);
        while(sc3ForRus.hasNextLine()){
            engForRus.getItems().addAll(sc3ForRus.nextLine());}
       
        ComboBox<String> ecoForRus=new ComboBox();
        File file4ForRus=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Специальность\\эконом.txt");
        Scanner sc4ForRus=new Scanner(file4ForRus);
        while(sc4ForRus.hasNextLine()){
            ecoForRus.getItems().addAll(sc4ForRus.nextLine());}
       
        comboForRus.setOnAction(e -> {
            if(comboForRus.getValue().equals("Факультет юриспруденции и социальнo-гуманитарных наук")){
                gridPaneForRus.add(new Label("Пожалуйста,выберите специальность: "),0,4);
                if (gridPaneForRus.contains(0, 4))
                    //if(combo.getValue().equals("Faculty of Education and Humanities"))
                        gridPaneForRus.getChildren().remove(philForRus);
                    //if(combo.getValue().equals("Faculty of Engineering and Natural sciences"))
                        gridPaneForRus.getChildren().remove(engForRus);
                    //if(combo.getValue().equals("SDU Business school"))
                        gridPaneForRus.getChildren().remove(ecoForRus);
                gridPaneForRus.add(lawForRus, 1,4);}
            else if(comboForRus.getValue().equals("Факультет педагогических и гуманитарных наук")){
                gridPaneForRus.add(new Label("Пожалуйста,выберите специальность: "),0,4);
                if (gridPaneForRus.contains(0, 4))
                    //if(combo.getValue().equals("Faculty of Education and Humanities"))
                        gridPaneForRus.getChildren().remove(lawForRus);
                    //if(combo.getValue().equals("Faculty of Engineering and Natural sciences"))
                        gridPaneForRus.getChildren().remove(engForRus);
                    //if(combo.getValue().equals("SDU Business school"))
                        gridPaneForRus.getChildren().remove(ecoForRus);
                gridPaneForRus.add(philForRus, 1,4);}
            else if(comboForRus.getValue().equals("Факультет инженерии и естественных наук")){
                gridPaneForRus.add(new Label("Пожалуйста,выберите специальность: "),0,4);
                if (gridPaneForRus.contains(0, 4))
                    //if(combo.getValue().equals("Faculty of Education and Humanities"))
                        gridPaneForRus.getChildren().remove(lawForRus);
                    //if(combo.getValue().equals("Faculty of Engineering and Natural sciences"))
                        gridPaneForRus.getChildren().remove(philForRus);
                    //if(combo.getValue().equals("SDU Business school"))
                        gridPaneForRus.getChildren().remove(ecoForRus);
                gridPaneForRus.add(engForRus, 1,4);}
            else if(comboForRus.getValue().equals("Бизнес-школа СДУ")){
                gridPaneForRus.add(new Label("Пожалуйста,выберите специальность: "),0,4);
                if (gridPaneForRus.contains(0, 4))
                    //if(combo.getValue().equals("Faculty of Education and Humanities"))
                        gridPaneForRus.getChildren().remove(lawForRus);
                    //if(combo.getValue().equals("Faculty of Engineering and Natural sciences"))
                        gridPaneForRus.getChildren().remove(philForRus);
                    //if(combo.getValue().equals("SDU Business school"))
                        gridPaneForRus.getChildren().remove(engForRus);
                gridPaneForRus.add(ecoForRus, 1,4);}
        });
        
        gridPaneForRus.add(new Label("ИНФОРМАЦИЯ О СЕБЕ: "), 0,9);
        gridPaneForRus.add(new Label("ПОЖАЛУЙСТА,ВЫБЕРИТЕ ПОЛ: "), 0,10);
        gridPaneForRus.add(new Label("ДЕНЬ РОЖДЕНИЯ: "), 0,11);
        
        HBox hboxForSexRus = new HBox();
        RadioButton rbMaleForRus=new RadioButton("Мужской");
        rbMaleForRus.setTextFill(Color.BLACK);
        rbMaleForRus.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbFemaleForRus=new RadioButton("Женский");
        rbFemaleForRus.setTextFill(Color.BLACK);
        rbFemaleForRus.setPadding(new Insets(5,10,5,5));
        
        ToggleGroup groupForSexRus=new ToggleGroup();
        rbMaleForRus.setToggleGroup(groupForSexRus);
        rbFemaleForRus.setToggleGroup(groupForSexRus);
        
        hboxForSexRus.getChildren().addAll(rbMaleForRus, rbFemaleForRus);
        gridPaneForRus.add(hboxForSexRus,1,10);
       
        HBox hboxForBDRus = new HBox();
       
        ComboBox<Integer> dayForRus=new ComboBox();
        dayForRus.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);

        ComboBox<String> monthForRus=new ComboBox();
        monthForRus.getItems().addAll("Январь","Февраль","Март","Апрель","Май",
             "Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь");

        ComboBox<Integer> yearForRus=new ComboBox();
        yearForRus.getItems().addAll(1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,
                1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004);
       
       
        hboxForBDRus.getChildren().addAll(new Label("День: "),dayForRus,new Label("   Месяц: "),monthForRus,new Label("   Год: "),yearForRus);
        gridPaneForRus.add(hboxForBDRus, 1, 11);

        gridPaneForRus.add(new Label("МЕСТО РОЖДЕНИЯ: "),0,12);
        gridPaneForRus.add(tfplaceForRus,1,12);

        gridPaneForRus.add(new Label("ВВЕДИТЕ НАЦИОНАЛЬНОСТЬ: "),0,13);
        gridPaneForRus.add(tfnationalityForRus,1,13);

        gridPaneForRus.add(new Label("ВВЕДИТЕ НОМЕР ТЕЛЕФОНА: "),0,14);
        gridPaneForRus.add(tfnumberForRus,1,14);

        gridPaneForRus.add(new Label("ВВЕДИТЕ ПОЧТОВЫЙ АДРЕС: "),0,15);
        gridPaneForRus.add(tfmailForRus,1,15);
        
        btConfirmForRus.setOnAction(e->{
            if(tfnameForRus.getText().equals("") && tfsurnameForRus.getText().equals("")){
                label1ForRus.setText("Пожалуйста заполните полностью");
                label1ForRus.setTextFill(Color.RED);
                vboxm.getChildren().add(label1ForRus);
            }
            else{
                try{
                    PrintWriter pw = new PrintWriter(tfnameForRus.getText()+"_"+tfsurnameForRus.getText()+".txt","UTF-8");
                    
                    pw.println("Имя: "+tfnameForRus.getText());
                    pw.println("Фамилия: "+tfsurnameForRus.getText());
                    pw.println("Факультет: "+comboForRus.getValue());
                    
                    if(comboForRus.getValue().equals("Факультет юриспруденции и социальнo-гуманитарных наук"))
                        pw.println("Специальность: "+lawForRus.getValue());
                    else if(comboForRus.getValue().equals("Факультет педагогических и гуманитарных наук"))
                        pw.println("Специальность: "+philForRus.getValue());
                    else if(comboForRus.getValue().equals("Факультет инженерии и естественных наук"))
                        pw.println("Специальность: "+engForRus.getValue());
                    else if(comboForRus.getValue().equals("Бизнес-школа СДУ"))
                        pw.println("Специальность: "+ecoForRus.getValue());
                    
                    if(rbMaleForRus.isSelected())
                        pw.println("Пол: Мужской");
                    else
                        pw.println("Пол: Женский");
                    
                    pw.println("ДЕНЬ РОЖДЕНИЯ: "+dayForRus.getValue()+"."+monthForRus.getValue()+"."+yearForRus.getValue());
                    pw.println("МЕСТО РОЖДЕНИЯ: "+tfplaceForRus.getText());
                    pw.println("Национальность: "+tfnationalityForRus.getText());
                    pw.println("Номер: "+tfnumberForRus.getText());
                    pw.println("E-mail: "+tfmailForRus.getText());
                    
                    if(rbBachelorForRus.isSelected()){
                        pw.println("Степень: Бакалавр");
                        pw.println("ЕНТ: "+tfentForRus.getText());
                        pw.println("Информация о родителях:");
                        pw.println("Отец: ");
                        pw.println("Должность: "+tffpostForRus.getText());
                        pw.println("Номер телефона: "+tffnumberForRus.getText());
                        pw.println("Мать: ");
                        pw.println("Должность: "+tfmpostForRus.getText());
                        pw.println("Номер телефона: "+tfmnumberForRus.getText());
                    }
                        
                    else if(rbMasterForRus.isSelected()){
                        pw.println("Степень: Магистратура");
                        pw.println("GPA: "+tfgpamForRus.getText());
                    }
                        
                    else if(rbPhDForRus.isSelected()){
                        pw.println("Степень: Докторантура");
                        pw.println("GPA: "+tfgpapForRus.getText());
                    }
                    pw.close();
                    label2ForRus.setText("Сделано!");
                    label2ForRus.setTextFill(Color.GREEN);
                    vboxm.getChildren().add(label2ForRus);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
        });
      
        vboxm.getChildren().addAll(hboxForDegreesRus, gridPaneForRus, vboxForDegreesRus, btConfirmForRus);
        vbox.getChildren().add(vboxm);
    }
       
    public void kaz() throws FileNotFoundException{
         
        HBox hboxForDegreesKaz = new HBox();
        VBox vboxForDegreesKaz = new VBox();
        
        GridPane gridPaneForBachelorKaz=new GridPane();
        GridPane gridPaneForMasterKaz=new GridPane();
        GridPane gridPaneForPhDKaz=new GridPane();
        
        TextField tfentForKaz=new TextField();
        TextField tffpostForKaz=new TextField();
        TextField tffnumberForKaz=new TextField();
        TextField tfmpostForKaz=new TextField();
        TextField tfmnumberForKaz=new TextField();
        
        TextField tfgpamForKaz=new TextField();
        
        TextField tfgpapForKaz=new TextField();
        
        RadioButton rbBachelorForKaz=new RadioButton("Бакалавриат");
        rbBachelorForKaz.setTextFill(Color.BLACK);
        rbBachelorForKaz.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbMasterForKaz=new RadioButton("Магистратура");
        rbMasterForKaz.setTextFill(Color.BLACK);
        rbMasterForKaz.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbPhDForKaz=new RadioButton("Докторантура");
        rbPhDForKaz.setTextFill(Color.BLACK);
        rbPhDForKaz.setPadding(new Insets(5,10,5,5));
        
        ToggleGroup groupForDegreesKaz=new ToggleGroup();
        rbBachelorForKaz.setToggleGroup(groupForDegreesKaz);
        rbMasterForKaz.setToggleGroup(groupForDegreesKaz);
        rbPhDForKaz.setToggleGroup(groupForDegreesKaz);
        
        rbBachelorForKaz.setOnAction(e -> {
            vboxForDegreesKaz.getChildren().clear();
            vboxForDegreesKaz.getChildren().add(gridPaneForBachelorKaz);
            
            if(rbBachelorForKaz.isSelected()) 
                gridPaneForBachelorKaz.add(new Label("ҰБТ НӘТИЖЕҢІЗ :"), 0, 0);
                gridPaneForBachelorKaz.add(tfentForKaz,1,0);

                gridPaneForBachelorKaz.add(new Label("АТА-АНАҢЫЗ ТУРАЛЫ МӘЛІМЕТ :"), 0, 1);
                gridPaneForBachelorKaz.add(new Label("ӘКЕ: "), 0, 2);
                gridPaneForBachelorKaz.add(new Label("ҚЫЗМЕТІ: "), 0, 3);
                gridPaneForBachelorKaz.add(tffpostForKaz,1,3);
                gridPaneForBachelorKaz.add(new Label("ҰЯЛЫ ТЕЛЕФОНЫ: "), 0, 4);
                gridPaneForBachelorKaz.add(tffnumberForKaz,1,4);

                gridPaneForBachelorKaz.add(new Label("АНА:"), 0, 5);
                gridPaneForBachelorKaz.add(new Label("ҚЫЗМЕТІ:"), 0, 6);
                gridPaneForBachelorKaz.add(tfmpostForKaz,1,6);
                gridPaneForBachelorKaz.add(new Label("ҰЯЛЫ ТЕЛЕФОНЫ:"), 0, 7);
                gridPaneForBachelorKaz.add(tfmnumberForKaz,1,7);
         });
     
        rbMasterForKaz.setOnAction(e -> {
            vboxForDegreesKaz.getChildren().clear();
            vboxForDegreesKaz.getChildren().add(gridPaneForMasterKaz);
            if(rbMasterForKaz.isSelected())
                gridPaneForMasterKaz.add(new Label("GPA ЕҢГІЗІҢІЗ:"), 0, 0);
                gridPaneForMasterKaz.add(tfgpamForKaz,1,0);
        });
        rbPhDForKaz.setOnAction(e -> {
            vboxForDegreesKaz.getChildren().clear();
            vboxForDegreesKaz.getChildren().add(gridPaneForPhDKaz);
            if(rbPhDForKaz.isSelected()) 
                 gridPaneForPhDKaz.add(new Label("GPA ЕҢГІЗІҢІЗ:"), 0, 16);
                 gridPaneForPhDKaz.add(tfgpapForKaz,1,16);
        });
        hboxForDegreesKaz.getChildren().addAll(rbBachelorForKaz, rbMasterForKaz, rbPhDForKaz);
        
        GridPane gridPaneForKaz=new GridPane();
        TextField tfnameForKaz=new TextField();
        TextField tfsurnameForKaz=new TextField();
        TextField tfplaceForKaz=new TextField();
        TextField tfnationalityForKaz=new TextField();
        TextField tfnumberForKaz=new TextField();
        TextField tfmailForKaz=new TextField();
        Button btConfirmForKaz = new Button("Confirm");
        Label label1ForKaz = new Label();
        Label label2ForKaz = new Label();

        gridPaneForKaz.setHgap(5);
        gridPaneForKaz.setVgap(5);
        gridPaneForKaz.add(new Label("АТЫ: "),0,0);
        gridPaneForKaz.add(tfnameForKaz,1,0);
        gridPaneForKaz.add(new Label("ТЕГІ: "),0,1);
        gridPaneForKaz.add(tfsurnameForKaz,1,1);
        gridPaneForKaz.add(new Label("ӨТІНІШ,ФАКУЛЬТЕТ ТАҢДАҢЫЗ: "),0,3);
       
       
        ComboBox<String> comboForKaz=new ComboBox();
        File fileForKaz=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\факультетказ.txt");
        Scanner scForKaz=new Scanner(fileForKaz);
        while(scForKaz.hasNextLine()){
            comboForKaz.getItems().addAll(scForKaz.nextLine());}
        gridPaneForKaz.add(comboForKaz,1,3);
       
        ComboBox<String> lawForKaz=new ComboBox();
        File file1ForKaz=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Мамандык\\зан.txt");
        Scanner sc1ForKaz=new Scanner(file1ForKaz);
        while(sc1ForKaz.hasNextLine()){
            lawForKaz.getItems().addAll(sc1ForKaz.nextLine());}
       
        ComboBox<String> philForKaz=new ComboBox();
        File file2ForKaz=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Мамандык\\Филология.txt");
        Scanner sc2ForKaz=new Scanner(file2ForKaz);
        while(sc2ForKaz.hasNextLine()){
            philForKaz.getItems().addAll(sc2ForKaz.nextLine());}

        ComboBox<String> engForKaz=new ComboBox();
        File file3ForKaz=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Мамандык\\инженер.txt");
        Scanner sc3ForKaz=new Scanner(file3ForKaz);
        while(sc3ForKaz.hasNextLine()){
            engForKaz.getItems().addAll(sc3ForKaz.nextLine());}

        ComboBox<String> ecoForKaz=new ComboBox();
        File file4ForKaz=new File("C:\\Users\\MI\\Documents\\NetBeansProjects\\Проект\\Мамандык\\эконом.txt");
        Scanner sc4ForKaz=new Scanner(file4ForKaz);
        while(sc4ForKaz.hasNextLine()){
            ecoForKaz.getItems().addAll(sc4ForKaz.nextLine());}
       
        comboForKaz.setOnAction(e -> {
            if(comboForKaz.getValue().equals("Құқық және әлеуметтік-гуманитарлық ғылымдар факультеті")){
                gridPaneForKaz.add(new Label("ӨТІНІШ,МАМАНДЫҚ ТАҢДАҢЫЗ: "),0,4);
                if (gridPaneForKaz.contains(0, 4))
                    //if(combo.getValue().equals("Faculty of Education and Humanities"))
                        gridPaneForKaz.getChildren().remove(philForKaz);
                    //if(combo.getValue().equals("Faculty of Engineering and Natural sciences"))
                        gridPaneForKaz.getChildren().remove(engForKaz);
                    //if(combo.getValue().equals("SDU Business school"))
                        gridPaneForKaz.getChildren().remove(ecoForKaz);
                gridPaneForKaz.add(lawForKaz, 1,4);}
            else if(comboForKaz.getValue().equals("Педагогикалық және гуманитарлық ғылымдар факультеті")){
                gridPaneForKaz.add(new Label("ӨТІНІШ,МАМАНДЫҚ ТАҢДАҢЫЗ: "),0,4);
                if (gridPaneForKaz.contains(0, 4))
                    //if(combo.getValue().equals("Faculty of Education and Humanities"))
                        gridPaneForKaz.getChildren().remove(lawForKaz);
                    //if(combo.getValue().equals("Faculty of Engineering and Natural sciences"))
                        gridPaneForKaz.getChildren().remove(engForKaz);
                    //if(combo.getValue().equals("SDU Business school"))
                        gridPaneForKaz.getChildren().remove(ecoForKaz);
                gridPaneForKaz.add(philForKaz, 1,4);}
            else if(comboForKaz.getValue().equals("Инженерлік және жаратылыстану ғылымдары факультеті")){
                gridPaneForKaz.add(new Label("ӨТІНІШ,МАМАНДЫҚ ТАҢДАҢЫЗ: "),0,4);
                if (gridPaneForKaz.contains(0, 4))
                    //if(combo.getValue().equals("Faculty of Education and Humanities"))
                        gridPaneForKaz.getChildren().remove(lawForKaz);
                    //if(combo.getValue().equals("Faculty of Engineering and Natural sciences"))
                        gridPaneForKaz.getChildren().remove(philForKaz);
                    //if(combo.getValue().equals("SDU Business school"))
                        gridPaneForKaz.getChildren().remove(ecoForKaz);
                gridPaneForKaz.add(engForKaz, 1,4);}
            else if(comboForKaz.getValue().equals("СДУ Бизнес мектебі")){
                gridPaneForKaz.add(new Label("ӨТІНІШ,МАМАНДЫҚ ТАҢДАҢЫЗ: "),0,4);
                if (gridPaneForKaz.contains(0, 4))
                    //if(combo.getValue().equals("Faculty of Education and Humanities"))
                        gridPaneForKaz.getChildren().remove(lawForKaz);
                    //if(combo.getValue().equals("Faculty of Engineering and Natural sciences"))
                        gridPaneForKaz.getChildren().remove(philForKaz);
                    //if(combo.getValue().equals("SDU Business school"))
                        gridPaneForKaz.getChildren().remove(engForKaz);
                gridPaneForKaz.add(ecoForKaz, 1,4);}
        });
       
        gridPaneForKaz.add(new Label("ӨЗІНІЗ ТУРАЛЫ МӘЛІМЕТ: "), 0,9);
        gridPaneForKaz.add(new Label("ӨТІНІШ,ЖЫНЫСЫНЫЗДЫ ТАҢДАҢЫЗ: "), 0,10);
        gridPaneForKaz.add(new Label("ТУҒАН КҮНІҢІЗ: "), 0,11);
        
        HBox hboxForSexKaz = new HBox();
        RadioButton rbMaleForKaz=new RadioButton("Еркек");
        rbMaleForKaz.setTextFill(Color.BLACK);
        rbMaleForKaz.setPadding(new Insets(5,10,5,5));
        
        RadioButton rbFemaleForKaz=new RadioButton("Әйел");
        rbFemaleForKaz.setTextFill(Color.BLACK);
        rbFemaleForKaz.setPadding(new Insets(5,10,5,5));
        
        ToggleGroup groupForSexKaz=new ToggleGroup();
        rbMaleForKaz.setToggleGroup(groupForSexKaz);
        rbFemaleForKaz.setToggleGroup(groupForSexKaz);
        
        hboxForSexKaz.getChildren().addAll(rbMaleForKaz, rbFemaleForKaz);
        gridPaneForKaz.add(hboxForSexKaz,1,10);
       
        HBox hboxForBDKaz = new HBox();
       
        ComboBox<Integer> dayForKaz=new ComboBox();
        dayForKaz.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
       
        ComboBox<String> monthForKaz=new ComboBox();
        monthForKaz.getItems().addAll("Қантар","Ақпан","Наурыз","Сәуір","Мамыр",
            "Маусым","Шілде","Тамыз","Қыркүйек","Қазан","Қараша","Желтоқсан");
       
        ComboBox<Integer> yearForKaz=new ComboBox();
        yearForKaz.getItems().addAll(1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,
               1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004);
       
        hboxForBDKaz.getChildren().addAll(new Label("Күн: "),dayForKaz,new Label("   Ай: "),monthForKaz,new Label("   Жыл: "),yearForKaz);
        gridPaneForKaz.add(hboxForBDKaz, 1, 11);
       
       
        gridPaneForKaz.add(new Label("ТУҒАН ЖЕРІҢІЗ: "),0,12);
        gridPaneForKaz.add(tfplaceForKaz,1,12);

        gridPaneForKaz.add(new Label("ҰЛТЫҢЫЗ: "),0,13);
        gridPaneForKaz.add(tfnationalityForKaz,1,13);

        gridPaneForKaz.add(new Label("ТЕЛЕФОН НӨМІРІҢІЗ: "),0,14);
        gridPaneForKaz.add(tfnumberForKaz,1,14);

        gridPaneForKaz.add(new Label("ПОШТАҢЫЗ: "),0,15);
        gridPaneForKaz.add(tfmailForKaz,1,15);
        
        btConfirmForKaz.setOnAction(e->{
            if(tfnameForKaz.getText().equals("") && tfsurnameForKaz.getText().equals("")){
                label1ForKaz.setText("Өтінемін толық толтырыңыз");
                label1ForKaz.setTextFill(Color.RED);
                vboxm.getChildren().add(label1ForKaz);
            }
            else{
                try{
                    PrintWriter pw = new PrintWriter(tfnameForKaz.getText()+"_"+tfsurnameForKaz.getText()+".txt","UTF-8");
                    
                    pw.println("Аты: "+tfnameForKaz.getText());
                    pw.println("Тегі: "+tfsurnameForKaz.getText());
                    pw.println("Факультеті: "+comboForKaz.getValue());
                    
                    if(comboForKaz.getValue().equals("Құқық және әлеуметтік-гуманитарлық ғылымдар факультеті"))
                        pw.println("Мамандық: "+lawForKaz.getValue());
                    else if(comboForKaz.getValue().equals("Педагогикалық және гуманитарлық ғылымдар факультеті"))
                        pw.println("Мамандық: "+philForKaz.getValue());
                    else if(comboForKaz.getValue().equals("Инженерлік және жаратылыстану ғылымдары факультеті"))
                        pw.println("Мамандық: "+engForKaz.getValue());
                    else if(comboForKaz.getValue().equals("СДУ Бизнес мектебі"))
                        pw.println("Мамандық: "+ecoForKaz.getValue());
                    
                    if(rbMaleForKaz.isSelected())
                        pw.println("Жынысы: Еркек");
                    else
                        pw.println("Жынысы: Әйел");
                    
                    pw.println("ТУҒАН КҮНІҢІЗ: "+dayForKaz.getValue()+"."+monthForKaz.getValue()+"."+yearForKaz.getValue());
                    pw.println("ТУҒАН ЖЕРІҢІЗ: "+tfplaceForKaz.getText());
                    pw.println("ҰЛТЫҢЫЗ: "+tfnationalityForKaz.getText());
                    pw.println("ТЕЛЕФОН НӨМІРІҢІЗ: "+tfnumberForKaz.getText());
                    pw.println("ПОШТАҢЫЗ: "+tfmailForKaz.getText());
                    
                    if(rbBachelorForKaz.isSelected()){
                        pw.println("Дәрежесі: Бакалавр");
                        pw.println("ҰБТ: "+tfentForKaz.getText());
                        pw.println("Ата-ана туралы мәлімет:");
                        pw.println("Әкесі: ");
                        pw.println("Жұмыс орны: "+tffpostForKaz.getText());
                        pw.println("Телефон номері: "+tffnumberForKaz.getText());
                        pw.println("Анасы: ");
                        pw.println("Жұмыс орны: "+tfmpostForKaz.getText());
                        pw.println("Телефон номері: "+tfmnumberForKaz.getText());
                    }
                        
                    else if(rbMasterForKaz.isSelected()){
                        pw.println("Дәрежесі: Магистратура");
                        pw.println("GPA: "+tfgpamForKaz.getText());
                    }
                        
                    else if(rbPhDForKaz.isSelected()){
                        pw.println("Дәрежесі: Докторантура");
                        pw.println("GPA: "+tfgpapForKaz.getText());
                    }
                    pw.close();
                    label2ForKaz.setText("Тіркелінді!");
                    label2ForKaz.setTextFill(Color.GREEN);
                    vboxm.getChildren().add(label2ForKaz);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
        });
      
        vboxm.getChildren().addAll(hboxForDegreesKaz, gridPaneForKaz, vboxForDegreesKaz, btConfirmForKaz);
        vbox.getChildren().add(vboxm);
    }
    public static void main(String[] args){
        Application.launch();
    }
}