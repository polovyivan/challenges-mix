package com.ivan.polovyi.challenges.springactivemqartemis;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringActiveMqArtemisApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(SpringActiveMqArtemisApplication.class, args);
	}

}
