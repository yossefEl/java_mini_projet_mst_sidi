package com.mst.java.mini.projet.usf.elm.helpers;

import javax.swing.*;
import java.awt.*;

public class DialogHelper {
    public static void showErrorMessage(Component parent,String message) {
        final JLabel messageLabel=new JLabel(   "<html><div style='width:300px'>"+ message +"</div></html>",SwingConstants.LEFT);
        JOptionPane.showMessageDialog(
                parent,
                messageLabel,
                "Erreur survenue",
                JOptionPane.ERROR_MESSAGE);

    }
}
