package controllers.clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Client;
import services.ClientServiceImp;
import views.clients.ClientFindByName;

public class ClientFindByNameController extends MouseAdapter implements ActionListener {

    private final ClientServiceImp clientServiceImp;
    private final ClientFindByName clientFindByName;

    private DefaultTableModel model = new DefaultTableModel();

    private List<Client> listClients;

    private int row;

    private int id;

    private Client client;

    public ClientFindByNameController(ClientFindByName clientFindByName, ClientServiceImp clientServiceImp) {

        this.clientFindByName = clientFindByName;

        this.clientServiceImp = clientServiceImp;

        this.listClients = clientServiceImp.findAll();
        
        listClients();
        
        addActions();

    }

    /*Actions*/
    private void addActions() {

        clientFindByName.getJtTableClients().addMouseListener(this);

        clientFindByName.getBtnSearch().addActionListener(this);

        clientFindByName.getBtnEdit().addActionListener(this);

        clientFindByName.getBtnDelete().addActionListener(this);

        clientFindByName.getBtnCancel().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientFindByName.getBtnSearch()) {
            
            actualizarTabla(model);
            
            listClients = findByName();

            listClients();

            System.out.println(listClients);
        }

        if (e.getSource() == clientFindByName.getBtnEdit()) {

            editClient();

            actualizarTabla(model);

            listClients();

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindByName.getBtnDelete()) {

            deleteClient();

            actualizarTabla(model);

            listClients();

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

    }

    /*Functions*/
    private void listClients() {

        model = (DefaultTableModel) clientFindByName.getJtTableClients().getModel();

        for (Client cl : listClients) {

            Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                cl.isAvailability(), cl.getSsn(), cl.getPhoneNumber()};

            model.addRow(clientObject);
        }

        this.clientFindByName.getJtTableClients().setModel(model);

    }
    
    private List<Client> findByName() {

        String clientName = clientFindByName.getTxtSearch().getText();

        return clientServiceImp.findByName(clientName);
    }

    private Client editClient() {

        setClientwithDataOfForm();

        return clientServiceImp.update(row, client);
    }

    private void deleteClient() {

        clientServiceImp.delete(id);
    }

    private void getClientSelectedOfTable() {

        row = clientFindByName.getJtTableClients().getSelectedRow();

        client = listClients.get(row);

        id = client.getId();
    }

    private void setClientwithDataOfForm() {

        client.setName(clientFindByName.getTxtName().getText());
        
        client.setLastName(clientFindByName.getTxtLastName().getText());
        
        client.setAge(Integer.valueOf(clientFindByName.getTxtAge().getText()));
        
        client.setAvailability(clientFindByName.getJcbAvailability().isSelected());
        
        client.setSsn(Integer.valueOf(clientFindByName.getTxtSsn().getText()));
        
        client.setPhoneNumber(clientFindByName.getTxtPhone().getText());

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

        if (client.isAvailability()) {

            clientFindByName.getJcbAvailability().setSelected(true);

        } else {

            clientFindByName.getJcbAvailability().setSelected(false);

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

}
