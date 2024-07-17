import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerShowSwing extends JFrame {

    private JLabel idLabel, lastNameLabel, firstNameLabel, phoneLabel;
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton previousButton, nextButton;

    private int currentCustomerIndex = 0;

    private String[] ids = {"1", "2", "3"};
    private String[] lastNames = {"Chenda", "kom", "Chan"};
    private String[] firstNames = {"Sovisal", "Lina", "Seyha"};
    private String[] phoneNumbers = {"092888999", "092000999", "09277776666"};

    public CustomerShowSwing() {
        super("Customer Show");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        // Labels
        idLabel = new JLabel("ID:");
        lastNameLabel = new JLabel("Last Name:");
        firstNameLabel = new JLabel("First Name:");
        phoneLabel = new JLabel("Phone:");

        // Text Fields
        idField = new JTextField(ids[currentCustomerIndex]);
        idField.setEditable(false);
        lastNameField = new JTextField(lastNames[currentCustomerIndex]);
        lastNameField.setEditable(false);
        firstNameField = new JTextField(firstNames[currentCustomerIndex]);
        firstNameField.setEditable(false);
        phoneField = new JTextField(phoneNumbers[currentCustomerIndex]);
        phoneField.setEditable(false);

        // Buttons
        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousCustomer();
            }
        });

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextCustomer();
            }
        });

        // Add components to the frame
        add(idLabel);
        add(idField);
        add(lastNameLabel);
        add(lastNameField);
        add(firstNameLabel);
        add(firstNameField);
        add(phoneLabel);
        add(phoneField);
        add(previousButton);
        add(nextButton);

        setVisible(true);
    }

    private void previousCustomer() {
        currentCustomerIndex--;
        if (currentCustomerIndex < 0) {
            currentCustomerIndex = ids.length - 1;
        }
        updateCustomerData();
    }

    private void nextCustomer() {
        currentCustomerIndex++;
        if (currentCustomerIndex >= ids.length) {
            currentCustomerIndex = 0;
        }
        updateCustomerData();
    }

    private void updateCustomerData() {
        idField.setText(ids[currentCustomerIndex]);
        lastNameField.setText(lastNames[currentCustomerIndex]);
        firstNameField.setText(firstNames[currentCustomerIndex]);
        phoneField.setText(phoneNumbers[currentCustomerIndex]);
    }

    public static void main(String[] args) {
        new CustomerShowSwing();
    }
}
