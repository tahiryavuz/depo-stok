package com.stok.converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


import com.stok.entity.Unit;

@ManagedBean(name = "categoryConverterBean") 
@FacesConverter(value = "categoryConverter")
public class CityConverter implements Converter {

	 public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && value.trim().length() > 0) {
	            try {
	            	
	            	
	            //	burda elinde value var, burdan sorgu atýp objeyi alacaksýn
	            //	select u from city where name ='value' gibi
	             //   ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
	             //   return service.getThemes().get(Integer.parseInt(value));
	            	Unit aa = new Unit();
	            	aa.setId(1l);
	            	return aa;
	            	
	            	
	            
	            } catch(NumberFormatException e) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
	            }
	        }
	        else {
	            return null;
	        }
	    }
	 
	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	        if(object != null) {
	            return String.valueOf(((Unit) object).getId());
	          
	        }
	        else {
	            return null;
	        }
	    }  
	    

}
