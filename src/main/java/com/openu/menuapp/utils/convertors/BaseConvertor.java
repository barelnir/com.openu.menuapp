/**
 * menuapp
 * 4 бреб 2013 22:31:31
 * BaseConvertor.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.utils.convertors;

import java.beans.PropertyEditorSupport;

import com.openu.menuapp.entity.BaseEntity;
import com.openu.menuapp.service.BaseEntityService;

public abstract class BaseConvertor<T extends BaseEntity> extends PropertyEditorSupport
{
	
	protected BaseEntityService baseService;
	
	@Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        T value =  baseService.findByUUID(text);
        setValue(value);
    }

    @SuppressWarnings("unchecked")
	@Override
    public String getAsText()
    {
    	T d = (T) getValue();
        return d != null ? String.valueOf(d.getUuid()) : "";
    }	
}