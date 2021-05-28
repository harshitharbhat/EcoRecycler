package GUI;

import RCM.RecycleMachine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RcmGui {

    public void createFrame(RecycleMachine rcm){
        JFrame frame = new JFrame("Recycling Machine Outlet");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        MachineInfoCreator machineCreator = new MachineInfoCreator();
        panel.add(machineCreator.createLayout(rcm),BorderLayout.NORTH);
        //panel.add(machineCreator.addItemsData(),BorderLayout.CENTER);
        frame.add(panel);
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }





    public void updateItemList() {
        //addItemsData();
    }

}
