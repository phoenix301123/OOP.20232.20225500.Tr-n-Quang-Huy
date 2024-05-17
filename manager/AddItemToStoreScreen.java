package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel mainPanel;
    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;
    protected JMenuBar menuBar;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        menuBar = createMenuBar();
        setJMenuBar(menuBar);

        addComponents();
        add(mainPanel);
    }

    protected void addComponents() {
        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);
        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(20);
        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField(20);

        mainPanel.add(titleLabel);
        mainPanel.add(titleField);
        mainPanel.add(categoryLabel);
        mainPanel.add(categoryField);
        mainPanel.add(costLabel);
        mainPanel.add(costField);
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store);
                dispose();
            }
        });
        menu.add(viewStoreItem);
        
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen(store);
                dispose();
            }
        });
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen(store);
                dispose();
            }
        });
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen(store);
                dispose();
            }
        });
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        return menuBar;
    }

    protected abstract void addSpecificFields();
    protected abstract void addItem();
}

