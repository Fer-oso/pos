package controllers.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Client;
import services.ClientServiceImp;
import views.clients.ClientRegisterForm;

public class ClientRegisterFormController  extends MouseAdapter implements ActionListener{

   private final ClientRegisterForm clientRegisterForm;
   private final ClientServiceImp clientServiceImp;
   
   
    private DefaultTableModel model = new DefaultTableModel();
    List<Client> listClients = new ArrayList<>();
    Client client;

    public ClientRegisterFormController(ClientRegisterForm clientRegisterForm, ClientServiceImp clientServiceImp) {
        this.clientRegisterForm = clientRegisterForm;
        this.clientServiceImp = clientServiceImp;
         listClients(findAll());
        this.clientRegisterForm.getJtTableClients().addMouseListener(this);
        this.clientRegisterForm.getBtnSave().addActionListener(this);
        this.clientRegisterForm.getBtnCancel().addActionListener(this);
    }

      private Client save() {
        return clientServiceImp.save(getDataOfForm());
    }

    private List<Client> findAll() {
        return clientServiceImp.findAll();
    }

    private void listClients(List<Client> listClients) {
        this.listClients = listClients;
        model = (DefaultTableModel) this.clientRegisterForm.getJtTableClients().getModel();
        Object[] client = new Object[7];

        for (int i = 0; i < listClients.size(); i++) {
            client[0] = listClients.get(i).getId();
            client[1] = listClients.get(i).getName();
            client[2] = listClients.get(i).getLastName();
            client[3] = listClients.get(i).getAge();
            client[4] = listClients.get(i).isAvailability();
            client[5] = listClients.get(i).getSsn();
            client[6] = listClients.get(i).getPhoneNumber();

            model.addRow(client);
        }
        this.clientRegisterForm.getJtTableClients().setModel(model);

    }

    private Client getClientSelectedOfTable() {
        int row = this.clientRegisterForm.getJtTableClients().getSelectedRow();
        client = listClients.get(row);
        return client;

    }

    private void setFormWithSelectedClient(Client client) {
        this.clientRegisterForm.getLblId().setText(String.valueOf(client.getId()));
        this.clientRegisterForm.getTxtName().setText(client.getName());
        this.clientRegisterForm.getTxtLastname().setText(String.valueOf(client.getLastName()));
        this.clientRegisterForm.getTxtAge().setText(String.valueOf(client.getAge()));
        checkAvailability();
        this.clientRegisterForm.getTxtSsn().setText(String.valueOf(client.getSsn()));
        this.clientRegisterForm.getTxtPhone().setText(client.getPhoneNumber());
    }

    private Client getDataOfForm(){

        String name = clientRegisterForm.getTxtName().getText();
        String lastName = clientRegisterForm.getTxtLastname().getText();
        Integer age = Integer.valueOf(clientRegisterForm.getTxtAge().getText());
        boolean availability = clientRegisterForm.getJcbAvailability().isSelected();
        Integer ssn =Integer.valueOf(clientRegisterForm.getTxtSsn().getText());
        String phoneNumber = clientRegisterForm.getTxtPhone().getText();
        //int id = Integer.parseInt(clientRegisterForm.getLblId().getText());

        return  new Client(name, lastName, age, ssn, availability, phoneNumber);
    }

    private void checkAvailability() {
        if (getClientSelectedOfTable().isAvailability()) {

            this.clientRegisterForm.getJcbAvailability().setSelected(true);
        } else {
            this.clientRegisterForm.getJcbAvailability().setSelected(false);
        }
    }

    private void clearForm() {
        this.clientRegisterForm.getLblId().setText("");
        this.clientRegisterForm.getTxtName().setText("");
        this.clientRegisterForm.getTxtLastname().setText("");
        this.clientRegisterForm.getTxtAge().setText("");
        checkAvailability();
        this.clientRegisterForm.getTxtSsn().setText("");
        this.clientRegisterForm.getTxtPhone().setText("");
    }

    private void actualizarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientRegisterForm.getBtnSave()) {
            save();
            actualizarTabla(model);
            listClients(findAll());
            System.out.println(listClients);
        }

        if (e.getSource() == clientRegisterForm.getBtnCancel()) {
            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == clientRegisterForm.getJtTableClients()) {
            getClientSelectedOfTable();
            setFormWithSelectedClient(client);
        }
    }
    

            
}