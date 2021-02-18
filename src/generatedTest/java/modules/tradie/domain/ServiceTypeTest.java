package modules.tradie.domain;

import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFixture.FixtureType;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class ServiceTypeTest extends AbstractDomainTest<ServiceType> {

	@Override
	protected ServiceType getBean() throws Exception {
		return new DataBuilder()
			.fixture(FixtureType.crud)
			.build(ServiceType.MODULE_NAME, ServiceType.DOCUMENT_NAME);
	}
}