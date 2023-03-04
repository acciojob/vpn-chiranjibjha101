public interface UserService {
    User registerUser(String username, String password, String countryName) throws InvalidInputException;
    User subscribe(Long userId, Long providerId) throws InvalidInputException;
    void connect(Long userId, Long countryId) throws InvalidInputException;
    void disconnect(Long userId) throws InvalidInputException;
    List<User> communicate(Long userId) throws InvalidInputException;
}