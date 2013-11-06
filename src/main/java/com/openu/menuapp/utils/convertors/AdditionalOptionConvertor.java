/**
 * menuapp
 * 4 бреб 2013 22:26:29
 * AdditionalOptionConvertor.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.utils.convertors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openu.menuapp.entity.AdditionalOption;
import com.openu.menuapp.service.AdditionalOptionService;

@Service("additionalOptionConvertor")
public class AdditionalOptionConvertor extends BaseConvertor<AdditionalOption>
{
    @Autowired
    protected AdditionalOptionService service;
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        baseService = service;
        super.setAsText(text);
    }
    
}
