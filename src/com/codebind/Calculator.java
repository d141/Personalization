//Works on Java 8_144 and Java 8_151


package com.codebind;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Calculator extends Component {
    private JPanel panel1;
    private JTextField lines10;
    private JTextField lines9;
    private JTextField colors2;
    private JTextField lines1;
    private JTextField colors3;
    private JTextField colors4;
    private JTextField colors5;
    private JTextField colors6;
    private JTextField colors7;
    private JTextField lines8;
    private JTextField lines2;
    private JTextField lines3;
    private JTextField lines4;
    private JTextField lines5;
    private JTextField lines6;
    private JTextField lines7;
    private JTextField colors1;
    private JTextField colors8;
    private JTextField colors9;
    private JTextField colors10;
    private JButton clearButton;
    private JButton calculateButton;
    private JTextArea textArea1;
    private JButton bitmapifyButton;
    private JComboBox fontBox;
    private JComboBox sizeBox;
    private JButton loadFontsButton;
    private JComboBox alignBox;
    private JComboBox comboBox1;
    private JCheckBox kernCheckBox;
    private JButton clearBackgroundButton;
    private JButton customAlignment;

    String justifyString = "";

    final JFileChooser  fc = new JFileChooser("C:/Sitex/Files/Downloads");

    Color B = new Color(255,141,17);
    Color P = new Color(64,0,0);
    Color W = new Color(249, 218, 224);


    public void clearBackground(){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(String.valueOf("C:/Sitex/Files/Downloads/Name Drop/CurrentSection.png")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x, y, Color.WHITE.getRGB());
            }
        }

        File outputfile = new File("C:/Sitex/Files/Downloads/Name Drop/CurrentSection.png");
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public void drawString(Graphics2D g, String text, int increment, String alignment) {

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(String.valueOf("C:/Sitex/Files/Downloads/Name Drop/CurrentSection.png")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        int x=0;
        int y=40;
        g.drawImage(image,0,0,null);
        FontMetrics fm = g.getFontMetrics();
        int count = 0;
        //Draw the first green line
        g.drawLine(0,0,473,0);

        String startString = "";
        if(alignment.equals("Custom")) {
            String[] choices = {"Justify Left", "Justify Right"};
            justifyString = (String) JOptionPane.showInputDialog(null, "Justify how?", "Justify how?", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
            if (justifyString.equals("Justify Left")) {
                startString = JOptionPane.showInputDialog(null, "What column should the text start on?");
            } else if (justifyString.equals("Justify Right")) {
                startString = JOptionPane.showInputDialog(null, "What column should the text end on?");
            }
        }

        for (String line : text.split("\n")) {
            count++;
            //    FontRenderContext frc = g.getFontRenderContext();
            //    Rectangle2D rect = font.getStringBounds(line,frc);
            //    int width = (int)rect.getWidth();
            g.drawImage(image,0,y+1,null);

            String format = (String)comboBox1.getItemAt(comboBox1.getSelectedIndex());
            if(format.equals("Capital Letters")){
                int width = fm.stringWidth(line.toUpperCase());

                if(alignment.equals("Align Left")){
                    x=40;
                }
                else if(alignment.equals("Center")){
                    x=236-(width/2);
                }
                else if(alignment.equals("Align Right")){
                    x = 443-width;
                }
                else if(alignment.equals("Custom") && justifyString.equals("Justify Left")) {
                    x = Integer.parseInt(startString);
                }
                else if(alignment.equals("Custom") && justifyString.equals("Justify Right")) {
                    x = Integer.parseInt(startString)-width;
                }
                g.setColor(W);
                g.drawString(line.toUpperCase(), x, y-increment);
                g.setColor(P);
                y++;
                g.drawLine(0,y,473,y);
                y += 40;
            }
            else {
                int width = fm.stringWidth(line);

                if(alignment.equals("Align Left")){
                    x=40;
                }
                else if(alignment.equals("Center")){
                    x=236-(width/2);
                }
                else if(alignment.equals("Align Right")){
                    x = 433-width;
                }
                else if(alignment.equals("Custom") && justifyString.equals("Justify Left")) {
                    x = Integer.parseInt(startString);
                }
                else if(alignment.equals("Custom") && justifyString.equals("Justify Right")) {
                    x = Integer.parseInt(startString)-width;
                }
                g.setColor(W);
                g.drawString(line, x, y - increment);
                g.setColor(P);
                y++;
                g.drawLine(0, y, 473, y);
                y += 40;
            }
        }
        int blanks =20-count;

        for(int i=0;i<blanks;i++){
            g.drawImage(image,0,y+1,null);
            g.setColor(P);
            y++;
            g.drawLine(0, y, 473, y);
            y += 40;
        }
        String message = "You entered " + count + " names.";
        JOptionPane.showMessageDialog(null,message);
        if(count>20){
            message = count + " names is too many!";
            JOptionPane.showMessageDialog(null,message,"TOO MANY NAMES",JOptionPane.ERROR_MESSAGE);
        }
    }









    public Calculator() {

        loadFontsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //  String[] fonts = {"Arial","Times New Roman"};
                fontBox.addItem("Arial");
                //fontBox.addItem("Times New Roman");
                //fontBox.addItem("Tahoma");
                //fontBox.addItem("College Black");
                //fontBox.addItem("Arial Black");
                // fontBox.addItem("Vitesse Bold");
                //fontBox.addItem("Rockwell");
                //fontBox.addItem("News701 BT");
                //fontBox.addItem("MS Sans Serif Regular");
                //fontBox.addItem("Brush Script MT Italic");
                //fontBox.addItem("Copperplate Gothic");
                fontBox.addItem("Clarendon BT");
                //fontBox.addItem("Back to Black");
                //fontBox.addItem("Army");
                //fontBox.addItem("Billy the Kid");
                //fontBox.addItem("IFC Railroad");
                //fontBox.addItem("Goudy STO");
                //fontBox.addItem("Canterbury");
                //fontBox.addItem("Kitten Swash");
                //fontBox.addItem("Drop Dead Gorgeous");
                //fontBox.addItem("Carbon");
                //fontBox.addItem("Alwyn");
                //fontBox.addItem("ChinaOne");
                //fontBox.addItem("BlackCaps");
                //fontBox.addItem("PirateKeg");
                //fontBox.addItem("Baskerville");
                sizeBox.addItem(10);
                sizeBox.addItem(12);
                sizeBox.addItem(14);
                sizeBox.addItem(16);
                sizeBox.addItem(19);
                sizeBox.addItem(24);
                sizeBox.addItem(30);
                sizeBox.addItem(40);
                alignBox.addItem("Align Left");
                alignBox.addItem("Center");
                alignBox.addItem("Align Right");
                alignBox.addItem("Custom");
                comboBox1.addItem("Keep Format");
                comboBox1.addItem("Capital Letters");

            }
        });


        bitmapifyButton.addActionListener(new ActionListener() {

            //This does all the work
            //Takes the empty image as an input along with the text gathered from the textArea
            //Also takes in the increment parameter which is used to properly locate the text in the field
            //Uses alignment to properly locate the text left to right


            @Override
            public void actionPerformed(ActionEvent e) {





                Font font = null;
                int sizeInt = 0;
                String fontString = (String) fontBox.getItemAt(fontBox.getSelectedIndex());


                if(fontString.equals("College Black")) {

                    try {
                       // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/collegeB.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/collegeB.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/collegeB.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/collegeB.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/collegeB.ttf")).deriveFont(35f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/collegeB.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/collegeB.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/collegeB.ttf")).deriveFont(46f);
                          //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Back to Black")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BacktoBlack.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BacktoBlack.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BacktoBlack.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BacktoBlack.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BacktoBlack.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BacktoBlack.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BacktoBlack.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BacktoBlack.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("ChinaOne")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/ChinaOne.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/ChinaOne.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/ChinaOne.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/ChinaOne.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/ChinaOne.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/ChinaOne.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/ChinaOne.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/ChinaOne.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Carbon")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/CARBONBL.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/CARBONBL.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/CARBONBL.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/CARBONBL.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/CARBONBL.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/CARBONBL.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/CARBONBL.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/CARBONBL.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Billy the Kid")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Billy the Kid.ttf")).deriveFont(23f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Billy the Kid.ttf")).deriveFont(27f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Billy the Kid.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Billy the Kid.ttf")).deriveFont(17f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Billy the Kid.ttf")).deriveFont(20f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Billy the Kid.ttf")).deriveFont(43f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Billy the Kid.ttf")).deriveFont(34f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Billy the Kid.ttf")).deriveFont(57f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Rockwell")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Rockwell.ttf")).deriveFont(23f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Rockwell.ttf")).deriveFont(27f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Rockwell.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Rockwell.ttf")).deriveFont(17f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Rockwell.ttf")).deriveFont(20f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Rockwell.ttf")).deriveFont(43f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Rockwell.ttf")).deriveFont(34f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Rockwell.ttf")).deriveFont(57f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("IFC Railroad")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/IFC Railroad.ttf")).deriveFont(23f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/IFC Railroad.ttf")).deriveFont(27f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/IFC Railroad.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/IFC Railroad.ttf")).deriveFont(17f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/IFC Railroad.ttf")).deriveFont(20f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/IFC Railroad.ttf")).deriveFont(43f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/IFC Railroad.ttf")).deriveFont(34f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/IFC Railroad.ttf")).deriveFont(57f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Army")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Army.ttf")).deriveFont(21f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Army.ttf")).deriveFont(25f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Army.ttf")).deriveFont(13f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Army.ttf")).deriveFont(15f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Army.ttf")).deriveFont(18f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Army.ttf")).deriveFont(39f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Army.ttf")).deriveFont(31f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Army.ttf")).deriveFont(52f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Copperplate Gothic")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Clarendon BT")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Clarendon.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Clarendon.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Clarendon.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Clarendon.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Clarendon.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Clarendon.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Clarendon.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Clarendon.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }
                else if(fontString.equals("BlackCaps")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BlackCaps.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BlackCaps.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BlackCaps.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BlackCaps.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BlackCaps.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BlackCaps.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BlackCaps.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/BlackCaps.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }


                else if(fontString.equals("PirateKeg")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/PirateKeg.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/PirateKeg.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/PirateKeg.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/PirateKeg.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/PirateKeg.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/PirateKeg.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/PirateKeg.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/PirateKeg.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Alwyn")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Alwyn.otf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Alwyn.otf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Alwyn.otf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Alwyn.otf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Alwyn.otf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Alwyn.otf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Alwyn.otf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Alwyn.otf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Baskerville")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Baskerville.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Baskerville.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Baskerville.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Baskerville.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Baskerville.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Baskerville.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Baskerville.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Baskerville.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }

                else if(fontString.equals("Canterbury")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Canterbury.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Canterbury.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Canterbury.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Canterbury.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Canterbury.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Canterbury.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Canterbury.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/Canterbury.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }
                else if(fontString.equals("Kitten Swash")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/KittenSwash.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/KittenSwash.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/KittenSwash.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/KittenSwash.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/KittenSwash.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/KittenSwash.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/KittenSwash.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/KittenSwash.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }
                else if(fontString.equals("Drop Dead Gorgeous")) {

                    try {
                        // System.out.println(sizeInt);
                        if( (int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(19f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(22f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(12f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(14f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(16f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(35f);
                        }

                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(28f);
                        }
                        else if((int)sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40){
                            font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("C:/Sitex/Files/Downloads/Name Drop/fonts/copperplate.ttf")).deriveFont(46f);
                            //  System.out.println(sizeInt);
                        }

                    } catch (IOException | FontFormatException e1) {
                        // Handle exception
                    }

                }



                else{
                    if ((int) sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 16) {
                        sizeInt = 22;
                    }
                    else if ((int) sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 14) {
                        sizeInt = 19;
                    }
                    else if ((int) sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 12) {
                        sizeInt = 16;
                    }
                    else if ((int) sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 19) {
                        sizeInt = 26;
                    }
                    else if ((int) sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 24) {
                        sizeInt = 33;
                    }
                    else if ((int) sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 30) {
                        sizeInt = 41;
                    }
                    else if ((int) sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 40) {
                        sizeInt = 53;
                    }
                    else if ((int) sizeBox.getItemAt(sizeBox.getSelectedIndex()) == 10) {
                        sizeInt = 13;
                    }
                   font = new Font(fontString, Font.BOLD, sizeInt);
                }

                int returnVal = fc.showOpenDialog(Calculator.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();

                    BufferedImage bitmapImage = null;
                    try {
                        bitmapImage = ImageIO.read(new File(String.valueOf(file)));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    String startingLine = JOptionPane.showInputDialog(null,"On what line do you want the bottom of the text?");
                    //  String height = JOptionPane.showInputDialog(null,"How tall is it?");
                    //  int heightNum = Integer.parseInt(height);
                    int startingLineNum = Integer.parseInt(startingLine);
                    int offset = ((40-(int)sizeBox.getItemAt(sizeBox.getSelectedIndex()))/2);
                    startingLineNum-=offset;
                    startingLineNum+=40;
                    int height = bitmapImage.getHeight();
                    System.out.println(height);
                    bitmapImage = bitmapImage.getSubimage(5, height-startingLineNum, 473, 41);
                    String filename = "C:/Sitex/Files/Downloads/Name Drop/CurrentSection.png";
                    File outputfile = new File(filename);
                    try {
                        ImageIO.write(bitmapImage, "png", outputfile);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

if(kernCheckBox.isSelected()){
                    Map<TextAttribute, Object> attributes = new HashMap<>();
                    attributes.put(TextAttribute.TRACKING,.02);
                    Font font2 = font.deriveFont(attributes);
                    font = font2;
}

                //Build the empty image and gather the font type and font size
                BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = img.createGraphics();

                String alignment = (String) alignBox.getItemAt(alignBox.getSelectedIndex());

                g2d.setFont(font);
                g2d.dispose();
                img = new BufferedImage(473, 821, BufferedImage.TYPE_INT_ARGB);
                g2d = img.createGraphics();
                g2d.setFont(font);




                //Logic for determining placement of text based on font size
                int sizeInt2 = (int)sizeBox.getItemAt(sizeBox.getSelectedIndex());
                System.out.println(sizeInt2);
                if (sizeInt2 == 16) {
                    drawString(g2d, textArea1.getText(), 12,alignment);
                }
                else if (sizeInt2 == 12) {
                    drawString(g2d, textArea1.getText(), 14,alignment);
                }
                else if (sizeInt2 == 14) {
                    drawString(g2d, textArea1.getText(), 13,alignment);
                }
                else if (sizeInt2 == 19) {
                    drawString(g2d, textArea1.getText(), 11,alignment);
                }
                else if (sizeInt2 == 24) {
                    drawString(g2d, textArea1.getText(), 8,alignment);
                }
                else if (sizeInt2 == 40) {
                    drawString(g2d, textArea1.getText(), 0,alignment);
                }
                else if (sizeInt2 == 10) {
                    drawString(g2d, textArea1.getText(), 15,alignment);
                }
                else if (sizeInt2 == 30) {
                    drawString(g2d, textArea1.getText(), 5,alignment);
                }

                //Create the output file
                String fileString = JOptionPane.showInputDialog(null,"What do you want to call the file?");
                String filename = "C:/Sitex/Files/Downloads/Name Drop/" + fileString + ".bmp";
                File outputfile = new File(filename);
                BufferedImage finalImage = new BufferedImage(img.getWidth(),
                        img.getHeight(), BufferedImage.TYPE_INT_RGB);
                finalImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
                try {
                    ImageIO.write(finalImage, "bmp", outputfile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            /*   String csvfilename = "C:/Users/Shannon/Desktop/Grid Lists/" + fileString + ".csv";
                String nameList = textArea1.getText();
                try {
                    FileWriter writer = new FileWriter(csvfilename);
                    for (String line : nameList.split("\n")) {
                        writer.write(line);
                        writer.write(System.lineSeparator());
                    }
                    writer.flush();
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }*/

                   }


        });



        clearBackgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearBackground();
            }
        });

    }




    public static void main (String[] args){

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        JFrame frame = new JFrame("Calculator");
    frame.setContentPane(new Calculator().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(500,900);
    frame.setVisible(true);

    }


}
