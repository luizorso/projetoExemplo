package br.com.drogaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {
	public static void adicionarMensagemSucesso(String mensagem) {
		FacesMessage msg = new FacesMessage(
				//Constante, mensagem resumida e a mensagem detalhada
				FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		//captura o contexto da aplicação
		FacesContext contexto = FacesContext.getCurrentInstance();
		//adiciona a mensagem ao contexto da aplicação
		contexto.addMessage(null, msg);
		
	}
	
	public static void adicionarMensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(
				FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
		
	}


}
