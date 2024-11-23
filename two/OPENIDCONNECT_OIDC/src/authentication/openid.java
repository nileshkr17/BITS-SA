package authentication;

public class openid {
    public static void main(String[] args) {
        AuthorizationServer authorizationServer = new AuthorizationServer();
        ResourceServer resourceServer = new ResourceServer(authorizationServer);
        Client client = new Client(authorizationServer, resourceServer);
        client.startAuthenticationFlow();
    }
}