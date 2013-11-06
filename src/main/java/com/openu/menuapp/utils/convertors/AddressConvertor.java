/**
 * menuapp
 * 4 бреб 2013 22:26:29
 * AdditionalOptionConvertor.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.utils.convertors;

import org.springframework.stereotype.Service;

import com.openu.menuapp.entity.Address;

@Service("addressConvertor")
public class AddressConvertor extends BaseConvertor<Address>
{
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
    	Address address = new Address("","Tel AvivConverter","Low",88,1,"Google",8,"2",323232);
    	setValue(address);
    }
    
}
