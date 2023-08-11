package controllers.clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Client;
import services.ClientServiceImp;
import views.clients.ClientFindBySsn;

public class ClientFindBySsnController extends MouseAdapter implements ActionListener {

    private final ClientFindBySsn clientFindBySsn;
    private final ClientServiceImp clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Client> listClients = new ArrayList<>();
    private int row;
    private int id;
    private Client client;

    public ClientFindBySsnController(ClientFindBySsn clientFindBySsn, ClientServiceImp clientServiceImp) {
        this.clientFindBySsn = clientFindBySsn;
        this.clientServiceImp = clientServiceImp;
        listClients(findAll());
        this.clientFindBySsn.getJtTableClients().addMouseListener(this);
        this.clientFindBySsn.getBtnSearch().addActionListener(this);
        this.clientFindBySsn.getBtnEdit().addActionListener(this);
        this.clientFindBySsn.getBtnDelete().addActionListener(this);
        this.clientFindBySsn.getBtnCancel().addActionListener(this);
    }

    private void listClients(List<Client> listClients) {
        this.listClients = listClients;
        model = (DefaultTableModel) this.clientFindBySsn.getJtTableClients().getModel();
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
        this.clientFindBySsn.getJtTableClients().setModel(model);

    }

    private List<Client> findAll() {
        return clientServiceImp.findAll();
    }

    private Client editClient() {
        setClientwithDataOfForm();
        return clientServiceImp.update(row, client);
    }

    private void deleteClient() {
        clientServiceImp.delete(id);
    }

    private List<Client> findBySsn() {
        int ssn = Integer.parseInt(this.clientFindBySsn.getTxtSearch().getText());
        List<Client> clientBySsn = clientServiceImp.findBySsn(ssn);
        return clientBySsn;
    }

    private void getClientSelectedOfTable() {
        row = this.clientFindBySsn.getJtTableClients().getSelectedRow();
        client = listClients.get(row);
        id = client.getId();
    }

    private void setClientwithDataOfForm() {
        client.setName(clientFindBySsn.getTxtName().getText());
        client.setLastName(clientFindBySsn.getTxtLastName().getText());
        client.setAge(Integer.valueOf(clientFindBySsn.getTxtAge().getText()));
        client.setAvailability(clientFindBySsn.getJcbAvailability().isSelected());
        client.setSsn(Integer.valueOf(clientFindBySsn.getTxtSsn().getText()));
        client.setPhoneNumber(clientFindBySsn.getTxtPhone().getText());
    }

    private void setFormWithSelectedClient(Client client) {
        this.clientFindBySsn.getLblId().setText(String.valueOf(client.getId()));
        this.clientFindBySsn.getTxtName().setText(client.getName());
        this.clientFindBySsn.getTxtLastName().setText(String.valueOf(client.getLastName()));
        this.clientFindBySsn.getTxtAge().setText(String.valueOf(client.getAge()));
        checkAvailability();
        this.clientFindBySsn.getTxtSsn().setText(String.valueOf(client.getSsn()));
        this.clientFindBySsn.getTxtPhone().setText(client.getPhoneNumber());
    }

    private void checkAvailability() {
        if (client.isAvailability()) {
            this.clientFindBySsn.getJcbAvailability().setSelected(true);
        } else {
            this.clientFindBySsn.getJcbAvailability().setSelected(false);
        }
    }

    private void actualizarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void clearForm() {
        this.clientFindBySsn.getLblId().setText("");
        this.clientFindBySsn.getTxtName().setText("");
        this.clientFindBySsn.getTxtLastName().setText("");
        this.clientFindBySsn.getTxtAge().setText("");
        this.clientFindBySsn.getJcbAvailability().setSelected(false);
        this.clientFindBySsn.getTxtSsn().setText("");
        this.clientFindBySsn.getTxtPhone().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clientFindBySsn.getBtnSearch()) {
            actualizarTabla(model);
            listClients(findBySsn());
            System.out.println(listClients);
        }

        if (e.getSource() == clientFindBySsn.getBtnEdit()) {
            editClient();
            actualizarTabla(model);
            listClients(findAll());

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindBySsn.getBtnDelete()) {
            deleteClient();
            actualizarTabla(model);
            listClients(findAll());

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindBySsn.getBtnCancel()) {
            clearForm();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == clientFindBySsn.getJtTableClients()) {
            getClientSelectedOfTable();
            setFormWithSelectedClient(client);
        }
    }

}
