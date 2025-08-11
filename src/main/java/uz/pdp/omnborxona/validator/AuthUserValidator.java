package uz.pdp.omnborxona.validator;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uz.pdp.omnborxona.model.entity.AuthUser;
import uz.pdp.omnborxona.repository.AuthUserRepository;

@ApplicationScoped
public class AuthUserValidator {
    @Inject
    private AuthUserRepository authUserRepository;
    public AuthUser existsAndGet(String id) {
        return authUserRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("AuthUser with id " + id + " not found")
        );
    }
}
