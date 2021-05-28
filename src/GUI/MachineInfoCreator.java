package GUI;

import RCM.RecyclableItem;
import RCM.RecyclableItemCache;
import RCM.RecycleMachine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MachineInfoCreator {
    JPanel panel = new JPanel(new BorderLayout());
    float returnableAmount = 0;
    public JPanel createLayout(RecycleMachine rcm){
        panel.add(addMachineDetails(rcm),BorderLayout.NORTH);
        panel.add(createButton(),BorderLayout.WEST);
        panel.add(addItemsData(),BorderLayout.EAST);
        panel.add(totalAMount(),BorderLayout.SOUTH);
        return panel;
    }

    public JPanel addMachineDetails(RecycleMachine rcm) {
        JPanel subPanel = new JPanel(new BorderLayout());
        String data = "Machine ID : " + rcm.getMachineId()
                + "\nLocation : " + rcm.getLocation()
                +"\nLast Emptied : " + rcm.getTimeEmptied();
        JLabel label = new JLabel("Please enter the weight of the items to be recycled");
        JTextArea textArea = new JTextArea(data);
        subPanel.add(textArea,BorderLayout.CENTER);
        subPanel.add(label,BorderLayout.SOUTH);

        return subPanel;
    }

    public JPanel addItemsData() {
        JPanel subPanel = new JPanel();
        String[] columns = {"ID","Item Type","Price"};
        List<RecyclableItem> itemList = RecyclableItemCache.getAllItems();

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        model.setColumnIdentifiers(columns);
        for (RecyclableItem ri : itemList) {
            Object[] o = new Object[3];
            o[0] = ri.getItemId();
            o[1] = ri.getItemType();
            o[2] = ri.getAmount();
            model.addRow(o);
        }
        JScrollPane scrollPane = new JScrollPane(table);

        subPanel.add(scrollPane,BorderLayout.CENTER);
        return subPanel;
    }

    private JPanel createButton() {
        JPanel subPanel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel(new BorderLayout());
        JButton button = new JButton("Insert Item");
        button.setPreferredSize(new Dimension(200, 20));
        button.addActionListener ( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                JTextField weight = new JTextField();
                String[] options = new String[RecyclableItemCache.getAllItems().size()];
                int i = 0;
                for(RecyclableItem ri : RecyclableItemCache.getAllItems()){
                    options[i] = ri.getItemType() + " - " + ri.getAmount();
                    i++;
                }
                JComboBox comboBox = new JComboBox(options);
                final JComponent[] inputs = new JComponent[] {
                        new JLabel("Item Type"),
                        comboBox,
                        new JLabel("Please Enter Weight of Item"),
                        weight,
                };
                int result = JOptionPane.showConfirmDialog(null, inputs,
                        "Recycle Item", JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println("New Item entered :  " +
                            weight.getText() + ", " +
                            comboBox.getSelectedItem());
                    String[] selected = String.valueOf(comboBox.getSelectedItem()).split(" - ");
                    returnableAmount = Float.valueOf(selected[1]) * Integer.valueOf(weight.getText());
                    JLabel newLine = new JLabel("<html><br><br><p></p></html>");
                    JLabel label = new JLabel("<html> <p> Added " + weight.getText() + "lbs of " + selected[0] + "</p></html>");
                    panel1.add(newLine,BorderLayout.NORTH);
                    panel1.add(label,BorderLayout.AFTER_LAST_LINE);
                    panel1.revalidate();
                    panel1.repaint();
                    subPanel.add(panel1,BorderLayout.CENTER);
                    subPanel.revalidate();
                    subPanel.repaint();
                } else {
                    System.out.println("Add new Item  : User canceled / closed the dialog, result = " + result);
                }
            }
        } );
        subPanel.add(button,BorderLayout.NORTH);
        return subPanel;
    }

   private JPanel totalAMount() {
        JPanel subPanel = new JPanel();
        JLabel label2 = new JLabel("TOTAL AMOUNT RETURNABLE :    "  + returnableAmount);
        subPanel.add(label2,BorderLayout.AFTER_LAST_LINE);
        return subPanel;
    }
}
