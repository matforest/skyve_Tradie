package modules.tradie.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.impl.domain.ChangeTrackingArrayList;

/**
 * Provider
 * 
 * @navhas n servicesProvided 1..n ServiceType
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Provider extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "tradie";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Provider";

	/** @hidden */
	public static final String namePropertyName = "name";
	/** @hidden */
	public static final String companyPropertyName = "company";
	/** @hidden */
	public static final String addressPropertyName = "address";
	/** @hidden */
	public static final String phonePropertyName = "phone";
	/** @hidden */
	public static final String servicesProvidedPropertyName = "servicesProvided";

	/**
	 * Name
	 **/
	private String name;
	/**
	 * Company
	 **/
	private String company;
	/**
	 * Address
	 **/
	private String address;
	/**
	 * phone
	 **/
	private String phone;
	/**
	 * Services Provided
	 **/
	private List<ServiceType> servicesProvided = new ChangeTrackingArrayList<>("servicesProvided", this);

	@Override
	@XmlTransient
	public String getBizModule() {
		return Provider.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Provider.DOCUMENT_NAME;
	}

	public static Provider newInstance() {
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
			return org.skyve.util.Binder.formatMessage("Provider - {name}", this);
		}
		catch (@SuppressWarnings("unused") Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Provider) && 
					this.getBizId().equals(((Provider) o).getBizId()));
	}

	/**
	 * {@link #name} accessor.
	 * @return	The value.
	 **/
	public String getName() {
		return name;
	}

	/**
	 * {@link #name} mutator.
	 * @param name	The new value.
	 **/
	@XmlElement
	public void setName(String name) {
		preset(namePropertyName, name);
		this.name = name;
	}

	/**
	 * {@link #company} accessor.
	 * @return	The value.
	 **/
	public String getCompany() {
		return company;
	}

	/**
	 * {@link #company} mutator.
	 * @param company	The new value.
	 **/
	@XmlElement
	public void setCompany(String company) {
		preset(companyPropertyName, company);
		this.company = company;
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

	/**
	 * {@link #phone} accessor.
	 * @return	The value.
	 **/
	public String getPhone() {
		return phone;
	}

	/**
	 * {@link #phone} mutator.
	 * @param phone	The new value.
	 **/
	@XmlElement
	public void setPhone(String phone) {
		preset(phonePropertyName, phone);
		this.phone = phone;
	}

	/**
	 * {@link #servicesProvided} accessor.
	 * @return	The value.
	 **/
	@XmlElement
	public List<ServiceType> getServicesProvided() {
		return servicesProvided;
	}

	/**
	 * {@link #servicesProvided} accessor.
	 * @param bizId	The bizId of the element in the list.
	 * @return	The value of the element in the list.
	 **/
	public ServiceType getServicesProvidedElementById(String bizId) {
		return getElementById(servicesProvided, bizId);
	}

	/**
	 * {@link #servicesProvided} mutator.
	 * @param bizId	The bizId of the element in the list.
	 * @param element	The new value of the element in the list.
	 **/
	public void setServicesProvidedElementById(String bizId, ServiceType element) {
		setElementById(servicesProvided, element);
	}

	/**
	 * {@link #servicesProvided} add.
	 * @param element	The element to add.
	 **/
	public boolean addServicesProvidedElement(ServiceType element) {
		return servicesProvided.add(element);
	}

	/**
	 * {@link #servicesProvided} add.
	 * @param index	The index in the list to add the element to.
	 * @param element	The element to add.
	 **/
	public void addServicesProvidedElement(int index, ServiceType element) {
		servicesProvided.add(index, element);
	}

	/**
	 * {@link #servicesProvided} remove.
	 * @param element	The element to remove.
	 **/
	public boolean removeServicesProvidedElement(ServiceType element) {
		return servicesProvided.remove(element);
	}

	/**
	 * {@link #servicesProvided} remove.
	 * @param index	The index in the list to remove the element from.
	 **/
	public ServiceType removeServicesProvidedElement(int index) {
		return servicesProvided.remove(index);
	}
}
