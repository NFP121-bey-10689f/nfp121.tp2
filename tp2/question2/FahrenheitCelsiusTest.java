package question2;


/**
 * Classe-test FahrenheitCelsiusTest.
 *
 * @author Ali.z
 * @version 17/12/2023
 *
 * Les classes-test sont document�es ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont bas�es sur le document � 2002 Robert A. Ballance intitul�
 * �JUnit: Unit Testing Framework�.
 *
 * Les objets Test (et TestSuite) sont associ�s aux classes � tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le m�me paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque m�thode Test � ex�cuter.  Il peut y avoir
 * plus d'une m�thode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ d�couvrira automatiquement (par introspection) les m�thodes
 * Test de votre classe Test et g�n�rera la TestSuite cons�quente.
 * Chaque appel d'une m�thode Test sera pr�c�d� d'un appel de setUp(),
 * qui r�alise les engagements, et suivi d'un appel � tearDown(), qui les
 * d�truit.
 */
public class FahrenheitCelsiusTest extends junit.framework.TestCase
{
    private FahrenheitCelsius converter;

    /**
     * Constructeur de la classe-test FahrenheitCelsiusTest
     */
    public FahrenheitCelsiusTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * M�thode appel�e avant chaque appel de m�thode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        converter = new FahrenheitCelsius();

    }

    /**
     * Supprime les engagements
     *
     * M�thode appel�e apr�s chaque appel de m�thode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
         converter = null;
    }
    
    /**
     * Cas de test pour la conversion valide de Fahrenheit a Celsius.
     */
    public void testValidFahrenheitToCelsiusConversion() {
        assertEquals("0 �F -> -17.7 �C ?", -17.7, converter.fahrenheitEnCelsius(0), 0.1);
        assertEquals("100 �F -> 37.7 �C ?", 37.7, converter.fahrenheitEnCelsius(100), 0.1);
        assertEquals("2000 �F -> 1093.3 �C ?", 1093.3, converter.fahrenheitEnCelsius(2000), 0.1);
        assertEquals("54 �F -> 12.2 �C ?", 12.2, converter.fahrenheitEnCelsius(54), 0.1);
    }

    /**
     * Cas de test pour la gestion des entr�es invalides (NumberFormatException).
     */
    public void testInvalidInputHandling() {
        String[] invalidInputs = {"a", "ZZ", "y"};
        for (String input : invalidInputs) {
            try {
                FahrenheitCelsius.fahrenheitEnCelsius(Integer.parseInt(input));
                fail("NumberFormatException attendue pour l'entree : " + input);
            } catch (NumberFormatException e) {
                assertNotNull("NumberFormatException lev�e pour l'entree : " + input, e);
                assertEquals("Le message d'erreur devrait contenir l'entree", "For input string: \"" + input + "\"", e.getMessage());
            }
        }
    }

}
