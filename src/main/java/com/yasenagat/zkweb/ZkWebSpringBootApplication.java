package com.yasenagat.zkweb;
/**
 * 
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Shandy
 *
 */
@SpringBootApplication
@ServletComponentScan
public class ZkWebSpringBootApplication extends SpringBootServletInitializer{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ZkWebSpringBootApplication.class);
    }
    public static void main(String[] args) {
    	new SpringApplicationBuilder(ZkWebSpringBootApplication.class).run(args);
    }
}