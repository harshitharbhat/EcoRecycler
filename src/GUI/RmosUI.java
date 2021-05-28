package GUI;

import RCM.RecyclableMachineCache;
import RCM.RecycleMachine;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RmosUI {
    JPanel panel = new JPanel(new GridLayout(3, 0,10,10));
    public void createRMOS(){
        JFrame frame = new JFrame("Recycle Machines Administrator");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JLabel label = new JLabel("<html> Recycle Machines Administrator. " );
//        panel.add(label);
//        panel.setLayout(new FlowLayout());
//        frame.add(panel);
//        displayMachinesContent(frame);
//        addFunctions(frame,panel);

//        frame.pack();
//        frame.setLocationRelativeTo(null);
        frame.add(createTabs());
        frame.setVisible(true);

    }

    private JTabbedPane createTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.add(new RecyclableMachineContent().displayMachineContent());
        panel2.add(new RecyclableItemContent().displayItemsContent());
        tabbedPane.addTab("Recycling Machines ", panel1);
        tabbedPane.addTab("Recyclable Items", panel2);
        tabbedPane.addTab("Stats and Analytics", panel3);
        return tabbedPane;
    }

    public void displayMachinesContent(JFrame frame) {
        List<RecycleMachine> recyclableMachines = RecyclableMachineCache.getAllItems();
        //JPanel panel = new JPanel(new GridLayout(1, 2,5,5));
        for (RecycleMachine rm: recyclableMachines) {

            System.out.println(rm.getMachineId());
            JLabel label = new JLabel("<html> Machine ID  : "+ rm.getMachineId()
                    +"<br/> Location : " + rm.getLocation()
                    +"<br/> Operational : " + (rm.isOperational() ? "Yes" : "No")
                    +"<br/> Amount Remaining : " + rm.getMoneyAvailable()
                    +"<br/> Capacity : " + rm.getAllowedWeight());
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(label);
            //frame.pack();
            frame.add(panel);
        }
       // createButtons(frame);
    }

    private void createButtons(JFrame frame) {
        JButton button = new JButton("Add New Machine" );
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);
        frame.add(panel);
    }
}
