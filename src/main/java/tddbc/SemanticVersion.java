package tddbc;

public class SemanticVersion {

    private final int major;
    private final int minor;
    private final int patch;

    public SemanticVersion(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public String toText() {
        return String.format("%d.%d.%d", major, minor, patch);
    }

    public boolean equalsVersion(SemanticVersion other) {
        return false;
    }
}

