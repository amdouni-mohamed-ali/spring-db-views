package com.spring.example.springdbviews.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YAMLConfig.class)
public class YAMLConfigTest {

    @Autowired
    YAMLConfig yamlConfig;

    @Test
    public void testConfiguration() {

        assertThat(yamlConfig.getDdlAuto()).isNotEmpty();
        /*
         * we gonna use read only views to the ddl strategy must be validate on all environments
         */
        assertThat(yamlConfig.getDdlAuto()).isEqualTo("validate");
    }
}
