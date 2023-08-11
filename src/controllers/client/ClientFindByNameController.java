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
import views.clients.ClientFindByName;

public class ClientFindByNameController extends MouseAdapter implements ActionListener {

     private final ClientServiceImp clientServiceImp;
    private final ClientFindByName clientFindByName;

    private DefaultTableModel model = new DefaultTableModel();
    List<Client> listClients = new ArrayList<>();
    int row;
    Client client;

    public ClientFindByNameController(ClientFindByName clientFindByName, ClientServiceImp clientServiceImp) {
        this.clientFindByName = clientFindByName;
        this.clientServiceImp = clientServiceImp;
        listClients(findAll());
        this.clientFindByName.getJtTableClients().addMouseListener(this);
        this.clientFindByName.getBtnSearch().addActionListener(this);
        this.clientFindByName.getBtnEdit().addActionListener(this);
        this.clientFindByName.getBtnDelete().addActionListener(this);
        this.clientFindByName.getBtnCancel().addActionListener(this);

    }

    private List<Client> findByName() {
        String clientName = this.clientFindByName.getTxtSearch().getText();
        List<Client> listClientByName = clientServiceImp.findByName(clientName);
        return listClientByName;
    }

    private List<Client> findAll() {
        return clientServiceImp.findAll();
    }

    private Client editClient() {
        return clientServiceImp.update(row, getDataOfForm());
    }

    private void deleteClient() {
        clientServiceImp.delete(row);
    }

    private void listClients(List<Client> listClients) {
        this.listClients = listClients;
        model = (DefaultTableModel) this.clientFindByName.getJtTableClients().getModel();
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
        this.clientFindByName.getJtTableClients().setModel(model);

    }

    private Client getClientSelectedOfTable() {
        row = this.clientFindByName.getJtTableClients().getSelectedRow();
        client = listClients.get(row);
        return client;

    }

    private Client getDataOfForm() {
        client.setName(clientFindByName.getTxtName().getText());
        client.setLastName(clientFindByName.getTxtLastName().getText());
        client.setAge(Integer.valueOf(clientFindByName.getTxtAge().getText()));
        client.setAvailability(clientFindByName.getJcbAvailability().isSelected());
        client.setSsn(Integer.valueOf(clientFindByName.getTxtSsn().getText()));
        client.setPhoneNumber(clientFindByName.getTxtPhone().getText());
        // int id = Integer.parseInt(clientFindByName.getLblId().getText());
        return client;
    }

    private void setFormWithSelectedClient(Client client) {
        this.clientFindByName.getLblId().setText(String.valueOf(client.getId()));
        this.clientFindByName.getTxtName().setText(client.getName());
        this.clientFindByName.getTxtLastName().setText(String.valueOf(client.getLastName()));
        this.clientFindByName.getTxtAge().setText(String.valueOf(client.getAge()));
        checkAvailability();
        this.clientFindByName.getTxtSsn().setText(String.valueOf(client.getSsn()));
        this.clientFindByName.getTxtPhone().setText(client.getPhoneNumber());
    }

    private void checkAvailability() {
        if (getClientSelectedOfTable().isAvailability()) {

            this.clientFindByName.getJcbAvailability().setSelected(true);
        } else {
            this.clientFindByName.getJcbAvailability().setSelected(false);
        }
    }

    private void actualizarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void clearForm() {
        this.clientFindByName.getLblId().setText("");
        this.clientFindByName.getTxtName().setText("");
        this.clientFindByName.getTxtLastName().setText("");
        this.clientFindByName.getTxtAge().setText("");
        this.clientFindByName.getJcbAvailability().setSelected(false);
        this.clientFindByName.getTxtSsn().setText("");
        this.clientFindByName.getTxtPhone().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clientFindByName.getBtnSearch()) {
            actualizarTabla(model);
            listClients(findByName());
            System.out.println(listClients);
        }

        if (e.getSource() == clientFindByName.getBtnEdit()) {
            editClient();
            actualizarTabla(model);
            listClients(findAll());

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindByName.getBtnDelete()) {
            deleteClient();
            actualizarTabla(model);
            listClients(findAll());

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindByName.getBtnCancel()) {
            clearForm();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == clientFindByName.getJtTableClients()) {
            getClientSelectedOfTable();
            setFormWithSelectedClient(client);
        }

//         if (true) {
//            actualizarTabla(model);
//            listClients(findAll());
//            System.out.println(listClients);
//        }
    }
}
