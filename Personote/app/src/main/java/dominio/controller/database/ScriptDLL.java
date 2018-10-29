package dominio.controller.database;

/**
 * Created by alsabino on 19/04/2018.
 */

public class ScriptDLL {
    public static String getOnCreateTable() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE USUARIO (" );
        sql.append("EMAIL VARCHAR2 (20)  NOT NULL DEFAULT('')," );
        sql.append("SENHA NUMBER (4,0)  NOT NULL DEFAULT(0)," );
        sql.append("ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL);" );

        sql.append("CREATE TABLE CLIMA (" );
        sql.append("CLIMA VARCHAR2 (20)  NOT NULL DEFAULT('')," );
        sql.append("TEMPERATURA NUMBER (4,0)  NOT NULL DEFAULT(0)," );
        sql.append("ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL);" );

        sql.append("CREATE TABLE NOTAS (" );
        sql.append("ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append("TITULO VARCHAR2 (20)  NOT NULL DEFAULT('')," );
        sql.append("TEXTO VARCHAR2 (500)  NOT NULL DEFAULT('')," );
        sql.append("DATA VARCHAR2(20) NOT NULL," );
        sql.append("CONSTRAINT FK_CLIMA FOREIGN KEY (ID) REFERENCES CLIMA(ID));" );

        return sql.toString();
    }
}
