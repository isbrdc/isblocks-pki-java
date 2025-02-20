/*************************************************************************
 *                                                                       *
 *  EJBCA Community: The OpenSource Certificate Authority                *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/

package org.ejbca.core.model.ra;

import org.ejbca.core.EjbcaException;

import com.keyfactor.ErrorCode;

/**
 * Exception is cast when values of an end entity field does not match a specific rule in the function FieldValidator.validate()
 *  
 * @version $Id$ 
 */
public class CustomFieldException extends EjbcaException {

	private static final long serialVersionUID = -4270699717178908309L;

	public CustomFieldException(){
		super(ErrorCode.FIELD_VALUE_NOT_VALID);
	}
	
	public CustomFieldException(String message){
		super(ErrorCode.FIELD_VALUE_NOT_VALID, message);
	}
	
	public CustomFieldException(Exception cause){
		super(ErrorCode.FIELD_VALUE_NOT_VALID, cause);
	}
	
	public CustomFieldException(String message, Throwable cause){
		super(ErrorCode.FIELD_VALUE_NOT_VALID, message, cause);
	}
}
