package com.mst.java.mini.projet.usf.elm.helpers;

import javax.swing.*;
import java.awt.*;


/**
 * This class handles the dialogs to show if case success/ error /confirmation
 * This is useful when the developer decides to change the view of the dialogs
 */
public class DialogHelper {
    public static void showErrorMessage(Component parent, String message) {
        final JLabel messageLabel = new JLabel("<html><div style='width:300px'>" + message + "</div></html>", SwingConstants.LEFT);
        JOptionPane.showMessageDialog(
                parent,
                messageLabel,
                "Erreur survenue",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showErrorMessage(Component parent, String title, String message) {
        final JLabel messageLabel = new JLabel("<html><div style='width:300px'>" + message + "</div></html>", SwingConstants.LEFT);
        JOptionPane.showMessageDialog(
                parent,
                messageLabel,
                title,
                JOptionPane.ERROR_MESSAGE);
    }


    public static int showConfirmationDialog(Component parent, String message) {
        return JOptionPane.showConfirmDialog(
                parent,
                message,
                "Confimation",

                JOptionPane.OK_CANCEL_OPTION
        );
    }
}
