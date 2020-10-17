package com.cg.wallet.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
/****************************************************************************************************
* @author      :  Parteek goel
* Description  :  It is a class that used to obtain date and time.
* Version      :  1.0
* Created Date :  7-OCT-2020
*******************************************************************************************************/

public class LDTTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime ldt) {
		if (ldt != null)
			return Timestamp.valueOf(ldt);
		return null;
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqltime) {
		if (sqltime != null)
			return sqltime.toLocalDateTime();
		return null;
	}

}
