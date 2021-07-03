package modules.CRM.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.domain.types.DateOnly;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.impl.domain.types.jaxb.DateOnlyMapper;

/**
 * Customer
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Customer extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "CRM";

	/** @hidden */
	public static final String DOCUMENT_NAME = "Customer";

	/** @hidden */
	public static final String usernamePropertyName = "username";

	/** @hidden */
	public static final String phonePropertyName = "phone";

	/** @hidden */
	public static final String birthdayPropertyName = "birthday";

	/** @hidden */
	public static final String addressPropertyName = "address";

	/**
	 * username
	 **/
	private String username;

	/**
	 * phone
	 **/
	private Integer phone;

	/**
	 * birthday
	 **/
	private DateOnly birthday;

	/**
	 * address
	 **/
	private String address;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Customer.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Customer.DOCUMENT_NAME;
	}

	public static Customer newInstance() {
		try {
			return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new DomainException(e);
		}
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage("Customer - {username}", this);
		}
		catch (@SuppressWarnings("unused") Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Customer) && 
					this.getBizId().equals(((Customer) o).getBizId()));
	}

	/**
	 * {@link #username} accessor.
	 * @return	The value.
	 **/
	public String getUsername() {
		return username;
	}

	/**
	 * {@link #username} mutator.
	 * @param username	The new value.
	 **/
	@XmlElement
	public void setUsername(String username) {
		preset(usernamePropertyName, username);
		this.username = username;
	}

	/**
	 * {@link #phone} accessor.
	 * @return	The value.
	 **/
	public Integer getPhone() {
		return phone;
	}

	/**
	 * {@link #phone} mutator.
	 * @param phone	The new value.
	 **/
	@XmlElement
	public void setPhone(Integer phone) {
		preset(phonePropertyName, phone);
		this.phone = phone;
	}

	/**
	 * {@link #birthday} accessor.
	 * @return	The value.
	 **/
	public DateOnly getBirthday() {
		return birthday;
	}

	/**
	 * {@link #birthday} mutator.
	 * @param birthday	The new value.
	 **/
	@XmlElement
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(DateOnlyMapper.class)
	public void setBirthday(DateOnly birthday) {
		preset(birthdayPropertyName, birthday);
		this.birthday = birthday;
	}

	/**
	 * {@link #address} accessor.
	 * @return	The value.
	 **/
	public String getAddress() {
		return address;
	}

	/**
	 * {@link #address} mutator.
	 * @param address	The new value.
	 **/
	@XmlElement
	public void setAddress(String address) {
		preset(addressPropertyName, address);
		this.address = address;
	}
}
