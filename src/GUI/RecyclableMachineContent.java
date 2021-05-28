package GUI;

import RCM.RecyclableMachineCache;
import RCM.RecycleMachine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class RecyclableMachineContent implements ActionListener {
    DefaultTableModel model = new DefaultTableModel();
    public JPanel displayMachineContent() {
        JPanel panel = new JPanel();

        String[] columns = {"ID","Location","Current Weight","Amount","Last Emptied","Status"};
        List<RecycleMachine> itemList = RecyclableMachineCache.getAllItems();

        JTable table = new JTable();

        table.setModel(model);

        model.setColumnIdentifiers(columns);
        for (RecycleMachine rcm : itemList) {
            String[] options = {"true","false"};
            JComboBox comboBox = new JComboBox(options);
            Object[] o = new Object[7];
            o[0] = rcm.getMachineId();
            o[1] = rcm.getLocation();
            o[2] = rcm.getWeightAdded();
            o[3] = rcm.getMoneyAvailable();
            o[4] = rcm.getTimeEmptied();
            o[5] = rcm.isOperational() ? "Available" : "Down";
            model.addRow(o);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        panel.add(createButtons());
        return panel;
    }

    private JButton createButtons() {
        JButton button = new JButton("Add Machine" );
        button.addActionListener(this);
        return button;
    }

    public boolean addNewItem(int id, String location, float weight,String operational,float money){
        boolean isOperational = (operational.equals("true"))? true : false;
        RecycleMachine rcm = new RecycleMachine(id,location,weight,isOperational,money);
        rcm.setTimeEmptied(new Date());
        RecyclableMachineCache.addNewItem(rcm);
        Object[] o = new Object[6];
        o[0] = rcm.getMachineId();
        o[1] = rcm.getLocation();
        o[2] = rcm.getAllowedWeight();
        o[3] = rcm.getMoneyAvailable();
        o[4] = rcm.getTimeEmptied();
        o[5] = rcm.isOperational() ? "Available" : "Down";
        model.addRow(o);

        RcmGui rcmUI = new RcmGui();
        rcmUI.createFrame(rcm);
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField id = new JTextField();
        JTextField location = new JTextField();
        JTextField amount = new JTextField();
        JTextField weight = new JTextField();
        String[] options = {"true","false"};
        JComboBox comboBox = new JComboBox(options);
        final JComponent[] inputs = new JComponent[] {
                new JLabel("ID"),
                id,
                new JLabel("Location"),
                location,
                new JLabel("Money Added"),
                amount,
                new JLabel("Allowed Weight"),
                weight,
                new JLabel("Operational"),
                comboBox
        };
        int result = JOptionPane.showConfirmDialog(null, inputs,
                "Adding New Machine", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("New Item entered :  " +
                    id.getText() + ", " +
                    location.getText() + ", " +
                    comboBox.getSelectedItem());
        } else {
            System.out.println("Add new Item  : User canceled / closed the dialog, result = " + result);
        }
        validateValues(id.getText(),location.getText(),weight.getText(),comboBox.getSelectedItem().toString(),amount.getText());
    }

    private void validateValues(String id, String location, String weight,String operational,String amount) {
        boolean err=true;
        try{
            Integer.parseInt(id);
            Float.parseFloat(weight);
            Float.parseFloat(amount);
            err=false;
        }catch(NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage() +
                    "Unable to add item");
        }
        if(!err){
            addNewItem(Integer.parseInt(id),
                    location,
                    Float.parseFloat(weight),
                    operational ,
                    Float.parseFloat(amount));
        }

    }
}
