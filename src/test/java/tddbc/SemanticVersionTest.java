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
}
