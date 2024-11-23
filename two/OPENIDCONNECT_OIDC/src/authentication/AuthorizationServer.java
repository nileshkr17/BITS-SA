package authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthorizationServer {
    private Map<String, String> authorizationCodes = new HashMap<>();
    private Map<String, String> idTokens = new HashMap<>();
    // Simulate a user database
    private Map<String, String> users = Map.of("user1", "password1");

    // Issue authorization code
    public String issueAuthorizationCode(String clientId, String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            String authCode = UUID.randomUUID().toString();
            authorizationCodes.put(authCode, clientId);
            System.out.println("Authorization code issued: " + authCode);
            return authCode;
        } else {
            System.out.println("Invalid credentials.");
            return null;
        }
    }

    // Exchange authorization code for ID token
    public String issueIdToken(String authCode, String clientId) {
        if (authorizationCodes.containsKey(authCode) &&
                authorizationCodes.get(authCode).equals(clientId)) {
            String idToken = "JWT-" + UUID.randomUUID();
            idTokens.put(idToken, clientId);
            authorizationCodes.remove(authCode);
            System.out.println("ID Token issued: " + idToken);
            return idToken;
        } else {
            System.out.println("Invalid authorization code or client ID.");
            return null;
        }
    }

    // Validate ID token
    public boolean validateIdToken(String idToken, String clientId) {
        return idTokens.containsKey(idToken) &&
                idTokens.get(idToken).equals(clientId);
    }
}