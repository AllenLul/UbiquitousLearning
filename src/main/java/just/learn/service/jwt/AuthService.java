package just.learn.service.jwt;


import just.learn.entity.User;

public interface AuthService {
    User register(User userToAdd);

    String login(String number, String password);

    String refresh(String oldToken);

//    void modify(ModifyUserVO modifiedUser);

    User get(Integer id);

    User get(String token);

    boolean isUsernameDuplicate(String username);



}
