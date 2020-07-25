import java.util.UUID;

public enum CommitUniqueId {
    UNIQUEID("");

    private final String id;

    CommitUniqueId(String id) {
        this.id = id;
    }

    public String getCommitId() {
        return this.id;
    }

    public String createUniqueId() {
        String randomId = UUID.randomUUID().toString();
        return randomId;
    }
}
