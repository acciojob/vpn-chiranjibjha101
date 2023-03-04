public interface AdminService {
    Admin registerAdmin(String username, String password) throws InvalidInputException;
    ServiceProvider addServiceProvider(String name) throws InvalidInputException;
    Country addCountry(Long serviceProviderId, String countryName) throws InvalidInputException;
}