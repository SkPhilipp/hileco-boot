package com.hileco.boot.enabler.sample.services;

import com.hileco.boot.enabler.sample.lib.annotations.Mocked;

/**
 * A sample interface for which a mock should used when {@link org.springframework.beans.factory.annotation.Autowired}.
 *
 * @author Philipp Gayret
 */
@Mocked
public interface HelloService {

    public String getWorld();

}
