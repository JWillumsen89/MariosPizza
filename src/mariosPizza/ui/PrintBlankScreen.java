package mariosPizza.ui;

import java.awt.*;

public class PrintBlankScreen {
    public void print() {
        var dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = dim.height;
        for (var i = 0;i <screenHeight;i++)
          System.out.println();
    }
}
