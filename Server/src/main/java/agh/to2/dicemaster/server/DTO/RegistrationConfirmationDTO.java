package agh.to2.dicemaster.server.DTO;

public class RegistrationConfirmationDTO {
    private String serverQueueName;

    public RegistrationConfirmationDTO(String serverQueueName) {
        this.serverQueueName = serverQueueName;
    }

    public String getServerQueueName() {
        return serverQueueName;
    }

    public void setServerQueueName(String serverQueueName) {
        this.serverQueueName = serverQueueName;
    }
}