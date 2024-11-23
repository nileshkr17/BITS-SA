// authorization/ResourceServer.java
package authorization;

public class ResourceServer {
    private AuthorizationServer authorizationServer;

    public ResourceServer(AuthorizationServer authorizationServer) {
        this.authorizationServer = authorizationServer;
    }

    // Simulated protected resource access
    public void getProtectedResource(String accessToken, String clientId) {
        if (authorizationServer.validateAccessToken(accessToken, clientId)) {
            System.out.println("Access granted. Here is the protected resource data.");
        } else {
            System.out.println("Access denied. Invalid access token.");
        }
    }
}
