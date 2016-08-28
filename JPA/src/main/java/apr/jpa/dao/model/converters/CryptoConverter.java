package apr.jpa.dao.model.converters;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.codec.binary.Base64;

@Converter
public class CryptoConverter implements AttributeConverter<String, String> {

	private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
	private static final byte[] KEY = "MySuperSecretKey".getBytes();

	/**
	 * Este método es llamado por hibernate antes de persistir la entidad en la
	 * BD. Obtiene la cadena sin cifrar de la entidad y utiliza el algoritmo AES
	 * con PKCS5Padding para encriptarla. A continuación, se codifica en base64
	 * para convertir el resultado del cifrado a la cadena que se persistirá en
	 * BD.
	 */
	@Override
	public String convertToDatabaseColumn(String ccNumber) {
		// do some encryption
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.ENCRYPT_MODE, key);
			return Base64.encodeBase64String(c.doFinal(ccNumber.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Cuando el proveedor de persitencia lee la entidad de la BD, este método
	 * es invocado. Realiza el proceso inverso al método anterior.
	 */

	@Override
	public String convertToEntityAttribute(String dbData) {
		// do some decryption
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			return new String(c.doFinal(Base64.decodeBase64(dbData)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
