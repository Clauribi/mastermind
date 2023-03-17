package mastermind.api;

import mastermind.api.domain.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
//Legend: (R)ed, (B)lue, (Y)ellow, (G)reen, (W)hite, (O)range

public class TestFeedback {
    @Test
    public void feedbackTest1() {
        List<String> secretCode = new ArrayList<>();
        secretCode.add("R");
        secretCode.add("G");
        secretCode.add("G");
        secretCode.add("B");
        List<String> code = new ArrayList<>();
        code.add("R");
        code.add("G");
        code.add("G");
        code.add("B");
        List result;
        List expected = new ArrayList<>();
        expected.add(0,4);
        expected.add(1,0);
        Game game = new Game(1, "referenceTest", 4, 6, secretCode, 10);
        result = game.feedback(code);
        Assertions.assertArrayEquals(new List[]{expected}, new List[]{result});
    }
    @Test
    public void feedbackTest2() {
        List<String> secretCode = new ArrayList<>();
        secretCode.add("R");
        secretCode.add("R");
        secretCode.add("R");
        secretCode.add("R");
        List<String> code = new ArrayList<>();
        code.add("B");
        code.add("Y");
        code.add("O");
        code.add("B");
        List result;
        List expected = new ArrayList<>();
        expected.add(0,0);
        expected.add(1,0);
        Game game = new Game(1, "referenceTest", 4, 6, secretCode, 10);
        result = game.feedback(code);
        Assertions.assertArrayEquals(new List[]{expected}, new List[]{result});
    }
    @Test
    public void feedbackTest3() {
        List<String> secretCode = new ArrayList<>();
        secretCode.add("G");
        secretCode.add("B");
        secretCode.add("B");
        secretCode.add("R");
        List<String> code = new ArrayList<>();
        code.add("G");
        code.add("B");
        code.add("R");
        code.add("B");
        List result;
        List expected = new ArrayList<>();
        expected.add(0,2);
        expected.add(1,2);
        Game game = new Game(1, "referenceTest", 4, 6, secretCode, 10);
        result = game.feedback(code);
        Assertions.assertArrayEquals(new List[]{expected}, new List[]{result});
    }
    @Test
    public void feedbackTest4() {
        List<String> secretCode = new ArrayList<>();
        secretCode.add("B");
        secretCode.add("B");
        secretCode.add("B");
        secretCode.add("R");
        List<String> code = new ArrayList<>();
        code.add("R");
        code.add("B");
        code.add("G");
        code.add("G");
        List result;
        List expected = new ArrayList<>();
        expected.add(0,1);
        expected.add(1,1);
        Game game = new Game(1, "referenceTest", 4, 6, secretCode, 10);
        result = game.feedback(code);
        Assertions.assertArrayEquals(new List[]{expected}, new List[]{result});
    }
    @Test
    public void feedbackTest5() {
        List<String> secretCode = new ArrayList<>();
        secretCode.add("B");
        secretCode.add("B");
        secretCode.add("B");
        secretCode.add("R");
        List<String> code = new ArrayList<>();
        code.add("B");
        code.add("B");
        code.add("R");
        code.add("B");
        List result;
        List expected = new ArrayList<>();
        expected.add(0,2);
        expected.add(1,2);
        Game game = new Game(1, "referenceTest", 4, 6, secretCode, 10);
        result = game.feedback(code);
        Assertions.assertArrayEquals(new List[]{expected}, new List[]{result});
    }
    @Test
    public void feedbackTest6() {
        List<String> secretCode = new ArrayList<>();
        secretCode.add("W");
        secretCode.add("B");
        secretCode.add("W");
        secretCode.add("B");
        List<String> code = new ArrayList<>();
        code.add("B");
        code.add("W");
        code.add("B");
        code.add("W");
        List result;
        List expected = new ArrayList<>();
        expected.add(0,0);
        expected.add(1,4);
        Game game = new Game(1, "referenceTest", 4, 6, secretCode, 10);
        result = game.feedback(code);
        Assertions.assertArrayEquals(new List[]{expected}, new List[]{result});
    }
}
