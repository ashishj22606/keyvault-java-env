import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

public class Main {
    public static void main(String[] args) {
        // Azure Key Vault parameters
        String keyVaultUrl = "https://your-keyvault-name.vault.azure.net";
        String clientId = "your-client-id";
        String clientSecret = "your-client-secret";
        String tenantId = "your-tenant-id";
        String secretName = "your-secret-name"; // Replace with your secret name

        // Create a ClientSecretCredential using your Azure AD application's client ID, client secret, and tenant ID
        ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
            .clientId(clientId)
            .clientSecret(clientSecret)
            .tenantId(tenantId)
            .build();

        // Create a SecretClient to interact with your Key Vault
        SecretClient secretClient = new SecretClientBuilder()
            .vaultUrl(keyVaultUrl)
            .credential(clientSecretCredential)
            .buildClient();

        // Retrieve the secret value
        String secretValue = secretClient.getSecret(secretName).getValue();
        System.out.println("Secret Value: " + secretValue);
    }
}
