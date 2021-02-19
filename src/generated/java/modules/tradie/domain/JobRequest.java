package modules.tradie.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.domain.types.Enumeration;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.metadata.model.document.Bizlet.DomainValue;

/**
 * Job Request
 * 
 * @depend - - - Urgency
 * @depend - - - State
 * @navhas n requestType 1 ServiceType
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class JobRequest extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "tradie";
	/** @hidden */
	public static final String DOCUMENT_NAME = "JobRequest";

	/** @hidden */
	public static final String customerNamePropertyName = "customerName";
	/** @hidden */
	public static final String phonePropertyName = "phone";
	/** @hidden */
	public static final String addressPropertyName = "address";
	/** @hidden */
	public static final String directionsPropertyName = "directions";
	/** @hidden */
	public static final String descriptionPropertyName = "description";
	/** @hidden */
	public static final String requestTypePropertyName = "requestType";
	/** @hidden */
	public static final String urgencyPropertyName = "urgency";
	/** @hidden */
	public static final String statePropertyName = "state";

	/**
	 * Urgency
	 * <br/>
	 * How soon does this request need to be fullfilled?
	 **/
	@XmlEnum
	public static enum Urgency implements Enumeration {
		immediateCallOut("Immediate call out", "Immediate call out"),
		nextDay("Next day", "Next day"),
		notUrgent("Not urgent", "Not urgent");

		private String code;
		private String description;

		/** @hidden */
		private DomainValue domainValue;

		/** @hidden */
		private static List<DomainValue> domainValues;

		private Urgency(String code, String description) {
			this.code = code;
			this.description = description;
			this.domainValue = new DomainValue(code, description);
		}

		@Override
		public String toCode() {
			return code;
		}

		@Override
		public String toDescription() {
			return description;
		}

		@Override
		public DomainValue toDomainValue() {
			return domainValue;
		}

		public static Urgency fromCode(String code) {
			Urgency result = null;

			for (Urgency value : values()) {
				if (value.code.equals(code)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static Urgency fromDescription(String description) {
			Urgency result = null;

			for (Urgency value : values()) {
				if (value.description.equals(description)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static List<DomainValue> toDomainValues() {
			if (domainValues == null) {
				Urgency[] values = values();
				domainValues = new ArrayList<>(values.length);
				for (Urgency value : values) {
					domainValues.add(value.domainValue);
				}
			}

			return domainValues;
		}
	}

	/**
	 * State
	 * <br/>
	 * Current state of this job request
	 **/
	@XmlEnum
	public static enum State implements Enumeration {
		submitted("Submitted", "Submitted"),
		booked("Booked", "Booked"),
		confirmed("Confirmed", "Confirmed"),
		resolved("Resolved", "Resolved"),
		invoiced("Invoiced", "Invoiced"),
		paid("Paid", "Paid"),
		cancelled("Cancelled", "Cancelled");

		private String code;
		private String description;

		/** @hidden */
		private DomainValue domainValue;

		/** @hidden */
		private static List<DomainValue> domainValues;

		private State(String code, String description) {
			this.code = code;
			this.description = description;
			this.domainValue = new DomainValue(code, description);
		}

		@Override
		public String toCode() {
			return code;
		}

		@Override
		public String toDescription() {
			return description;
		}

		@Override
		public DomainValue toDomainValue() {
			return domainValue;
		}

		public static State fromCode(String code) {
			State result = null;

			for (State value : values()) {
				if (value.code.equals(code)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static State fromDescription(String description) {
			State result = null;

			for (State value : values()) {
				if (value.description.equals(description)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static List<DomainValue> toDomainValues() {
			if (domainValues == null) {
				State[] values = values();
				domainValues = new ArrayList<>(values.length);
				for (State value : values) {
					domainValues.add(value.domainValue);
				}
			}

			return domainValues;
		}
	}

	/**
	 * Customer Name
	 **/
	private String customerName;
	/**
	 * Phone
	 **/
	private String phone;
	/**
	 * Address
	 **/
	private String address;
	/**
	 * Directions
	 **/
	private String directions;
	/**
	 * Description
	 **/
	private String description;
	/**
	 * Request Type
	 * <br/>
	 * The type of the service request
	 **/
	private ServiceType requestType = null;
	/**
	 * Urgency
	 * <br/>
	 * How soon does this request need to be fullfilled?
	 **/
	private Urgency urgency;
	/**
	 * State
	 * <br/>
	 * Current state of this job request
	 **/
	private State state = State.submitted;

	@Override
	@XmlTransient
	public String getBizModule() {
		return JobRequest.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return JobRequest.DOCUMENT_NAME;
	}

	public static JobRequest newInstance() {
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
			return org.skyve.util.Binder.formatMessage("Job Request - {customerName}", this);
		}
		catch (@SuppressWarnings("unused") Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof JobRequest) && 
					this.getBizId().equals(((JobRequest) o).getBizId()));
	}

	/**
	 * {@link #customerName} accessor.
	 * @return	The value.
	 **/
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * {@link #customerName} mutator.
	 * @param customerName	The new value.
	 **/
	@XmlElement
	public void setCustomerName(String customerName) {
		preset(customerNamePropertyName, customerName);
		this.customerName = customerName;
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
	 * {@link #directions} accessor.
	 * @return	The value.
	 **/
	public String getDirections() {
		return directions;
	}

	/**
	 * {@link #directions} mutator.
	 * @param directions	The new value.
	 **/
	@XmlElement
	public void setDirections(String directions) {
		preset(directionsPropertyName, directions);
		this.directions = directions;
	}

	/**
	 * {@link #description} accessor.
	 * @return	The value.
	 **/
	public String getDescription() {
		return description;
	}

	/**
	 * {@link #description} mutator.
	 * @param description	The new value.
	 **/
	@XmlElement
	public void setDescription(String description) {
		preset(descriptionPropertyName, description);
		this.description = description;
	}

	/**
	 * {@link #requestType} accessor.
	 * @return	The value.
	 **/
	public ServiceType getRequestType() {
		return requestType;
	}

	/**
	 * {@link #requestType} mutator.
	 * @param requestType	The new value.
	 **/
	@XmlElement
	public void setRequestType(ServiceType requestType) {
		if (this.requestType != requestType) {
			preset(requestTypePropertyName, requestType);
			this.requestType = requestType;
		}
	}

	/**
	 * {@link #urgency} accessor.
	 * @return	The value.
	 **/
	public Urgency getUrgency() {
		return urgency;
	}

	/**
	 * {@link #urgency} mutator.
	 * @param urgency	The new value.
	 **/
	@XmlElement
	public void setUrgency(Urgency urgency) {
		preset(urgencyPropertyName, urgency);
		this.urgency = urgency;
	}

	/**
	 * {@link #state} accessor.
	 * @return	The value.
	 **/
	public State getState() {
		return state;
	}

	/**
	 * {@link #state} mutator.
	 * @param state	The new value.
	 **/
	@XmlElement
	public void setState(State state) {
		preset(statePropertyName, state);
		this.state = state;
	}

	/**
	 * Created
	 *
	 * @return The condition
	 */
	@XmlTransient
	@Override
	public boolean isCreated() {
		return (isPersisted());
	}

	/**
	 * {@link #isCreated} negation.
	 *
	 * @return The negated condition
	 */
	@Override
	public boolean isNotCreated() {
		return (! isCreated());
	}
}
