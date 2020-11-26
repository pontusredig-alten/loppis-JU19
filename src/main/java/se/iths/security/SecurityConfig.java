package se.iths.security;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@ApplicationScoped
@BasicAuthenticationMechanismDefinition
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/MyApp/MyDS",
        callerQuery = "SELECT password FROM user WHERE username = ?",
        groupsQuery = "SELECT groupname FROM user WHERE username = ?"
)
@DeclareRoles({ "admin", "user"})
public class SecurityConfig {
}
