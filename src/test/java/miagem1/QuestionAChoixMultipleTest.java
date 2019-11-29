package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple uneQuestion;

    @Before
    public void setUp() throws Exception {
        //given : un objet de type QuestionAChoixMultiple
        List<Integer> reponses = new ArrayList<Integer>();
        reponses.add(1);
        reponses.add(2);
        uneQuestion = new QuestionAChoixMultiple("un énoncé", reponses);
    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'énoncé à la question
        String resEnonce = uneQuestion.getEnonce();
        //then : l'énoncé est non null
        assertNotNull(resEnonce);
        // and : l'énoncé est bien celui fourni à la construction
        assertEquals(resEnonce, "un énoncé");
    }

    @Test
    public void testGetScoreForIndice() {
        // when : un étudiant fourni l'indice correspondant à la bonne réponse
        int indiceEtudiant =2;
        // and : on demande le calcul du score
        Float resScore = uneQuestion.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 50
        assertEquals(new Float(50f),resScore);
        // when : un étudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant =3;
        resScore =uneQuestion.getScoreForIndice(indiceEtudiant);
        // then le score obtenu est 0
        assertEquals(new Float(0f),resScore);
    }
}