package com.amdudda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * Created by amdudda on 11/9/2015.
 */
public class NewTicket extends JFrame {
    private JTextField addNewTicketTextField;
    private JTextField priorityTextField;
    private JTextField reportedByTextField;
    private JTextArea descriptionTextArea1;
    private JButton addTicketToSystemButton;
    private JPanel rootPanel;

    public NewTicket() {
        super("Enter New Ticket");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        addTicketToSystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // gather our values to pass into ticketQueue
                String descript = descriptionTextArea1.getText();
                String priText = priorityTextField.getText();
                String rept = reportedByTextField.getText();
                int priInt = Integer.parseInt(priText);
                Ticket toAdd = new Ticket(descript, priInt, rept, LocalDateTime.now());
                // add info as a new ticket in ticketQueue
                TicketManager.ticketQueue.add(toAdd);
                // for now, all this does is close the window
                dispose();
            }
        });
    }
}
