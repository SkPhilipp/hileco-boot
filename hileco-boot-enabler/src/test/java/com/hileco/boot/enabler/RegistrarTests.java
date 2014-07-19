package com.hileco.boot.enabler;

import com.hileco.boot.enabler.sample.SampleApplicationConfiguration;
import com.hileco.boot.enabler.sample.services.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests to see if a custom registrar implementation example is functioning property.
 *
 * @author Philipp Gayret
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SampleApplicationConfiguration.class, loader = SpringApplicationContextLoader.class)
public class RegistrarTests {

    @Autowired
    private HelloService helloService;

    /**
     * Asserts that the autowired {@link #helloService} is actually a Mockito instantiated mock, as it should have been instantiated via {@link com.hileco.boot.enabler.sample.lib.MockRegistrar},
     * as the referenced configuration uses the {@link com.hileco.boot.enabler.sample.lib.annotations.EnableMocking} annotation and the {@link #helloService} is marked with {@link com.hileco.boot.enabler.sample.lib.annotations.Mocked}.
     */
    @Test
    public void testIsMock() {
        Assert.assertTrue(Mockito.mockingDetails(helloService).isMock());
    }

}