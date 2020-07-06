package com.my.poc.notificationstoreimpl;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.NONE, classes = {BaseTest.Config.class})
@AutoConfigureStubRunner(
        repositoryRoot = "https://artifactory-url",
        ids = "com.my.poc:apis:+:stubs",
        stubsMode = StubRunnerProperties.StubsMode.REMOTE
)
public abstract class BaseTest {

    UserServiceConfig userServiceConfig;

    @Value("${stubrunner.runningstubs.apis.port}")
    private int port;

    @Before
    public void setUpConfig() {
        userServiceConfig = new UserServiceConfig();
        userServiceConfig.setRestApiUrl("http://localhost:" + port);
    }

    static class Config {

    }
}
