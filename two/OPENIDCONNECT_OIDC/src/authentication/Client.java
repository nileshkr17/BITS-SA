package authentication;

import java.util.Scanner;

public class Client {
    private AuthorizationServer authorizationServer;
    private ResourceServer resourceServer;
    private String clientId = "client123";

    public Client(AuthorizationServer authorizationServer, ResourceServer resourceServer) {
        this.authorizationServer = authorizationServer;
        this.resourceServer = resourceServer;
    }

    public void startAuthenticationFlow() {
        Scanner scanner = new Scanner(System.in);
        // Step 1: Authenticate user and request authorization code
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String authCode = authorizationServer.issueAuthorizationCode(clientId,
                username, password);
        if (authCode == null) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }
        // Step 2: Exchange authorization code for ID token
        System.out.println("Exchanging authorization code for ID token...");
        String idToken = authorizationServer.issueIdToken(authCode, clientId);
        if (idToken == null) {
            System.out.println("Failed to obtain ID token. Exiting...");
            return;
        }
        // Step 3: Access protected resource
        System.out.println("Accessing protected resource...");
        resourceServer.accessProtectedResource(idToken, clientId);
    }
}