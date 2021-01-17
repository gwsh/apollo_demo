package com.apollo.yf;

import com.apollo.yf.apollo.OrderProperties;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class ApolloDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloDemoApplication.class, args);
    }

    @Component
    public class OrderPropertiesCommandLineRunner implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        private final OrderProperties orderProperties;

        public OrderPropertiesCommandLineRunner(OrderProperties orderProperties) {
            this.orderProperties = orderProperties;
        }

        @Override
        public void run(String... args) {
            logger.info("payTimeoutSeconds:" + orderProperties.getPayTimeoutSeconds());
            logger.info("createFrequencySeconds:" + orderProperties.getCreateFrequencySeconds());
        }

    }

    @Component
    public class ValueCommandLineRunner implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Value(value = "${order.pay-timeout-seconds}")
        private Integer payTimeoutSeconds;

        @Value(value = "${order.create-frequency-seconds}")
        private Integer createFrequencySeconds;

        @Override
        public void run(String... args) {
            logger.info("payTimeoutSeconds:" + payTimeoutSeconds);
            logger.info("createFrequencySeconds:" + createFrequencySeconds);
        }
    }

}
