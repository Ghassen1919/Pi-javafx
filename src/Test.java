
import edu.gestion.entities.Comentaire;
import edu.gestion.entities.Post;
import edu.gestion.services.ComentaireCrud;
import edu.gestion.services.PostCrud;
import edu.gestion.entities.Reclamation;
import edu.gestion.services.ReclamationCRUD;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Test {

    public static void main(String[] args) throws SQLException {
        PostCrud su = new PostCrud();
        ComentaireCrud sp = new ComentaireCrud();
       // Post t1 = new Post("ghassennews", "ghassen marzouk", "aaaaa");
//             Post t2 = new Post("adamnews","adam amara","bbbbbb");
//            Post t5 = new Post("adafgmnews","adamggf amara","bvvbbbbb");
       Comentaire t3 = new Comentaire("ghasseeen", "hhhhhhhhhhhhhhhhhhhh");
       //sp.ajouter(t3);//
        // sp.ajouter(t3);
//        su.ajouter(t1);
       System.out.println(sp.postCommentaire());

        /*su.ajouter(t1);
                 su.ajouter(t2);
                 
                 su.ajouter(t5);*/
 /* su.Update(9,"marzouk","ghassen","rerere");*/
 /*  sp.Update(3,"marzouk","descr");*/
 /* su.delete(10);*/
        ReclamationCRUD sm = new ReclamationCRUD();
        Reclamation t6 = new Reclamation("ghassennews", "animal");
        /*sm.ajouter(t6);*/
       /* System.out.println(sm.readAll());*/
        /* sm.ajouter(t6);
            sm.ajouter(t6);*/
        // sm.delete(27);
        /*sm.Update(26,"marzouk","descr");*/

//            su.Update("2022-12-01","2022-12-11","Each tournament match will be “best-of-one,” except for the final, which will be as described above.\n" +
//"Before each match, the team captains and the referee will hold a coin toss.",4);
//            
           /*System.out.println(sm.readAll1());*/
//           
    }
}
