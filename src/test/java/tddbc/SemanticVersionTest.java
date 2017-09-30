package tddbc;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SemanticVersionTest {

    @Test
    public void バージョン番号に1_4_2を与えれば文字列表現を生成することが出来る() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        String actual = sut.toText();
        assertThat(actual, is("1.4.2"));
    }

    @Test
    public void バージョン番号に0_0_0を与えれば文字列表現を生成することが出来る() {
        SemanticVersion sut = new SemanticVersion(0, 0, 0);
        String actual = sut.toText();
        assertThat(actual, is("0.0.0"));
    }

    @Test
    public void バージョン番号が異なる2つのセマンティックバージョンが等しく無いことが判定できる() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        SemanticVersion other = new SemanticVersion(0, 0, 0);
        boolean actual = sut.equalsVersion(other);
        assertThat(actual, is(false));
    }

    @Test
    public void バージョン番号が一致する2つのセマンティックバージョンが等しいことが判定できる() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        SemanticVersion other = new SemanticVersion(1, 4, 2);
        boolean actual = sut.equalsVersion(other);
        assertThat(actual, is(true));
    }
}
