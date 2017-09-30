package tddbc;

public class SemanticVersion {

    private final int major;
    private final int minor;
    private final int patch;
    public SemanticVersion(int i, int i1, int i2) {
        major = i;
        minor = i1;
        patch = i2;
    }

    public String toText() {
        return major + "." + minor + "." + patch;
    }
}

