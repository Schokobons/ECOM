/**
 * 
 */
package com.bean;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.gestionnaire.data.ClientRepository;
import com.gestionnaire.entities.Client;

/**
 * @author MORJARET fixe
 *
 */

@SuppressWarnings("serial")
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable
{
    private String email;
    private String password;
    private Client clientConnect;
    
    private Boolean isConnected = false;
    
    @Inject
    private ClientRepository clientRepository;

    public String getEmail() {
		return email;
	}

	public Client getClientConnect() {
		return clientConnect;
	}

	public void setClientConnect(Client clientConnect) {
		this.clientConnect = clientConnect;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword ()
    {
        return password;
    }


    public void setPassword (final String password)
    {
        this.password = password;
    }


	public Boolean getIsConnected() {
		return isConnected;
	}


	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}
    
	public void login() {
		Client client = clientRepository.CheckClient(email, password);
		Boolean ok = false;
		if (client != null){
			 ok = true;
		}
		setIsConnected(ok);
		if ( ok){
			setClientConnect(client);
		}else {
			email = new String();
			password = new String();	
		}
	}
	
	public void logout() {
		setIsConnected(false);
		setClientConnect(null);
		email = new String();
		password = new String();	
	}
    
    
}