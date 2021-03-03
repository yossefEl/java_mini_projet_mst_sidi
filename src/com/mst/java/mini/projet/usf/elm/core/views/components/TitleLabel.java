package com.mst.java.mini.projet.usf.elm.core.views.components;

import javax.swing.JLabel;
import java.awt.*;

public class TitleLabel extends JLabel {


    public TitleLabel(String blueWord, String orangeWord) {
        super("<html><div style='text-align:center'><span style='color:#0F7298;font-weight:bold;'>" + blueWord.toUpperCase() + " " + "</span>" +
                        "<span style='color:#F28923;font-weight:bold;'>" + orangeWord.toUpperCase() + "</span></div></html>");
        setFont(new Font("Arial",Font.BOLD,18));
    }
    public TitleLabel(String blueWord, String orangeWord,int fontSize) {
        super("<html><div style='text-align:center'><span style='color:#0F7298;font-weight:bold;'>" + blueWord.toUpperCase() + " " + "</span>" +
                "<span style='color:#F28923;font-weight:bold;'>" + orangeWord.toUpperCase() + "</span></div></html>");
        setFont(new Font("Arial",Font.BOLD,fontSize));

    }
}
