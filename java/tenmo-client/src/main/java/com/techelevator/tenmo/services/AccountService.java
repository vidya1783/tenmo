package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.view.ConsoleService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public class AccountService {
    public static String AUTH_TOKEN = "";
    private final String API_BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser currentUser;
    //private ConsoleService console = new ConsoleService();

    //Constructor
    public AccountService(String url) {
        this.API_BASE_URL = url+"account";
    }

    //Make Auth Entity Method
    private HttpHeaders authHeaders(String authToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(AUTH_TOKEN);
        return headers;
    }

    //Methods
    public BigDecimal seeBalance(String authToken) {
        HttpEntity<?> entity = new HttpEntity<>(authHeaders(authToken));
        ResponseEntity<BigDecimal>result = restTemplate.exchange(API_BASE_URL + "/balance" , HttpMethod.GET, entity, BigDecimal.class);
        return result.getBody();

    }
    /*public BigDecimal seeBalance() {
        BigDecimal balance = new BigDecimal("500.00");
        try {
            balance = restTemplate.exchange(API_BASE_URL + "balance/" + currentUser.getUser().getId(), HttpMethod.GET, makeAuthEntity(), BigDecimal.class).getBody();
        } catch (RestClientResponseException ex) {
            System.out.println("We could not retrieve your balance.");
        }
        return balance;
    }*/

}
