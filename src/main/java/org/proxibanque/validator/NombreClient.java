package org.proxibanque.validator;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


import org.proxibanque.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@ViewScoped
@FacesValidator("nombreClient")
public class NombreClient implements Validator {

	@Autowired
	private ClientService clientService; 
	
	
	public NombreClient() {
		super();
	}



	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		int nombreClient=10;
		try {
			nombreClient = clientService.findAll().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(nombreClient >= 10){

			FacesMessage msg =
				new FacesMessage("Quota de client atteint !!!! Vous ne pouvez pas avoir plus de 10 clients !!!!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}
}