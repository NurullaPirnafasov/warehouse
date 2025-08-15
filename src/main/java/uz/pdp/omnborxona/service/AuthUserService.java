package uz.pdp.omnborxona.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uz.pdp.omnborxona.mapper.AuthUserMapper;
import uz.pdp.omnborxona.model.dto.AuthUserCreateDto;
import uz.pdp.omnborxona.model.dto.AuthUserDto;
import uz.pdp.omnborxona.model.dto.AuthUserUpdateDto;
import uz.pdp.omnborxona.model.entity.AuthUser;
import uz.pdp.omnborxona.repository.AuthUserRepository;
import uz.pdp.omnborxona.service.base.AbstractService;
import uz.pdp.omnborxona.service.base.CrudService;
import uz.pdp.omnborxona.validator.AuthUserValidator;

import java.util.List;

@ApplicationScoped
public class AuthUserService
        extends AbstractService<AuthUserMapper, AuthUserRepository, AuthUserValidator>
        implements CrudService<AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto, String> {

    @Inject
    public AuthUserService(AuthUserMapper mapper, AuthUserRepository repository, AuthUserValidator validator) {
        super(mapper, repository, validator);
    }

    @Override
    public void create(AuthUserCreateDto dto) {
        AuthUser authUser = mapper.fromCreateDto(dto);
        repository.save(authUser);
    }

    @Override
    public AuthUserDto update(AuthUserUpdateDto dto, String id) {
        AuthUser authUser = validator.existsAndGet(id);
        mapper.updateEntityFromDto(dto, authUser);
        AuthUser save = repository.save(authUser);
        return mapper.toDto(save);
    }

    @Override
    public AuthUserDto get(String id) {
        return mapper.toDto(validator.existsAndGet(id));
    }

    @Override
    public List<AuthUserDto> getAll() {
        List<AuthUser> authUsers = repository.findAll();
        return mapper.toDto(authUsers);
    }

    @Override
    public void delete(String id) {
        AuthUser authUser = validator.existsAndGet(id);
        repository.delete(authUser);
    }
    //qwerty
}
