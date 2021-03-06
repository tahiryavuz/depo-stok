package com.stok.converter;



import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;



import com.stok.bean.StockBean;
import com.stok.entity.Stock;


@FacesConverter("themeConverter")
public class ThemeConverter implements Converter {
	
	 public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && value.trim().length() > 0) {
	            try {
	                StockBean service = (StockBean) fc.getExternalContext().getApplicationMap().get("stockService");
	                return service.getStock();
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
	            return String.valueOf(((Stock) object).getId());
	        }
	        else {
	            return null;
	        }
	    }   

}
