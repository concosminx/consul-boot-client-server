package com.nimsoc.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping(path = "/api")
@EnableDiscoveryClient
public class ConsulController {

  @Autowired
  private RestTemplate standardRestTemplate;

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/consul")
  public String invokeGreetingService() {
    URI uri = discoveryClient.getInstances("Consul-Service").stream().map(si -> si.getUri()).findFirst().map(s -> s.resolve("/api/greetings")).get();
    return standardRestTemplate.getForObject(uri, String.class);
  }

}
