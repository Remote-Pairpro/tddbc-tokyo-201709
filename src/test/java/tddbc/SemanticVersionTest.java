package tddbc;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SemanticVersionTest {

    @Test
    public void バージョン番号を与えれば文字列表現を生成することが出来る() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        String actual = sut.toText();
        assertThat(actual, is("1.4.2"));
    }

}
