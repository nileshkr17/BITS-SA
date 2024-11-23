package authentication;

public class ResourceServer {
    private AuthorizationServer authorizationServer;

    public ResourceServer(AuthorizationServer authorizationServer) {
        this.authorizationServer = authorizationServer;
    }

    public void accessProtectedResource(String idToken, String clientId) {
        if (authorizationServer.validateIdToken(idToken, clientId)) {
            System.out.println("Access granted. Protected resource: [User Profile Data]");
        } else {
            System.out.println("Access denied. Invalid ID token.");
        }
    }
}