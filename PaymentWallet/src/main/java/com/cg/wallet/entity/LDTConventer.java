package com.cg.wallet.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
/****************************************************************************************************
* @author      :  Parteek goel
* Description  :  It is a class that convert localdate into java.sql.Date
* Version      :  1.0
* Created Date :  7-OCT-2020
*******************************************************************************************************/

public class LDTConventer implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate ldt) {
		if (ldt != null)
			return Date.valueOf(ldt); //convert LocalDate into java.sql.Date
		return null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqldt) {
		if (sqldt != null)
			return sqldt.toLocalDate();
		return null;
	}


}
