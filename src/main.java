/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Gui.MainFrame;
import gui.MainFrameEsas;
import java.awt.Dimension;

import java.awt.Toolkit;

/**
 *
 * @author Vusal
 */
public class main {

    public static void main(String args[]) {

        MainFrame frame = new MainFrame();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setVisible(true);

    }

}
