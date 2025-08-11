package uz.pdp.omnborxona.repository;

import uz.pdp.omnborxona.model.entity.AuthUser;
import uz.pdp.omnborxona.repository.base.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthUserRepository extends CrudRepository<AuthUser,String> {
    @Override
    Optional<AuthUser> findById(String id);

    @Override
    List<AuthUser> findAll();

    @Override
    AuthUser save(AuthUser entity);

    @Override
    void delete(AuthUser entity);
}
