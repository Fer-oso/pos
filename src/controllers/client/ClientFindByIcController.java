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
import views.clients.ClientFindByIc;

public class ClientFindByIcController extends MouseAdapter implements ActionListener{

    private final ClientFindByIc clientFindByIc;
    private final ClientServiceImp clientServiceImp;

      private DefaultTableModel model = new DefaultTableModel();
    List<Client> listClients = new ArrayList<>();
    int row;
    Client client;

    public ClientFindByIcController(ClientFindByIc clientFindByIc, ClientServiceImp clientServiceImp) {
        this.clientFindByIc = clientFindByIc;
        this.clientServiceImp = clientServiceImp;
    }
    
      private List<Client> findByName() {
        String clientName = this.clientFindByIc.getTxtSearch().getText();
        List<Client> listClientByName = clientServiceImp.findByName(clientName);
        return listClientByName;
    }
    
    private List<Client> findAll() {
        return clientServiceImp.findAll();
    }
    
    private Client editClient() {
        return clientServiceImp.update(row, getDataOfForm());
    }
    
    private void deleteProduct() {
        clientServiceImp.delete(row);
    }
    
    private void listClients(List<Client> listClients) {
        this.listClients = listClients;
        model = (DefaultTableModel) this.clientFindByIc.getJtTableClients().getModel();
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
        this.clientFindByIc.getJtTableClients().setModel(model);
        
    }
    
    private Client getClientSelectedOfTable() {
        int row = this.clientFindByIc.getJtTableClients().getSelectedRow();
        client = listClients.get(row);
        return client;
        
    }
    
    private void setFormWithSelectedClient(Client client) {
        this.clientFindByIc.getLblId().setText(String.valueOf(client.getId()));
        this.clientFindByIc.getTxtName().setText(client.getName());
        this.clientFindByIc.getTxtLastName().setText(client.getLastName());
        this.clientFindByIc.getTxtAge().setText(String.valueOf(client.getAge()));
        checkAvailability();
        this.clientFindByIc.getTxtSsn().setText(String.valueOf(client.getSsn()));
        this.clientFindByIc.getTxtPhone().setText(client.getPhoneNumber());
    }
    
    private Client getDataOfForm() {
        
        client.setName(clientFindByIc.getTxtName().getText());
        client.setLastName(clientFindByIc.getTxtLastName().getText());
        client.setAge(Integer.valueOf(clientFindByIc.getTxtAge().getText()));
        client.setAvailability(clientFindByIc.getJcbAvailability().isSelected());
        client.setSsn(Integer.valueOf(clientFindByIc.getTxtSsn().getText()));
        client.setPhoneNumber(clientFindByIc.getTxtPhone().getText());
        //int id = Integer.parseInt(clientFindByIc.getLblId().getText());

        return client;
    }
    
    private void checkAvailability() {
        if (getClientSelectedOfTable().isAvailability()) {
            
            this.clientFindByIc.getJcbAvailability().setSelected(true);
        } else {
            this.clientFindByIc.getJcbAvailability().setSelected(false);
        }
    }
    
    private void clearForm() {
        this.clientFindByIc.getLblId().setText("");
        this.clientFindByIc.getTxtName().setText("");
        this.clientFindByIc.getTxtLastName().setText("");
        this.clientFindByIc.getTxtAge().setText("");
        checkAvailability();
        this.clientFindByIc.getTxtSsn().setText("");
        this.clientFindByIc.getTxtPhone().setText("");
    }
    
    private void actualizarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clientFindByIc.getBtnSearch()) {
            actualizarTabla(model);
            listClients(findByName());
            System.out.println(listClients);
        }
        
        if (e.getSource() == clientFindByIc.getBtnEdit()) {
            editClient();
            actualizarTabla(model);
            listClients(findAll());
            
            System.out.println(listClients);
            
        }
        
        if (e.getSource() == clientFindByIc.getBtnDelete()) {
            deleteProduct();
            actualizarTabla(model);
            listClients(findAll());
            
            System.out.println(listClients);
            
        }
        
        if (e.getSource() == clientFindByIc.getBtnCancel()) {
            clearForm();
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == clientFindByIc.getJtTableClients()) {
            getClientSelectedOfTable();
            setFormWithSelectedClient(client);
        }
    }

}
