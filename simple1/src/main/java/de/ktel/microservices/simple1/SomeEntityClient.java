package de.ktel.microservices.simple1;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created on 11.01.16.
 *
 * @author David Steiman, K-TEL Communications GmbH
 */

@Component
public class SomeEntityClient {

    private final Logger log = LoggerFactory.getLogger(SomeEntityClient.class);

    private RestTemplate restTemplate;

    private LoadBalancerClient loadBalancerClient;

    private String serviceHost;

    private long servicePort;

    private boolean useRibbon;

    @Autowired(required = false)
    public void setLoadBalancerClient(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    @Autowired
    public SomeEntityClient(
            @Value("${simple2.service.host:simple2}") String serviceHost,
            @Value("${simple2.service.port:8080}") long servicePort,
            @Value("${ribbon.eureka.enabled:false}") boolean useRibbon
    ) {
        this.serviceHost = serviceHost;
        this.servicePort = servicePort;
        this.useRibbon = useRibbon;
        this.restTemplate = getRestTemplate();
    }

    protected RestTemplate getRestTemplate() {
        //this is for how RestTemplate maps the response data to object
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
        mapper.registerModule(new Jackson2HalModule());

        //add response message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));
        converter.setObjectMapper(mapper);

        return new RestTemplate(
                Collections.<HttpMessageConverter<?>> singletonList(converter));
    }

    public String getServiceUrl() {
        String url;

        if (useRibbon) {
            ServiceInstance instance = loadBalancerClient.choose("SIMPLE2");
            url = "http://" + instance.getHost() + ":" + instance.getPort() + "/";
        } else {
            url = "http://" + serviceHost + ":" + servicePort + "/";
        }

        log.info("RandomClientUrl: {}", url);

        return url;
    }

    public SomeEntity getOne() {

        return restTemplate.getForObject(getServiceUrl(), SomeEntity.class);
    }
}
