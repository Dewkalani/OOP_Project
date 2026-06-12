package com.sliit.greenloop;

public class GreenLoop {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new gui.MainForm().setVisible(true));
    }
}
