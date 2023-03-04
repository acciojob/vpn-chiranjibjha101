public interface ConnectionService {
    void establishConnection(Long user1Id, Long user2Id) throws InvalidInputException;
}