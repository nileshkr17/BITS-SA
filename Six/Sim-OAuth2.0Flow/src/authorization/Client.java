// authorization/Client.java
package authorization;

public class Client {
    private AuthorizationServer authorizationServer;
    private ResourceServer resourceServer;
    private String clientId = "client123"; // Unique identifier for the client
    private String redirectUri = "http://localhost/callback"; // Redirect URI after authorization

    public Client(AuthorizationServer authorizationServer, ResourceServer resourceServer) {
        this.authorizationServer = authorizationServer;
        this.resourceServer = resourceServer;
    }

    // Simulate the process of obtaining the authorization code and accessing the resource
    public void authenticateAndAccessResource() {
        // Step 1: Request authorization code
        System.out.println("Requesting authorization code...");
        String authCode = authorizationServer.issueAuthorizationCode(clientId, redirectUri);

        // Step 2: Exchange authorization code for access token
        System.out.println("Exchanging authorization code for access token...");
        String accessToken = authorizationServer.issueAccessToken(authCode, clientId);

        if (accessToken != null) {
            // Step 3: Use the access token to access the protected resource
            System.out.println("Accessing protected resource with access token...");
            resourceServer.getProtectedResource(accessToken, clientId);
        } else {
            System.out.println("Failed to retrieve access token.");
        }
    }
}
