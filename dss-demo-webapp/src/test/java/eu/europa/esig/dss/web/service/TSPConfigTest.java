package eu.europa.esig.dss.web.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import eu.europa.esig.dss.enumerations.DigestAlgorithm;
import eu.europa.esig.dss.model.TimestampBinary;
import eu.europa.esig.dss.spi.DSSUtils;
import eu.europa.esig.dss.spi.x509.tsp.TSPSource;
import eu.europa.esig.dss.utils.Utils;
import eu.europa.esig.dss.web.config.DSSBeanConfig;

@WebAppConfiguration
@ContextConfiguration(classes = { DSSBeanConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class TSPConfigTest {

	@Autowired
	private TSPSource tspSource;

	@Test
	public void test() {
		TimestampBinary timeStampResponse = tspSource.getTimeStampResponse(DigestAlgorithm.SHA256, DSSUtils.digest(DigestAlgorithm.SHA256, "Hello".getBytes()));
		assertNotNull(timeStampResponse);
		assertTrue(Utils.isArrayNotEmpty(timeStampResponse.getBytes()));
	}
}
