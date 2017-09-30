package tddbc;

public class SemanticVersion {

    private final int major;
    private final int minor;
    private final int patch;

    public SemanticVersion(int major, int minor, int patch) {
        if (major < 0) throw new IllegalArgumentException();
        if (minor < 0) throw new IllegalArgumentException();
        if (patch < 0) throw new IllegalArgumentException();
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public String toText() {
        return String.format("%d.%d.%d", major, minor, patch);
    }

    public SemanticVersion fixBugWithCompatibility() {
        return new SemanticVersion(major, minor, patch + 1);
    }

    public SemanticVersion addFixtureWithCompatibility() {
        return new SemanticVersion(major, minor + 1, 0);
    }

    public SemanticVersion changeWithoutCompatibility() {
        return new SemanticVersion(major + 1, 0, 0);
    }

    @Override
    public int hashCode() {
        return major ^ minor ^ patch;
    }

    @Override
    public boolean equals(Object other) {
        SemanticVersion otherVersion = (SemanticVersion) other;
        return major == otherVersion.major &&
                minor == otherVersion.minor &&
                patch == otherVersion.patch;
    }

}

