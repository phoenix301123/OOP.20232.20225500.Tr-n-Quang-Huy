package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends JFrame {
    private Store store;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;

    public AddBookToStoreScreen(Store store) {
        this.store = store;
        
        setTitle("Add Book");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        mainPanel.add(createInputPanel());
        
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
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
                // Already on the Add Book screen, do nothing
            }
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen(store).setVisible(true);
                dispose();
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
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
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

        return inputPanel;
    }

    private void addBook() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        Book book = new Book(title, category, cost);
        store.addMedia(book);

        JOptionPane.showMessageDialog(this, "Book added to store!");

        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
    }
}



