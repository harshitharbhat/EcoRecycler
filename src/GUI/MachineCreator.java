package GUI;

import RCM.RecycleMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MachineCreator implements ActionListener {
    RecycleMachine rcm;
    JFrame frame;
    public void addMachine(RecycleMachine rcm,JFrame frame,JPanel panel){
        this.rcm = rcm;
        this.frame = frame;
        JButton button = new JButton("Add new Machine");
        panel.add(button);
        button.addActionListener(this);
        this.frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        RcmUI rcmUI = new RcmUI();
//        rcmUI.createFrame(rcm);
//        updateRmosUI();
    }

    private void updateRmosUI() {
        RmosUI rmosUI = new RmosUI();
        rmosUI.displayMachinesContent(this.frame);
    }
}
