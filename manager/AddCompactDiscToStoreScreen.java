package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame {
    private Store store;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField artistField;

    public AddCompactDiscToStoreScreen(Store store) {
        this.store = store;
        
        setTitle("Add CD");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        mainPanel.add(createInputPanel());
        
        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCD();
            }
        });
        mainPanel.add(addButton);

        setContentPane(mainPanel);
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store).setVisible(true);
                dispose();
            }
        });
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen(store).setVisible(true);
                dispose();
            }
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Already on the Add CD screen, do nothing
            }
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen(store).setVisible(true);
                dispose();
            }
        });
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);
        inputPanel.add(titleLabel);
        inputPanel.add(titleField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(20);
        inputPanel.add(categoryLabel);
        inputPanel.add(categoryField);

        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField(20);
        inputPanel.add(costLabel);
        inputPanel.add(costField);

        JLabel artistLabel = new JLabel("Artist:");
        artistField = new JTextField(20);
        inputPanel.add(artistLabel);
        inputPanel.add(artistField);

        return inputPanel;
    }

    private void addCD() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String artist = artistField.getText();
        float cost = Float.parseFloat(costField.getText());

        CompactDisc cd = new CompactDisc(title, category, artist, cost);
        store.addMedia(cd);

        JOptionPane.showMessageDialog(this, "CD added to store!");

        titleField.setText("");
        categoryField.setText("");
        artistField.setText("");
        costField.setText("");
    }
}


