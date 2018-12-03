import java.io.BufferedReader;
import java.util.List;

public class Domino {

	public static void main(String[] args) 
	{

	}
	
	//importer les donnees du fichier excel
	public class CsvFileHelper {

	    public static String getResourcePath(String fileName) {
	       final File f = new File("");
	       final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
	       return dossierPath;
	   }

	   public static File getResource(String fileName) {
	       final String completeFileName = getResourcePath(fileName);
	       File file = new File(completeFileName);
	       return file;
	       
	   public static List<String> readFile(File file) 
	   {

	       List<String> result = new ArrayList<String>();

	       FileReader fr = new FileReader(file);
	       BufferedReader br = new BufferedReader(fr);

           for (String line = br.readLine(); line != null; line = br.readLine()) {
        	   result.add(line);
	       }
           
	       br.close();
	       fr.close();
	       return result;
	    }
	   }
	}
	
	private final static String FILE_NAME = "domino.csv";

	@Test
	public void testGetResource() {
	    // Param
	    final String fileName = FILE_NAME;

	    // Result
	    final int nombreLigne = 11;

	    // Appel
	    final File file = CsvFileHelper.getResource(fileName);

	    // Test
	    // On sait que le fichier existe bien puisque c'est avec lui qu'on travaille depuis le début.
	    Assert.assertEquals(nombreLigne, lines.size());
	}
	
	public interface CsvFile {

	    File getFile();

	    List<String[] > getData();
	}
	
	public class CsvFile01 implements CsvFile {

	    public final static char SEPARATOR = ',';

	    private File file;
	    private List<String> lines;
	    private List<String[] > data;

	    private CsvFile01() {
	    }

	    public CsvFile01(File file) {
	        this.file = file;

	        // Init
	        init();
	    }

	    private void init() {
	        lines = CsvFileHelper.readFile(file);

	        data = new ArrayList<String[] >(lines.size());
	        String sep = new Character(SEPARATOR).toString();
	        for (String line : lines) {
	            String[] oneData = line.split(sep);
	            data.add(oneData);
	        }
	    }
	    
	    
	    //tuile
	    public interface Chien {
	        Integer getId();

	        String getPrenom();

	        String getCouleur();

	        Integer getAge();
	    }
	    
	    public class SimpleChien implements Chien {

	        private Integer id;
	        private String prenom;
	        private String couleur;
	        private Integer age;

	        @Override
	        public String toString() {
	            return prenom + "(" + id + ")";
	        }

	        // plus GETTERS / SETTERS 
	        //...
	    }
	    

	    public interface ChienDao {

	    	List<Chien> findAllChiens();
	    }

}
