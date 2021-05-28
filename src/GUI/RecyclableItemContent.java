package GUI;

import RCM.RecyclableItem;
import RCM.RecyclableItemCache;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RecyclableItemContent implements ActionListener {
    DefaultTableModel model = new DefaultTableModel();
    public JPanel displayItemsContent() {
        JPanel panel = new JPanel();

        String[] columns = {"ID","Item Type","Price"};
        List<RecyclableItem> itemList = RecyclableItemCache.getAllItems();

        JTable table = new JTable();

        table.setModel(model);

        model.setColumnIdentifiers(columns);
        for (RecyclableItem ri : itemList) {
            Object[] o = new Object[3];
            o[0] = ri.getItemId();
            o[1] = ri.getItemType();
            o[2] = ri.getAmount();
            model.addRow(o);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        panel.add(createButtons());
        return panel;
    }

    private JButton createButtons() {
        JButton button = new JButton("Add Recyclable Item" );
        button.addActionListener(this);
        return button;
    }

    public void addNewItem(Integer id, String itemType, float amount){
        RecyclableItem item = new RecyclableItem(itemType,id,amount);
        RecyclableItemCache.addNewItem(item);
        Object[] o = new Object[3];
        o[0] = id;
        o[1] = itemType;
        o[2] = amount;
        model.addRow(o);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField id = new JTextField();
        JTextField type = new JTextField();
        JTextField amount = new JTextField();
        final JComponent[] inputs = new JComponent[] {
                new JLabel("ID"),
                id,
                new JLabel("Item Type"),
                type,
                new JLabel("Amount"),
                amount
        };
        int result = JOptionPane.showConfirmDialog(null, inputs,
                "Add new Item", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("New Item entered :  " +
                    id.getText() + ", " +
                    type.getText() + ", " +
                    amount.getText());
        } else {
            System.out.println("Add new Item  : User canceled / closed the dialog, result = " + result);
        }
        validateValues(id.getText(),type.getText(),amount.getText());

    }

    private void validateValues(String id, String type, String amount) {
        boolean err=true;
            try{
                Integer.parseInt(id);
                Float.parseFloat(amount);
                err=false;
            }catch(NumberFormatException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage() +
                        "Unable to add item");
            }
        if(!err){
            addNewItem(Integer.parseInt(id),type , Float.parseFloat(amount));
            RcmGui rcmGui = new RcmGui();
            rcmGui.updateItemList();
        }
    }
}
