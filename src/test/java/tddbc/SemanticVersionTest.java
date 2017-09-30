package tddbc;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
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
        boolean actual = sut.equals(other);
        assertThat(actual, is(false));
    }

    @Test
    public void バージョン番号が一致する2つのセマンティックバージョンが等しいことが判定できる() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        SemanticVersion other = new SemanticVersion(1, 4, 2);
        boolean actual = sut.equals(other);
        assertThat(actual, is(true));
    }

    @Test
    public void 同一バージョンのセマンティックバージョンはHash値も同一となる() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        SemanticVersion other = new SemanticVersion(1, 4, 2);
        assertEquals(sut.hashCode(), other.hashCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void major番号にマイナス値を指定することは出来ない() {
        new SemanticVersion(-1, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minor番号にマイナス値を指定することは出来ない() {
        new SemanticVersion(0, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void patch番号にマイナス値を指定することは出来ない() {
        new SemanticVersion(0, 0, -1);
    }

    @Test
    public void 下位互換性のあるバグ修正ならばpatchフィールドのインクリメントされる() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        SemanticVersion actual = sut.fixBugWithCompatibility();
        assertThat(actual.toText(), is("1.4.3"));
    }

    @Test
    public void 下位互換性のある機能追加を行う場合はminorフィールドをインクリメントされpatchが0となる() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        SemanticVersion actual = sut.addFixtureWithCompatibility();
        assertThat(actual.toText(), is("1.5.0"));
    }

    @Test
    public void 下位互換性を壊す変更が入る場合majorフィールドをインクリメントされminorとpatchは0となる() {
        SemanticVersion sut = new SemanticVersion(1, 4, 2);
        SemanticVersion actual = sut.changeWithoutCompatibility();
        assertThat(actual.toText(), is("2.0.0"));
    }

}
