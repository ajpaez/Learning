package apr.jpa.dao.model.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Boolean aBoolean) {
		if (Boolean.TRUE.equals(aBoolean)) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public Boolean convertToEntityAttribute(Integer value) {
		if (value == null) {
			return Boolean.FALSE;
		} else {
			if (value == 1) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		}
	}
}
