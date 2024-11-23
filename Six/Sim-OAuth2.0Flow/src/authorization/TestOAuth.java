// authorization/TestOAuth.java
package authorization;

public class TestOAuth {
    public static void main(String[] args) {
        // Set up the Authorization Server and Resource Server
        AuthorizationServer authorizationServer = new AuthorizationServer();
        ResourceServer resourceServer = new ResourceServer(authorizationServer);
        
        // Set up the Client
        Client client = new Client(authorizationServer, resourceServer);
        
        // Start the OAuth flow
        client.authenticateAndAccessResource();
    }
}
