// authorization/AuthorizationServer.java
package authorization;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthorizationServer {
    private Map<String, String> authorizationCodes = new HashMap<>();
    private Map<String, String> accessTokens = new HashMap<>();

    // Issue an authorization code
    public String issueAuthorizationCode(String clientId, String redirectUri) {
        String authCode = UUID.randomUUID().toString();  // Create a unique authorization code
        authorizationCodes.put(authCode, clientId);
        System.out.println("Authorization code issued: " + authCode);
        return authCode;
    }

    // Exchange authorization code for access token
    public String issueAccessToken(String authCode, String clientId) {
        if (authorizationCodes.containsKey(authCode) && authorizationCodes.get(authCode).equals(clientId)) {
            String accessToken = UUID.randomUUID().toString();  // Create a unique access token
            accessTokens.put(accessToken, clientId);
            authorizationCodes.remove(authCode);
            System.out.println("Access token issued: " + accessToken);
            return accessToken;
        } else {
            System.out.println("Invalid authorization code or client ID");
            return null;
        }
    }

    // Validate access token
    public boolean validateAccessToken(String token, String clientId) {
        return accessTokens.containsKey(token) && accessTokens.get(token).equals(clientId);
    }
}
