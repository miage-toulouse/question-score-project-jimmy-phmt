package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private  ScoreCalculateur unScoreCalculateur;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        //given : un objet de type ScoreCalculateur
        unScoreCalculateur = new ScoreCalculateur();
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
    }

    @Test
    public void testCalculeScore() {
        // when : un étudiant fourni aucune bonne réponse
        List<Integer> indicesEtudiant = new ArrayList<Integer>(Arrays.asList(1,4));
        // and : on demande le calcul du score
        Float resScore = unScoreCalculateur.calculeScore(indicesEtudiant, this.questionAChoixMultiple);
        // then : le score obtenu est 0
        // (valeur que je veux vérifier, mon test)
        assertEquals(new Float(0f), resScore);

        // when : un étudiant fourni une partie des bonnes réponses
        List<Integer> indicesEtudiant2 = new ArrayList<Integer>(Arrays.asList(2,3));
        // and : on demande le calcul du score
        Float resScore2 = unScoreCalculateur.calculeScore(indicesEtudiant2, this.questionAChoixMultiple);
        // then : le score obtenu est 2*100/3 à 0,01 près
        // (valeur que je veux vérifier, mon test)
        assertEquals(new Float(2*100/3f), resScore2, 0.01f);

        // when : un étudiant fourni aucune bonne réponse
        List<Integer> indicesEtudiant3 = new ArrayList<Integer>(Arrays.asList(2,3,5));
        // and : on demande le calcul du score
        Float resScore3 = unScoreCalculateur.calculeScore(indicesEtudiant3, this.questionAChoixMultiple);
        // then : le score obtenu est 100 à 0,01 près
        // (valeur que je veux vérifier, mon test)
        assertEquals(new Float(100f), resScore3, 0.01f);
    }
}